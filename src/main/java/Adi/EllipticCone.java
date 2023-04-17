package Adi;

import Engine.Utils;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_LINE_STRIP;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;

// Rumus Cone dari website ini:
// https://mathworld.wolfram.com/EllipticCone.html
// Asumsi v = sector, u = stack

public class EllipticCone extends Object {
    List<Integer> index = new ArrayList<>();
    int ibo;

    // Constructor biasa
    public EllipticCone(List<ShaderModuleData> shaderModuleDataList, Vector3f center, float radiusX, float radiusY, float coneHeight, int sectorCount, int stackCount, Vector4f color) {
        super(shaderModuleDataList, Utils.dummyVerticeValue(), color);

        // Set the actual vertice value
        this.vertices = calculateEllipticConeVertices(center, radiusX, radiusY, coneHeight, sectorCount, stackCount);

        // Call Setup
        setupVAOVBO();
        setupIBO(sectorCount, stackCount);
    }

    // Constructor untuk Cone yang dipotong
    // Frustum = ada berapa row yang diambil
    // Asumsi: bottom frustum tidak negatif dan topfrustum < stackCount
    public EllipticCone(List<ShaderModuleData> shaderModuleDataList, Vector3f center, float radiusX, float radiusY, float coneHeight, int sectorCount, int stackCount, int bottomFrustum, int topFrustum, Vector4f color) {
        super(shaderModuleDataList, Utils.dummyVerticeValue(), color);

        // Set the actual vertice value
        this.vertices = calculateEllipticConeVerticesWithFrustum(center, radiusX, radiusY, coneHeight, sectorCount, stackCount, bottomFrustum, topFrustum);

        // Call Setup
        setupVAOVBO();
        setupIBO(sectorCount, stackCount);
    }

    // Draw pakai Triangles
    @Override
    public void draw() {
        drawSetup();
        // Draw the vertices
        // Optional
        glLineWidth(1);
        glPointSize(2);
        // Wajib
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glDrawElements(GL_TRIANGLES, index.size(), GL_UNSIGNED_INT, 0);
        // Pilihan draw:
        // LINES
        // LINE_STRIP
        // TRIANGLES
        // TRIANGLE_FAN
        // POINT
        // Parameter first dan end itu, vertices yang digambar mulai dari index keberapa, terus dari first ngegambar berapa kali.
        // Misal 0, 2. Berarti, digambar index 0, 1, 2. Soalnya dari index 0 maju 2x

        // Gambar child
        for (Object child : getChildObject()) {
            child.draw();
        }
    }

    public List<Vector3f> calculateEllipticConeVertices(Vector3f center, float radiusX, float radiusY, float coneHeight, int sectorCount, int stackCount) {
        ArrayList<Vector3f> ellipticConeVertices = new ArrayList<>();

//        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/stackCount){
//            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/sectorCount){
//                float x = center.x + radiusX * (float)(v * Math.cos(u));
//                float y = center.y + radiusY * (float)(v * Math.sin(u));
//                float z = center.z + radiusZ * (float)(v);
//                ellipticConeVertices.add(new Vector3f(x,y,z)); // Kalau mau lihat dari perspektif lain, coba y dan z dituker
//            }
//        }

        float pi = (float) Math.PI;

        float sectorStep = 2 * pi / sectorCount;
        float stackStep = coneHeight / stackCount;
        float sectorAngle, stackAngle;
        float x, y, z;

        for (int i = 0; i <= stackCount; ++i) {
            stackAngle = i * stackStep;                // starting from 0 to coneHeight
            x = radiusX * (coneHeight - stackAngle)/coneHeight;
            y = radiusY * (coneHeight - stackAngle)/coneHeight;
            z = stackAngle;

            // add (sectorCount+1) vertices per stack
            // the first and last vertices have same position and normal, but different tex coords
            for (int j = 0; j < sectorCount; ++j) {
                sectorAngle = j * sectorStep;           // starting from 0 to 2pi
                Vector3f tempVector = new Vector3f();

                tempVector.x = center.x + x * (float) Math.cos(sectorAngle);
                tempVector.y = center.y + y * (float) Math.sin(sectorAngle);
                tempVector.z = center.z + z;
                ellipticConeVertices.add(tempVector);
            }
        }
        return ellipticConeVertices;
    }

    // Frustum = ada berapa row yang diambil
    // Asumsi: bottom frustum tidak negatif dan topfrustum < stackCount
    public List<Vector3f> calculateEllipticConeVerticesWithFrustum(Vector3f center, float radiusX, float radiusY, float radiusZ, int sectorCount, int stackCount, int bottomFrustum, int topFrustum) {
        List<Vector3f> ellipticConeVertices = calculateEllipticConeVertices(center, radiusX, radiusY, radiusZ, sectorCount, stackCount);
        List<Vector3f> cutEllipticConeVertices = new ArrayList<>();

        for (int i = bottomFrustum; i < topFrustum + 1; i++) {
//            System.out.println("i: " + i);
            for (int j = 0; j < sectorCount + 1; j++) {
                cutEllipticConeVertices.add(ellipticConeVertices.get(((sectorCount + 1) * i) + j));
//                System.out.println(((sectorCount + 1) * i) + j);
            }
        }
//        System.out.println("Size:" + cutSphereVertices.size());
//        System.out.println(cutSphereVertices);

        return cutEllipticConeVertices;
    }

    public void setupIBO(int sectorCount, int stackCount) {
        // Setup urutan index dan ibo
//        index = Arrays.asList(0, 3, 3, 1, 1, 4, 4, 2, 2, 0);

        // Stack = Rownya (Yang melingkar searah putaran donut)
        // Sector = Columnnya (Yang melingkar tegak lurus putaran donut)
//        List<List<Vector3f>> torusStacks = new ArrayList<>();
//        for (int i = 0; i < stackCount - 1; i++) {
//            torusStacks.add(this.vertices.subList(sectorCount * i, sectorCount * (i + 1)));
//        }

//        System.out.println("Size: " + this.vertices.size());
        // Buat masukin ke indexnya
        for (int i = 0; i < stackCount; i++) {
            for (int j = 0; j < sectorCount; j++) {
                // Titiknya: stack sekarang sector sekarang, stack selanjutnya sector sekarang, stack sekarang sector selanjutnya
                index.add(((sectorCount) * i) + j);
                index.add(((sectorCount) * (i + 1)) + j);
                if (j == sectorCount - 1) {
                    // Kalau sector terakhir, kaitkan dengan sector awal
                    index.add(((sectorCount) * i));
                } else {
                    // Kalau bukan sector terakhir, kaitkan dengan stack selanjutnya
                    index.add(((sectorCount) * i) + j + 1);
                }


                // Titiknya: stack selanjutnya sector selanjutnya, stack sekarang sector selanjutnya, stack selanjutnya sector selanjutnya
                index.add(((sectorCount) * (i + 1)) + j);
                if (j == sectorCount - 1) {
                    // Kalau sector terakhir, kaitkan dengan sector awal
                    index.add(((sectorCount) * i));
                } else {
                    // Kalau bukan sector terakhir, kaitkan dengan stack selanjutnya
                    index.add(((sectorCount) * i) + j + 1);
                }
                if (j == sectorCount - 1) {
                    // Kalau sector terakhir, kaitkan dengan sector awal
                    index.add(((sectorCount) * i) + j + 1);
                } else {
                    // Kalau bukan sector terakhir, kaitkan dengan stack selanjutnya
                    index.add(((sectorCount) * (i + 1)) + j + 1);
                }


            }

//            System.out.println("First:");
//            System.out.printf("%d, %d, %d\n", (sectorCount * (i + 1)) - 1, ((sectorCount * (i + 2)) - 1), (stackCount * i));
//            // Jadi agar sector akhir ke awalnya ngeloop
//            // Titiknya: Stack sekarang sector terakhir, stack selanjutnya sector terakhir, stack sekarang sector pertama
//            index.add((sectorCount * (i + 1)) - 1);
//            index.add((sectorCount * (i + 2)) - 1);
//            index.add(stackCount * i);
//
//            System.out.println("First2:");
//            System.out.printf("%d, %d, %d\n", ((sectorCount * (i + 2)) - 1), (stackCount * i), sectorCount * (i + 1));
//            // Titiknya: Stack selanjutnya sector terakhir, stack sekarang sector pertama, stack selanjutnya sector pertama
//            index.add((sectorCount * (i + 2)) - 1);
//            index.add(stackCount * i);
//            index.add(sectorCount * (i + 1));
        }

//        // Untuk stack terakhir dan pertama
//        // Jadi agar stack terakhir dan pertama ngeloop
//        for (int j = 0; j < sectorCount; j++) {
//        // Titiknya: stack terakhir sector sekarang, stack pertama sector sekarang, stack terakhir sector selanjutnya
//        index.add((stackCount * (stackCount - 1)) + j);
//        index.add(0 + j);
//        index.add((stackCount * (stackCount - 1)) + j + 1);
//
//        // Titiknya: stack pertama sector selanjutnya, stack terakhir sector selanjutnya, stack pertama sector selanjutnya
//        index.add(0 + j);
//        index.add((stackCount * (stackCount - 1)) + j + 1);
//        index.add(0 + j + 1);
//        }

//        System.out.println(index);

        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, Utils.listoInt(index), GL_STATIC_DRAW);
    }
}

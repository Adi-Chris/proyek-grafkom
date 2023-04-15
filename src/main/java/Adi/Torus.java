package Adi;

import Engine.Utils;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.opengl.GL20C.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30C.glGenVertexArrays;

// Rumus Torus dari website ini
// https://mathworld.wolfram.com/Torus.html

public class Torus extends Object {
    List<Integer> index = new ArrayList<>();
    int ibo;

    // Constructor untuk Torus
    public Torus(List<ShaderModuleData> shaderModuleDataList, Vector3f center, float radiusToCenterTube, float radiusofTube, int sectorCount, int stackCount, Vector4f color) {
        super(shaderModuleDataList, Utils.dummyVerticeValue(), color);

        // Set the actual vertice value
        this.vertices = calculateTorusVertices(center, radiusToCenterTube, radiusofTube, sectorCount, stackCount);

        this.setCenterPoint(center);

        // Call Setup
        setupVAOVBO();
        setupIBO(sectorCount, stackCount);
    }

//    // Constructor untuk Torus dengan custom torusStackAngleRadian (Bisa untuk half torus, dll yang dengan handle)
//    public Torus(List<ShaderModuleData> shaderModuleDataList, Vector3f center, float radiusToCenterTube, float radiusofTube, int sectorCount, int stackCount, float torusSectorAngleRadian, Vector4f color) {
//        super(shaderModuleDataList, Utils.dummyVerticeValue(), color);
//
//        // Set the actual vertice value
//        this.vertices = calculateTorusVertices(center, radiusToCenterTube, radiusofTube, sectorCount, stackCount, torusSectorAngleRadian);
//
//        this.setCenterPoint(center);
//
//        // Call Setup
//        setupVAOVBO();
//        setupIBO(sectorCount, stackCount);
//    }

    // Constructor untuk Torus dengan custom startSector dan endSector (Bisa untuk half torus, dll yang tanpa handle)
    public Torus(List<ShaderModuleData> shaderModuleDataList, Vector3f center, float radiusToCenterTube, float radiusofTube, int sectorCount, int stackCount, int startSector, int endSector, Vector4f color) {
        super(shaderModuleDataList, Utils.dummyVerticeValue(), color);

        // Set the actual vertice value
        this.vertices = calculateTorusVertices(center, radiusToCenterTube, radiusofTube, sectorCount, stackCount);

        this.setCenterPoint(center);

        // Call Setup
        setupVAOVBO();
        setupIBO(sectorCount, stackCount, startSector, endSector);
    }

//    // Draw pakai biasa
//    @Override
//    public void draw() {
//        drawSetup();
//        // Draw the vertices
//        // Optional
//        glLineWidth(10);
//        glPointSize(3);
//        // Wajib
//        glDrawArrays(GL_TRIANGLE_STRIP, 0, vertices.size());
//        // Pilihan draw:
//        // LINES
//        // LINE_STRIP
//        // TRIANGLES
//        // TRIANGLE_FAN
//        // POINT
//        // Parameter first dan end itu, vertices yang digambar mulai dari index keberapa, terus dari first ngegambar berapa kali.
//        // Misal 0, 2. Berarti, digambar index 0, 1, 2. Soalnya dari index 0 maju 2x
//    }

    // Draw pakai ibo
    @Override
    public void draw() {
        drawSetup();
        // Draw the vertices
        // Optional
        glLineWidth(1);
        glPointSize(10);
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
    }

    public List<Vector3f> calculateTorusVertices(Vector3f center, float radiusToCenterTube, float radiusofTube, int sectorCount, int stackCount) {
        ArrayList<Vector3f> torusVertices = new ArrayList<>();

        float pi = (float) Math.PI;

        float sectorStep = 2 * pi / sectorCount;
        float stackStep = 2 * pi / stackCount;
        float sectorAngle, stackAngle;
        float x, y, z;

        for (int i = 0; i <= stackCount; ++i) {
            stackAngle = i * stackStep;                // starting from 0 to 2pi
            x = radiusToCenterTube + radiusofTube * (float) Math.sin(stackAngle);
            y = radiusToCenterTube + radiusofTube * (float) Math.sin(stackAngle);
            z = radiusofTube * (float) Math.cos(stackAngle);

            // add (sectorCount+1) vertices per stack
            // the first and last vertices have same position and normal, but different tex coords
            for (int j = 0; j <= sectorCount; ++j) {
                sectorAngle = j * sectorStep;           // starting from 0 to 2pi
                Vector3f tempVector = new Vector3f();

                tempVector.x = center.x + x * (float) Math.sin(sectorAngle);
                tempVector.y = center.y + y * (float) Math.cos(sectorAngle);
                tempVector.z = center.z + z;
                torusVertices.add(tempVector);
            }
        }
        return torusVertices;
    }

//    // Custom torusStackAngleRadian (Bisa untuk torus, half torus, dll)
//    public List<Vector3f> calculateTorusVertices(Vector3f center, float radiusToCenterTube, float radiusofTube, int sectorCount, int stackCount, float torusSectorAngleRadian) {
//        ArrayList<Vector3f> torusVertices = new ArrayList<>();
//
//        float pi = (float) Math.PI;
//
//        float sectorStep = torusSectorAngleRadian / sectorCount;
//        float stackStep = 2 * pi / stackCount;
//        float sectorAngle, stackAngle;
//        float x, y, z;
//
//        for (int i = 0; i <= stackCount; ++i) {
//            stackAngle = i * stackStep;                // starting from 0 to 2pi
//            x = radiusToCenterTube + radiusofTube * (float) Math.sin(stackAngle);
//            y = radiusToCenterTube + radiusofTube * (float) Math.sin(stackAngle);
//            z = radiusofTube * (float) Math.cos(stackAngle);
//
//            // add (sectorCount+1) vertices per stack
//            // the first and last vertices have same position and normal, but different tex coords
//            for (int j = 0; j <= sectorCount; ++j) {
//                sectorAngle = j * sectorStep;           // starting from 0 to torusSectorAngleRadian
//                Vector3f tempVector = new Vector3f();
//
//                tempVector.x = center.x + x * (float) Math.sin(sectorAngle);
//                tempVector.y = center.y + y * (float) Math.cos(sectorAngle);
//                tempVector.z = center.z + z;
//                torusVertices.add(tempVector);
//            }
//        }
//        return torusVertices;
//    }

    public void setupIBO(int sectorCount, int stackCount) {
        // Setup urutan index dan ibo
//        index = Arrays.asList(0, 3, 3, 1, 1, 4, 4, 2, 2, 0);

        // Stack = Rownya (Yang melingkar searah putaran donut)
        // Sector = Columnnya (Yang melingkar tegak lurus putaran donut)
//        List<List<Vector3f>> torusStacks = new ArrayList<>();
//        for (int i = 0; i < stackCount - 1; i++) {
//            torusStacks.add(this.vertices.subList(sectorCount * i, sectorCount * (i + 1)));
//        }

        System.out.println("Size: " + this.vertices.size());
        // Buat masukin ke indexnya
        for (int i = 0; i < stackCount; i++) {
            for (int j = 0; j < sectorCount; j++) {
                // Titiknya: stack sekarang sector sekarang, stack selanjutnya sector sekarang, stack sekarang sector selanjutnya
                index.add(((sectorCount + 1) * i) + j);
                index.add(((sectorCount + 1) * (i + 1)) + j);
                index.add(((sectorCount + 1) * i) + j + 1);

                // Titiknya: stack selanjutnya sector selanjutnya, stack sekarang sector selanjutnya, stack selanjutnya sector selanjutnya
                index.add(((sectorCount + 1) * (i + 1)) + j);
                index.add(((sectorCount + 1) * i) + j + 1);
                index.add(((sectorCount + 1) * (i + 1)) + j + 1);

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

        System.out.println(index);

        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, Utils.listoInt(index), GL_STATIC_DRAW);
    }

    // ASUMSI: startSector >= 0, endSector < sectorCount
    public void setupIBO(int sectorCount, int stackCount, int startSector, int endSector) {
        // Setup urutan index dan ibo
//        index = Arrays.asList(0, 3, 3, 1, 1, 4, 4, 2, 2, 0);

        // Stack = Rownya (Yang melingkar searah putaran donut)
        // Sector = Columnnya (Yang melingkar tegak lurus putaran donut)
//        List<List<Vector3f>> torusStacks = new ArrayList<>();
//        for (int i = 0; i < stackCount - 1; i++) {
//            torusStacks.add(this.vertices.subList(sectorCount * i, sectorCount * (i + 1)));
//        }

        // Buat masukin ke indexnya
        for (int i = 0; i < stackCount; i++) {
            for (int j = startSector; j <= endSector; j++) {
//        for (int i = startSector; i <= endSector; i++) {
//            for (int j = 0; j < sectorCount; j++) {
                // Titiknya: stack sekarang sector sekarang, stack selanjutnya sector sekarang, stack sekarang sector selanjutnya
                index.add(((sectorCount + 1) * i) + j);
                index.add(((sectorCount + 1) * (i + 1)) + j);
                index.add(((sectorCount + 1) * i) + j + 1);

                // Titiknya: stack selanjutnya sector selanjutnya, stack sekarang sector selanjutnya, stack selanjutnya sector selanjutnya
                index.add(((sectorCount + 1) * (i + 1)) + j);
                index.add(((sectorCount + 1) * i) + j + 1);
                index.add(((sectorCount + 1) * (i + 1)) + j + 1);
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
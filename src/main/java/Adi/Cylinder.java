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

// Rumus cylinder dari website ini:
// https://mathworld.wolfram.com/Cylinder.html
// Asumsi v = sector, u = stack

public class Cylinder extends Object {
    List<Integer> index = new ArrayList<>();
    int ibo;

    // Constructor biasa
    public Cylinder(List<ShaderModuleData> shaderModuleDataList, Vector3f center, float radiusX, float radiusY, float cylinderHeight, int sectorCount, int stackCount, Vector4f color) {
        super(shaderModuleDataList, Utils.dummyVerticeValue(), color);

        // Set the actual vertice value
        this.vertices = calculateCylinderVertices(center, radiusX, radiusY, cylinderHeight, sectorCount, stackCount);

        // Call Setup
        setupVAOVBO();
        setupIBO(sectorCount, stackCount);
    }

    // Constructor dengan custom bottomSideCenterHeight dan topSideCenterHeight, agar membentuk seperti kristal
    public Cylinder(List<ShaderModuleData> shaderModuleDataList, Vector3f center, float radiusX, float radiusY, float cylinderHeight, int sectorCount, int stackCount, float bottomSideCenterHeight, float topSideCenterHeight, Vector4f color) {
        super(shaderModuleDataList, Utils.dummyVerticeValue(), color);

        // Set the actual vertice value
        this.vertices = calculateCylinderVertices(center, radiusX, radiusY, cylinderHeight, sectorCount, stackCount, bottomSideCenterHeight, topSideCenterHeight);

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

        // Gambar child
        for (Object child : getChildObject()) {
            child.draw();
        }
    }

    public List<Vector3f> calculateCylinderVertices(Vector3f center, float radiusX, float radiusY, float cylinderHeight, int sectorCount, int stackCount) {
        ArrayList<Vector3f> sphereVertices = new ArrayList<>();

        // Vertice pertama: Titik tengah sisi alas/atas
        sphereVertices.add(new Vector3f(0.0f, 0.0f, -cylinderHeight/2));

        // Vertice selanjutnya: Sekeliling cylinder
        float pi = (float) Math.PI;

        float sectorStep = 2 * pi / sectorCount;
        float stackStep = cylinderHeight / stackCount;
        float sectorAngle, stackAngle;
        float x, y, z;

        for (int i = 0; i <= stackCount; ++i) {
            stackAngle = i * stackStep;        // starting from 0 to cylinderHeight
            x = radiusX;
            y = radiusY;
            z = stackAngle - (cylinderHeight / 2);

            // add (sectorCount+1) vertices per stack
            // the first and last vertices have same position and normal, but different tex coords
            for (int j = 0; j < sectorCount; ++j) {
                sectorAngle = j * sectorStep;           // starting from 0 to 2pi
                Vector3f tempVector = new Vector3f();

                tempVector.x = center.x + x * (float) Math.cos(sectorAngle);
                tempVector.y = center.y + y * (float) Math.sin(sectorAngle);
                tempVector.z = center.z + z;
                sphereVertices.add(tempVector);
            }
        }

        // Vertice terakhir: Titik tengah sisi alas/atas
        sphereVertices.add(new Vector3f(0.0f, 0.0f, cylinderHeight/2));

        return sphereVertices;
    }

    // calculateCylinderVertices dengan custom bottomSideCenterHeight dan topSideCenterHeight, agar membentuk seperti kristal
    public List<Vector3f> calculateCylinderVertices(Vector3f center, float radiusX, float radiusY, float cylinderHeight, int sectorCount, int stackCount, float bottomSideCenterHeight, float topSideCenterHeight) {
        ArrayList<Vector3f> sphereVertices = new ArrayList<>();

        // Vertice pertama: Titik tengah sisi alas/atas
        sphereVertices.add(new Vector3f(0.0f, 0.0f, bottomSideCenterHeight));

        // Vertice selanjutnya: Sekeliling cylinder
        float pi = (float) Math.PI;

        float sectorStep = 2 * pi / sectorCount;
        float stackStep = cylinderHeight / stackCount;
        float sectorAngle, stackAngle;
        float x, y, z;

        for (int i = 0; i <= stackCount; ++i) {
            stackAngle = i * stackStep;        // starting from 0 to cylinderHeight
            x = radiusX;
            y = radiusY;
            z = stackAngle - (cylinderHeight / 2);

            // add (sectorCount+1) vertices per stack
            // the first and last vertices have same position and normal, but different tex coords
            for (int j = 0; j < sectorCount; ++j) {
                sectorAngle = j * sectorStep;           // starting from 0 to 2pi
                Vector3f tempVector = new Vector3f();

                tempVector.x = center.x + x * (float) Math.cos(sectorAngle);
                tempVector.y = center.y + y * (float) Math.sin(sectorAngle);
                tempVector.z = center.z + z;
                sphereVertices.add(tempVector);
            }
        }

        // Vertice terakhir: Titik tengah sisi alas/atas
        sphereVertices.add(new Vector3f(0.0f, 0.0f, topSideCenterHeight));

        return sphereVertices;
    }

    public void setupIBO(int sectorCount, int stackCount) {
//        System.out.println("Size: " + this.vertices.size());
        // Buat masukin ke indexnya
        // Sisi sekeliling
        for (int i = 0; i < stackCount; i++) {
            for (int j = 0; j < sectorCount; j++) {
                // Titiknya: stack sekarang sector sekarang, stack selanjutnya sector sekarang, stack sekarang sector selanjutnya
                index.add(((sectorCount) * i) + j + 1);
                index.add(((sectorCount) * (i + 1)) + j + 1);
                if (j == sectorCount - 1) {
                    // Kalau sector terakhir, kaitkan dengan sector awal
                    index.add(((sectorCount) * i) + 1);
                } else {
                    // Kalau bukan sector terakhir, kaitkan dengan stack selanjutnya
                    index.add(((sectorCount) * i) + j + 1 + 1);
                }

                // Titiknya: stack selanjutnya sector selanjutnya, stack sekarang sector selanjutnya, stack selanjutnya sector selanjutnya
                index.add(((sectorCount) * (i + 1)) + j + 1);
                if (j == sectorCount - 1) {
                    // Kalau sector terakhir, kaitkan dengan sector awal
                    index.add(((sectorCount) * i) + 1);
                } else {
                    // Kalau bukan sector terakhir, kaitkan dengan stack selanjutnya
                    index.add(((sectorCount) * i) + j + 1 + 1);
                }
                if (j == sectorCount - 1) {
                    // Kalau sector terakhir, kaitkan dengan sector awal
                    index.add(((sectorCount) * i) + j + 1 + 1);
                } else {
                    // Kalau bukan sector terakhir, kaitkan dengan stack selanjutnya
                    index.add(((sectorCount) * (i + 1)) + j + 1 + 1);
                }
            }
        }

        // Sisi Bawah
        for (int i = 0; i < sectorCount; i++) {
            // Titiknya: 0, stack sekarang sector + 1, stack sekarang sector + 2
            index.add(0);
            index.add(i + 1);
            if (i == sectorCount - 1) {
                // Kalau sector terakhir, kaitkan dengan sector awal
                index.add(1);
            } else {
                // Kalau bukan sector terakhir, kaitkan dengan stack selanjutnya
                index.add(i + 2);
            }
        }

        // Sisi Atas
        for (int i = 0; i < sectorCount; i++) {
            // Titiknya: vertice terakhir, stack sekarang sector + 1, stack sekarang sector + 2
            int lastVertice = vertices.size() - 1;
            index.add(lastVertice);
            index.add(lastVertice - sectorCount + i);
            if (i == sectorCount - 1) {
                // Kalau sector terakhir, kaitkan dengan sector awal
                index.add(lastVertice - sectorCount);
            } else {
                // Kalau bukan sector terakhir, kaitkan dengan stack selanjutnya
                index.add(lastVertice - sectorCount + i + 1);
            }
        }
//        System.out.println(index);

        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, Utils.listoInt(index), GL_STATIC_DRAW);
    }
}

package Adi;

import Engine.*;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.*;

import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.opengl.GL20C.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30C.glGenVertexArrays;

public class Sphere extends Object {
//    // Constructor
//    public Sphere(List<ShaderModuleData> shaderModuleDataList, Vector3f center, float radiusX, float radiusY, int amountOfVertices, Vector4f color) {
//        super(shaderModuleDataList, Utils.dummyVerticeValue(), color);
//
//        // Set the actual vertice value
//        this.vertices = calculateEllipseVertices(center, radiusX, radiusY, amountOfVertices);
//        // Call Setup
//        setupVAOVBO();
//    }
//
//    // Constructor dengan angle (untuk Star)
//    public Sphere(List<ShaderModuleData> shaderModuleDataList, Vector3f center, float radiusX, float radiusY, int amountOfVertices, Vector4f color, float rotation) {
//        super(shaderModuleDataList, Utils.dummyVerticeValue(), color);
//
//        // Set the actual vertice value
//        this.vertices = calculateEllipseVertices(center, radiusX, radiusY, amountOfVertices, rotation);
//        // Call Setup
//        setupVAOVBO();
//    }

    // Constructor untuk Sphere
    public Sphere(List<ShaderModuleData> shaderModuleDataList, Vector3f center, float radiusX, float radiusY, float radiusZ, int stackCount, int sectorCount, Vector4f color) {
        super(shaderModuleDataList, Utils.dummyVerticeValue(), color);

        // Set the actual vertice value
        this.vertices = calculateSphereVertices(center, radiusX, radiusY, radiusZ, stackCount, sectorCount);

        this.setCenterPoint(center);

        // Call Setup
        setupVAOVBO();
    }

//    // Draw pakai Polygon
//    @Override
//    public void draw() {
//        drawSetup();
//        // Draw the vertices
//        // Optional
//        glLineWidth(1);
//        glPointSize(2);
//        // Wajib
//        glDrawArrays(GL_POLYGON, 0, vertices.size());
//        // Pilihan draw:
//        // LINES
//        // LINE_STRIP
//        // TRIANGLES
//        // TRIANGLE_FAN
//        // POINT
//        // Parameter first dan end itu, vertices yang digambar mulai dari index keberapa, terus dari first ngegambar berapa kali.
//        // Misal 0, 2. Berarti, digambar index 0, 1, 2. Soalnya dari index 0 maju 2x
//    }

//    // Ellipse Vertices tanpa rotation
//    public List<Vector3f> calculateEllipseVertices(Vector3f center, float radiusX, float radiusY, int amountOfVertices) {
//        return calculateEllipseVertices(center, radiusX, radiusY, amountOfVertices, 0);
//    }
//
//    // Ellipse Vertices dengan rotation
//    public List<Vector3f> calculateEllipseVertices(Vector3f center, float radiusX, float radiusY, int amountOfVertices, float rotation) {
//        List<Vector3f> ellipseVertices = new ArrayList<Vector3f>();
//        Vector3f secondVertice = new Vector3f(0, 0, 0);
//
//        // Hitung incTetha
//        float incTetha = (float)360/amountOfVertices;
//
//        // Add centernya ke vertices
//        ellipseVertices.add(center);
//
//        // Generate vertices
//        for (int i = 0; i < amountOfVertices; i++) {
//            double currentTethaRadians = Math.toRadians(i * incTetha + rotation);
//            float posX = center.x + radiusX * (float)Math.cos(currentTethaRadians);
//            float posY = center.y + radiusY * (float)Math.sin(currentTethaRadians);
//
//            ellipseVertices.add(new Vector3f(posX, posY, 0));
//            if (i == 0) {
//                secondVertice = new Vector3f(posX, posY, 0);
//            }
//        }
//
//        // Add Second Vertice ke vertices agar menjadi lingkaran penuh
//        ellipseVertices.add(secondVertice);
//
//        // Return list verticenya
//        return ellipseVertices;
//    }

    public List<Vector3f> calculateSphereVertices(Vector3f center, float radiusX, float radiusY, float radiusZ, int sectorCount, int stackCount) {
        ArrayList<Vector3f> sphereVertices = new ArrayList<>();

        float pi = (float)Math.PI;

        float sectorStep = 2 * pi / sectorCount;
        float stackStep = pi / stackCount;
        float sectorAngle, stackAngle;
        float x, y, z;

        for(int i = 0; i <= stackCount; ++i)
        {
            stackAngle = pi / 2 - i * stackStep;        // starting from pi/2 to -pi/2
            x = radiusX * (float)Math.cos(stackAngle);
            y = radiusY * (float)Math.cos(stackAngle);
            z = radiusZ * (float)Math.sin(stackAngle);

            // add (sectorCount+1) vertices per stack
            // the first and last vertices have same position and normal, but different tex coords
            for(int j = 0; j <= sectorCount; ++j)
            {
                sectorAngle = j * sectorStep;           // starting from 0 to 2pi
                Vector3f tempVector = new Vector3f();

                tempVector.x = center.x + x * (float)Math.cos(sectorAngle);
                tempVector.y = center.y + y * (float)Math.sin(sectorAngle);
                tempVector.z = center.z + z;
                sphereVertices.add(tempVector);
            }
        }
        return sphereVertices;
    }
}

package Adi;

import Engine.*;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.*;

import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.opengl.GL20C.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30C.glGenVertexArrays;

/*
stackAngle = v
sectorAngle = u

sectorCount: Di tiap lingkaran yang atasbawah itu jumlahnya berapa (column)
stackCount, ada berapa row dari sector
*/

public class Sphere extends Object {
    // Constructor untuk Sphere
    public Sphere(List<ShaderModuleData> shaderModuleDataList, Vector3f center, float radiusX, float radiusY, float radiusZ, int sectorCount, int stackCount, Vector4f color) {
        super(shaderModuleDataList, Utils.dummyVerticeValue(), color);

        // Set the actual vertice value
        this.vertices = calculateSphereVertices(center, radiusX, radiusY, radiusZ, sectorCount, stackCount);

        this.setCenterPoint(center);

        // Call Setup
        setupVAOVBO();
    }

    // Constructor untuk Sphere yang Egg Shell
    // Frustum = ada berapa row yang diambil
    // Asumsi: bottom frustum tidak negatif dan topfrustum < stackCount
    public Sphere(List<ShaderModuleData> shaderModuleDataList, Vector3f center, float radiusX, float radiusY, float radiusZ, int sectorCount, int stackCount, int bottomFrustum, int topFrustum, Vector4f color) {
        super(shaderModuleDataList, Utils.dummyVerticeValue(), color);

        // Set the actual vertice value
        this.vertices = calculateSphereVerticesWithFrustum(center, radiusX, radiusY, radiusZ, sectorCount, stackCount, bottomFrustum, topFrustum);

        this.setCenterPoint(center);

        // Call Setup
        setupVAOVBO();
    }

    // Constructor untuk Sphere yang float
    public Sphere(List<ShaderModuleData> shaderModuleDataList, Vector3f center, float radiusX, float radiusY, float radiusZ, int sectorCount, int stackCount, float sectorAngleRadian, float stackAngleRadian, Vector4f color) {
        super(shaderModuleDataList, Utils.dummyVerticeValue(), color);

        // Set the actual vertice value
        this.vertices = calculateSphereVertices(center, radiusX, radiusY, radiusZ, sectorCount, stackCount, sectorAngleRadian, stackAngleRadian);

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

    public List<Vector3f> calculateSphereVertices(Vector3f center, float radiusX, float radiusY, float radiusZ, int sectorCount, int stackCount) {
        ArrayList<Vector3f> sphereVertices = new ArrayList<>();

        float pi = (float)Math.PI;

        float sectorStep = 2 * pi / sectorCount;
        float stackStep = pi / stackCount;
        float sectorAngle, stackAngle;
        float x, y, z;

        for(int i = 0; i <= stackCount; ++i)
        {
            stackAngle = - 1 * pi / 2 + i * stackStep;        // starting from -pi/2 to pi/2
            x = radiusX * (float)Math.cos(stackAngle);
            y = radiusY * (float)Math.cos(stackAngle);
            z = radiusZ * (float)Math.sin(stackAngle);

            // add (sectorCount+1) vertices per stack
            // the first and last vertices have same position and normal, but different tex coords
            for(int j = 0; j <= sectorCount; ++j)
            {
                sectorAngle = -1 * pi + j * sectorStep;           // starting from -pi to pi
                Vector3f tempVector = new Vector3f();

                tempVector.x = center.x + x * (float)Math.cos(sectorAngle);
                tempVector.y = center.y + y * (float)Math.sin(sectorAngle);
                tempVector.z = center.z + z;
                sphereVertices.add(tempVector);
            }
        }
        return sphereVertices;
    }

    // TODO: Ini coba seperti rumus ellipsoid dipaskan v dan u rangenya
    public List<Vector3f> calculateSphereVertices(Vector3f center, float radiusX, float radiusY, float radiusZ, int sectorCount, int stackCount, float sectorAngleRadian, float stackAngleRadian) {
        ArrayList<Vector3f> sphereVertices = new ArrayList<>();

        float pi = (float)Math.PI;

        float sectorStep = sectorAngleRadian / sectorCount;
        float stackStep = stackAngleRadian / stackCount;
        float sectorAngle, stackAngle;
        float x, y, z;

        for(int i = 0; i <= stackCount; ++i)
        {
            stackAngle = i * stackStep;        // starting from 0 to 2pi ?
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

    // Frustum = ada berapa row yang diambil
    // Asumsi: bottom frustum tidak negatif dan topfrustum < stackCount
    public List<Vector3f> calculateSphereVerticesWithFrustum(Vector3f center, float radiusX, float radiusY, float radiusZ, int sectorCount, int stackCount, int bottomFrustum, int topFrustum) {
        List<Vector3f> sphereVertices = calculateSphereVertices(center, radiusX, radiusY, radiusZ, sectorCount, stackCount);
        List<Vector3f> cutSphereVertices = new ArrayList<>();
//        System.out.println("Size: " + sphereVertices.size());

        for (int i = bottomFrustum; i < topFrustum + 1; i++) {
//            System.out.println("i: " + i);
            for (int j = 0; j < sectorCount + 1; j++) {
                cutSphereVertices.add(sphereVertices.get(((sectorCount + 1) * i) + j));
//                System.out.println(((sectorCount + 1) * i) + j);
            }
        }
//        System.out.println("Size:" + cutSphereVertices.size());
//        System.out.println(cutSphereVertices);

        return cutSphereVertices;
    }
}


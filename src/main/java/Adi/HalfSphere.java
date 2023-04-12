package Adi;

import Engine.*;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.*;

import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.opengl.GL20C.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30C.glGenVertexArrays;

public class HalfSphere extends Object {
    // Constructor untuk HalfSphere
    public HalfSphere(List<ShaderModuleData> shaderModuleDataList, Vector3f center, float radiusX, float radiusY, float radiusZ, int stackCount, int sectorCount, Vector4f color) {
        super(shaderModuleDataList, Utils.dummyVerticeValue(), color);

        // Set the actual vertice value
        this.vertices = calculateHalfSphereVertices(center, radiusX, radiusY, radiusZ, stackCount, sectorCount);

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

    public List<Vector3f> calculateHalfSphereVertices(Vector3f center, float radiusX, float radiusY, float radiusZ, int sectorCount, int stackCount) {
        ArrayList<Vector3f> sphereVertices = new ArrayList<>();

        float pi = (float)Math.PI;

        float sectorStep = pi / sectorCount;
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

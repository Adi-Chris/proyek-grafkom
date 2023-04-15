package Ryan;

import Engine.*;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.*;

public class HalfSphere extends Object {
    float centerX;
    float centerY;
    float centerZ;

    public HalfSphere(List<ShaderModuleData> shaderModuleDataList, Vector4f color, float centerX, float centerY, float centerZ, float radiusX, float radiusY, float radiusZ, int stackCount, int sectorCount) {
        super(shaderModuleDataList, Utils.dummyVerticeValue(), color);
        this.vertices = calculateHalfSphereVertices(centerX, centerY, centerZ, radiusX, radiusY, radiusZ, stackCount, sectorCount);
        this.centerX = centerX;
        this.centerY = centerY;
        this.centerZ = centerZ;
        // Call Setup
        setupVAOVBO();
    }

    public List<Vector3f> calculateHalfSphereVertices(float centerX, float centerY, float centerZ, float radiusX, float radiusY, float radiusZ, int sectorCount, int stackCount) {
        ArrayList<Vector3f> sphereVertices = new ArrayList<>();

        float pi = (float) Math.PI;

        float sectorStep = pi / sectorCount;
        float stackStep = pi / stackCount;
        float sectorAngle, stackAngle;
        float x, y, z;

        for (int i = 0; i <= stackCount; ++i) {
            stackAngle = pi / 2 - i * stackStep;        // starting from pi/2 to -pi/2
            x = radiusX * (float) Math.cos(stackAngle);
            y = radiusY * (float) Math.cos(stackAngle);
            z = radiusZ * (float) Math.sin(stackAngle);

            // add (sectorCount+1) vertices per stack
            // the first and last vertices have same position and normal, but different tex coords
            for (int j = 0; j <= sectorCount; ++j) {
                sectorAngle = j * sectorStep;           // starting from 0 to 2pi
                Vector3f tempVector = new Vector3f();

                tempVector.x = centerX + x * (float) Math.cos(sectorAngle);
                tempVector.y = centerY + y * (float) Math.sin(sectorAngle);
                tempVector.z = centerZ + z;
                sphereVertices.add(tempVector);
            }
        }
        return sphereVertices;
    }
}
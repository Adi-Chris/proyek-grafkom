package Louis;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

public class Cylinder extends Object {
    float centerX;
    float centerY;
    float centerZ;
    float radiusX;
    float radiusY;
    float radiusZ;

    public Cylinder(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, float centerX, float centerY, float centerZ, float radiusX, float radiusY, float radiusZ) {
        super(shaderModuleDataList, vertices, color);
        this.centerX = centerX;
        this.centerY = centerY;
        this.centerZ = centerZ;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
        this.radiusZ = radiusZ;
        createCylinder();
        setupVAOVBO();
    }

    public void createCylinderu() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        // Create sides of cylinder
        for (double theta = 0; theta <= Math.PI * 2; theta += Math.PI / 180) {
            for (double v = 0; v <= 1; v += 1 / 180) {
                float x = radiusX * (float) Math.cos(theta);
                float y = radiusY * (float) v;
                float z = radiusZ * (float) Math.sin(theta);
                temp.add(new Vector3f(x, y - (radiusY / 2.0f), z));
            }
        }

        // Create top cap of cylinder
        for (double theta = 0; theta <= Math.PI * 2; theta += Math.PI / 180) {
            float x = radiusX * (float) Math.cos(theta);
            float y = radiusY / 2.0f;
            float z = radiusZ * (float) Math.sin(theta);
            temp.add(new Vector3f(x, y, z));
        }

        // Create bottom cap of cylinder
        for (double theta = 0; theta <= Math.PI * 2; theta += Math.PI / 180) {
            float x = radiusX * (float) Math.cos(theta);
            float y = -radiusY / 2.0f;
            float z = radiusZ * (float) Math.sin(theta);
            temp.add(new Vector3f(x, y, z));
        }

        vertices = temp;
    }


    public void createCylinder() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double theta = 0; theta <= Math.PI * 2; theta += Math.PI / 180) {
            for (double v = 0; v <= 1; v += 1 / 16.0) {
                float x = radiusX * (float) Math.cos(theta);
                float y = radiusY * (float) v;
                float z = radiusZ * (float) Math.sin(theta);
                temp.add(new Vector3f(x, y - (radiusY / 2.0f), z));
            }
        }
        vertices = temp;
    }
}

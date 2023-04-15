package Louis;

import Engine.*;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;

public class Cube extends Object {
    float centerX;
    float centerY;
    float centerZ;
    float radiusX;
    float radiusY;
    float radiusZ;

    public Cube(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, float centerX, float centerY, float centerZ, float radiusX, float radiusY, float radiusZ) {
        super(shaderModuleDataList, vertices, color);
        this.centerX = centerX;
        this.centerY = centerY;
        this.centerZ = centerZ;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
        this.radiusZ = radiusZ;
        createCube();
        setupVAOVBO();
    }

    public void createCube() {
        vertices.clear();
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();

        // Titik 1 kiri atas belakang
        temp.x = centerX - radiusX / 2;
        temp.y = centerY + radiusY / 2;
        temp.z = centerZ - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // Titik 2 kiri bawah belakang
        temp.x = centerX - radiusX / 2;
        temp.y = centerY - radiusY / 2;
        temp.z = centerZ - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // Titik 3 kanan bawah belakang
        temp.x = centerX + radiusX / 2;
        temp.y = centerY - radiusY / 2;
        temp.z = centerZ - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // Titik 4 kanan atas belakang
        temp.x = centerX + radiusX / 2;
        temp.y = centerY + radiusY / 2;
        temp.z = centerZ - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // Titik 5 kiri atas depan
        temp.x = centerX - radiusX / 2;
        temp.y = centerY + radiusY / 2;
        temp.z = centerZ + radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // Titik 6 kiri bawah depan
        temp.x = centerX - radiusX / 2;
        temp.y = centerY - radiusY / 2;
        temp.z = centerZ + radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // Titik 7 kanan bawah depan
        temp.x = centerX + radiusX / 2;
        temp.y = centerY - radiusY / 2;
        temp.z = centerZ + radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // Titik 8 kanan atas depan
        temp.x = centerX + radiusX / 2;
        temp.y = centerY + radiusY / 2;
        temp.z = centerZ + radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // Kotak belakang
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));

        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(0));

        // Kotak depan
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));

        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(4));

        // Kotak samping kiri
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(1));

        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));

        // Kotak samping kanan
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));

        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(7));

        // Kotak atas
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(3));

        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));

        // Kotak bawah
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));

        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
    }

    public void setCenterX(float centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(float centerY) {
        this.centerY = centerY;
    }

    public void setCenterZ(float centerZ) {
        this.centerZ = centerZ;
    }

    public float getCenterX() {
        return centerX;
    }

    public float getCenterY() {
        return centerY;
    }

    public float getCenterZ() {
        return centerZ;
    }
}
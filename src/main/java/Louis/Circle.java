package Louis;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

public class Circle extends Object {
    float centerX;
    float centerY;
    float radiusX;
    float radiusY;

    public Circle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, float centerX, float centerY, float radiusX, float radiusY) {
        super(shaderModuleDataList, vertices, color);
        this.centerX = centerX;
        this.centerY = centerY;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
        createCircle();
        setupVAOVBO();
    }

    public void createCircle() {
        vertices.clear();

        for (double i = 0; i < 360; i += 0.01f) {
            float x = (float) (radiusX * Math.cos(i) + centerX);
            float y = (float) (radiusY * Math.sin(i) + centerY);
            vertices.add(new Vector3f(x, y, 0.0f));
        }
    }

    public float getCenterX() {
        return centerX;
    }

    public float getCenterY() {
        return centerY;
    }

    public void setCenterX(float centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(float centerY) {
        this.centerY = centerY;
    }

    public float getRadiusX() {
        return radiusX;
    }

    public boolean isOverlap(float x, float y) {
        float jarak = (float) Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2));
        return jarak <= 2 * this.radiusX;
    }

    public boolean isTouched(float x, float y) {
        float jarak = (float) Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2));
        return jarak <= this.radiusX;
    }

    public void moveKotak(float x, float y, float radius) {
        this.centerX = x;
        this.centerY = y;
        this.radiusX = radius;
        this.radiusY = radius;
        createCircle();
        setupVAOVBO();
    }

    public void update(int index, Vector3f newVector) {

    }
}
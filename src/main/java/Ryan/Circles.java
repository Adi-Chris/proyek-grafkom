package Ryan;
import Engine .*;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

public class Circles extends Object2d {
    public float centerx;
    public float centery;
    public float radiusX;
    public float radiusY;

    public float getCenterx() {
        return centerx;
    }

    public float getCentery() {
        return centery;
    }

    public float getRadiusX() {
        return radiusX;
    }

    public float getRadiusY() {
        return radiusY;
    }

    public void setCenterx(float centerx) {
        this.centerx = centerx;
    }

    public void setCentery(float centery) {
        this.centery = centery;
    }

    public void setRadiusX(float radiusX) {
        this.radiusX = radiusX;
    }

    public void setRadiusY(float radiusY) {
        this.radiusY = radiusY;
    }

    public Circles(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, float centerx, float centery, float radiusX, float radiusY) {
        super(shaderModuleDataList, vertices, color);
        this.centerx = centerx;
        this.centery = centery;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
        createCircle();
        setupVAOVBO();
    }

    public void createCircle() {
        //vertices -> clear dlu
        vertices.clear();
        // batas kiri kanan -1 sm 1
        // int degree = 45;
        // i += biar loopnya 4 kali untuk persegi
        // kalo segitiga loopnya 3 kali
        // kalo elipse radius yang x sendiri terus radius y  juga sendiri beda2
        for (double i = 0; i < 360; i += 0.01f) {
            float x = (float) (centerx + radiusX * Math.cos(i));
            float y = (float) (centery + radiusY * Math.sin(i));
            vertices.add(new Vector3f(x, y, 0.0f));

            // setiap loop degree += 90 kalo rectangle
        }
    }

    @Override
    public void draw() {
        drawSetup();
        glLineWidth(10);
        glPointSize(10);
        glDrawArrays(GL_POLYGON, 0, vertices.size());
    }
}

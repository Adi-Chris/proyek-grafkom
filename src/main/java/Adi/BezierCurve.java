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

public class BezierCurve extends Object {
    public BezierCurve(List<ShaderModuleData> shaderModuleDataList, Vector4f color) {
        super(shaderModuleDataList, Utils.dummyVerticeValue(), color);
    }

    @Override
    // Draw Line
    public void draw() {
        drawSetup();
        // Draw the vertices
        // Optional
        glLineWidth(12);
        glPointSize(10);
        // Wajib
        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());
        // Pilihan draw:
        // LINES
        // LINE_STRIP
        // TRIANGLES
        // TRIANGLE_FAN
        // POINT
        // Parameter first dan end itu, vertices yang digambar mulai dari index keberapa, terus dari first ngegambar berapa kali.
        // Misal 0, 2. Berarti, digambar index 0, 1, 2. Soalnya dari index 0 maju 2x

    }

    // startPoint = titik mulai bezier, yaitu sphere ice beam
    // oppositePoint = titik yang dijauhi bezier, yaitu Regice
    public List<Vector3f> makeHandlePointTowardDirection(Vector3f startPoint, Vector3f oppositePoint, int handlePointCount) {
        List<Vector3f> handlePoints = new ArrayList<>();
        float stepRandom = 0.1f;

        for (int i = 1; i <= handlePointCount; i++) {
            Vector3f currentHandlePoint = new Vector3f();

            // Generate x
            if (startPoint.x - oppositePoint.x >= 0) {
                currentHandlePoint.x = Utils.randomNum(stepRandom * i, stepRandom * (i + 1));
//                System.out.println("X up");
            } else {
                currentHandlePoint.x = Utils.randomNum(-stepRandom * (i + 1), -stepRandom * i);
            }

            // Generate y
            if (startPoint.y - oppositePoint.y >= 0) {
                currentHandlePoint.y = Utils.randomNum(stepRandom * i, stepRandom * (i + 1));
//                System.out.println("Y up");
            } else {
                currentHandlePoint.y = Utils.randomNum(-stepRandom * (i + 1), -stepRandom * i);
            }

            // Generate z
            if (startPoint.z - oppositePoint.z >= 0) {
                currentHandlePoint.z = Utils.randomNum(stepRandom * i, stepRandom * (i + 1));
//                System.out.println("Z up");
            } else {
                currentHandlePoint.z = Utils.randomNum(-stepRandom * (i + 1), -stepRandom * i);
            }

            // Tambah dengan startingPoint
            currentHandlePoint = currentHandlePoint.add(startPoint);

//            System.out.println("Handle Point:" + currentHandlePoint);
            handlePoints.add(currentHandlePoint);
        }
//        System.out.println("Handle: ");
//        System.out.println(handlePoints);

        return handlePoints;
    }

    public void recalculateBezier(List<Vector3f> handlePoints, int amountOfBezierVertices) {
        // Clear Vertice
        this.vertices.clear();

        // Recalculate bezier vertices
        this.vertices = Utils.bezierCurve(handlePoints, amountOfBezierVertices);

        // Add first vertice
        this.vertices.add(0, handlePoints.get(0));

        // Add last vertice
        this.vertices.add(handlePoints.get(handlePoints.size()-1));

        // Call Setup
        setupVAOVBO();
    }

    public void recalculateBezier(Vector3f startPoint, Vector3f oppositePoint, int handlePointCount, int amountOfBezierVertices) {
        // Clear Vertice
        this.vertices.clear();

        List<Vector3f> handlePoints = new ArrayList<>();

        // Make handle points
        handlePoints = makeHandlePointTowardDirection(startPoint, oppositePoint, handlePointCount);

        // Recalculate bezier vertices
        this.vertices = Utils.bezierCurve(handlePoints, amountOfBezierVertices);

        // Add first vertice
        this.vertices.add(0, startPoint);

        // Add last vertice
        this.vertices.add(handlePoints.get(handlePoints.size()-1));

        // Call Setup
        setupVAOVBO();
    }
}

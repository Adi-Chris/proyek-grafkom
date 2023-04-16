package Ryan;

import Engine.*;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

public class Object extends ShaderProgram {
    List<Vector3f> vertices;
    int vao;
    int vbo;
    Vector4f color;
    UniformsMap uniformsMap;
    List<Vector3f> verticesColor;
    int vboColor;
    Matrix4f model;
    List <Object> childObject;

    public Vector3f updateCenterPoint() {
        Vector3f centerTemp = new Vector3f();
        model.transformPosition(0.0f, 0.0f, 0.0f, centerTemp);
        return centerTemp;
    }

    public Object(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList);

        this.vertices = vertices;
        this.color = color;
        setupVAOVBO();

        uniformsMap = new UniformsMap(getProgramId());
        uniformsMap.createUniform("uni_color");
        uniformsMap.createUniform("model");
        model = new Matrix4f();
        childObject = new ArrayList<>();
    }

    public void setupVAOVBO() {
        //set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        //set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(vertices), GL_STATIC_DRAW);
    }

    public void drawSetup() {
        bind();
        uniformsMap.setUniform("uni_color", color);
        uniformsMap.setUniform("model", model);

        // Bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
    }

    public void draw() {
        drawSetup();
        // Draw the vertices
        glLineWidth(1);
        glPointSize(0);
        glDrawArrays(GL_POLYGON, 0, vertices.size());
//        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());
        for(Object child : childObject) {
            child.draw();
        }
    }

    public void drawLine() {
        drawSetup();
        // Draw the vertices
        glLineWidth(5);
        glPointSize(1);
        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());
    }

    public void addVertices(Vector3f newVector) {
        vertices.add(newVector);
        setupVAOVBO();
    }
    public void changeVertices(int i, Vector3f newVector){
        vertices.set(i, newVector);
        setupVAOVBO();
    }

    public void update(int index, Vector3f newVector) {
        vertices.set(index, newVector);
        setupVAOVBO();
    }

    public void translateObject(Float offsetX, Float offsetY, Float offsetZ) {
        model = new Matrix4f().translate(offsetX, offsetY, offsetZ).mul(new Matrix4f(model));
        for (Object child : childObject) {
            child.translateObject(offsetX, offsetY, offsetZ);
        }
    }

    public void rotateObject(Float degree, Float offsetX, Float offsetY, Float offsetZ) {
        model = new Matrix4f().rotate(degree, offsetX, offsetY, offsetZ).mul(new Matrix4f(model));
        for (Object child : childObject) {
            child.rotateObject(degree, offsetX, offsetY, offsetZ);
        }
    }

    public void scaleObject(Float x, Float y, Float z) {
        model = new Matrix4f().scale(x, y, z).mul(new Matrix4f(model));
        for (Object child : childObject) {
            child.scaleObject(x, y, z);
        }
    }

    public List<Object> getChildObject() {
        return childObject;
    }

    public void setChildObject(List<Object> childObject) {
        this.childObject = childObject;
    }
}
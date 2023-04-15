package Ryan;
import Engine .*;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

public class Object2d extends ShaderProgram {

    List<Vector3f> vertices;
    int vao;
    int vbo;
    Vector4f color;
    UniformsMap uniformsMap;
    List<Vector3f> verticesColor;
    int vboColor;
    Matrix4f model;

    public Object2d(List<ShaderModuleData> shaderModuleDataList
            , List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        setupVAOVBO();
        this.color = color;
        uniformsMap = new UniformsMap(getProgramId());
        uniformsMap.createUniform("uni_color");
        uniformsMap.createUniform("model");
        model = new Matrix4f();
    }
    public Object2d(List<ShaderModuleData> shaderModuleDataList
            , List<Vector3f> vertices, List<Vector3f> verticesColor) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        this.verticesColor = verticesColor;
        setupVAOVBOWithVerticesColor();
    }

    public void setupVAOVBO() {
        //set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        //set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        //mengirim vertices ke shader
        glBufferData(GL_ARRAY_BUFFER,
                Utils.listoFloat(vertices),
                GL_STATIC_DRAW);
//        if(verticesColor.size()>0){
//
//        }
    }
    public void setupVAOVBOWithVerticesColor() {
        //set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        //set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        //mengirim vertices ke shader
        glBufferData(GL_ARRAY_BUFFER,
                Utils.listoFloat(vertices),
                GL_STATIC_DRAW);
        //set vboColor
        vboColor = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        //mengirim vertices ke shader
        glBufferData(GL_ARRAY_BUFFER,
                Utils.listoFloat(verticesColor),
                GL_STATIC_DRAW);
    }

    public void drawSetup() {
        bind();
        uniformsMap.setUniform("uni_color", color);
        uniformsMap.setUniform("model", model);

        // Bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3,
                GL_FLOAT,
                false,
                0, 0);
    }
    public void drawSetupWithVerticesColor() {
        bind();

        // Bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3,
                GL_FLOAT,
                false,
                0, 0);
        // Bind VBOColor
        glEnableVertexAttribArray(1);
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glVertexAttribPointer(1, 3,
                GL_FLOAT,
                false,
                0, 0);
    }

    public void draw() {
        drawSetup();
        // Draw the vertices
        glLineWidth(1);
        glPointSize(0);
//        GL_TRIANGLES
//        GL_LINE_LOOP
//        GL_LINE_STRIP
//        GL_LINES
//        GL_POINTS
//        GL_TRIANGLE_FAN
//        GL_POINTS

        glDrawArrays(GL_LINE_STRIP,
                0,
                vertices.size());
    }
    public void drawWithVerticesColor() {
        drawSetupWithVerticesColor();
        // Draw the vertices
        glLineWidth(1);
        glPointSize(0);

//        glDrawArrays(GL_TRIANGLES,
//                0,
//                vertices.size());
        glDrawArrays(GL_TRIANGLES,
                0,
                vertices.size());
    }

    public void drawLine() {
        drawSetup();
        // Draw the vertices
        glLineWidth(3);
        glPointSize(0);

        glDrawArrays(GL_LINE_STRIP, 0,
                vertices.size());
    }

    public void addVertice(Vector3f newVector){
        vertices.add(newVector);
        setupVAOVBO();
    }

    public void update(int index, Vector3f newVector){
        vertices.set(index, newVector);
        setupVAOVBO();
    }
    public void translateObject(Float offsetX, Float offsetY, Float offsetZ){
        model = new Matrix4f().translate(offsetX, offsetY, offsetZ).mul(new Matrix4f(model));
    }
    public void rotateObject(Float degree, Float offsetX, Float offsetY, Float offsetZ){
        model = new Matrix4f().rotate(degree, offsetX, offsetY, offsetZ).mul(new Matrix4f(model));
    }
    public void scaleObject(Float offsetX, Float offsetY, Float offsetZ){
        model = new Matrix4f().scale(offsetX, offsetY, offsetZ).mul(new Matrix4f(model));
    }
}
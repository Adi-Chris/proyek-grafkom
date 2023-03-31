package Adi;

import Engine.*;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20C.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20C.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30C.glBindVertexArray;
import static org.lwjgl.opengl.GL30C.glGenVertexArrays;


public class Object extends ShaderProgram {

    // Variables
    List<Vector3f> vertices;
    int vao;
    int vbo;

    UniformsMap uniformsMap;
    Vector4f color;

    int vboColor;
    List<Vector3f> verticesColor;

    public Matrix4f model;

    private Vector3f centerPoint = new Vector3f();

    // Hierarchy
    private List<Object> childObject;

    // Constructor
    public Object(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices,
                    Vector4f color) {
        super(shaderModuleDataList);
        this.vertices = vertices;

        this.color = color;
        this.childObject = new ArrayList<>();

        uniformsMap = new UniformsMap(getProgramId());
        // Tiap kali menambahi uniform, jangan lupa tambahi disini
        uniformsMap.createUniform(
                "uni_color"
        );
        uniformsMap.createUniform(
                "model"
        ); // NOTE: KALAU MAU PAKAI YANG SCENES.VERT DAN SCENES.FRAG, COMMENT DULU MODELNYA INI
        model = new Matrix4f().identity();

        // Call Setup
        setupVAOVBO();
    }

    // Constructor WithVertice
    public Object(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices,
                    List<Vector3f> verticesColor) {
        super(shaderModuleDataList);
        this.vertices = vertices;

        this.verticesColor = verticesColor;

        // Call Setup
        setupVAOVBOWithVerticesColor();
    }

    // Update vao and vbo
    public void setupVAOVBO() {
        // Set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        // Set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(vertices), GL_STATIC_DRAW);
    }

    // Update vao and vbo with vertices color
    public void setupVAOVBOWithVerticesColor() {
        // Set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        // Set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(vertices), GL_STATIC_DRAW);

        // Set vboColor
        vboColor = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(verticesColor), GL_STATIC_DRAW);
    }

    public void draw() {
        drawSetup();
        // Draw the vertices
        // Optional
        glLineWidth(10);
        glPointSize(10);
        // Wajib
        glDrawArrays(GL_POLYGON, 0, vertices.size());
        // Pilihan draw:
        // LINES
        // LINE_STRIP
        // TRIANGLES
        // TRIANGLE_FAN
        // POINT
        // Parameter first dan end itu, vertices yang digambar mulai dari index keberapa, terus dari first ngegambar berapa kali.
        // Misal 0, 2. Berarti, digambar index 0, 1, 2. Soalnya dari index 0 maju 2x

        // Gambar child
        for (Object child : childObject) {
            child.draw();
        }

    }

    // DrawWithVerticeColor
    public void drawWithVerticeColor() {
        drawSetupWithVerticeColor();
        // Draw the vertices
        // Optional
        glLineWidth(10);
        glPointSize(10);
        // Wajib
        glDrawArrays(GL_POLYGON, 0, vertices.size());
        // Pilihan draw:
        // LINES
        // LINE_STRIP
        // TRIANGLES
        // TRIANGLE_FAN
        // POINT
        // Parameter first dan end itu, vertices yang digambar mulai dari index keberapa, terus dari first ngegambar berapa kali.
        // Misal 0, 2. Berarti, digambar index 0, 1, 2. Soalnya dari index 0 maju 2x

    }

    // Draw Line saja
    public void drawLine() {
        drawSetup();
        // Draw the vertices
        // Optional
        glLineWidth(10);
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

    // Function untuk nambah vertice
    public void addVertice(Vector3f newVertices) {
        vertices.add(newVertices);
        // Setup ulang VAO VBO
        setupVAOVBO();
    }

    public void drawSetup() {
        bind();
        uniformsMap.setUniform("uni_color", color);
        uniformsMap.setUniform("model", model);

        // Bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT,false, 0, 0);
    }

    // Update vao and vbo with vertices color
    public void drawSetupWithVerticeColor() {
        bind();

        // Bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT,false, 0, 0);

        // Bind VBO Color
        glEnableVertexAttribArray(1);
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glVertexAttribPointer(1, 3, GL_FLOAT,false, 0, 0);
    }

    // Buat Translasi
    public void translateObject(float offsetX, float offsetY, float offsetZ) {
        model = new Matrix4f().translate(offsetX, offsetY, offsetZ).mul(new Matrix4f(model));

        updateCenterPoint();
        for (Object child : childObject) {
            child.translateObject(offsetX, offsetY, offsetZ);
        }
    }

    // Buat Rotasi
    public void rotateObject(float degree, float x, float y, float z) {
        model = new Matrix4f().rotate((float)Math.toRadians(degree), x, y, z).mul(new Matrix4f(model));

        updateCenterPoint();
        for (Object child : childObject) {
            child.rotateObject((float)Math.toRadians(degree), x, y, z);
        }
    }

    // Buat Rotasi berdasarkan titik pusat
    public void rotateObjectByCenter(float degree, float x, float y, float z) {
//        System.out.println("Initial: ");
//        System.out.println(model);

        // Cari Translation
        Vector3f translationMinus = new Vector3f();
        Vector3f translation = new Vector3f();
        model.getTranslation(translation);
        translationMinus = new Vector3f(new Vector3f(translation).mul(-1.0f));

        // Kembalikan ke origin
        model = new Matrix4f(model).translate(translationMinus);
//        System.out.println("Back to origin: ");
//        System.out.println(model);

        // Dirotasi
        model = new Matrix4f().rotate(degree, x, y, z).mul(new Matrix4f(model));
//        System.out.println("Rotate: ");
//        System.out.println(model);

        // Kembalikan ke awal
//        model = new Matrix4f(model).translate(translation.x, translation.y, translation.z);
        // For some reason, .translate() itu ngebug ketika menambah row 03, 13, dan 23, hahaha
        // Lebih baik dimanual saja :))
        model.setRowColumn(0, 3, model.get(0, 3) + translation.x);
        model.setRowColumn(1, 3, model.get(1, 3) + translation.y);
        model.setRowColumn(2, 3, model.get(2, 3) + translation.z);
        // Wait this is illegal. Harusnya get (3, 0), (3, 1), (3, 2) tapi kok kalau diubah begitu jadi bug
//        System.out.println("New + Rotated: ");
//        System.out.println(model);
    }

    // Buat Rotasi berdasarkan titik pusat object lain (Untuk bulan)
    public void rotateObjectByCenter(float degree, float x, float y, float z, Object other) {
//        this.translateObject(-other.centerPoint.x, -other.centerPoint.y, -other.centerPoint.z);
//        model = new Matrix4f().rotate(degree, x, y, z).mul(new Matrix4f(model));
//        this.translateObject(other.centerPoint.x, other.centerPoint.y, other.centerPoint.z);

        // DIBAWAH INI MUNGKIN BISA MENJADI BENAR, TAPI MASIH NGEBUG
        // Cari Translation
        System.out.println("Initial: ");
        System.out.println(model);
        Vector3f translationMinus = new Vector3f();
        Vector3f translation = new Vector3f();
        other.model.getTranslation(translation); // Ini udah dicoba pakai new tetep gak bisa
        translationMinus = new Vector3f(new Vector3f(translation).mul(-1.0f));
        System.out.println("Translation: ");
        System.out.println(translation);
        System.out.println("TranslationMinus: ");
        System.out.println(translationMinus);

        // Kembalikan ke origin
//        model = new Matrix4f(model).translate(translationMinus);
//        // For some reason, .translate() itu ngebug ketika menambah row 03, 13, dan 23, hahaha
//        // Lebih baik dimanual saja :))
        System.out.println(model.get(0, 3));
        model.setRowColumn(0, 3, model.get(3, 0) + translationMinus.x);
        model.setRowColumn(1, 3, model.get(3, 1) + translationMinus.y);
        model.setRowColumn(2, 3, model.get(3, 2) + translationMinus.z);
        System.out.println("Back to origin: ");
        System.out.println(model);

        // Dirotasi
        model = new Matrix4f().rotate(degree, x, y, z).mul(new Matrix4f(model));
        System.out.println("Rotate: ");
        System.out.println(model);

        // Kembalikan ke awal
//        model = new Matrix4f(model).translate(translation.x, translation.y, translation.z);
        // For some reason, .translate() itu ngebug ketika menambah row 03, 13, dan 23, hahaha
        // Lebih baik dimanual saja :))
        System.out.println("Translation: ");
        System.out.println(translation);
        System.out.println("TranslationMinus: ");
        System.out.println(translationMinus);
        model.setRowColumn(0, 3, model.get(3, 0) + translation.x);
        model.setRowColumn(1, 3, model.get(3, 1) + translation.y);
        model.setRowColumn(2, 3, model.get(3, 2) + translation.z);
        System.out.println("New + Rotated: ");
        System.out.println(model);
    }

    // Buat Translasi
    public void scaleObject(float scaleX, float scaleY, float scaleZ) {
        model = new Matrix4f().scale(scaleX, scaleY, scaleZ).mul(new Matrix4f(model));

        updateCenterPoint();
        for (Object child : childObject) {
            child.scaleObject(scaleX, scaleY, scaleZ);
        }
    }

    public void updateCenterPoint(){
        Vector3f destTemp = new Vector3f();
        model.transformPosition(0.0f,0.0f,0.0f,destTemp);
        centerPoint.set(destTemp.x, destTemp.y, destTemp.z);
        System.out.println(centerPoint.get(0) + " " + centerPoint.get(1));
    }

    public List<Object> getChildObject() {
        return childObject;
    }

    public void setChildObject(List<Object> childObject) {
        this.childObject = childObject;
    }

    public Vector3f getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(Vector3f centerPoint) {
        this.centerPoint = centerPoint;
    }
}

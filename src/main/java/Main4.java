import Engine.*;
import Ryan.Ellipsoid;
import Timotius.Cylinder;
import Timotius.Sphere;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main4 {
    private Window window =
            new Window(800, 800, "Uji");

    private ArrayList<Object> objectsPointsControl = new ArrayList<>();

    private ArrayList<Timotius.Sphere> objectsSphere = new ArrayList<>();
    private ArrayList<Timotius.Ellipsoid> objectsEllipsoid = new ArrayList<>();
    private ArrayList<Timotius.EllipticParaboloid> objectsEllipticParaboloid = new ArrayList<>();
    private ArrayList<Timotius.Cylinder> cylinder = new ArrayList<>();
    private ArrayList<Timotius.Object> berzier = new ArrayList<>();

    int tes;

    private static float[][] controlBerzier = {
            { -0.0835f, 0.09f, -0.3f},
            { 0.0835f, 0.09f, -0.3f}
    };
    private static float[][] controlBerzier2 = {
            { -0.0415f, 0.018f, -0.3f},
            { 0.0415f, 0.018f, -0.3f}
    };


//    Camera camera = new Camera();
//    Projection projection = new Projection(window.getWidth(), window.getHeight());

    public void init() {
        window.init();
        GL.createCapabilities();

//        objectsSphere.add(new Sphere(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                ),
//                new Vector4f(1.0f,0.0f,1.0f,1.0f), 0.4f,0.2f,0.2f,0.0f,0.5f,0.0f
//        ));

//        objectsSphere.add(new Sphere(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                ),
//                new Vector4f(0.792f,0.459f,0.196f,1.0f), 0.3f,0.25f,0.2f,0.1f,0.55f,0.0f
//        ));
//badan
        objectsSphere.add(new Sphere(Arrays.asList(
                //shaderFile lokasi menyesuaikan objectnya
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                ),
                new Vector4f(0, 1f, 1f, 1.0f), 0.3f, 0.25f, 0.2f, 0.3f, 0.35f, 0.3f
        ));
        // mata kiri
        objectsSphere.add(new Sphere(Arrays.asList(
                //shaderFile lokasi menyesuaikan objectnya
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                ),
                new Vector4f(0, 0f, 0f, 1.0f), 0.3f, 0.25f, 0.2f, 0.05f, 0.05f, 0.3f
        ));
        objectsSphere.get(1).scaleObject(0.5f, 0.5f, 0.1f);
        objectsSphere.get(1).translateObject(-0.08f, 0.19f, -0.23f);
        // mata kanan
        objectsSphere.add(new Sphere(Arrays.asList(
                //shaderFile lokasi menyesuaikan objectnya
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                ),
                new Vector4f(0, 0f, 0f, 1.0f), 0.3f, 0.25f, 0.2f, 0.05f, 0.05f, 0.3f
        ));
        objectsSphere.get(2).scaleObject(0.5f, 0.5f, 0.1f);
        objectsSphere.get(2).translateObject(0.08f, 0.19f, -0.23f);
        // putih mata kiri
        objectsSphere.add(new Sphere(Arrays.asList(
                //shaderFile lokasi menyesuaikan objectnya
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                ),
                new Vector4f(1, 1f, 1f, 1.0f), 0.3f, 0.25f, 0.2f, 0.05f, 0.05f, 0.3f
        ));
        objectsSphere.get(3).scaleObject(0.25f, 0.25f, 0.1f);
        objectsSphere.get(3).translateObject(0.08f, 0.20f, -0.24f);
        // putih mata kanan
        objectsSphere.add(new Sphere(Arrays.asList(
                //shaderFile lokasi menyesuaikan objectnya
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                ),
                new Vector4f(1, 1f, 1f, 1.0f), 0.3f, 0.25f, 0.0f, 0.05f, 0.05f, 0.3f
        ));
        objectsSphere.get(4).scaleObject(0.25f, 0.25f, 0.1f);
        objectsSphere.get(4).translateObject(-0.08f, 0.20f, -0.24f);
        //ekor
        objectsSphere.add(new Sphere(Arrays.asList(
                //shaderFile lokasi menyesuaikan objectnya
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                ),
                new Vector4f(1, 1f, 1f, 1.0f), 0.5f, 0.15f, 0f, 0.1f, 0.1f, 0.1f
        ));
        objectsSphere.get(5).translateObject(0f, -0.2f, 0.40f);
        //telinga kanan
        objectsEllipsoid.add(new Timotius.Ellipsoid(Arrays.asList(
                //shaderFile lokasi menyesuaikan objectnya
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                ),
                new Vector4f(0, 1f, 1f, 1.0f), 0.19f, 0.31f, 0.1f, 0.077f, 0.087f, -0.090f
        ));
        //telinga kiri
        objectsEllipsoid.add(new Timotius.Ellipsoid(Arrays.asList(
                //shaderFile lokasi menyesuaikan objectnya
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                ),
                new Vector4f(0, 1f, 1f, 1.0f), -0.19f, 0.31f, 0.1f, 0.077f, 0.087f, -0.090f
        ));
        //tangan kiri
        objectsEllipsoid.add(new Timotius.Ellipsoid(Arrays.asList(
                //shaderFile lokasi menyesuaikan objectnya
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                ),
                new Vector4f(0, 1f, 1f, 1.0f), -0.33f, 0.05f, 0.0f, 0.060f, 0.037f, 0.0f
        ));
        //tangan kanan
        objectsEllipsoid.add(new Timotius.Ellipsoid(Arrays.asList(
                //shaderFile lokasi menyesuaikan objectnya
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                ),
                new Vector4f(0, 1f, 1f, 1.0f), 0.33f, 0.05f, 0.0f, 0.060f, 0.037f, 0.02f
        ));
        //perut
        objectsEllipsoid.add(new Timotius.Ellipsoid(Arrays.asList(
                //shaderFile lokasi menyesuaikan objectnya
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f), 0.0f, 0.0f, 0.0f, 0.2f, 0.2f, 0.1f
        ));
        objectsEllipsoid.get(4).rotateObject((float) Math.toRadians(10f), -1.65f, 0f, 0f);
        objectsEllipsoid.get(4).translateObject(0.0f, -0.15f, -0.23f);
        // kaki kiri
        objectsEllipsoid.add(new Timotius.Ellipsoid(Arrays.asList(
                //shaderFile lokasi menyesuaikan objectnya
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                ),
                new Vector4f(0, 1f, 1f, 1.0f), 0.0f, -0.4f, 0.1f, 0.075f, 0.055f, 0.09f
        ));
        objectsEllipsoid.get(5).translateObject(-0.2f, 0.065f, -0.15f);
        // kaki kanan
        objectsEllipsoid.add(new Timotius.Ellipsoid(Arrays.asList(
                //shaderFile lokasi menyesuaikan objectnya
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                ),
                new Vector4f(0, 1f, 1f, 1.0f), 0.0f, -0.4f, 0.1f, 0.085f, 0.055f, 0.09f
        ));
        objectsEllipsoid.get(6).translateObject(0.2f, 0.065f, -0.15f);
        //mulut
        berzier.add(new Timotius.Object(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 0.0f, 0.0f)
        ));
        berzierMulut(controlBerzier, 0);
       // ekor
        cylinder.add(new Timotius.Cylinder(Arrays.asList(
                //shaderFile lokasi menyesuaikan objectnya
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                ),
                new Vector4f(0f, 1f, 0f, 1.0f), 0.0f, -0.5f, 0.0f, 0.03f, 0.2f, 0.03f
        ));
        cylinder.get(0).rotateObject((float)Math.toRadians(90f),1.0f,0.0f,0.0f);
        cylinder.get(0).translateObject(0.0f,-0.2f,0.3f);
    }

    public void input() {
        if (window.getMouseInput().isLeftButtonPressed()) {
            Vector2f pos = window.getMouseInput().getCurrentPos();
            System.out.println("x : " + pos.x + "y : " + pos.y);

            // dinormalisasi biar titik 0,0 itu di tengah
            pos.x = (pos.x - (window.getWidth()) / 2.0f) / (window.getWidth() / 2.0f);
            pos.y = (pos.y - (window.getHeight()) / 2.0f) / (-window.getHeight() / 2.0f);
        }
        if (window.isKeyPressed(GLFW_KEY_D)){
            for (int i = 0;i < objectsSphere.size();i++){
                objectsSphere.get(i).rotateObject((float)Math.toRadians(1f),0.0f,1f,0.0f);
            }
            for (int i = 0;i < objectsEllipsoid.size();i++){
                objectsEllipsoid.get(i).rotateObject((float)Math.toRadians(1f),0.0f,1f,0.0f);
            }
            for (int i = 0;i < berzier.size();i++){
                berzier.get(i).rotateObject((float)Math.toRadians(1f),0.0f,1f,0.0f);
            }
            for (int i = 0;i < cylinder.size();i++){
                cylinder.get(i).rotateObject((float)Math.toRadians(1f),0.0f,1f,0.0f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_A)){
            for (int i = 0;i < objectsSphere.size();i++){
                objectsSphere.get(i).rotateObject((float)Math.toRadians(1f),0.0f,-1f,0.0f);
            }
            for (int i = 0;i < objectsEllipsoid.size();i++){
                objectsEllipsoid.get(i).rotateObject((float)Math.toRadians(1f),0.0f,-1f,0.0f);
            }
            for (int i = 0;i < berzier.size();i++){
                berzier.get(i).rotateObject((float)Math.toRadians(1f),0.0f,-1f,0.0f);
            }
            for (int i = 0;i < cylinder.size();i++){
                cylinder.get(i).rotateObject((float)Math.toRadians(1f),0.0f,-1f,0.0f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_W)){
            for (int i = 0;i < objectsSphere.size();i++){
                objectsSphere.get(i).rotateObject((float)Math.toRadians(1f),1f,0f,0f);
            }
            for (int i = 0;i < objectsEllipsoid.size();i++){
                objectsEllipsoid.get(i).rotateObject((float)Math.toRadians(1f),1f,0f,0f);
            }
            for (int i = 0;i < berzier.size();i++){
                berzier.get(i).rotateObject((float)Math.toRadians(1f),1f,0f,0f);
            }
            for (int i = 0;i < cylinder.size();i++){
                cylinder.get(i).rotateObject((float)Math.toRadians(1f),1f,0f,0f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_S)){
            for (int i = 0;i < objectsSphere.size();i++){
                objectsSphere.get(i).rotateObject((float)Math.toRadians(1f),-1f,0f,0f);
            }
            for (int i = 0;i < objectsEllipsoid.size();i++){
                objectsEllipsoid.get(i).rotateObject((float)Math.toRadians(1f),-1f,0f,0f);
            }
            for (int i = 0;i < berzier.size();i++){
                berzier.get(i).rotateObject((float)Math.toRadians(1f),-1f,0f,0f);
            }
            for (int i = 0;i < cylinder.size();i++){
                cylinder.get(i).rotateObject((float)Math.toRadians(1f),-1f,0f,0f);
            }
        }
        }



    public void loop() {
        while (window.isOpen()) {
            window.update();
            glClearColor(1.0f, 0.0f, 0.0f, 0.0f);
            GL.createCapabilities();
            input();


            for(Timotius.Object objects: objectsSphere) {
                objects.draw();
            }
            for (Timotius.Object objects: objectsEllipsoid){
                objects.draw();
            }
            for (Timotius.Object objects: berzier){
                objects.drawLine();
            }
            for (Timotius.Object objects: cylinder){
                objects.drawLine();
            }
            glDisableVertexAttribArray(0);

            glfwPollEvents();
        }
    }

//    private static int combination(int n, int k) {
//        int result = 1;
//        for (int i = 1; i <= k; i++) {
//            result *= n - i + 1;
//            result /= i;
//        }
//        return result;
//    }

//    public static ArrayList<Object> calcBezierCurve(ArrayList <multiRect> list){
//        int n = list.size() - 1;
//        ArrayList<Object> objectsBezier = new ArrayList<>();
//        objectsBezier.add(new Object(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.0f,1.0f,1.0f,1.0f)
//        ));
//
//        for (float i = 0; i <= 1; i += 0.01f) {
//            float x = 0;
//            float y = 0;
//            for (int j = 0; j <= n; j++) {
//                double factor = combination(n, j) * Math.pow(1 - i, n - j) * Math.pow(i, j);
//                x += factor * list.get(j).getCenterX();
//                y += factor * list.get(j).getCenterY();
//            }
//            objectsBezier.get(0).addVertices((new Vector3f(x, y, 0)));
//        }
//        return objectsBezier;
//    }

    public void run() {
        init();
        loop();

        // Terminate GLFW and
        // free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }
    public void berzierMulut(float[][] floats, int pilihan) {
        int indexBerzier = 0;
        for (float t = 0; t <= 1; t += 0.01f) {
            float x = 0;
            float y = 0;
            float z = 0;
            int n = floats.length - 1;
            for (int i = 0; i <= n; i++) {
                int koefisien = koefSegitigaPascal(n, i);
                float term = koefisien * (float) Math.pow(1 - t, n - i) * (float) Math.pow(t, i);
                x += term * floats[i][0];
                y += term * floats[i][1];
                z += term * floats[i][2];
            }
            if (tes == 0) {
                if (pilihan == 0){
                    berzier.get(0).addVertices(new Vector3f(x, y, z));
                }
            }
        }
    }

    public int koefSegitigaPascal(int n, int k) {
        if (k < 0 || k > n) {
            return 0;
        }
        int koef = 1;
        for (int i = 0; i < k; i++) {
            koef *= (n - i);
            koef /= (i + 1);
        }
        return koef;
    }
    public static void main(String[] args) {
        new Main4().run();
    }
}

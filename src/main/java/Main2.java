import Engine.*;
import Louis.*;

import Louis.Object;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main2 {
    private Window window = new Window(800, 800, "Window");

    ArrayList<Object> objects = new ArrayList<>();
    ArrayList<Sphere> objectsSphere = new ArrayList<>();
    ArrayList<HalfTorus> objectsHalfTorus = new ArrayList<>();
    ArrayList<Cube> objectCube = new ArrayList<>();
    ArrayList<HalfSphere> objectsHalfSphere = new ArrayList<>();
    ArrayList<Cylinder> objectsCylinder = new ArrayList<>();

    public void init() {
        window.init();
        GL.createCapabilities();

        // badan
        objectsSphere.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.624f, 0.753f, 0.796f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.5f, 0.5f, 0.5f
        ));
        objectsSphere.get(0).scaleObject(0.5f, 0.5f, 0.5f);

        // mata
        objectsSphere.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.5f, 0.5f, 0.5f
        ));

        objectsSphere.get(0).getChildObject().get(0).scaleObject(0.2f, 0.2f, 0.05f);
        objectsSphere.get(0).getChildObject().get(0).translateObject(0.0f, 0.04f, -0.25f);

        // bola mata
        objectsSphere.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 0.0f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.5f, 0.5f, 0.1f
        ));

        objectsSphere.get(0).getChildObject().get(1).scaleObject(0.035f, 0.035f, 0.035f);
        objectsSphere.get(0).getChildObject().get(1).translateObject(0.0f, 0.04f, -0.276f);

        // kaki kiri
        objectsSphere.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.667f, 0.667f, 0.678f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.5f, 0.5f, 0.5f
        ));
        objectsSphere.get(0).getChildObject().get(2).scaleObject(0.1f, 0.1f, 0.05f);
        objectsSphere.get(0).getChildObject().get(2).translateObject(-0.17f, -0.14f, -0.18f);

        // kaki kanan
        objectsSphere.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.667f, 0.667f, 0.678f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.5f, 0.5f, 0.5f
        ));
        objectsSphere.get(0).getChildObject().get(3).scaleObject(0.1f, 0.1f, 0.05f);
        objectsSphere.get(0).getChildObject().get(3).translateObject(0.17f, -0.14f, -0.18f);

        // tangan kiri
        // half torus kiri
        objectsHalfTorus.add(new HalfTorus(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                0.0f, 0.0f, 0.0f,
                0.08f,
                0.035f,
                180,
                180,
                (float)Math.PI,
                new Vector4f(0.588f, 0.584f, 0.596f, 0.0f)
        ));
        objectsHalfTorus.get(0).translateObject(-0.35f, 0.0f, 0.0f);

        // cube kiri atas
        objectCube.add(new Cube(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.588f, 0.584f, 0.596f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.08f, 0.073f, 0.035f
        ));
        objectCube.get(0).translateObject(-0.38f, 0.0775f, 0.0f);

        // cube kiri bawah
        objectCube.add(new Cube(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.588f, 0.584f, 0.596f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.08f, 0.073f, 0.035f
        ));
        objectCube.get(1).translateObject(-0.38f, -0.0775f, 0.0f);

        // cube kiri atas merah
        objectCube.add(new Cube(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.651f, 0.396f, 0.408f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.07f, 0.073f, 0.035f
        ));
        objectCube.get(2).translateObject(-0.45f, 0.0775f, 0.0f);

        // cube kiri bawah biru
        objectCube.add(new Cube(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.271f, 0.557f, 0.714f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.07f, 0.073f, 0.035f
        ));
        objectCube.get(3).translateObject(-0.45f, -0.0775f, 0.0f);

        // tangan kanan (masi cacat)
        // half torus kanan (masi cacat)
        objectsHalfTorus.add(new HalfTorus(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                0.0f, 0.0f, 0.0f,
                0.08f,
                0.035f,
                180,
                180,
                (float)Math.PI,
                new Vector4f(0.588f, 0.584f, 0.596f, 0.0f)
        ));
        objectsHalfTorus.get(1).translateObject(0.35f, 0.0f, 0.0f);
        objectsHalfTorus.get(1).rotateObject((float) Math.toRadians(180f),0.0f, 1.0f, 0.0f);
        objectsHalfTorus.get(1).translateObject(0.7f, 0.0f, 0.0f);

        // cube kanan atas
        objectCube.add(new Cube(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.588f, 0.584f, 0.596f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.08f, 0.073f, 0.035f
        ));
        objectCube.get(4).translateObject(0.38f, 0.0775f, 0.0f);

        // cube kanan bawah
        objectCube.add(new Cube(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.588f, 0.584f, 0.596f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.08f, 0.073f, 0.035f
        ));
        objectCube.get(5).translateObject(0.38f, -0.0775f, 0.0f);

        // cube kanan atas biru
        objectCube.add(new Cube(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.271f, 0.557f, 0.714f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.07f, 0.073f, 0.035f
        ));
        objectCube.get(6).translateObject(0.45f, 0.0775f, 0.0f);

        // cube kanan bawah merah
        objectCube.add(new Cube(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.651f, 0.396f, 0.408f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.07f, 0.073f, 0.035f
        ));
        objectCube.get(7).translateObject(0.45f, -0.0775f, 0.0f);

        // half sphere paling atas
        objectsHalfSphere.add(new HalfSphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(0.435f, 0.42f, 0.467f, 0.0f),
                0.0f, 0.0f, 0.0f,
                0.08f,
                0.02f,
                0.08f,
                180,
                180
        ));
        objectsHalfSphere.get(0).translateObject(0.0f, 0.3f, 0.0f);

        // + kaki kiri
        objectCube.add(new Cube(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.439f, 0.42f, 0.467f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.015f, 0.04f, 0.01f
        ));
        objectCube.get(8).translateObject(-0.17f, -0.14f, -0.2f);

        objectCube.add(new Cube(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.439f, 0.42f, 0.467f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.04f, 0.015f, 0.01f
        ));
        objectCube.get(9).translateObject(-0.17f, -0.14f, -0.2f);

        // + kaki kanan
        objectCube.add(new Cube(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.439f, 0.42f, 0.467f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.015f, 0.04f, 0.01f
        ));
        objectCube.get(10).translateObject(0.17f, -0.14f, -0.2f);

        objectCube.add(new Cube(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.439f, 0.42f, 0.467f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.04f, 0.015f, 0.01f
        ));
        objectCube.get(11).translateObject(0.17f, -0.14f, -0.2f);

        // silinder penyambung
        objectsCylinder.add(new Cylinder(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.435f, 0.42f, 0.467f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.02f, 0.07f, 0.02f
        ));
        objectsCylinder.get(0).translateObject(0.0f, 0.275f, 0.0f);
    }

    public void input() {
        if (window.isKeyPressed(GLFW_KEY_W)) {
            objectsSphere.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);

            for (int i = 0; i < objectsHalfTorus.size(); i++) {
                objectsHalfTorus.get(i).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
            }

            for (int i = 0; i < objectCube.size(); i++) {
                objectCube.get(i).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
            }

            for (int i = 0; i < objectsHalfSphere.size(); i++) {
                objectsHalfSphere.get(i).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
            }

            for (int i = 0; i < objectsCylinder.size(); i++) {
                objectsCylinder.get(i).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
            }

//            for (Object child : objectsSphere.get(0).getChildObject()) {
//                Vector3f tempCenterPoint = child.updateCenterPoint();
//                child.translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
//                child.rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
//                child.translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
//            }
//
//            for (Object child : objectsSphere.get(0).getChildObject().get(1).getChildObject()) {
//                Vector3f tempCenterPoint = objectsSphere.get(0).getChildObject().get(1).updateCenterPoint();
//                child.translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
//                child.rotateObject(0.05f, 0.0f, 0.0f, 1.0f);
//                child.translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
//            }
        }
    }

    public void loop() {
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GL.createCapabilities();
            input();

            //code
            for (Object object : objects) {
                object.draw();
            }

            for (Sphere object : objectsSphere) {
                object.draw();
            }

            for (HalfTorus object : objectsHalfTorus) {
                object.draw();
            }

            for (Cube object : objectCube) {
                object.draw();
            }

            for (HalfSphere object : objectsHalfSphere) {
                object.draw();
            }

            for (Cylinder object : objectsCylinder) {
                object.draw();
            }

            glDisableVertexAttribArray(0);
            glfwPollEvents();
        }
    }

    public void run() {
        init();
        loop();
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public static void main(String[] args) {
        new Main2().run();
    }
}
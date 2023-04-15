import Engine.*;
import Louis.*;

import Louis.Object;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

// TODO: gerakan tambahan, curve manual tanpa klik mouse, laporan (sisa animasi), video
public class Main2 {
    private Window window = new Window(800, 800, "Window");

    ArrayList<Object> objects = new ArrayList<>();
    ArrayList<Sphere> objectsSphere = new ArrayList<>();
    ArrayList<HalfTorus> objectsHalfTorus = new ArrayList<>();
    ArrayList<Cube> objectCube = new ArrayList<>();
    ArrayList<HalfSphere> objectsHalfSphere = new ArrayList<>();
    ArrayList<Cylinder> objectsCylinder = new ArrayList<>();
    ArrayList<Object> objectsPointsControl = new ArrayList<>();
    ArrayList <Circle> objectsCircle = new ArrayList<>();
    boolean overlap;
    boolean isTouched;

    public void init() {
        window.init();
        GL.createCapabilities();
        glEnable(GL_DEPTH_TEST);

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
        objectsSphere.add(new Sphere(
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

        objectsSphere.get(1).scaleObject(0.2f, 0.2f, 0.05f);
        objectsSphere.get(1).translateObject(0.0f, 0.04f, -0.25f);

        // bola mata
        objectsSphere.add(new Sphere(
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

        objectsSphere.get(2).scaleObject(0.035f, 0.035f, 0.035f);
        objectsSphere.get(2).translateObject(0.0f, 0.04f, -0.276f);

        // kaki kiri
        objectsSphere.add(new Sphere(
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
        objectsSphere.get(3).scaleObject(0.1f, 0.1f, 0.05f);
        objectsSphere.get(3).translateObject(-0.17f, -0.14f, -0.17f);

        // kaki kanan
        objectsSphere.add(new Sphere(
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
        objectsSphere.get(4).scaleObject(0.1f, 0.1f, 0.05f);
        objectsSphere.get(4).translateObject(0.17f, -0.14f, -0.17f);

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
                0, 90,
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
                0.0f, 0.0f, 0.0f, 0.08f, 0.072f, 0.035f
        ));
        objectCube.get(0).translateObject(-0.38f, 0.078f, 0.0f);

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
                0.0f, 0.0f, 0.0f, 0.08f, 0.072f, 0.035f
        ));
        objectCube.get(1).translateObject(-0.38f, -0.078f, 0.0f);

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
                0.0f, 0.0f, 0.0f, 0.07f, 0.072f, 0.035f
        ));
        objectCube.get(2).translateObject(-0.45f, 0.078f, 0.0f);

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
                0.0f, 0.0f, 0.0f, 0.07f, 0.072f, 0.035f
        ));
        objectCube.get(3).translateObject(-0.45f, -0.078f, 0.0f);

        // tangan kanan
        // half torus kanan
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
                0, 90,
                new Vector4f(0.588f, 0.584f, 0.596f, 0.0f)
        ));
//        objectsHalfTorus.get(1).translateObject(0.35f, 0.0f, 0.0f);
        objectsHalfTorus.get(1).rotateObject((float) Math.toRadians(180f), 0.0f, 1.0f, 0.0f);
        objectsHalfTorus.get(1).translateObject(0.35f, 0.0f, 0.0f);

//        // cube kanan atas
        objectCube.add(new Cube(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.588f, 0.584f, 0.596f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.08f, 0.072f, 0.035f
        ));
        objectCube.get(4).translateObject(0.38f, 0.078f, 0.0f);

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
                0.0f, 0.0f, 0.0f, 0.08f, 0.072f, 0.035f
        ));
        objectCube.get(5).translateObject(0.38f, -0.078f, 0.0f);

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
                0.0f, 0.0f, 0.0f, 0.07f, 0.072f, 0.035f
        ));
        objectCube.get(6).translateObject(0.45f, 0.078f, 0.0f);

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
                0.0f, 0.0f, 0.0f, 0.07f, 0.072f, 0.035f
        ));
        objectCube.get(7).translateObject(0.45f, -0.078f, 0.0f);

        // half sphere paling atas
        objectsHalfSphere.add(new HalfSphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.435f, 0.42f, 0.467f, 0.0f),
                0.0f, 0.0f, 0.0f,
                0.08f,
                0.08f,
                0.03f
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
        objectCube.get(8).translateObject(-0.17f, -0.14f, -0.19f);

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
        objectCube.get(9).translateObject(-0.17f, -0.14f, -0.19f);

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
        objectCube.get(10).translateObject(0.17f, -0.14f, -0.19f);

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
        objectCube.get(11).translateObject(0.17f, -0.14f, -0.19f);

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

        // warna garis antar titik
        objectsPointsControl.add(new Object(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 1.0f, 1.0f, 1.0f)
        ));
    }

    public void input() {
        // Rotate kiri kanan
        if (window.isKeyPressed(GLFW_KEY_1)) {
            Vector3f tmp = objectsSphere.get(0).updateCenterPoint();
            objectsSphere.get(0).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
            objectsSphere.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
            objectsSphere.get(0).translateObject(tmp.x, tmp.y, tmp.z);

            for (int i = 1; i < objectsSphere.size(); i++) {
                objectsSphere.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                objectsSphere.get(i).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
                objectsSphere.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }

            for (int i = 0; i < objectsHalfTorus.size(); i++) {
                objectsHalfTorus.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                objectsHalfTorus.get(i).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
                objectsHalfTorus.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }

            for (int i = 0; i < objectCube.size(); i++) {
                objectCube.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                objectCube.get(i).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
                objectCube.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }

            for (int i = 0; i < objectsHalfSphere.size(); i++) {
                objectsHalfSphere.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                objectsHalfSphere.get(i).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
                objectsHalfSphere.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }

            for (int i = 0; i < objectsCylinder.size(); i++) {
                objectsCylinder.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                objectsCylinder.get(i).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
                objectsCylinder.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }
            // rotate atas bawah
        } else if (window.isKeyPressed(GLFW_KEY_2)) {
            Vector3f tmp = objectsSphere.get(0).updateCenterPoint();
            objectsSphere.get(0).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
            objectsSphere.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
            objectsSphere.get(0).translateObject(tmp.x, tmp.y, tmp.z);

            for (int i = 0; i < objectsSphere.size(); i++) {
                objectsSphere.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                objectsSphere.get(i).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
                objectsSphere.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }

            for (int i = 0; i < objectsHalfTorus.size(); i++) {
                objectsHalfTorus.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                objectsHalfTorus.get(i).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
                objectsHalfTorus.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }

            for (int i = 0; i < objectCube.size(); i++) {
                objectCube.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                objectCube.get(i).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
                objectCube.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }

            for (int i = 0; i < objectsHalfSphere.size(); i++) {
                objectsHalfSphere.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                objectsHalfSphere.get(i).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
                objectsHalfSphere.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }

            for (int i = 0; i < objectsCylinder.size(); i++) {
                objectsCylinder.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                objectsCylinder.get(i).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
                objectsCylinder.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }
            // rotate depan belakang
        } else if (window.isKeyPressed(GLFW_KEY_3)) {
            Vector3f tmp = objectsSphere.get(0).updateCenterPoint();
            objectsSphere.get(0).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
            objectsSphere.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
            objectsSphere.get(0).translateObject(tmp.x, tmp.y, tmp.z);

            for (int i = 0; i < objectsSphere.size(); i++) {
                objectsSphere.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                objectsSphere.get(i).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
                objectsSphere.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }

            for (int i = 0; i < objectsHalfTorus.size(); i++) {
                objectsHalfTorus.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                objectsHalfTorus.get(i).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
                objectsHalfTorus.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }

            for (int i = 0; i < objectCube.size(); i++) {
                objectCube.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                objectCube.get(i).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
                objectCube.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }

            for (int i = 0; i < objectsHalfSphere.size(); i++) {
                objectsHalfSphere.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                objectsHalfSphere.get(i).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
                objectsHalfSphere.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }


            for (int i = 0; i < objectsCylinder.size(); i++) {
                objectsCylinder.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                objectsCylinder.get(i).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
                objectsCylinder.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }
            // geser atas
        } else if (window.isKeyPressed(GLFW_KEY_W)) {
            for (int i = 0; i < objectsSphere.size(); i++) {
                objectsSphere.get(i).translateObject(0.0f, 0.01f, 0.0f);
            }

            for (int i = 0; i < objectsHalfTorus.size(); i++) {
                objectsHalfTorus.get(i).translateObject(0.0f, 0.01f, 0.0f);
            }

            for (int i = 0; i < objectCube.size(); i++) {
                objectCube.get(i).translateObject(0.0f, 0.01f, 0.0f);
            }

            for (int i = 0; i < objectsHalfSphere.size(); i++) {
                objectsHalfSphere.get(i).translateObject(0.0f, 0.01f, 0.0f);
            }

            for (int i = 0; i < objectsCylinder.size(); i++) {
                objectsCylinder.get(i).translateObject(0.0f, 0.01f, 0.0f);
            }
            // geser kiri
        } else if (window.isKeyPressed(GLFW_KEY_A)) {
            for (int i = 0; i < objectsSphere.size(); i++) {
                objectsSphere.get(i).translateObject(-0.01f, 0.0f, 0.0f);
            }

            for (int i = 0; i < objectsHalfTorus.size(); i++) {
                objectsHalfTorus.get(i).translateObject(-0.01f, 0.0f, 0.0f);
            }

            for (int i = 0; i < objectCube.size(); i++) {
                objectCube.get(i).translateObject(-0.01f, 0.0f, 0.0f);
            }

            for (int i = 0; i < objectsHalfSphere.size(); i++) {
                objectsHalfSphere.get(i).translateObject(-0.01f, 0.0f, 0.0f);
            }

            for (int i = 0; i < objectsCylinder.size(); i++) {
                objectsCylinder.get(i).translateObject(-0.01f, 0.0f, 0.0f);
            }
            // geser kanan
        } else if (window.isKeyPressed(GLFW_KEY_D)) {
            for (int i = 0; i < objectsSphere.size(); i++) {
                objectsSphere.get(i).translateObject(0.01f, 0.0f, 0.0f);
            }

            for (int i = 0; i < objectsHalfTorus.size(); i++) {
                objectsHalfTorus.get(i).translateObject(0.01f, 0.0f, 0.0f);
            }

            for (int i = 0; i < objectCube.size(); i++) {
                objectCube.get(i).translateObject(0.01f, 0.0f, 0.0f);
            }

            for (int i = 0; i < objectsHalfSphere.size(); i++) {
                objectsHalfSphere.get(i).translateObject(0.01f, 0.0f, 0.0f);
            }

            for (int i = 0; i < objectsCylinder.size(); i++) {
                objectsCylinder.get(i).translateObject(0.01f, 0.0f, 0.0f);
            }
            // geser bawah
        } else if (window.isKeyPressed(GLFW_KEY_S)) {
            for (int i = 0; i < objectsSphere.size(); i++) {
                objectsSphere.get(i).translateObject(0.0f, -0.01f, 0.0f);
            }

            for (int i = 0; i < objectsHalfTorus.size(); i++) {
                objectsHalfTorus.get(i).translateObject(0.0f, -0.01f, 0.0f);
            }

            for (int i = 0; i < objectCube.size(); i++) {
                objectCube.get(i).translateObject(0.0f, -0.01f, 0.0f);
            }

            for (int i = 0; i < objectsHalfSphere.size(); i++) {
                objectsHalfSphere.get(i).translateObject(0.0f, -0.01f, 0.0f);
            }

            for (int i = 0; i < objectsCylinder.size(); i++) {
                objectsCylinder.get(i).translateObject(0.0f, -0.01f, 0.0f);
            }
            // kecilin
        } else if (window.isKeyPressed(GLFW_KEY_4)) {
            for (int i = 0; i < objectsSphere.size(); i++) {
                objectsSphere.get(i).scaleObject(0.999f, 0.999f, 0.999f);
            }

            for (int i = 0; i < objectsHalfTorus.size(); i++) {
                objectsHalfTorus.get(i).scaleObject(0.999f, 0.999f, 0.999f);
            }

            for (int i = 0; i < objectCube.size(); i++) {
                objectCube.get(i).scaleObject(0.999f, 0.999f, 0.999f);
            }

            for (int i = 0; i < objectsHalfSphere.size(); i++) {
                objectsHalfSphere.get(i).scaleObject(0.999f, 0.999f, 0.999f);
            }

            for (int i = 0; i < objectsCylinder.size(); i++) {
                objectsCylinder.get(i).scaleObject(0.999f, 0.999f, 0.999f);
            }
            // besarin
        } else if (window.isKeyPressed(GLFW_KEY_5)) {
            for (int i = 0; i < objectsSphere.size(); i++) {
                objectsSphere.get(i).scaleObject(1.001f, 1.001f, 1.001f);
            }

            for (int i = 0; i < objectsHalfTorus.size(); i++) {
                objectsHalfTorus.get(i).scaleObject(1.001f, 1.001f, 1.001f);
            }

            for (int i = 0; i < objectCube.size(); i++) {
                objectCube.get(i).scaleObject(1.001f, 1.001f, 1.001f);
            }

            for (int i = 0; i < objectsHalfSphere.size(); i++) {
                objectsHalfSphere.get(i).scaleObject(1.001f, 1.001f, 1.001f);
            }

            for (int i = 0; i < objectsCylinder.size(); i++) {
                objectsCylinder.get(i).scaleObject(1.001f, 1.001f, 1.001f);
            }
        }

        if (window.getMouseInput().isLeftButtonPressed()) {
            Vector2f pos = window.getMouseInput().getCurrentPos();

            pos.x = (pos.x - (window.getWidth()) / 2.0f) / (window.getWidth() / 2.0f);
            pos.y = (pos.y - (window.getHeight()) / 2.0f) / (-window.getHeight() / 2.0f);

            if ((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1))) {
                // print x y tempat diklik
                // System.out.println("x : " + pos.x + " y : " + pos.y);
                overlap = false;
                int index = 0;

                for (Circle object : objectsCircle) {
                    overlap = object.isOverlap(pos.x, pos.y);
                    if (overlap) {
                        break;
                    }
                }

                for (Circle object : objectsCircle) {
                    isTouched = object.isTouched(pos.x, pos.y);
                    if (isTouched) {
                        objectsPointsControl.get(0).update(index, new Vector3f(pos.x, pos.y, 0));
                        object.moveKotak(pos.x, pos.y, 0.01f);
                    }
                    index++;
                }

                if (!overlap) {
                    objectsPointsControl.get(0).addVertices(new Vector3f(pos.x, pos.y, 0));
                    // warna titik kontrol
                    objectsCircle.add(new Circle(
                            Arrays.asList(
                                    //shaderFile lokasi menyesuaikan objectnya
                                    new ShaderProgram.ShaderModuleData
                                            ("resources/shaders/scene.vert"
                                                    , GL_VERTEX_SHADER),
                                    new ShaderProgram.ShaderModuleData
                                            ("resources/shaders/scene.frag"
                                                    , GL_FRAGMENT_SHADER)
                            ),
                            new ArrayList<>(),
                            new Vector4f(0.0f, 1.0f, 0.0f, 0.0f),
                            pos.x, pos.y, 0.01f, 0.01f
                    ));
                }
            }
        }
    }

    public void loop() {
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GL.createCapabilities();
            glEnable(GL_DEPTH_TEST);
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

//            for (Object object : objectsPointsControl) {
//                object.drawLine();
//            }

            ArrayList<Object> objectsCurve = calculatePoint(objectsCircle);
            for (Object object : objectsCurve) {
                object.drawLine();
            }

//            for (Circle object : objectsCircle) {
//                object.draw();
//            }

            glDisableVertexAttribArray(0);
            glfwPollEvents();
        }
    }

    public static ArrayList<Object> calculatePoint(ArrayList<Circle> arr) {
        int n = arr.size() - 1;
        ArrayList<Object> objectsCurve = new ArrayList<>();

        // warna curve
        objectsCurve.add(new Object(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 0.0f, 0.0f, 0.0f)
        ));

        for (float j = 0; j <= 1; j += 0.01f) {
            float x = 0;
            float y = 0;
            for (int i = 0; i <= n; i++) {
                double factor = combination(n, i) * Math.pow(1 - j, n - i) * Math.pow(j, i);
                x += factor * arr.get(i).getCenterX();
                y += factor * arr.get(i).getCenterY();
            }
            objectsCurve.get(0).addVertices((new Vector3f(x, y, 0)));
        }

        return objectsCurve;
    }

    public static int combination(int n, int k) {
        int result = 1;
        for (int i = 1; i <= k; i++) {
            result *= n - i + 1;
            result /= i;
        }
        return result;
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
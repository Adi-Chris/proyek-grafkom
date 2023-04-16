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

// TODO: gerakan tambahan (animasi), curve manual tanpa klik mouse, laporan (sisa animasi), video
public class Main2 {
    private Window window = new Window(800, 800, "Window");

    ArrayList<Object> objects = new ArrayList<>();
    ArrayList<Sphere> objectsSphere = new ArrayList<>();
    ArrayList<HalfTorus> objectsHalfTorus = new ArrayList<>();
    ArrayList<Cube> objectCube = new ArrayList<>();
    ArrayList<HalfSphere> objectsHalfSphere = new ArrayList<>();
    ArrayList<Cylinder> objectsCylinder = new ArrayList<>();
    ArrayList<Object> objectsBezier1 = new ArrayList<>();
    ArrayList<Object> objectsBezier2 = new ArrayList<>();
//    ArrayList<Object> objectsBezier3 = new ArrayList<>();
//    ArrayList<Object> objectsBezier4 = new ArrayList<>();
//    ArrayList<Object> objectsBezier5 = new ArrayList<>();
//    ArrayList<Object> objectsBezier6 = new ArrayList<>();

//    private static float[][] bezierDots1 = {
//            {-0.5375f, 0.0125f, 0.0f},
//            {-0.6525f, 0.135f, 0.0f},
//            {-0.6975f, 0.045f, 0.0f},
//            {-0.84f, 0.1025f, 0.0f}
//    };
//
//    private static float[][] bezierDots2 = {
//            {0.5075f, 0.0075f, 0.0f},
//            {0.6475f, 0.1175f, 0.0f},
//            {0.6475f, 0.0175f, 0.0f},
//            {0.7775f, 0.0975f, 0.0f}
//    };

    boolean keyPressed = false;

    public void init() {
        window.init();
        GL.createCapabilities();
        glEnable(GL_DEPTH_TEST);
        MouseInput mouseInput = window.getMouseInput();

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
        objectsSphere.get(2).translateObject(0.0f, 0.07f, -0.276f);

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

        // serangan listrik
        objectsBezier1.add(new Object(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 0.0f, 0.0f, 0.0f)
        ));
//        drawCurve(bezierDots1, 1);
//        objectCube.get(2).getChildObject().add(objectsBezier1.get(0));

        objectsBezier2.add(new Object(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 0.0f, 0.0f, 0.0f)
        ));
//        drawCurve(bezierDots2, 2);
//        objectCube.get(6).getChildObject().add(objectsBezier2.get(0));
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
        }

        // rotate atas bawah
        if (window.isKeyPressed(GLFW_KEY_2)) {
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
        }

        // rotate depan belakang
        if (window.isKeyPressed(GLFW_KEY_3)) {
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

        }

        // geser atas
        if (window.isKeyPressed(GLFW_KEY_W)) {
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

        }

        // geser kiri
        if (window.isKeyPressed(GLFW_KEY_A)) {
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

        }

        // geser kanan
        if (window.isKeyPressed(GLFW_KEY_D)) {
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

        }

        // geser bawah
        if (window.isKeyPressed(GLFW_KEY_S)) {
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

        }

        // kecilin
        if (window.isKeyPressed(GLFW_KEY_4)) {
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

        }

        // besarin

        if (window.isKeyPressed(GLFW_KEY_5)) {
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

        // animasi attack
        if (window.isKeyPressed(GLFW_KEY_6) && keyPressed == false) {
            keyPressed = true;
            System.out.println(keyPressed);
            // magnemite naik dikit
            // copas GLFW_KEY_W

            // mata membesar
            objectsSphere.get(2).scaleObject(1.01f, 1.01f, 1.0f);

            // show listrik pakai bezier
            Vector3f cubeAtasTanganKiri = objectCube.get(2).updateCenterPoint();
            Vector3f cubeBawahTanganKiri = objectCube.get(3).updateCenterPoint();
            float xKiri = (cubeAtasTanganKiri.x + cubeBawahTanganKiri.x) / 2;
            float yKiri = (cubeAtasTanganKiri.y + cubeBawahTanganKiri.y) / 2;
            float zKiri = (cubeAtasTanganKiri.z + cubeBawahTanganKiri.z) / 2;

            Vector3f cubeAtasTanganKanan = objectCube.get(6).updateCenterPoint();
            Vector3f cubeBawahTanganKanan = objectCube.get(7).updateCenterPoint();
            float xKanan = (cubeAtasTanganKanan.x + cubeBawahTanganKanan.x) / 2;
            float yKanan = (cubeAtasTanganKanan.y + cubeBawahTanganKanan.y) / 2;
            float zKanan = (cubeAtasTanganKanan.z + cubeBawahTanganKanan.z) / 2;

            float[][] bezierDots1 = {
                    {xKiri - 0.1f, yKiri, zKiri},
                    {xKiri - 0.2f, yKiri + 0.05f, zKiri},
                    {xKiri - 0.3f, yKiri - 0.05f, zKiri},
                    {xKiri - 0.4f, yKiri, zKiri}
            };

            float[][] bezierDots2 = {
                    {xKanan + 0.1f, yKanan, zKanan},
                    {xKanan + 0.2f, yKanan + 0.05f, zKanan},
                    {xKanan + 0.3f, yKanan - 0.05f, zKanan},
                    {xKanan + 0.4f, yKanan, zKanan}
            };

            drawCurve(bezierDots1, 1);
            drawCurve(bezierDots2, 2);
        }

        if (keyPressed) {
            Vector3f tmp = objectsSphere.get(0).updateCenterPoint();

            // tangan gerak
            for (int i = 0; i < objectsHalfTorus.size(); i++) {
                objectsHalfTorus.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                objectsHalfTorus.get(i).rotateObject((float) Math.toRadians(10f), 1.0f, 0.0f, 0.0f);
                objectsHalfTorus.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }

            for (int i = 0; i < 8; i++) {
                objectCube.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                objectCube.get(i).rotateObject((float) Math.toRadians(10f), 1.0f, 0.0f, 0.0f);
                objectCube.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }


        }

        if (window.isKeyReleased(GLFW_KEY_6)) {
            keyPressed = false;
        }

        // animasi bola mata gerak
        if (window.isKeyPressed(GLFW_KEY_7)) {
            Vector3f tmp = objectsSphere.get(1).updateCenterPoint();

            objectsSphere.get(2).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
            objectsSphere.get(2).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
            objectsSphere.get(2).translateObject(tmp.x, tmp.y, tmp.z);
        }

        // print x y tempat diklik
        if (window.getMouseInput().isLeftButtonPressed()) {
            Vector2f pos = window.getMouseInput().getCurrentPos();
            pos.x = (pos.x - (window.getWidth()) / 2.0f) / (window.getWidth() / 2.0f);
            pos.y = (pos.y - (window.getHeight()) / 2.0f) / (-window.getHeight() / 2.0f);

            if ((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1))) {

                System.out.println(pos.x + "f, " + pos.y + "f, 0.0f");
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

            for (Object object : objectsBezier1) {
                object.drawLine();
            }

            for (Object object : objectsBezier2) {
                object.drawLine();
            }

            glDisableVertexAttribArray(0);
            glfwPollEvents();
        }
    }

    public void drawCurve(float[][] floats, int pilihan) {
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

            if (pilihan == 1) {
                objectsBezier1.get(0).addVertices(new Vector3f(x, y, z));
            } else if (pilihan == 2) {
                objectsBezier2.get(0).addVertices(new Vector3f(x, y, z));
            } //else if (pilihan == 3) {
//                objectsBezier3.get(0).addVertices(new Vector3f(x, y, z));
//            } else if (pilihan == 4) {
//                objectsBezier4.get(0).addVertices(new Vector3f(x, y, z));
//            } else if (pilihan == 5) {
//                objectsBezier5.get(0).addVertices(new Vector3f(x, y, z));
//            } else if (pilihan == 6) {
//                objectsBezier6.get(0).addVertices(new Vector3f(x, y, z));
//            }
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
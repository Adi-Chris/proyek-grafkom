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

// TODO: bezier curve, rotasi pada poros, gerakan tambahan
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
    }

    public void input() {
        // Rotate kiri kanan
        if (window.isKeyPressed(GLFW_KEY_1)) {
            for (int i = 0; i < objectsSphere.size(); i++) {
                objectsSphere.get(i).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
            }

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
            // rotate atas bawah
        } else if (window.isKeyPressed(GLFW_KEY_2)) {
            for (int i = 0; i < objectsSphere.size(); i++) {
                objectsSphere.get(i).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
            }

            for (int i = 0; i < objectsHalfTorus.size(); i++) {
                objectsHalfTorus.get(i).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
            }

            for (int i = 0; i < objectCube.size(); i++) {
                objectCube.get(i).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
            }

            for (int i = 0; i < objectsHalfSphere.size(); i++) {
                objectsHalfSphere.get(i).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
            }

            for (int i = 0; i < objectsCylinder.size(); i++) {
                objectsCylinder.get(i).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
            }
            // rotate depan belakang
        } else if (window.isKeyPressed(GLFW_KEY_3)) {
            for (int i = 0; i < objectsSphere.size(); i++) {
                objectsSphere.get(i).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
            }

            for (int i = 0; i < objectsHalfTorus.size(); i++) {
                objectsHalfTorus.get(i).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
            }

            for (int i = 0; i < objectCube.size(); i++) {
                objectCube.get(i).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
            }

            for (int i = 0; i < objectsHalfSphere.size(); i++) {
                objectsHalfSphere.get(i).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
            }

            for (int i = 0; i < objectsCylinder.size(); i++) {
                objectsCylinder.get(i).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
            }
            // geser atas
        } else if (window.isKeyPressed(GLFW_KEY_W)) {
            for (int i = 0; i < objectsSphere.size(); i++) {
                objectsSphere.get(i).translateObject(0.0f, 0.01f, 0.0f);
            }

            for (int i = 0; i < objectsHalfTorus.size(); i++) {
                objectsHalfTorus.get(i).translateObject(0.0f, 0.01f, 0.0f);
                objectsHalfTorus.get(i).setCenterY(objectsHalfTorus.get(i).getCenterY() + 0.01f);
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
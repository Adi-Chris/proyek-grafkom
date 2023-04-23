package Louis;

import Engine.*;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.Arrays;

import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;

public class Magnemite {
    public ArrayList<Object> objects = new ArrayList<>();
    public ArrayList<Sphere> objectsSphere = new ArrayList<>();
    public ArrayList<HalfTorus> objectsHalfTorus = new ArrayList<>();
    public ArrayList<Cube> objectCube = new ArrayList<>();
    public ArrayList<HalfSphere> objectsHalfSphere = new ArrayList<>();
    public ArrayList<Cylinder> objectsCylinder = new ArrayList<>();
    public ArrayList<Object> objectsBezier1 = new ArrayList<>();
    public ArrayList<Object> objectsBezier2 = new ArrayList<>();
    public ArrayList<Object> objectsBezier3 = new ArrayList<>();
    public ArrayList<Object> objectsBezier4 = new ArrayList<>();
    public ArrayList<Object> objectsBezier5 = new ArrayList<>();
    public ArrayList<Object> objectsBezier6 = new ArrayList<>();
    int frame = 0;
    boolean isAnimating = false;
    int idleFrameCount = 0;
    boolean idleBigger = true;
    Vector3f positionBeforeAnimating = null;

    public void init() {
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
                new Vector4f(0.475f, 0.549f, 0.937f, 0.0f)
        ));

        objectsBezier2.add(new Object(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.475f, 0.549f, 0.937f, 0.0f)
        ));

        objectsBezier3.add(new Object(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.475f, 0.549f, 0.937f, 0.0f)
        ));

        objectsBezier4.add(new Object(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.475f, 0.549f, 0.937f, 0.0f)
        ));

        objectsBezier5.add(new Object(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.475f, 0.549f, 0.937f, 0.0f)
        ));

        objectsBezier6.add(new Object(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.475f, 0.549f, 0.937f, 0.0f)
        ));
    }

    public void loop(boolean isKeyPressed, boolean isInBattleState) {
        idleAnimation();
        attackAnimation(isKeyPressed, isInBattleState);

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

        for (Object object : objectsBezier3) {
            object.drawLine();
        }

        for (Object object : objectsBezier4) {
            object.drawLine();
        }

        for (Object object : objectsBezier5) {
            object.drawLine();
        }

        for (Object object : objectsBezier6) {
            object.drawLine();
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
            } else if (pilihan == 3) {
                objectsBezier3.get(0).addVertices(new Vector3f(x, y, z));
            } else if (pilihan == 4) {
                objectsBezier4.get(0).addVertices(new Vector3f(x, y, z));
            } else if (pilihan == 5) {
                objectsBezier5.get(0).addVertices(new Vector3f(x, y, z));
            } else if (pilihan == 6) {
                objectsBezier6.get(0).addVertices(new Vector3f(x, y, z));
            }
        }
    }

    // rotate magnemite
    public void rotateMagnemite(Float degree, float x, float y, float z) {
        Vector3f tmp = objectsSphere.get(0).updateCenterPoint();

        for (int i = 0; i < objectsSphere.size(); i++) {
            objectsSphere.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
            objectsSphere.get(i).rotateObject((float) Math.toRadians(degree), x, y, z);
            objectsSphere.get(i).translateObject(tmp.x, tmp.y, tmp.z);
        }

        for (int i = 0; i < objectsHalfTorus.size(); i++) {
            objectsHalfTorus.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
            objectsHalfTorus.get(i).rotateObject((float) Math.toRadians(degree), x, y, z);
            objectsHalfTorus.get(i).translateObject(tmp.x, tmp.y, tmp.z);
        }

        for (int i = 0; i < objectCube.size(); i++) {
            objectCube.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
            objectCube.get(i).rotateObject((float) Math.toRadians(degree), x, y, z);
            objectCube.get(i).translateObject(tmp.x, tmp.y, tmp.z);
        }

        for (int i = 0; i < objectsHalfSphere.size(); i++) {
            objectsHalfSphere.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
            objectsHalfSphere.get(i).rotateObject((float) Math.toRadians(degree), x, y, z);
            objectsHalfSphere.get(i).translateObject(tmp.x, tmp.y, tmp.z);
        }

        for (int i = 0; i < objectsCylinder.size(); i++) {
            objectsCylinder.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
            objectsCylinder.get(i).rotateObject((float) Math.toRadians(degree), x, y, z);
            objectsCylinder.get(i).translateObject(tmp.x, tmp.y, tmp.z);
        }

//        objectsBezier1.get(0).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
//        objectsBezier1.get(0).rotateObject((float) Math.toRadians(0.5f), x, y, z);
//        objectsBezier1.get(0).translateObject(tmp.x, tmp.y, tmp.z);
//
//        objectsBezier2.get(0).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
//        objectsBezier2.get(0).rotateObject((float) Math.toRadians(0.5f), x, y, z);
//        objectsBezier2.get(0).translateObject(tmp.x, tmp.y, tmp.z);
//
//        objectsBezier3.get(0).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
//        objectsBezier3.get(0).rotateObject((float) Math.toRadians(0.5f), x, y, z);
//        objectsBezier3.get(0).translateObject(tmp.x, tmp.y, tmp.z);
//
//        objectsBezier4.get(0).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
//        objectsBezier4.get(0).rotateObject((float) Math.toRadians(0.5f), x, y, z);
//        objectsBezier4.get(0).translateObject(tmp.x, tmp.y, tmp.z);
//
//        objectsBezier5.get(0).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
//        objectsBezier5.get(0).rotateObject((float) Math.toRadians(0.5f), x, y, z);
//        objectsBezier5.get(0).translateObject(tmp.x, tmp.y, tmp.z);
//
//        objectsBezier6.get(0).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
//        objectsBezier6.get(0).rotateObject((float) Math.toRadians(0.5f), x, y, z);
//        objectsBezier6.get(0).translateObject(tmp.x, tmp.y, tmp.z);
    }

    // translate magnemite
    public void translateMagnemite(Float x, Float y, Float z) {
        for (int i = 0; i < objectsSphere.size(); i++) {
            objectsSphere.get(i).translateObject(x, y, z);
        }

        for (int i = 0; i < objectsHalfTorus.size(); i++) {
            objectsHalfTorus.get(i).translateObject(x, y, z);
        }

        for (int i = 0; i < objectCube.size(); i++) {
            objectCube.get(i).translateObject(x, y, z);
        }

        for (int i = 0; i < objectsHalfSphere.size(); i++) {
            objectsHalfSphere.get(i).translateObject(x, y, z);
        }

        for (int i = 0; i < objectsCylinder.size(); i++) {
            objectsCylinder.get(i).translateObject(x, y, z);
        }

        objectsBezier1.get(0).translateObject(x, y, z);
        objectsBezier2.get(0).translateObject(x, y, z);
        objectsBezier3.get(0).translateObject(x, y, z);
        objectsBezier4.get(0).translateObject(x, y, z);
        objectsBezier5.get(0).translateObject(x, y, z);
        objectsBezier6.get(0).translateObject(x, y, z);
    }

    // scale magnemite size
    public void scaleMagnemite(Float x, Float y, Float z) {
        for (int i = 0; i < objectsSphere.size(); i++) {
            objectsSphere.get(i).scaleObject(x, y, z);
        }

        for (int i = 0; i < objectsHalfTorus.size(); i++) {
            objectsHalfTorus.get(i).scaleObject(x, y, z);
        }

        for (int i = 0; i < objectCube.size(); i++) {
            objectCube.get(i).scaleObject(x, y, z);
        }

        for (int i = 0; i < objectsHalfSphere.size(); i++) {
            objectsHalfSphere.get(i).scaleObject(x, y, z);
        }

        for (int i = 0; i < objectsCylinder.size(); i++) {
            objectsCylinder.get(i).scaleObject(x, y, z);
        }

        objectsBezier1.get(0).scaleObject(x, y, z);
        objectsBezier2.get(0).scaleObject(x, y, z);
        objectsBezier3.get(0).scaleObject(x, y, z);
        objectsBezier4.get(0).scaleObject(x, y, z);
        objectsBezier5.get(0).scaleObject(x, y, z);
        objectsBezier6.get(0).scaleObject(x, y, z);
    }

    // clear all arraylist
    public void deleteObject() {
        for (int i = objectsSphere.size() - 1; i >= 0; i--) {
            objectsSphere.remove(i);
        }

        for (int i = objectsHalfTorus.size() - 1; i >= 0; i--) {
            objectsHalfTorus.remove(i);
        }

        for (int i = objectCube.size() - 1; i >= 0; i--) {
            objectCube.remove(i);
        }

        for (int i = objectsHalfSphere.size() - 1; i >= 0; i--) {
            objectsHalfSphere.remove(i);
        }

        for (int i = objectsCylinder.size() - 1; i >= 0; i--) {
            objectsCylinder.remove(i);
        }

        for (int i = objectsBezier1.size() - 1; i >= 0; i--) {
            objectsBezier1.remove(i);
        }

        for (int i = objectsBezier2.size() - 1; i >= 0; i--) {
            objectsBezier2.remove(i);
        }

        for (int i = objectsBezier3.size() - 1; i >= 0; i--) {
            objectsBezier3.remove(i);
        }

        for (int i = objectsBezier4.size() - 1; i >= 0; i--) {
            objectsBezier4.remove(i);
        }

        for (int i = objectsBezier5.size() - 1; i >= 0; i--) {
            objectsBezier5.remove(i);
        }

        for (int i = objectsBezier6.size() - 1; i >= 0; i--) {
            objectsBezier6.remove(i);
        }
    }

    // fly
    public void fly(Float distance) {
        for (int i = 0; i < objectsSphere.size(); i++) {
            objectsSphere.get(i).translateObject(0.0f, distance, 0.0f);
        }

        for (int i = 0; i < objectsHalfTorus.size(); i++) {
            objectsHalfTorus.get(i).translateObject(0.0f, distance, 0.0f);
        }

        for (int i = 0; i < objectCube.size(); i++) {
            objectCube.get(i).translateObject(0.0f, distance, 0.0f);
        }

        for (int i = 0; i < objectsHalfSphere.size(); i++) {
            objectsHalfSphere.get(i).translateObject(0.0f, distance, 0.0f);
        }

        for (int i = 0; i < objectsCylinder.size(); i++) {
            objectsCylinder.get(i).translateObject(0.0f, distance, 0.0f);
        }
    }

    // idle animation
    public void idleAnimation() {
        if (isAnimating) {
            return;
        }

        int animationBound = 10;

        if (idleBigger) {
            idleFrameCount++;
        } else {
            idleFrameCount--;
        }

        if (idleFrameCount < animationBound && idleBigger) {
            scaleMagnemite(1.001f, 1.001f, 1.001f);
        }

        if (idleFrameCount > -animationBound && !idleBigger) {
            scaleMagnemite(0.999f, 0.999f, 0.999f);
        }

        if (idleFrameCount >= animationBound * 3) {
            idleFrameCount = animationBound;
            idleBigger = false;
        }

        if (idleFrameCount <= -animationBound * 3) {
            idleFrameCount = -animationBound;
            idleBigger = true;
        }
    }

    // attack animation
    public void attackAnimation(boolean isKeyPressed, boolean isInBattleState) {
        if (!isAnimating) {
            positionBeforeAnimating = objectsSphere.get(0).updateCenterPoint();
        }

        if (isKeyPressed && !isAnimating) {
            this.frame = 0;
            deleteObject();
            init();
            isAnimating = true;
        }

        if (!isKeyPressed && !isAnimating) {
            return;
        }

        // terbang
        if (this.frame < 300) {
            fly(0.001f);
            translateMagnemite(0.0f, 0.0f, -0.001f);
            this.frame++;
            return;
        }

        // bola mata membesar
        if (this.frame >= 300 && this.frame <= 400) {
            objectsSphere.get(2).scaleObject(1.001f, 1.001f, 1.001f);
            this.frame++;
            return;
        }


        if (this.frame >= 400 && this.frame <= 1000) {
            // posisi center tangan kiri dan tangan kanan
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

            // tangan berputar
            Vector3f tmp = objectsHalfTorus.get(0).updateCenterPoint();
            Vector3f tmp2 = objectsHalfTorus.get(1).updateCenterPoint();

            for (int i = 0; i < objectsHalfTorus.size(); i++) {
                if (i == 0) {
                    objectsHalfTorus.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                    objectsHalfTorus.get(i).rotateObject((float) Math.toRadians(15f), 1.0f, 0.0f, 0.0f);
                    objectsHalfTorus.get(i).translateObject(tmp.x, tmp.y, tmp.z);
                } else {
                    objectsHalfTorus.get(i).translateObject(tmp2.x * -1, tmp2.y * -1, tmp2.z * -1);
                    objectsHalfTorus.get(i).rotateObject((float) Math.toRadians(15f), 1.0f, 0.0f, 0.0f);
                    objectsHalfTorus.get(i).translateObject(tmp2.x, tmp2.y, tmp2.z);
                }
            }

            for (int i = 0; i < 8; i++) {
                if (i <= 3) {
                    objectCube.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                    objectCube.get(i).rotateObject((float) Math.toRadians(15f), 1.0f, 0.0f, 0.0f);
                    objectCube.get(i).translateObject(tmp.x, tmp.y, tmp.z);
                } else {
                    objectCube.get(i).translateObject(tmp2.x * -1, tmp2.y * -1, tmp2.z * -1);
                    objectCube.get(i).rotateObject((float) Math.toRadians(15f), 1.0f, 0.0f, 0.0f);
                    objectCube.get(i).translateObject(tmp2.x, tmp2.y, tmp2.z);
                }
            }

            // antena rotate pada poros
            Vector3f tmp3 = objectsCylinder.get(0).updateCenterPoint();
            Vector3f tmp4 = objectsHalfSphere.get(0).updateCenterPoint();
            for (int i = 0; i < objectsCylinder.size(); i++) {
                objectsCylinder.get(i).translateObject(tmp3.x * -1, tmp3.y * -1, tmp3.z * -1);
                objectsCylinder.get(i).rotateObject((float) Math.toRadians(10f), 0.0f, 1.0f, .0f);
                objectsCylinder.get(i).translateObject(tmp3.x, tmp3.y, tmp3.z);
            }

            for (int i = 0; i < objectsHalfSphere.size(); i++) {
                objectsHalfSphere.get(i).translateObject(tmp4.x * -1, tmp4.y * -1, tmp4.z * -1);
                objectsHalfSphere.get(i).rotateObject((float) Math.toRadians(10f), 0.0f, 1.0f, .0f);
                objectsHalfSphere.get(i).translateObject(tmp4.x, tmp4.y, tmp4.z);
            }

            // spawn listrik 1
            if (this.frame == 550) {
                float[][] bezierDots1 = {
                        {xKiri - 0.1f, yKiri, zKiri},
                        {xKiri - 0.2f, yKiri + 0.25f, zKiri},
                        {xKiri - 0.3f, yKiri - 0.1f, zKiri},
                        {xKiri - 0.4f, yKiri + 0.3f, zKiri}
                };

                float[][] bezierDots2 = {
                        {xKanan + 0.1f, yKanan, zKanan},
                        {xKanan + 0.2f, yKanan + 0.25f, zKanan},
                        {xKanan + 0.3f, yKanan - 0.1f, zKanan},
                        {xKanan + 0.4f, yKanan + 0.3f, zKanan}
                };

                drawCurve(bezierDots1, 1);
                drawCurve(bezierDots2, 2);
            }

            // spawn listrik 2
            if (this.frame == 700) {
                float[][] bezierDots3 = {
                        {xKiri - 0.1f, yKiri, zKiri},
                        {xKiri - 0.2f, yKiri + 0.25f, zKiri},
                        {xKiri - 0.3f, yKiri - 0.2f, zKiri},
                        {xKiri - 0.4f, yKiri + 0.1f, zKiri}
                };

                float[][] bezierDots4 = {
                        {xKanan + 0.1f, yKanan, zKanan},
                        {xKanan + 0.2f, yKanan + 0.25f, zKanan},
                        {xKanan + 0.3f, yKanan - 0.2f, zKanan},
                        {xKanan + 0.4f, yKanan + 0.1f, zKanan}
                };

                drawCurve(bezierDots3, 3);
                drawCurve(bezierDots4, 4);
            }

            // spawn listrik 3
            if (this.frame == 850) {
                float[][] bezierDots5 = {
                        {xKiri - 0.1f, yKiri, zKiri},
                        {xKiri - 0.2f, yKiri + 0.25f, zKiri},
                        {xKiri - 0.3f, yKiri - 0.2f, zKiri},
                        {xKiri - 0.4f, yKiri - 0.3f, zKiri}
                };

                float[][] bezierDots6 = {
                        {xKanan + 0.1f, yKanan, zKanan},
                        {xKanan + 0.2f, yKanan + 0.25f, zKanan},
                        {xKanan + 0.3f, yKanan - 0.2f, zKanan},
                        {xKanan + 0.4f, yKanan - 0.3f, zKanan}
                };

                drawCurve(bezierDots5, 5);
                drawCurve(bezierDots6, 6);
            }

            this.frame++;
            return;
        }

        // selesai animasi
        isAnimating = false;
        deleteObject();
        init();
        this.frame = 0;

        // mengembalikan ke posisi awal sebelum animasi
        if (isInBattleState) {
            rotateMagnemite(15f, 0.0f, 1.0f, 0.0f);
            scaleMagnemite(0.5f, 0.5f, 0.5f);
        }
        translateMagnemite(positionBeforeAnimating.x, positionBeforeAnimating.y, positionBeforeAnimating.z);
    }

    public int getFrame() {
        return frame;
    }
}
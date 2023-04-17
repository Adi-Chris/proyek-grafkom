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

    public void loop() {
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
    public void rotateMagnemite(String offset) {
        Vector3f tmp = objectsSphere.get(0).updateCenterPoint();
        float x = 0.0f;
        float y = 0.0f;
        float z = 0.0f;

        // hadap kiri
        if (offset == "yPlus") {
            y = 1.0f;
            // hadap kanan
        } else if (offset == "yMin") {
            y = -1.0f;
            // muter atas
        } else if (offset == "xPlus") {
            x = 1.0f;
            // muter bawah
        } else if (offset == "xMin") {
            x = -1.0f;
            // muter kiri
        } else if (offset == "zPlus") {
            z = 1.0f;
            // muter kanan
        } else if (offset == "zMin") {
            z = -1.0f;
        }

        for (int i = 0; i < objectsSphere.size(); i++) {
            objectsSphere.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
            objectsSphere.get(i).rotateObject((float) Math.toRadians(0.5f), x, y, z);
            objectsSphere.get(i).translateObject(tmp.x, tmp.y, tmp.z);
        }

        for (int i = 0; i < objectsHalfTorus.size(); i++) {
            objectsHalfTorus.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
            objectsHalfTorus.get(i).rotateObject((float) Math.toRadians(0.5f), x, y, z);
            objectsHalfTorus.get(i).translateObject(tmp.x, tmp.y, tmp.z);
        }

        for (int i = 0; i < objectCube.size(); i++) {
            objectCube.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
            objectCube.get(i).rotateObject((float) Math.toRadians(0.5f), x, y, z);
            objectCube.get(i).translateObject(tmp.x, tmp.y, tmp.z);
        }

        for (int i = 0; i < objectsHalfSphere.size(); i++) {
            objectsHalfSphere.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
            objectsHalfSphere.get(i).rotateObject((float) Math.toRadians(0.5f), x, y, z);
            objectsHalfSphere.get(i).translateObject(tmp.x, tmp.y, tmp.z);
        }

        for (int i = 0; i < objectsCylinder.size(); i++) {
            objectsCylinder.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
            objectsCylinder.get(i).rotateObject((float) Math.toRadians(0.5f), x, y, z);
            objectsCylinder.get(i).translateObject(tmp.x, tmp.y, tmp.z);
        }
    }

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
    }

    // translate magnemite position
    public void translateMagnemite(String keyword) {
        if (keyword == "W") {
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
        } else if (keyword == "A") {
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
        } else if (keyword == "D") {
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
        } else if (keyword == "S") {
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
    }

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
    }


    // scale magnemite size
    public void scaleMagnemite(String keyword) {
        if (keyword == "smaller") {
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
        } else if (keyword == "bigger") {
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
}
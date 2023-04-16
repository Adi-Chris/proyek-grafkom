package Engine;


import Ryan.Cube;
import Ryan.Object;
import Ryan.Sphere;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.Arrays;

import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;

public class Environtment {
    public ArrayList<Sphere> objectsSphere = new ArrayList<>();

    public ArrayList<Object> berzier1 = new ArrayList<>();
    public ArrayList<Object> berzier2 = new ArrayList<>();

    public ArrayList<Object> berzier3 = new ArrayList<>();
    public ArrayList<Object> berzier4 = new ArrayList<>();
    public ArrayList<Cube> objectsCube = new ArrayList<>();

    public static float[][] controlBerzier1 = {
            {-0.55f, 0.935f, 0.0f},
            {-0.27f, 0.9325f, 0.0f}
    };
    public static float[][] controlBerzier2 = {
            {-0.62f, 0.7775f, 0.0f},
            {-0.3925f, 0.685f, 0.0f}
    };

    public static float[][] controlBerzier3 = {
            {-0.725f, 0.63f, 0.0f},
            {-0.6125f, 0.4275f, 0.0f}
    };

    public static float[][] controlBerzier4 = {
            {-0.915f, 0.54f, 0.0f},
            {-0.9175f, 0.295f, 0.0f}
    };

    public void init() {
        objectsSphere.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.0f, 0.5f, 0.3f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.3f, 0.1f, 0.3f
        ));
        objectsSphere.get(0).rotateObject((float) Math.toRadians(60), 1.0f, 1.0f, 0.0f);
        objectsSphere.get(0).translateObject(-0.5f, -0.6f, 0.6f);

        objectsSphere.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.0f, 0.5f, 0.3f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.3f, 0.1f, 0.3f
        ));
        objectsSphere.get(1).rotateObject((float) Math.toRadians(60), 1.0f, 1.0f, 0.0f);
        objectsSphere.get(1).translateObject(0.5f, 0.2f, 0.6f);

        // matahari
        objectsSphere.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(1.0f, 0.769f, 0.212f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.4f, 0.4f, 0.4f
        ));
        objectsSphere.get(2).translateObject(-1.0f, 1.0f, 0.6f);

        berzier1.add(new Ryan.Object(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 0.769f, 0.212f, 0.0f)
        ));

        berzier2.add(new Ryan.Object(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 0.769f, 0.212f, 0.0f)
        ));

        berzier3.add(new Ryan.Object(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 0.769f, 0.212f, 0.0f)
        ));

        berzier4.add(new Ryan.Object(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 0.769f, 0.212f, 0.0f)
        ));

        drawCurve(controlBerzier1, 1);
        drawCurve(controlBerzier2, 2);
        drawCurve(controlBerzier3, 3);
        drawCurve(controlBerzier4, 4);

        // rumput
        objectsCube.add(new Cube(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.22f, 0.702f, 0.286f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.5f, 0.5f, 0.5f
        ));
        objectsCube.get(0).rotateObject((float) Math.toRadians(45f), 0.0f, 0.0f, 1.0f);
        objectsCube.get(0).translateObject(0.6f, -1.0f, 0.6f);

        objectsCube.add(new Cube(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.22f, 0.702f, 0.286f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.5f, 0.5f, 0.5f
        ));
        objectsCube.get(1).rotateObject((float) Math.toRadians(45f), 0.0f, 0.0f, 1.0f);
        objectsCube.get(1).translateObject(0.9f, -0.9f, 0.6f);

        objectsCube.add(new Cube(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.22f, 0.702f, 0.286f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.5f, 0.5f, 0.5f
        ));
        objectsCube.get(2).rotateObject((float) Math.toRadians(45f), 0.0f, 0.0f, 1.0f);
        objectsCube.get(2).translateObject(0.3f, -1.1f, 0.6f);
    }

    public void loop() {
        for (Sphere object : objectsSphere) {
            object.draw();
        }

        for (Ryan.Object object : berzier1) {
            object.drawLine();
        }
        for (Ryan.Object object : berzier2) {
            object.drawLine();
        }
        for (Ryan.Object object : berzier3) {
            object.drawLine();
        }
        for (Ryan.Object object : berzier4) {
            object.drawLine();
        }
        for (Cube object : objectsCube) {
            object.draw();
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
                berzier1.get(0).addVertices(new Vector3f(x, y, z));
            } else if (pilihan == 2) {
                berzier2.get(0).addVertices(new Vector3f(x, y, z));
            } else if (pilihan == 3) {
                berzier3.get(0).addVertices(new Vector3f(x, y, z));
            } else if (pilihan == 4) {
                berzier4.get(0).addVertices(new Vector3f(x, y, z));
            }
        }
    }
}
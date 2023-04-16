package Ryan;

import Engine.*;
import org.joml.Vector3f;
import org.joml.Vector4f;
import java.util.ArrayList;
import java.util.Arrays;
import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;

public class Oshawott {
    public ArrayList<Louis.Object> objects = new ArrayList<>();
    public ArrayList<Sphere> objectsSphere = new ArrayList<>();
    public ArrayList<Ellipsoid> objectEllipsoid = new ArrayList<>();
    public ArrayList<HalfSphere> objectsHS = new ArrayList<>();
    public ArrayList<EllipticParaboloid> objectEP = new ArrayList<>();
    public ArrayList<Ryan.Object> berzier1 = new ArrayList<>();
    public ArrayList<Ryan.Object> berzier2 = new ArrayList<>();
    public ArrayList<Cylinder> objectsCylinder = new ArrayList<>();
    int tes;
    public static float[][] controlBerzier1 = {
            { -0.0675f, 0.2925f, -0.2229f},
            { -0.01f, 0.3325f, -0.2229f}
    };
    public static float[][] controlBerzier2 = {
            { -0.01f, 0.3325f, -0.2229f},
            { 0.0675f, 0.2925f, -0.2229f}
    };
    public MouseInput mouseInput;
    int countDegree = 0;

    public void init() {
        berzier1.add(new Ryan.Object(
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
        berzier2.add(new Ryan.Object(
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
        //code
        // Kepala
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
        objectsSphere.get(0).scaleObject(0.49f, 0.44f, 0.49f);
        objectsSphere.get(0).translateObject(0.0f, 0.4f, 0.0f);

        // mata kiri
        objectsSphere.get(0).getChildObject().add(new Ellipsoid(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 0.0f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.08f, 0.073f, 0.035f
        ));
        objectsSphere.get(0).getChildObject().get(0).scaleObject(0.2f, 0.1f, 0.06f);
        objectsSphere.get(0).getChildObject().get(0).translateObject(-0.12f,0.4f,-0.21f);
        objectsSphere.get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);

        // mata kanan
        objectsSphere.get(0).getChildObject().add(new Ellipsoid(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 0.0f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.08f, 0.073f, 0.035f
        ));
        objectsSphere.get(0).getChildObject().get(1).scaleObject(0.2f, 0.1f, 0.06f);
        objectsSphere.get(0).getChildObject().get(1).translateObject(0.12f,0.4f,-0.21f);
        objectsSphere.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
        // hidung
        objectsSphere.get(0).getChildObject().add(new Ellipsoid(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(223/225f,161/225f,74/225f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.08f, 0.073f, 0.035f
        ));
        objectsSphere.get(0).getChildObject().get(2).scaleObject(0.3f, 0.09f, 0.08f);
        objectsSphere.get(0).getChildObject().get(2).translateObject(0.0f,0.4f,-0.26f);

        // Telinga Kiri
        objectsSphere.get(0).getChildObject().add(new EllipticParaboloid(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(77/225f,106/225f,153/225f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.08f, 0.073f, 0.035f
        ));
        objectsSphere.get(0).getChildObject().get(3).scaleObject(0.06f, 0.008f, 0.07f);
        objectsSphere.get(0).getChildObject().get(3).rotateObject((float) Math.toRadians(234), 0.0f, 0.0f, 0.5f);
        objectsSphere.get(0).getChildObject().get(3).translateObject(-0.18f,0.6f,0.0f);

        // Telinga kanan
        objectsSphere.get(0).getChildObject().add(new EllipticParaboloid(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(77/225f,106/225f,153/225f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.08f, 0.073f, 0.035f
        ));
        objectsSphere.get(0).getChildObject().get(4).scaleObject(0.06f, 0.008f, 0.13f);
        objectsSphere.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(118), 0.0f, 0.0f, 0.5f);
        objectsSphere.get(0).getChildObject().get(4).translateObject(0.18f,0.6f,0.0f);

        // bola mata kiri
        objectsSphere.get(0).getChildObject().add(new Ellipsoid(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.08f, 0.073f, 0.035f
        ));
        objectsSphere.get(0).getChildObject().get(5).scaleObject(0.06f, 0.03f, 0.009f);
        objectsSphere.get(0).getChildObject().get(5).translateObject(-0.11f,0.42f,-0.24f);
        objectsSphere.get(0).getChildObject().get(5).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);

        // bola mata kanan
        objectsSphere.get(0).getChildObject().add(new Ellipsoid(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.08f, 0.073f, 0.035f
        ));
        objectsSphere.get(0).getChildObject().get(6).scaleObject(0.06f, 0.03f, 0.009f);
        objectsSphere.get(0).getChildObject().get(6).translateObject(0.11f,0.42f,-0.24f);
        objectsSphere.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);

        // mulut
        berzierMulut(controlBerzier1,0);
        objectsSphere.get(0).getChildObject().add(berzier1.get(0));
        berzierMulut(controlBerzier2,1);
        objectsSphere.get(0).getChildObject().add(berzier2.get(0));

        // Badan
        objectEllipsoid.add(new Ellipsoid(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(148/225f,220/225f,218/225f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.5f, 0.5f, 0.5f
        ));
        objectEllipsoid.get(0).scaleObject(1.06f, 0.45f, 0.4f);
        objectEllipsoid.get(0).translateObject(0.0f, 0.06f, 0.0f);

        // Kerang
        // Kerang atas
        objectsHS.add(new HalfSphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(255/225f,246/225f,184/225f, 0.0f),
                0.0f, 0.0f, 0.0f,
                0.1f,
                0.08f,
                0.03f,
                180,
                180
        ));
        objectsHS.get(0).translateObject(0.0f, -0.02f, -0.20f);

        // Kerang bawah
        objectsHS.get(0).getChildObject().add(new HalfSphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector4f(255/225f,246/225f,184/225f, 0.0f),
                0.0f, 0.0f, 0.0f,
                0.1f,
                0.06f,
                0.03f,
                180,
                180
        ));
        objectsHS.get(0).getChildObject().get(0).translateObject(0.0f, 0.02f, 0.20f);
        objectsHS.get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(180),0.0f, 0.1f, 0.0f);

        // Garis
        objectsHS.get(0).getChildObject().add(new Cube(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.439f, 0.42f, 0.467f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.015f, 0.13f, 0.01f
        ));
        objectsHS.get(0).getChildObject().get(1).translateObject(-0.04f, 0.0f, -0.23f);
        objectsHS.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(13), 0.0f, 0.0f, 1.0f);
        objectsHS.get(0).getChildObject().add(new Cube(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.439f, 0.42f, 0.467f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.015f, 0.13f, 0.01f
        ));
        objectsHS.get(0).getChildObject().get(2).translateObject(0.04f, 0.0f, -0.23f);
        objectsHS.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(-13), 0.0f, 0.0f, 1.0f);

        // Bagian paling bawah kerang
        objectsHS.get(0).getChildObject().add(new Ellipsoid(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(255/225f,246/225f,184/225f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.5f, 0.5f, 0.5f
        ));
        objectsHS.get(0).getChildObject().get(3).scaleObject(0.13f, 0.05f, 0.04f);
        objectsHS.get(0).getChildObject().get(3).translateObject(0.0f, -0.076f, -0.20f);

        // Tangan Kanan
        objectEllipsoid.add(new Ellipsoid(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(1.0f,1.0f,1.0f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.09f, 0.03f, 0.05f
        ));
        objectEllipsoid.get(1).scaleObject(0.6f, 0.14f, 0.15f);
        objectEllipsoid.get(1).translateObject(0.24f,0.119f,0.0f);

        // Tangan Kiri
        objectEllipsoid.add(new Ellipsoid(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(1.0f,1.0f,1.0f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.09f, 0.03f, 0.05f
        ));
        objectEllipsoid.get(2).scaleObject(0.6f, 0.14f, 0.15f);
        objectEllipsoid.get(2).translateObject(-0.24f,0.119f,0.0f);

        // Kaki Kanan
        objectEllipsoid.add(new Ellipsoid(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(77/225f,106/225f,153/225f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.09f, 0.03f, 0.05f
        ));
        objectEllipsoid.get(3).scaleObject(0.6f, 0.14f, 0.15f);
        objectEllipsoid.get(3).translateObject(0.2f,-0.15f,0.0f);
        objectEllipsoid.get(3).rotateObject((float) Math.toRadians(90), 0.0f, 1.0f, 0.0f);
        objectEllipsoid.get(3).translateObject(0.08f,-0.02f,0.15f);

        // Kaki kiri
        objectEllipsoid.add(new Ellipsoid(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(77/225f,106/225f,153/225f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.09f, 0.03f, 0.05f
        ));
        objectEllipsoid.get(4).scaleObject(0.6f, 0.14f, 0.15f);
        objectEllipsoid.get(4).translateObject(-0.2f,-0.15f,0.0f);
        objectEllipsoid.get(4).rotateObject((float) Math.toRadians(-90), 0.0f, 1.0f, 0.0f);
        objectEllipsoid.get(4).translateObject(-0.08f,-0.02f,0.15f);

        // titik pusat
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
                0.0f, 0.0f, 0.0f, 0.05f, 0.05f, 0.05f
        ));

        // Ekor
        objectsCylinder.add(new Cylinder(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(77/225f,106/225f,153/225f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.12f, 0.03f, 0.06f
        ));
        objectsCylinder.get(0).rotateObject((float) Math.toRadians(90), 0.0f, 1.0f, 0.0f);
        objectsCylinder.get(0).translateObject(0.0f,0.0f,0.3f);
    }
    public void loop() {
        for (Sphere object : objectsSphere) {
            object.draw();
        }
        for (Ellipsoid object : objectEllipsoid) {
            object.draw();
        }
        for (EllipticParaboloid object : objectEP) {
            object.draw();
        }
        for (HalfSphere object : objectsHS) {
            object.draw();
        }
        for (Ryan.Object object : berzier1) {
            object.drawLine();
        }
        for (Ryan.Object object : berzier2) {
            object.drawLine();
        }
        for (Cylinder object : objectsCylinder) {
            object.draw();
        }
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
                    berzier1.get(0).addVertices(new Vector3f(x, y, z));
                }
                if (pilihan == 1){
                    berzier2.get(0).addVertices(new Vector3f(x, y, z));
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
}

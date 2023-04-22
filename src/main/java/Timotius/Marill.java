package Timotius;

import Engine.*;
import org.joml.Vector3f;
import org.joml.Vector4f;


import java.util.ArrayList;
import java.util.Arrays;

import Engine.ShaderProgram;

import static org.lwjgl.opengl.GL20.*;

public class Marill {
    public ArrayList<java.lang.Object> objectsPointsControl = new ArrayList<>();

    public ArrayList<Timotius.Sphere> objectsSphere = new ArrayList<>();
    public ArrayList<Timotius.Ellipsoid> objectsEllipsoid = new ArrayList<>();
    public ArrayList<Timotius.Cylinder> cylinder = new ArrayList<>();
    public ArrayList<Timotius.Object> berzier = new ArrayList<>();
    int idleFrameCount = 0;
    boolean idleBigger = true;
    int tes;

    private static float[][] controlBerzier = {
            {-0.0835f, 0.09f, -0.3f},
            {0.0835f, 0.09f, -0.3f}
    };
    private static float[][] controlBerzier2 = {
            {-0.0415f, 0.018f, -0.3f},
            {0.0415f, 0.018f, -0.3f}
    };


    public void init() {
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
        // buntut
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
                new Vector4f(0, 1f, 1f, 1.0f), 0.0f, -0.5f, 0.0f, 0.03f, 0.2f, 0.03f
        ));
        cylinder.get(0).rotateObject((float) Math.toRadians(90f), 1.0f, 0.0f, 0.0f);
        cylinder.get(0).translateObject(0.0f, -0.2f, 0.3f);
    }
    public void loop(){
        idleAnimation();
        for(Timotius.Object objects: objectsSphere) {
            objects.draw();
        }
        for (Timotius.Object objects : objectsEllipsoid) {
            objects.draw();
        }
        for (Timotius.Object objects : berzier) {
            objects.drawLine();
        }
        for (Timotius.Object objects : cylinder) {
            objects.drawLine();
        }
        glDisableVertexAttribArray(0);
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
                if (pilihan == 0) {
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

    public void idleAnimation(){
        int animationBound = 10;

        if (idleBigger) {
            idleFrameCount++;
        } else {
            idleFrameCount--;
        }

        if (idleFrameCount < animationBound && idleBigger) {
            for (Timotius.Sphere object : objectsSphere) {
                object.scaleObject(1.001f, 1.001f, 1.001f);
            }
            for (Timotius.Ellipsoid object : objectsEllipsoid) {
                object.scaleObject(1.001f, 1.001f, 1.001f);
            }
            for (Timotius.Cylinder object : cylinder) {
                object.scaleObject(1.001f, 1.001f, 1.001f);
            }for (Timotius.Object object : berzier) {
                object.scaleObject(1.001f, 1.001f, 1.001f);
            }
            objectsSphere.get(5).rotateObject((float)Math.toRadians(-1f),0.0f,1f,0.0f);
            cylinder.get(0).rotateObject((float)Math.toRadians(-1f),0.0f,1f,0.0f);
        }

        if (idleFrameCount > -animationBound && !idleBigger) {
            objectsSphere.get(5).rotateObject((float)Math.toRadians(1f),0.0f,1f,0.0f);
            cylinder.get(0).rotateObject((float)Math.toRadians(1f),0.0f,1f,0.0f);
            for (Timotius.Sphere object : objectsSphere) {
                object.scaleObject(0.999f, 0.999f, 0.999f);
            }
            for (Timotius.Ellipsoid object : objectsEllipsoid) {
                object.scaleObject(0.999f, 0.999f, 0.999f);
            }
            for (Timotius.Cylinder object : cylinder) {
                object.scaleObject(0.999f, 0.999f, 0.999f);
            }for (Timotius.Object object : berzier) {
                object.scaleObject(0.999f, 0.999f, 0.999f);
            }
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
    public void reset(){
        objectsSphere.clear();
        objectsEllipsoid.clear();
        cylinder.clear();
        berzier.clear();
        init();
    }
}


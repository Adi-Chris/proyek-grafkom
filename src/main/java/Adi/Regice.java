package Adi;

import Engine.ShaderProgram;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.Arrays;

import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;

public class Regice {
    private ArrayList<Object> objects = new ArrayList<>();

    int frameCount = 0;

    public void init() {
        // Main Body
        objects.add(new EllipticCone(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector3f(0, 0, 0),
                1f,
                1f,
                1f,
                6,
                10,
                0,
                5,
                new Vector4f(0.5f, 0.9f, 0.9f, 0.0f)
        ));
        objects.get(0).scaleObject(0.4f, 0.4f, 0.8f);
        objects.get(0).rotateObject(-90.0f, 1, 0, 0);
        objects.get(0).rotateObject(30.0f, 0, 1, 0);

        // Atas
        objects.get(0).getChildObject().add(new EllipticCone(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector3f(0, 0, 0),
                1f,
                1f,
                1f,
                6,
                10,
                new Vector4f(0.0f, 0.9f, 0.9f, 0.0f)
        ));
        objects.get(0).getChildObject().get(0).scaleObject(0.1625f, 0.1625f, 0.1f);
        objects.get(0).getChildObject().get(0).rotateObject(-90.0f, 1, 0, 0);
        objects.get(0).getChildObject().get(0).rotateObject(30.0f, 0, 1, 0);
        objects.get(0).getChildObject().get(0).translateObject(0.0f, 0.48f, 0.0f);

        // Mata Row 1
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector3f(0, 0, 0),
                1f,
                1f,
                1f,
                36,
                36,
                new Vector4f(1.0f, 1.0f, 0.0f, 0.0f)
        ));
        objects.get(0).getChildObject().get(1).scaleObject(0.0125f, 0.0125f, 0.0125f);
        objects.get(0).getChildObject().get(1).translateObject(0.0f, 0.4f, -0.2f);

        // Mata Row 2, Col 1
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector3f(0, 0, 0),
                1f,
                1f,
                1f,
                36,
                36,
                new Vector4f(1.0f, 1.0f, 0.0f, 0.0f)
        ));
        objects.get(0).getChildObject().get(2).scaleObject(0.0125f, 0.0125f, 0.0125f);
        objects.get(0).getChildObject().get(2).translateObject(-0.075f, 0.36f, -0.18f);

        // Mata Row 2, Col 2
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector3f(0, 0, 0),
                1f,
                1f,
                1f,
                36,
                36,
                new Vector4f(1.0f, 1.0f, 0.0f, 0.0f)
        ));
        objects.get(0).getChildObject().get(3).scaleObject(0.0125f, 0.0125f, 0.0125f);
        objects.get(0).getChildObject().get(3).translateObject(-0.0375f, 0.36f, -0.21f);

        // Mata Row 2, Col 3
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector3f(0, 0, 0),
                1f,
                1f,
                1f,
                36,
                36,
                new Vector4f(1.0f, 1.0f, 0.0f, 0.0f)
        ));
        objects.get(0).getChildObject().get(4).scaleObject(0.0125f, 0.0125f, 0.0125f);
        objects.get(0).getChildObject().get(4).translateObject(0.0f, 0.36f, -0.23f);

        // Mata Row 2, Col 4
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector3f(0, 0, 0),
                1f,
                1f,
                1f,
                36,
                36,
                new Vector4f(1.0f, 1.0f, 0.0f, 0.0f)
        ));
        objects.get(0).getChildObject().get(5).scaleObject(0.0125f, 0.0125f, 0.0125f);
        objects.get(0).getChildObject().get(5).translateObject(0.0375f, 0.36f, -0.21f);

        // Mata Row 2, Col 5
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector3f(0, 0, 0),
                1f,
                1f,
                1f,
                36,
                36,
                new Vector4f(1.0f, 1.0f, 0.0f, 0.0f)
        ));
        objects.get(0).getChildObject().get(6).scaleObject(0.0125f, 0.0125f, 0.0125f);
        objects.get(0).getChildObject().get(6).translateObject(0.075f, 0.36f, -0.18f);

        // Mata Row 3
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector3f(0, 0, 0),
                1f,
                1f,
                1f,
                36,
                36,
                new Vector4f(1.0f, 1.0f, 0.0f, 0.0f)
        ));
        objects.get(0).getChildObject().get(7).scaleObject(0.0125f, 0.0125f, 0.0125f);
        objects.get(0).getChildObject().get(7).translateObject(0.0f, 0.32f, -0.24f);

        // Bagian bawah Main Body
        objects.get(0).getChildObject().add(new EllipticCone(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector3f(0, 0, 0),
                1f,
                1f,
                1f,
                6,
                20,
                0,
                5,
                new Vector4f(0.0f, 0.9f, 0.9f, 0.0f)
        ));
        objects.get(0).getChildObject().get(8).scaleObject(0.4f, 0.4f, 0.15f);
        objects.get(0).getChildObject().get(8).rotateObject(90.0f, 1, 0, 0);
        objects.get(0).getChildObject().get(8).rotateObject(30.0f, 0, 1, 0);

        // Pangkal kaki kiri
        objects.get(0).getChildObject().add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector3f(0, 0, 0),
                1f,
                1f,
                1f,
                6,
                10,
                -0.5f,
                0.5f,
                new Vector4f(0.5f, 0.9f, 0.9f, 0.0f)
        ));
        objects.get(0).getChildObject().get(9).scaleObject(0.2f, 0.2f, 0.075f);
        objects.get(0).getChildObject().get(9).rotateObject(90.0f, 1, 0, 0);
        objects.get(0).getChildObject().get(9).translateObject(-0.21f, -0.0825f, 0.0f);

        // Kaki kiri
        objects.get(0).getChildObject().add(new EllipticCone(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector3f(0, 0, 0),
                1f,
                1f,
                1f,
                6,
                10,
                new Vector4f(0.0f, 0.9f, 0.9f, 0.0f)
        ));
        objects.get(0).getChildObject().get(10).scaleObject(0.1f, 0.1f, 0.2f);
        objects.get(0).getChildObject().get(10).rotateObject(90.0f, 1, 0, 0);
        objects.get(0).getChildObject().get(10).translateObject(-0.21f, -0.1f, 0.0f);

        // Pangkal kaki kanan
        objects.get(0).getChildObject().add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector3f(0, 0, 0),
                1f,
                1f,
                1f,
                6,
                10,
                -0.5f,
                0.5f,
                new Vector4f(0.5f, 0.9f, 0.9f, 0.0f)
        ));
        objects.get(0).getChildObject().get(11).scaleObject(0.2f, 0.2f, 0.075f);
        objects.get(0).getChildObject().get(11).rotateObject(90.0f, 1, 0, 0);
        objects.get(0).getChildObject().get(11).translateObject(0.21f, -0.0825f, 0.0f);

        // Kaki kanan
        objects.get(0).getChildObject().add(new EllipticCone(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector3f(0, 0, 0),
                1f,
                1f,
                1f,
                6,
                10,
                new Vector4f(0.0f, 0.9f, 0.9f, 0.0f)
        ));
        objects.get(0).getChildObject().get(12).scaleObject(0.1f, 0.1f, 0.2f);
        objects.get(0).getChildObject().get(12).rotateObject(90.0f, 1, 0, 0);
        objects.get(0).getChildObject().get(12).translateObject(0.21f, -0.1f, 0.0f);

        // Lengan kiri
        objects.get(0).getChildObject().add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector3f(0, 0, 0),
                1f,
                1f,
                1.75f,
                6,
                10,
                -2f,
                2f,
                new Vector4f(0.0f, 0.9f, 0.9f, 0.0f)
        ));
        objects.get(0).getChildObject().get(13).scaleObject(0.1f, 0.1f, 0.1f);
        objects.get(0).getChildObject().get(13).rotateObject(90.0f, 1, 0, 0);
        objects.get(0).getChildObject().get(13).rotateObject(30.0f, 0, 1, 0);
        objects.get(0).getChildObject().get(13).rotateObject(-65f, 0, 0, 1);
        objects.get(0).getChildObject().get(13).translateObject(-0.375f, 0.25f, 0.0f);

        // Jari kiri 1
        objects.get(0).getChildObject().add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector3f(0, 0, 0),
                1f,
                1f,
                1.75f,
                6,
                10,
                -2f,
                2f,
                new Vector4f(0.3f, 0.9f, 0.9f, 0.0f)
        ));
        objects.get(0).getChildObject().get(14).scaleObject(0.025f, 0.025f, 0.025f);
        objects.get(0).getChildObject().get(14).rotateObject(90.0f, 1, 0, 0);
        objects.get(0).getChildObject().get(14).rotateObject(-65f, 0, 0, 1);
        objects.get(0).getChildObject().get(14).translateObject(-0.55f, 0.24f, 0.0f);

        // Jari kiri 2
        objects.get(0).getChildObject().add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector3f(0, 0, 0),
                1f,
                1f,
                1.75f,
                6,
                10,
                -2f,
                2f,
                new Vector4f(0.3f, 0.9f, 0.9f, 0.0f)
        ));
        objects.get(0).getChildObject().get(15).scaleObject(0.025f, 0.025f, 0.025f);
        objects.get(0).getChildObject().get(15).rotateObject(90.0f, 1, 0, 0);
        objects.get(0).getChildObject().get(15).rotateObject(-65f, 0, 0, 1);
        objects.get(0).getChildObject().get(15).translateObject(-0.5f, 0.15f, -0.04f);

        // Jari kiri 3
        objects.get(0).getChildObject().add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector3f(0, 0, 0),
                1f,
                1f,
                1.75f,
                6,
                10,
                -2f,
                2f,
                new Vector4f(0.3f, 0.9f, 0.9f, 0.0f)
        ));
        objects.get(0).getChildObject().get(16).scaleObject(0.025f, 0.025f, 0.025f);
        objects.get(0).getChildObject().get(16).rotateObject(90.0f, 1, 0, 0);
        objects.get(0).getChildObject().get(16).rotateObject(-65f, 0, 0, 1);
        objects.get(0).getChildObject().get(16).translateObject(-0.5f, 0.15f, 0.04f);

        // Lengan kanan
        objects.get(0).getChildObject().add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector3f(0, 0, 0),
                1f,
                1f,
                1.75f,
                6,
                10,
                -2f,
                2f,
                new Vector4f(0.0f, 0.9f, 0.9f, 0.0f)
        ));
        objects.get(0).getChildObject().get(17).scaleObject(0.1f, 0.1f, 0.1f);
        objects.get(0).getChildObject().get(17).rotateObject(90.0f, 1, 0, 0);
        objects.get(0).getChildObject().get(17).rotateObject(30.0f, 0, 1, 0);
        objects.get(0).getChildObject().get(17).rotateObject(65f, 0, 0, 1);
        objects.get(0).getChildObject().get(17).translateObject(0.375f, 0.25f, 0.0f);

        // Jari kanan 1
        objects.get(0).getChildObject().add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector3f(0, 0, 0),
                1f,
                1f,
                1.75f,
                6,
                10,
                -2f,
                2f,
                new Vector4f(0.3f, 0.9f, 0.9f, 0.0f)
        ));
        objects.get(0).getChildObject().get(18).scaleObject(0.025f, 0.025f, 0.025f);
        objects.get(0).getChildObject().get(18).rotateObject(90.0f, 1, 0, 0);
        objects.get(0).getChildObject().get(18).rotateObject(65f, 0, 0, 1);
        objects.get(0).getChildObject().get(18).translateObject(0.55f, 0.24f, 0.0f);

        // Jari kanan 2
        objects.get(0).getChildObject().add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector3f(0, 0, 0),
                1f,
                1f,
                1.75f,
                6,
                10,
                -2f,
                2f,
                new Vector4f(0.3f, 0.9f, 0.9f, 0.0f)
        ));
        objects.get(0).getChildObject().get(19).scaleObject(0.025f, 0.025f, 0.025f);
        objects.get(0).getChildObject().get(19).rotateObject(90.0f, 1, 0, 0);
        objects.get(0).getChildObject().get(19).rotateObject(65f, 0, 0, 1);
        objects.get(0).getChildObject().get(19).translateObject(0.5f, 0.15f, -0.04f);

        // Jari kanan 3
        objects.get(0).getChildObject().add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector3f(0, 0, 0),
                1f,
                1f,
                1.75f,
                6,
                10,
                -2f,
                2f,
                new Vector4f(0.3f, 0.9f, 0.9f, 0.0f)
        ));
        objects.get(0).getChildObject().get(20).scaleObject(0.025f, 0.025f, 0.025f);
        objects.get(0).getChildObject().get(20).rotateObject(90.0f, 1, 0, 0);
        objects.get(0).getChildObject().get(20).rotateObject(65f, 0, 0, 1);
        objects.get(0).getChildObject().get(20).translateObject(0.5f, 0.15f, 0.04f);

        // Kristal punggung, Row 1, Col 1
        objects.get(0).getChildObject().add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector3f(0, 0, 0),
                1f,
                1f,
                3f,
                6,
                10,
                -1.5f,
                2.5f,
                new Vector4f(0.3f, 0.9f, 0.9f, 0.0f)
        ));
        objects.get(0).getChildObject().get(21).scaleObject(0.05f, 0.05f, 0.05f);
        objects.get(0).getChildObject().get(21).rotateObject(-45.0f, 1, 0, 0);
        objects.get(0).getChildObject().get(21).rotateObject(45.0f, 0, 1, 0);
        objects.get(0).getChildObject().get(21).translateObject(0.125f, 0.45f, 0.175f);

        // Kristal punggung, Row 2, Col 1
        objects.get(0).getChildObject().add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector3f(0, 0, 0),
                1f,
                1f,
                3f,
                6,
                10,
                -1.5f,
                2.5f,
                new Vector4f(0.3f, 0.9f, 0.9f, 0.0f)
        ));
        objects.get(0).getChildObject().get(22).scaleObject(0.05f, 0.05f, 0.05f);
        objects.get(0).getChildObject().get(22).rotateObject(-45.0f, 1, 0, 0);
        objects.get(0).getChildObject().get(22).rotateObject(60.0f, 0, 1, 0);
        objects.get(0).getChildObject().get(22).translateObject(0.175f, 0.3f, 0.175f);

        // Kristal punggung, Row 1, Col 2
        objects.get(0).getChildObject().add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector3f(0, 0, 0),
                1f,
                1f,
                3f,
                6,
                10,
                -1.5f,
                2.5f,
                new Vector4f(0.3f, 0.9f, 0.9f, 0.0f)
        ));
        objects.get(0).getChildObject().get(23).scaleObject(0.05f, 0.05f, 0.05f);
        objects.get(0).getChildObject().get(23).rotateObject(-45.0f, 1, 0, 0);
        objects.get(0).getChildObject().get(23).rotateObject(-45.0f, 0, 1, 0);
        objects.get(0).getChildObject().get(23).translateObject(-0.125f, 0.45f, 0.175f);

        // Kristal punggung, Row 2, Col 2
        objects.get(0).getChildObject().add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector3f(0, 0, 0),
                1f,
                1f,
                3f,
                6,
                10,
                -1.5f,
                2.5f,
                new Vector4f(0.3f, 0.9f, 0.9f, 0.0f)
        ));
        objects.get(0).getChildObject().get(24).scaleObject(0.05f, 0.05f, 0.05f);
        objects.get(0).getChildObject().get(24).rotateObject(-45.0f, 1, 0, 0);
        objects.get(0).getChildObject().get(24).rotateObject(-60.0f, 0, 1, 0);
        objects.get(0).getChildObject().get(24).translateObject(-0.175f, 0.3f, 0.175f);
    }

    public void loop() {
        for (Object object : objects) {
            object.draw();
        }
    }

    public void rotateObject(float degree, float x, float y, float z) {
        for (Object object : objects) {
            object.rotateObject(degree, x, y, z);
        }
    }

    public void attackAnimation() {
//        this.frameCount = 0;
//
//        while (frameCount < 60) {
//
//        }
    }
}

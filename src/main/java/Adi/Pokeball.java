package Adi;

import Engine.ShaderProgram;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.Arrays;

import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;

public class Pokeball {
    private ArrayList<Object> objects = new ArrayList<>();

    public void init() {
        // Atas
        objects.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector3f(0, 0, 0),
                1f,
                1f,
                1f,
                180,
                180,
                0,
                80,
                new Vector4f(1.0f, 0.0f, 0.0f, 0.0f)
        ));
        objects.get(0).scaleObject(0.1f, 0.1f, 0.1f);
        objects.get(0).rotateObject(90.0f, 1, 0, 0);

        // Bawah
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector3f(0, 0, 0),
                1f,
                1f,
                1f,
                180,
                180,
                0,
                80,
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f)
        ));
        objects.get(0).getChildObject().get(0).scaleObject(0.1f, 0.1f, 0.1f);
        objects.get(0).getChildObject().get(0).rotateObject(-90.0f, 1, 0, 0);

        // Ring
        objects.get(0).getChildObject().add(new Torus(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector3f(0, 0, 0),
                0.0875f,
                0.0175f,
                180,
                180,
                new Vector4f(0.0f, 0.0f, 0.0f, 0.0f)
        ));
        objects.get(0).getChildObject().get(1).rotateObject(90.0f, 1, 0, 0);

        // Depan Hitam
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector3f(0, 0, 0),
                1f,
                1f,
                1f,
                180,
                180,
                0,
                30,
                new Vector4f(0.0f, 0.0f, 0.0f, 0.0f)
        ));
        objects.get(0).getChildObject().get(2).scaleObject(0.075f, 0.075f, 0.075f);
        objects.get(0).getChildObject().get(2).translateObject(0.0f, 0.0f, -0.0375f);

        // Depan Putih
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector3f(0, 0, 0),
                1f,
                1f,
                1f,
                180,
                180,
                0,
                20,
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f)
        ));
        objects.get(0).getChildObject().get(3).scaleObject(0.075f, 0.075f, 0.075f);
        objects.get(0).getChildObject().get(3).translateObject(0.0f, 0.0f, -0.04f);


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

    public void rotateObjectByCenter(float degree, float x, float y, float z) {
        for (Object object : objects) {
            object.rotateObjectByCenter(degree, x, y, z, objects.get(0));
        }
    }

    public void scaleObject(float scaleX, float scaleY, float scaleZ) {
        for (Object object : objects) {
            object.scaleObject(scaleX, scaleY, scaleZ);
        }
    }

    public void scaleObjectByCenter(float scaleX, float scaleY, float scaleZ) {
        for (Object object : objects) {
            object.scaleObjectByCenter(scaleX, scaleY, scaleZ, objects.get(0));
        }
    }

    public void translateObject(float x, float y, float z) {
        for (Object object : objects) {
            object.translateObject(x, y, z);
        }
    }

    public void reset() {
        this.objects = new ArrayList<>();
        init();
    }
}

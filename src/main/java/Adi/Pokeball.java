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
//        // Atas
                objects.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector3f(0, 0, 0),
                0.25f,
                0.25f,
                0.25f,
                36,
                36,
        0,
                        1,
//                (float)Math.PI,
//                (float)Math.PI / 2,
                new Vector4f(0.0f, 0.0f, 0.0f, 0.0f)
        ));
//                objects.get(0).rotateObject(90.0f, 0, 1, 0);
//        objects.add(new HalfSphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
//                ),
//                new Vector3f(0, 0, 0),
//                0.1f,
//                0.1f,
//                0.1f,
//                36,
//                36,
//                new Vector4f(1.0f, 0.0f, 0.0f, 0.0f)
//        ));
//
//        // Bawah
//        objects.get(0).getChildObject().add(new HalfSphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
//                ),
//                new Vector3f(0, 0, 0),
//                0.1f,
//                0.1f,
//                0.1f,
//                36,
//                36,
//                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f)
//        ));
//        objects.get(0).getChildObject().get(0).rotateObject(180.0f, 0, 0, 1);
//
        // Ring
        objects.get(0).getChildObject().add(new Torus(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
                ),
                new Vector3f(0, 0, 0),
                0.5f,
                0.2f,
                36,
                36,
                new Vector4f(0.0f, 0.0f, 0.0f, 0.0f)
        ));
//        objects.get(0).getChildObject().get(1).rotateObject(90.0f, 1, 0, 0);
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
}

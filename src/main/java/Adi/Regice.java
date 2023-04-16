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

    public void init() {
        // Atas
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
//                0,
//                80,
                new Vector4f(1.0f, 0.0f, 0.0f, 0.0f)
        ));
        objects.get(0).scaleObject(0.3f, 0.3f, 0.3f);
//        objects.get(0).rotateObject(90.0f, 1, 0, 0);

        // Main Body


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

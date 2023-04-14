package Ryan;

import Adi.Object;
import Adi.Sphere;
import Adi.Torus;
import Engine.ShaderProgram;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.Arrays;

import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;

public class Oshawott {
    private ArrayList<Object> objects = new ArrayList<>();

    public void init() {
//        // Atas
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
//                ),
//                new Vector3f(0, 0, 0),
//                1f,
//                1f,
//                1f,
//                180,
//                180,
//                0,
//                80,
//                new Vector4f(1.0f, 0.0f, 0.0f, 0.0f)
//        ));
//        objects.get(0).scaleObject(0.1f, 0.1f, 0.1f);
//        objects.get(0).rotateObject(90.0f, 1, 0, 0);
          // Kepala
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
                180,
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f)
        ));
        objects.get(0).scaleObject(0.25f, 0.25f, 0.25f);
        objects.get(0).rotateObject(90.0f, 1, 0, 0);
        objects.get(0).translateObject(0.0f,0.4f,0.0f);
//        // Bawah
//        objects.get(0).getChildObject().add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
//                ),
//                new Vector3f(0, 0, 0),
//                1f,
//                1f,
//                1f,
//                180,
//                180,
//                0,
//                80,
//                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f)
//        ));
//        objects.get(0).getChildObject().get(0).scaleObject(0.1f, 0.1f, 0.1f);
//        objects.get(0).getChildObject().get(0).rotateObject(-90.0f, 1, 0, 0);

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

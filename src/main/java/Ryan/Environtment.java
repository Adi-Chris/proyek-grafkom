package Ryan;

import Engine.*;
import org.joml.Vector3f;
import org.joml.Vector4f;
import java.util.ArrayList;
import java.util.Arrays;
import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;

public class Environtment {
    public ArrayList<Cylinder> objectsCylinder = new ArrayList<>();
    public void init() {
        objectsCylinder.add(new Cylinder(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.0f,0.5f,0.3f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.3f, 0.1f, 0.3f
        ));
        objectsCylinder.get(0).rotateObject((float) Math.toRadians(60), 1.0f, 1.0f, 0.0f);
        objectsCylinder.get(0).translateObject(-0.5f,-0.8f,0.6f);

        objectsCylinder.add(new Cylinder(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.0f,0.5f,0.3f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.3f, 0.1f, 0.3f
        ));
        objectsCylinder.get(1).rotateObject((float) Math.toRadians(60), 1.0f, 1.0f, 0.0f);
        objectsCylinder.get(1).translateObject(0.5f,0.2f,0.6f);
    }
    public void loop() {
        for (Cylinder object : objectsCylinder) {
            object.draw();
        }
    }
}
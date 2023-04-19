import Adi.Object;
import Engine.*;
import Adi.*;
//import Louis.*;
//import Ryan.*;

import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main {
    private Window window =
            new Window
                    (800, 800, "Hello World");

    // Object Engine
    private Environtment environtment = new Environtment();

    // Object Adi
    private Pokeball pokeball = new Pokeball();
    private Regice regice = new Regice();

    public void init() {
        window.init();
        GL.createCapabilities();

        //code
        environtment.init();
        pokeball.init();
        regice.init();
    }

    public void input() {
        if (window.isKeyPressed(GLFW_KEY_I)) {
            // Rotasi
            pokeball.rotateObject(10f, 1.0f, 0.0f, 0.0f);
            regice.rotateObject(10f, 1.0f, 0.0f, 0.0f);
        }
        if (window.isKeyPressed(GLFW_KEY_J)) {
            // Rotasi
            pokeball.rotateObject(10f, 0.0f, 1.0f, 0.0f);
            regice.rotateObject(10f, 0.0f, 1.0f, 0.0f);
        }
        if (window.isKeyPressed(GLFW_KEY_K)) {
            // Rotasi
            pokeball.rotateObject(-10f, 1.0f, 0.0f, 0.0f);
            regice.rotateObject(-10f, 1.0f, 0.0f, 0.0f);
        }
        if (window.isKeyPressed(GLFW_KEY_L)) {
            // Rotasi
            pokeball.rotateObject(-10f, 0.0f, 1.0f, 0.0f);
            regice.rotateObject(-10f, 0.0f, 1.0f, 0.0f);
        }

        if (window.isKeyPressed(GLFW_KEY_W)) {
            // Translasi
            pokeball.translateObject(0.0f, 0.1f, 0.0f);
            regice.translateObject(0.0f, 0.01f, 0.0f);
        }
        if (window.isKeyPressed(GLFW_KEY_A)) {
            // Translasi
            pokeball.translateObject(-0.1f, 0.0f, 0.0f);
            regice.translateObject(-0.01f, 0.0f, 0.0f);
        }
        if (window.isKeyPressed(GLFW_KEY_S)) {
            // Translasi
            pokeball.translateObject(0.0f, -0.1f, 0.0f);
            regice.translateObject(0.0f, -0.01f, 0.0f);
        }
        if (window.isKeyPressed(GLFW_KEY_D)) {
            // Translasi
            pokeball.translateObject(0.1f, 0.0f, 0.0f);
            regice.translateObject(0.01f, 0.0f, 0.0f);
        }

        if (window.isKeyPressed(GLFW_KEY_T)) {
            // Scale
//            pokeball.scaleObject(1.1f, 1.1f, 1.1f);
            regice.scaleObject(1.001f, 1.001f, 1.001f);
        }
        if (window.isKeyPressed(GLFW_KEY_G)) {
            // Scale
//            pokeball.scaleObject(0.9f, 0.9f, 0.9f);
            regice.scaleObject(0.999f, 0.999f, 0.999f);
        }

        if (window.isKeyPressed(GLFW_KEY_R)) {
            // Reset ke posisi awal
            regice.reset();
        }
    }

    public void loop() {
        while (window.isOpen()) {
            window.update();
            glClearColor(1.0f,
                    0.3f, 0.95f,
                    0.0f);
            GL.createCapabilities();
            input();

            //code
            environtment.loop();
//            pokeball.loop();
            regice.loop(window.isKeyPressed(GLFW_KEY_Q), false);

            // Restore state
            glDisableVertexAttribArray(0);

            // Poll for window events.
            // The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }
    }

    public void run() {

        init();
        loop();

        // Terminate GLFW and
        // free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
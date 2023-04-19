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
            pokeball.rotateObjectByCenter(0.01f, 1.0f, 0.0f, 0.0f);
            regice.rotateObjectByCenter(0.01f, 1.0f, 0.0f, 0.0f);
        }
        if (window.isKeyPressed(GLFW_KEY_J)) {
            // Rotasi
            pokeball.rotateObjectByCenter(0.01f, 0.0f, 1.0f, 0.0f);
            regice.rotateObjectByCenter(0.01f, 0.0f, 1.0f, 0.0f);
        }
        if (window.isKeyPressed(GLFW_KEY_K)) {
            // Rotasi
            pokeball.rotateObjectByCenter(-0.01f, 1.0f, 0.0f, 0.0f);
            regice.rotateObjectByCenter(-0.01f, 1.0f, 0.0f, 0.0f);
        }
        if (window.isKeyPressed(GLFW_KEY_L)) {
            // Rotasi
            pokeball.rotateObjectByCenter(-0.01f, 0.0f, 1.0f, 0.0f);
            regice.rotateObjectByCenter(-0.01f, 0.0f, 1.0f, 0.0f);
        }

        if (window.isKeyPressed(GLFW_KEY_W)) {
            // Translasi
            pokeball.translateObject(0.0f, 0.01f, 0.0f);
            regice.translateObject(0.0f, 0.01f, 0.0f);
        }
        if (window.isKeyPressed(GLFW_KEY_A)) {
            // Translasi
            pokeball.translateObject(-0.01f, 0.0f, 0.0f);
            regice.translateObject(-0.01f, 0.0f, 0.0f);
        }
        if (window.isKeyPressed(GLFW_KEY_S)) {
            // Translasi
            pokeball.translateObject(0.0f, -0.01f, 0.0f);
            regice.translateObject(0.0f, -0.01f, 0.0f);
        }
        if (window.isKeyPressed(GLFW_KEY_D)) {
            // Translasi
            pokeball.translateObject(0.01f, 0.0f, 0.0f);
            regice.translateObject(0.01f, 0.0f, 0.0f);
            // Scale
            pokeball.scaleObjectByCenter(1.01f, 1.01f, 1.01f);
            regice.scaleObjectByCenter(1.01f, 1.01f, 1.01f);
        }
        if (window.isKeyPressed(GLFW_KEY_G)) {
            // Scale
            pokeball.scaleObjectByCenter(0.99f, 0.99f, 0.99f);
            regice.scaleObjectByCenter(0.99f, 0.99f, 0.99f);
        }

        if (window.isKeyPressed(GLFW_KEY_R) && !regice.isAnimating()) {
            // Reset ke posisi awal
            pokeball.reset();
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
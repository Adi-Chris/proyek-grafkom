import Engine.*;
import Louis.*;

import org.joml.Vector2f;
import org.joml.Vector3f;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main2 {
    private Window window = new Window(800, 800, "Window");
    private Magnemite magnemite = new Magnemite();
    private Environtment environtment = new Environtment();

    public void init() {
        window.init();
        GL.createCapabilities();
        glEnable(GL_DEPTH_TEST);
        MouseInput mouseInput = window.getMouseInput();

        // init environment
        environtment.init();

        // init object magnemite
        magnemite.init();
    }

    public void input() {
        // rotate offsetY (hadap kiri)
        if (window.isKeyPressed(GLFW_KEY_1)) {
            magnemite.rotateMagnemite("yPlus");
        }

        // rotate offsetY (hadap kanan)
        if (window.isKeyPressed(GLFW_KEY_2)) {
            magnemite.rotateMagnemite("yMin");
        }

        // rotate offsetX (muter atas)
        if (window.isKeyPressed(GLFW_KEY_3)) {
            magnemite.rotateMagnemite("xPlus");
        }

        // rotate offsetX (muter bawah)
        if (window.isKeyPressed(GLFW_KEY_4)) {
            magnemite.rotateMagnemite("xMin");
        }

        // rotate offsetZ (muter kiri)
        if (window.isKeyPressed(GLFW_KEY_5)) {
            magnemite.rotateMagnemite("zPlus");
        }

        // rotate offsetZ (muter kanan)
        if (window.isKeyPressed(GLFW_KEY_6)) {
            magnemite.rotateMagnemite("zMin");
        }

        // geser atas
        if (window.isKeyPressed(GLFW_KEY_W)) {
            magnemite.translateMagnemite("W");
        }

        // geser kiri
        if (window.isKeyPressed(GLFW_KEY_A)) {
            magnemite.translateMagnemite("A");
        }

        // geser kanan
        if (window.isKeyPressed(GLFW_KEY_D)) {
            magnemite.translateMagnemite("D");
        }

        // geser bawah
        if (window.isKeyPressed(GLFW_KEY_S)) {
            magnemite.translateMagnemite("S");
        }

        // kecilin
        if (window.isKeyPressed(GLFW_KEY_7)) {
            magnemite.scaleMagnemite("smaller");
        }

        // besarin
        if (window.isKeyPressed(GLFW_KEY_8)) {
            magnemite.scaleMagnemite("bigger");
        }

        // animasi bola mata gerak
        if (window.isKeyPressed(GLFW_KEY_0)) {
            Vector3f tmp = magnemite.objectsSphere.get(1).updateCenterPoint();

            magnemite.objectsSphere.get(2).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
            magnemite.objectsSphere.get(2).rotateObject((float) Math.toRadians(5f), 0.0f, 0.0f, 1.0f);
            magnemite.objectsSphere.get(2).translateObject(tmp.x, tmp.y, tmp.z);
        }

        // print x y tempat diklik, untuk cek letak titik kontrol bezier
        if (window.getMouseInput().isLeftButtonPressed()) {
            Vector2f pos = window.getMouseInput().getCurrentPos();
            pos.x = (pos.x - (window.getWidth()) / 2.0f) / (window.getWidth() / 2.0f);
            pos.y = (pos.y - (window.getHeight()) / 2.0f) / (-window.getHeight() / 2.0f);

            if ((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1))) {
                System.out.println(pos.x + "f, " + pos.y + "f, 0.0f");
            }
        }

        // reset ke posisi default
        if (window.isKeyPressed(GLFW_KEY_R)) {
            magnemite.deleteObject();
            magnemite.init();
        }

        // untuk attack animation, klik 9
    }

    public void loop() {
        while (window.isOpen()) {
            window.update();
//            glClearColor(0.0f, 1.0f, 0.5f, 0.0f);
            glClearColor(15f,192/255f,203/255f,0.0f);
            GL.createCapabilities();
            glEnable(GL_DEPTH_TEST);
            input();

            environtment.loop();
            magnemite.loop(window.isKeyPressed(GLFW_KEY_9), false);

            glDisableVertexAttribArray(0);
            glfwPollEvents();
        }
    }

    public void run() {
        init();
        loop();
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public static void main(String[] args) {
        new Main2().run();
    }
}
import Adi.Pokeball;
import Engine.*;
import Ryan.*;

import org.joml.Vector2f;
import org.joml.Vector3f;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main3 {
    private Window window =
            new Window
                    (800, 800, "Hello World");
    private Oshawott Oshawott = new Oshawott();
    private Environtment envi = new Environtment();
    private Pokeball pokeball = new Pokeball();
    int checkTangan = 0;
    boolean checkArahTangan = true;
    int checkKaki = 0;
    boolean checkArahKaki = true;
    int checkBadan = 0;
    boolean checkArahBadan = true;
    private MouseInput mouseInput;

    public void init() {
        window.init();
        GL.createCapabilities();
        glEnable(GL_DEPTH_TEST);
        mouseInput = window.getMouseInput();
        pokeball.init();
        Oshawott.init();
        envi.init();
    }

    public static void main(String[] args) {
        new Main3().run();
    }

    public void input() {

        // Rotasi Atas
        if (window.isKeyPressed(GLFW_KEY_UP)) {
            Vector3f tmp = Oshawott.objectsSphere.get(1).updateCenterPoint();
            for (int i = 0; i < Oshawott.objectEllipsoid.size(); i++) {
                Oshawott.objectEllipsoid.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                Oshawott.objectEllipsoid.get(i).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
                Oshawott.objectEllipsoid.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }
            for (int i = 0; i < Oshawott.objectsSphere.size(); i++) {
                Oshawott.objectsSphere.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                Oshawott.objectsSphere.get(i).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
                Oshawott.objectsSphere.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }
            Oshawott.objectsHS.get(0).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
            Oshawott.objectsHS.get(0).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
            Oshawott.objectsHS.get(0).translateObject(tmp.x, tmp.y, tmp.z);

            Oshawott.objectsCylinder.get(0).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
            Oshawott.objectsCylinder.get(0).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
            Oshawott.objectsCylinder.get(0).translateObject(tmp.x, tmp.y, tmp.z);
        }

        // Rotasi bawah
        if (window.isKeyPressed(GLFW_KEY_DOWN)) {
            Vector3f tmp = Oshawott.objectsSphere.get(1).updateCenterPoint();
            for (int i = 0; i < Oshawott.objectEllipsoid.size(); i++) {
                Oshawott.objectEllipsoid.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                Oshawott.objectEllipsoid.get(i).rotateObject((float) Math.toRadians(-0.5f), 1.0f, 0.0f, 0.0f);
                Oshawott.objectEllipsoid.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }
            for (int i = 0; i < Oshawott.objectsSphere.size(); i++) {
                Oshawott.objectsSphere.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                Oshawott.objectsSphere.get(i).rotateObject((float) Math.toRadians(-0.5f), 1.0f, 0.0f, 0.0f);
                Oshawott.objectsSphere.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }
            Oshawott.objectsHS.get(0).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
            Oshawott.objectsHS.get(0).rotateObject((float) Math.toRadians(-0.5f), 1.0f, 0.0f, 0.0f);
            Oshawott.objectsHS.get(0).translateObject(tmp.x, tmp.y, tmp.z);

            Oshawott.objectsCylinder.get(0).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
            Oshawott.objectsCylinder.get(0).rotateObject((float) Math.toRadians(-0.5f), 1.0f, 0.0f, 0.0f);
            Oshawott.objectsCylinder.get(0).translateObject(tmp.x, tmp.y, tmp.z);
        }

        // Rotasi kiri
        if (window.isKeyPressed(GLFW_KEY_LEFT)) {
            Vector3f tmp = Oshawott.objectsSphere.get(1).updateCenterPoint();
            for (int i = 0; i < Oshawott.objectEllipsoid.size(); i++) {
                Oshawott.objectEllipsoid.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                Oshawott.objectEllipsoid.get(i).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
                Oshawott.objectEllipsoid.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }
            for (int i = 0; i < Oshawott.objectsSphere.size(); i++) {
                Oshawott.objectsSphere.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                Oshawott.objectsSphere.get(i).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
                Oshawott.objectsSphere.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }
            Oshawott.objectsHS.get(0).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
            Oshawott.objectsHS.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
            Oshawott.objectsHS.get(0).translateObject(tmp.x, tmp.y, tmp.z);

            Oshawott.objectsCylinder.get(0).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
            Oshawott.objectsCylinder.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
            Oshawott.objectsCylinder.get(0).translateObject(tmp.x, tmp.y, tmp.z);
        }

        // Rotasi kanan
        if (window.isKeyPressed(GLFW_KEY_RIGHT)) {
            Vector3f tmp = Oshawott.objectsSphere.get(1).updateCenterPoint();
            for (int i = 0; i < Oshawott.objectEllipsoid.size(); i++) {
                Oshawott.objectEllipsoid.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                Oshawott.objectEllipsoid.get(i).rotateObject((float) Math.toRadians(-0.5f), 0.0f, 1.0f, 0.0f);
                Oshawott.objectEllipsoid.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }
            for (int i = 0; i < Oshawott.objectsSphere.size(); i++) {
                Oshawott.objectsSphere.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                Oshawott.objectsSphere.get(i).rotateObject((float) Math.toRadians(-0.5f), 0.0f, 1.0f, 0.0f);
                Oshawott.objectsSphere.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }
            Oshawott.objectsHS.get(0).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
            Oshawott.objectsHS.get(0).rotateObject((float) Math.toRadians(-0.5f), 0.0f, 1.0f, 0.0f);
            Oshawott.objectsHS.get(0).translateObject(tmp.x, tmp.y, tmp.z);

            Oshawott.objectsCylinder.get(0).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
            Oshawott.objectsCylinder.get(0).rotateObject((float) Math.toRadians(-0.5f), 0.0f, 1.0f, 0.0f);
            Oshawott.objectsCylinder.get(0).translateObject(tmp.x, tmp.y, tmp.z);
        }

        // Pindah atas
        if (window.isKeyPressed(GLFW_KEY_W)) {
            for (int i = 0; i < Oshawott.objectEllipsoid.size(); i++) {
                Oshawott.objectEllipsoid.get(i).translateObject(0.0f, 0.01f, 0.0f);
            }
            for (int i = 0; i < Oshawott.objectsSphere.size(); i++) {
                Oshawott.objectsSphere.get(i).translateObject(0.0f, 0.01f, 0.0f);
            }
            Oshawott.objectsHS.get(0).translateObject(0.0f, 0.01f, 0.0f);
            Oshawott.objectsCylinder.get(0).translateObject(0.0f, 0.01f, 0.0f);
        }

        // Pindah bawah
        if (window.isKeyPressed(GLFW_KEY_S)) {
            for (int i = 0; i < Oshawott.objectEllipsoid.size(); i++) {
                Oshawott.objectEllipsoid.get(i).translateObject(0.0f, -0.01f, 0.0f);
            }
            for (int i = 0; i < Oshawott.objectsSphere.size(); i++) {
                Oshawott.objectsSphere.get(i).translateObject(0.0f, -0.01f, 0.0f);
            }
            Oshawott.objectsHS.get(0).translateObject(0.0f, -0.01f, 0.0f);
            Oshawott.objectsCylinder.get(0).translateObject(0.0f, -0.01f, 0.0f);
        }
        // Pindah kiri
        if (window.isKeyPressed(GLFW_KEY_A)) {
            for (int i = 0; i < Oshawott.objectEllipsoid.size(); i++) {
                Oshawott.objectEllipsoid.get(i).translateObject(-0.01f, 0.0f, 0.0f);
            }
            for (int i = 0; i < Oshawott.objectsSphere.size(); i++) {
                Oshawott.objectsSphere.get(i).translateObject(-0.01f, 0.0f, 0.0f);
            }
            Oshawott.objectsHS.get(0).translateObject(-0.01f, 0.0f, 0.0f);
            Oshawott.objectsCylinder.get(0).translateObject(-0.01f, 0.0f, 0.0f);
        }

        // Pindah kanan
        if (window.isKeyPressed(GLFW_KEY_D)) {
            for (int i = 0; i < Oshawott.objectEllipsoid.size(); i++) {
                Oshawott.objectEllipsoid.get(i).translateObject(0.01f, 0.0f, 0.0f);
            }
            for (int i = 0; i < Oshawott.objectsSphere.size(); i++) {
                Oshawott.objectsSphere.get(i).translateObject(0.01f, 0.0f, 0.0f);
            }
            Oshawott.objectsHS.get(0).translateObject(0.01f, 0.0f, 0.0f);
            Oshawott.objectsCylinder.get(0).translateObject(0.01f, 0.0f, 0.0f);
        }

        // Mencari koordinat
        if (window.getMouseInput().isLeftButtonPressed()) {
            Vector2f pos = window.getMouseInput().getCurrentPos();
//            System.out.println("x : " + pos.x + "y : " + pos.y);

            // dinormalisasi biar titik 0,0 itu di tengah
            pos.x = (pos.x - (window.getWidth()) / 2.0f) / (window.getWidth() / 2.0f);
            pos.y = (pos.y - (window.getHeight()) / 2.0f) / (-window.getHeight() / 2.0f);
            System.out.println(pos.x + "f, " + pos.y + "f, 0.0f");
        }

        // Gerakan Tangan
        if (window.isKeyPressed(GLFW_KEY_1)) {
            Vector3f tmp = Oshawott.objectsSphere.get(1).updateCenterPoint();
            if (checkTangan < 30 && checkArahTangan) {
                Oshawott.objectEllipsoid.get(1).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                Oshawott.objectEllipsoid.get(1).rotateObject((float) Math.toRadians(0.23f), 0.0f, 0.0f, -1.0f);
                Oshawott.objectEllipsoid.get(1).translateObject(tmp.x, tmp.y, tmp.z);
                Oshawott.objectEllipsoid.get(2).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                Oshawott.objectEllipsoid.get(2).rotateObject((float) Math.toRadians(-0.23f), 0.0f, 0.0f, 1.0f);
                Oshawott.objectEllipsoid.get(2).translateObject(tmp.x, tmp.y, tmp.z);
                checkTangan++;
            }
            if (checkTangan > -30 && !checkArahTangan) {
                Oshawott.objectEllipsoid.get(1).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                Oshawott.objectEllipsoid.get(1).rotateObject((float) Math.toRadians(0.23f), 0.0f, 0.0f, 1.0f);
                Oshawott.objectEllipsoid.get(1).translateObject(tmp.x, tmp.y, tmp.z);
                Oshawott.objectEllipsoid.get(2).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                Oshawott.objectEllipsoid.get(2).rotateObject((float) Math.toRadians(-0.23f), 0.0f, 0.0f, -1.0f);
                Oshawott.objectEllipsoid.get(2).translateObject(tmp.x, tmp.y, tmp.z);
                checkTangan--;
            }
            if (checkTangan >= 30) {
                checkTangan = 30;
                checkArahTangan = false;
            }
            if (checkTangan <= -30) {
                checkTangan = -30;
                checkArahTangan = true;
            }
        }

        // Gerakan Kaki
        if (window.isKeyPressed(GLFW_KEY_2)) {
            Vector3f tmp = Oshawott.objectsSphere.get(1).updateCenterPoint();
            if (checkKaki < 30 && checkArahKaki) {
                Oshawott.objectEllipsoid.get(3).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                Oshawott.objectEllipsoid.get(3).rotateObject((float) Math.toRadians(-0.5f), 1.0f, 0.0f, 0.0f);
                Oshawott.objectEllipsoid.get(3).translateObject(tmp.x, tmp.y, tmp.z);
                Oshawott.objectEllipsoid.get(4).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                Oshawott.objectEllipsoid.get(4).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
                Oshawott.objectEllipsoid.get(4).translateObject(tmp.x, tmp.y, tmp.z);
                checkKaki++;
            }
            if (checkKaki > -30 && !checkArahKaki) {
                Oshawott.objectEllipsoid.get(3).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                Oshawott.objectEllipsoid.get(3).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
                Oshawott.objectEllipsoid.get(3).translateObject(tmp.x, tmp.y, tmp.z);
                Oshawott.objectEllipsoid.get(4).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                Oshawott.objectEllipsoid.get(4).rotateObject((float) Math.toRadians(-0.5f), 1.0f, 0.0f, 0.0f);
                Oshawott.objectEllipsoid.get(4).translateObject(tmp.x, tmp.y, tmp.z);
                checkKaki--;
            }
            if (checkKaki >= 30) {
                checkKaki = 30;
                checkArahKaki = false;
            }
            if (checkKaki <= -30) {
                checkKaki = -30;
                checkArahKaki = true;
            }
        }
        // Maju
        if (window.isKeyPressed(GLFW_KEY_3)) {
            for (int i = 0; i < Oshawott.objectEllipsoid.size(); i++) {
                Oshawott.objectEllipsoid.get(i).scaleObject(1.001f, 1.001f, 1.001f);
            }
            for (int i = 0; i < Oshawott.objectsSphere.size(); i++) {
                Oshawott.objectsSphere.get(i).scaleObject(1.001f, 1.001f, 1.001f);
            }
            Oshawott.objectsHS.get(0).scaleObject(1.001f, 1.001f, 1.001f);
            Oshawott.objectsCylinder.get(0).scaleObject(1.001f, 1.001f, 1.001f);
        }

        // Mandur
        if (window.isKeyPressed(GLFW_KEY_4)) {
            for (int i = 0; i < Oshawott.objectEllipsoid.size(); i++) {
                Oshawott.objectEllipsoid.get(i).scaleObject(0.999f, 0.999f, 0.999f);
            }
            for (int i = 0; i < Oshawott.objectsSphere.size(); i++) {
                Oshawott.objectsSphere.get(i).scaleObject(0.999f, 0.999f, 0.999f);
            }
            Oshawott.objectsHS.get(0).scaleObject(0.999f, 0.999f, 0.999f);
            Oshawott.objectsCylinder.get(0).scaleObject(0.999f, 0.999f, 0.999f);
        }

        // Gerakan Ekor
        if (window.isKeyPressed(GLFW_KEY_5)) {
            Vector3f tmp = Oshawott.objectsSphere.get(1).updateCenterPoint();
            if (checkBadan < 20 && checkArahBadan) {
                Oshawott.objectsCylinder.get(0).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                Oshawott.objectsCylinder.get(0).rotateObject((float) Math.toRadians(-0.5f), 1.0f, 0.0f, 0.0f);
                Oshawott.objectsCylinder.get(0).translateObject(tmp.x, tmp.y, tmp.z);
                checkBadan++;
            }
            if (checkBadan > -20 && !checkArahBadan) {
                Oshawott.objectsCylinder.get(0).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                Oshawott.objectsCylinder.get(0).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
                Oshawott.objectsCylinder.get(0).translateObject(tmp.x, tmp.y, tmp.z);
                checkBadan--;
            }
            if (checkBadan >= 20) {
                checkBadan = 20;
                checkArahBadan = false;
            }
            if (checkBadan <= -20) {
                checkBadan = -20;
                checkArahBadan = true;
            }
        }

        // Muter 180 derajat
        if (window.isKeyPressed(GLFW_KEY_6)) {
            Vector3f tmp = Oshawott.objectsSphere.get(1).updateCenterPoint();
            for (int i = 0; i < Oshawott.objectEllipsoid.size(); i++) {
                Oshawott.objectEllipsoid.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                Oshawott.objectEllipsoid.get(i).rotateObject((float) Math.toRadians(180), 0.0f, 1.0f, 0.0f);
                Oshawott.objectEllipsoid.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }

            for (int i = 0; i < Oshawott.objectsSphere.size(); i++) {
                Oshawott.objectsSphere.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                Oshawott.objectsSphere.get(i).rotateObject((float) Math.toRadians(180), 0.0f, 1.0f, 0.0f);
                Oshawott.objectsSphere.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }

            Oshawott.objectsHS.get(0).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
            Oshawott.objectsHS.get(0).rotateObject((float) Math.toRadians(180), 0.0f, 1.0f, 0.0f);
            Oshawott.objectsHS.get(0).translateObject(tmp.x, tmp.y, tmp.z);

            Oshawott.objectsCylinder.get(0).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
            Oshawott.objectsCylinder.get(0).rotateObject((float) Math.toRadians(180), 0.0f, 1.0f, 0.0f);
            Oshawott.objectsCylinder.get(0).translateObject(tmp.x, tmp.y, tmp.z);

        }

        // Masuk pokeball
        if(window.isKeyPressed(GLFW_KEY_7)){
            for (int i = 0; i < Oshawott.objectEllipsoid.size(); i++) {
                Oshawott.objectEllipsoid.get(i).translateObject(0.01f, 0.01f, 0.0f);
            }
            for (int i = 0; i < Oshawott.objectsSphere.size(); i++) {
                Oshawott.objectsSphere.get(i).translateObject(0.01f, 0.01f, 0.0f);
            }
            Oshawott.objectsHS.get(0).translateObject(0.01f, 0.01f, 0.0f);
            Oshawott.objectsCylinder.get(0).translateObject(0.01f, 0.01f, 0.0f);
            for (int i = 0; i < Oshawott.objectEllipsoid.size(); i++) {
                Oshawott.objectEllipsoid.get(i).scaleObject(0.989f, 0.989f, 0.989f);
            }
            for (int i = 0; i < Oshawott.objectsSphere.size(); i++) {
                Oshawott.objectsSphere.get(i).scaleObject(0.989f, 0.989f, 0.989f);
            }
            Oshawott.objectsHS.get(0).scaleObject(0.989f, 0.989f, 0.989f);
            Oshawott.objectsCylinder.get(0).scaleObject(0.989f, 0.989f, 0.989f);
        }
    }

    public void loop() {
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f,
                    1.0f, 0.5f,
                    0.0f);
            GL.createCapabilities();
            input();

            Oshawott.loop();
            envi.loop();

            //code
//            for(Object object: objects){
//                object.draw();
//            }
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
}
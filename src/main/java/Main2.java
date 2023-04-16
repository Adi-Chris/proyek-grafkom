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
    boolean keyPressed = false;
    boolean animated = false;

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
        if (window.isKeyPressed(GLFW_KEY_1) && animated == false) {
            magnemite.rotateMagnemite("yPlus");
        }

        // rotate offsetY (hadap kanan)
        if (window.isKeyPressed(GLFW_KEY_2) && animated == false) {
            magnemite.rotateMagnemite("yMin");
        }

        // rotate offsetX (muter atas)
        if (window.isKeyPressed(GLFW_KEY_3) && animated == false) {
            magnemite.rotateMagnemite("xPlus");
        }

        // rotate offsetX (muter bawah)
        if (window.isKeyPressed(GLFW_KEY_4) && animated == false) {
            magnemite.rotateMagnemite("xMin");
        }

        // rotate offsetZ (muter kiri)
        if (window.isKeyPressed(GLFW_KEY_5) && animated == false) {
            magnemite.rotateMagnemite("zPlus");
        }

        // rotate offsetZ (muter kanan)
        if (window.isKeyPressed(GLFW_KEY_6) && animated == false) {
            magnemite.rotateMagnemite("zMin");
        }

        // geser atas
        if (window.isKeyPressed(GLFW_KEY_W) && animated == false) {
            magnemite.translateMagnemite("W");
        }

        // geser kiri
        if (window.isKeyPressed(GLFW_KEY_A) && animated == false) {
            magnemite.translateMagnemite("A");
        }

        // geser kanan
        if (window.isKeyPressed(GLFW_KEY_D) && animated == false) {
            magnemite.translateMagnemite("D");
        }

        // geser bawah
        if (window.isKeyPressed(GLFW_KEY_S) && animated == false) {
            magnemite.translateMagnemite("S");
        }

        // kecilin
        if (window.isKeyPressed(GLFW_KEY_7) && animated == false) {
            magnemite.scaleMagnemite("smaller");
        }

        // besarin
        if (window.isKeyPressed(GLFW_KEY_8) && animated == false) {
            magnemite.scaleMagnemite("bigger");
        }

        // animasi preparing to attack
        // saat key 9 pertama kali dipencet
        if (window.isKeyPressed(GLFW_KEY_9) && keyPressed == false) {
            if (animated == false) {
                keyPressed = true;
                animated = true;

                // magnemite terbang (naik dari posisi semula)
                magnemite.fly(0.3f);

                // bola mata membesar
                magnemite.objectsSphere.get(2).scaleObject(1.1f, 1.1f, 1.0f);

                // show listrik pakai bezier
                Vector3f cubeAtasTanganKiri = magnemite.objectCube.get(2).updateCenterPoint();
                Vector3f cubeBawahTanganKiri = magnemite.objectCube.get(3).updateCenterPoint();
                float xKiri = (cubeAtasTanganKiri.x + cubeBawahTanganKiri.x) / 2;
                float yKiri = (cubeAtasTanganKiri.y + cubeBawahTanganKiri.y) / 2;
                float zKiri = (cubeAtasTanganKiri.z + cubeBawahTanganKiri.z) / 2;

                Vector3f cubeAtasTanganKanan = magnemite.objectCube.get(6).updateCenterPoint();
                Vector3f cubeBawahTanganKanan = magnemite.objectCube.get(7).updateCenterPoint();
                float xKanan = (cubeAtasTanganKanan.x + cubeBawahTanganKanan.x) / 2;
                float yKanan = (cubeAtasTanganKanan.y + cubeBawahTanganKanan.y) / 2;
                float zKanan = (cubeAtasTanganKanan.z + cubeBawahTanganKanan.z) / 2;

                float[][] bezierDots1 = {
                        {xKiri - 0.1f, yKiri, zKiri},
                        {xKiri - 0.2f, yKiri + 0.25f, zKiri},
                        {xKiri - 0.3f, yKiri - 0.1f, zKiri},
                        {xKiri - 0.4f, yKiri + 0.3f, zKiri}
                };

                float[][] bezierDots2 = {
                        {xKanan + 0.1f, yKanan, zKanan},
                        {xKanan + 0.2f, yKanan + 0.25f, zKanan},
                        {xKanan + 0.3f, yKanan - 0.1f, zKanan},
                        {xKanan + 0.4f, yKanan + 0.3f, zKanan}
                };

                float[][] bezierDots3 = {
                        {xKiri - 0.1f, yKiri, zKiri},
                        {xKiri - 0.2f, yKiri + 0.25f, zKiri},
                        {xKiri - 0.3f, yKiri - 0.2f, zKiri},
                        {xKiri - 0.4f, yKiri + 0.1f, zKiri}
                };

                float[][] bezierDots4 = {
                        {xKanan + 0.1f, yKanan, zKanan},
                        {xKanan + 0.2f, yKanan + 0.25f, zKanan},
                        {xKanan + 0.3f, yKanan - 0.2f, zKanan},
                        {xKanan + 0.4f, yKanan + 0.1f, zKanan}
                };

                float[][] bezierDots5 = {
                        {xKiri - 0.1f, yKiri, zKiri},
                        {xKiri - 0.2f, yKiri + 0.25f, zKiri},
                        {xKiri - 0.3f, yKiri - 0.2f, zKiri},
                        {xKiri - 0.4f, yKiri - 0.3f, zKiri}
                };

                float[][] bezierDots6 = {
                        {xKanan + 0.1f, yKanan, zKanan},
                        {xKanan + 0.2f, yKanan + 0.25f, zKanan},
                        {xKanan + 0.3f, yKanan - 0.2f, zKanan},
                        {xKanan + 0.4f, yKanan - 0.3f, zKanan}
                };

                magnemite.drawCurve(bezierDots1, 1);
                magnemite.drawCurve(bezierDots2, 2);
                magnemite.drawCurve(bezierDots3, 3);
                magnemite.drawCurve(bezierDots4, 4);
                magnemite.drawCurve(bezierDots5, 5);
                magnemite.drawCurve(bezierDots6, 6);
                // animasi saat key 9 telah dilepas lalu dihold lagi
            } else {
                // tangan gerak
                Vector3f tmp = magnemite.objectsHalfTorus.get(0).updateCenterPoint();
                Vector3f tmp2 = magnemite.objectsHalfTorus.get(1).updateCenterPoint();

                for (int i = 0; i < magnemite.objectsHalfTorus.size(); i++) {
                    if (i == 0) {
                        magnemite.objectsHalfTorus.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                        magnemite.objectsHalfTorus.get(i).rotateObject((float) Math.toRadians(10f), 1.0f, 0.0f, 0.0f);
                        magnemite.objectsHalfTorus.get(i).translateObject(tmp.x, tmp.y, tmp.z);
                    } else {
                        magnemite.objectsHalfTorus.get(i).translateObject(tmp2.x * -1, tmp2.y * -1, tmp2.z * -1);
                        magnemite.objectsHalfTorus.get(i).rotateObject((float) Math.toRadians(10f), 1.0f, 0.0f, 0.0f);
                        magnemite.objectsHalfTorus.get(i).translateObject(tmp2.x, tmp2.y, tmp2.z);
                    }
                }

                for (int i = 0; i < 8; i++) {
                    if (i <= 3) {
                        magnemite.objectCube.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                        magnemite.objectCube.get(i).rotateObject((float) Math.toRadians(10f), 1.0f, 0.0f, 0.0f);
                        magnemite.objectCube.get(i).translateObject(tmp.x, tmp.y, tmp.z);
                    } else {
                        magnemite.objectCube.get(i).translateObject(tmp2.x * -1, tmp2.y * -1, tmp2.z * -1);
                        magnemite.objectCube.get(i).rotateObject((float) Math.toRadians(10f), 1.0f, 0.0f, 0.0f);
                        magnemite.objectCube.get(i).translateObject(tmp2.x, tmp2.y, tmp2.z);
                    }
                }

                // antena rotate pada poros
                Vector3f tmp3 = magnemite.objectsCylinder.get(0).updateCenterPoint();
                Vector3f tmp4 = magnemite.objectsHalfSphere.get(0).updateCenterPoint();
                for (int i = 0; i < magnemite.objectsCylinder.size(); i++) {
                    magnemite.objectsCylinder.get(i).translateObject(tmp3.x * -1, tmp3.y * -1, tmp3.z * -1);
                    magnemite.objectsCylinder.get(i).rotateObject((float) Math.toRadians(10f), 0.0f, 1.0f, .0f);
                    magnemite.objectsCylinder.get(i).translateObject(tmp3.x, tmp3.y, tmp3.z);
                }

                for (int i = 0; i < magnemite.objectsHalfSphere.size(); i++) {
                    magnemite.objectsHalfSphere.get(i).translateObject(tmp4.x * -1, tmp4.y * -1, tmp4.z * -1);
                    magnemite.objectsHalfSphere.get(i).rotateObject((float) Math.toRadians(10f), 0.0f, 1.0f, .0f);
                    magnemite.objectsHalfSphere.get(i).translateObject(tmp4.x, tmp4.y, tmp4.z);
                }
            }
        }

        // animasi saat key 9 dihold
        if (keyPressed) {
            // tangan gerak
            Vector3f tmp = magnemite.objectsHalfTorus.get(0).updateCenterPoint();
            Vector3f tmp2 = magnemite.objectsHalfTorus.get(1).updateCenterPoint();

            for (int i = 0; i < magnemite.objectsHalfTorus.size(); i++) {
                if (i == 0) {
                    magnemite.objectsHalfTorus.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                    magnemite.objectsHalfTorus.get(i).rotateObject((float) Math.toRadians(10f), 1.0f, 0.0f, 0.0f);
                    magnemite.objectsHalfTorus.get(i).translateObject(tmp.x, tmp.y, tmp.z);
                } else {
                    magnemite.objectsHalfTorus.get(i).translateObject(tmp2.x * -1, tmp2.y * -1, tmp2.z * -1);
                    magnemite.objectsHalfTorus.get(i).rotateObject((float) Math.toRadians(10f), 1.0f, 0.0f, 0.0f);
                    magnemite.objectsHalfTorus.get(i).translateObject(tmp2.x, tmp2.y, tmp2.z);
                }
            }

            for (int i = 0; i < 8; i++) {
                if (i <= 3) {
                    magnemite.objectCube.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                    magnemite.objectCube.get(i).rotateObject((float) Math.toRadians(10f), 1.0f, 0.0f, 0.0f);
                    magnemite.objectCube.get(i).translateObject(tmp.x, tmp.y, tmp.z);
                } else {
                    magnemite.objectCube.get(i).translateObject(tmp2.x * -1, tmp2.y * -1, tmp2.z * -1);
                    magnemite.objectCube.get(i).rotateObject((float) Math.toRadians(10f), 1.0f, 0.0f, 0.0f);
                    magnemite.objectCube.get(i).translateObject(tmp2.x, tmp2.y, tmp2.z);
                }
            }

            // antena rotate pada poros
            Vector3f tmp3 = magnemite.objectsCylinder.get(0).updateCenterPoint();
            Vector3f tmp4 = magnemite.objectsHalfSphere.get(0).updateCenterPoint();
            for (int i = 0; i < magnemite.objectsCylinder.size(); i++) {
                magnemite.objectsCylinder.get(i).translateObject(tmp3.x * -1, tmp3.y * -1, tmp3.z * -1);
                magnemite.objectsCylinder.get(i).rotateObject((float) Math.toRadians(10f), 0.0f, 1.0f, .0f);
                magnemite.objectsCylinder.get(i).translateObject(tmp3.x, tmp3.y, tmp3.z);
            }

            for (int i = 0; i < magnemite.objectsHalfSphere.size(); i++) {
                magnemite.objectsHalfSphere.get(i).translateObject(tmp4.x * -1, tmp4.y * -1, tmp4.z * -1);
                magnemite.objectsHalfSphere.get(i).rotateObject((float) Math.toRadians(10f), 0.0f, 1.0f, .0f);
                magnemite.objectsHalfSphere.get(i).translateObject(tmp4.x, tmp4.y, tmp4.z);
            }
        }

        if (window.isKeyReleased(GLFW_KEY_9)) {
            keyPressed = false;
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
            keyPressed = false;
            animated = false;
        }
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
            magnemite.loop();

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
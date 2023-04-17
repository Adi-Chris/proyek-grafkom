import Engine.*;
import Adi.*;
import Louis.*;
import Ryan.*;

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

public class MainGabung {
    private Window window =
            new Window
                    (800, 800, "Hello World");

    // Object Engine
    private Environtment environtment = new Environtment();

    // Draw State
    /*
    0: Adi, tekan Z untuk ke Adi
    1: Louis, tekan X untuk ke Louis
    2: Ryan, tekan C untuk ke Ryan
    3: Timotius, tekan V untuk ke Timotius
    */
    int drawState = 0;

    // Object Adi
    private Regice regice = new Regice();

    // Object Louis
    private Magnemite magnemite = new Magnemite();
    boolean keyPressed = false;
    boolean animated = false;

    // Object Ryan
    private Oshawott Oshawott = new Oshawott();
    private Pokeball pokeball = new Pokeball();
    int checkTangan = 0;
    boolean checkArahTangan = true;
    int checkKaki = 0;
    boolean checkArahKaki = true;
    int checkBadan = 0;
    boolean checkArahBadan = true;

    // Object Timotius


    public void init() {
        window.init();
        GL.createCapabilities();
        glEnable(GL_DEPTH_TEST);

        // Code
        // Engine
        environtment.init();

        // Adi
        pokeball.init();
        regice.init();

        // Louis
        // init object magnemite
        magnemite.init();

        // Ryan
        pokeball.init();
        pokeball.translateObject(0.7825f, 0.81f, -0.5f);
        Oshawott.init();

        // Timotius

    }

    public void inputDrawState() {
        if (window.isKeyPressed(GLFW_KEY_Z)) {
            drawState = 0;
        } else{
            if (window.isKeyPressed(GLFW_KEY_X)) {
                drawState = 1;
            } else {
                if (window.isKeyPressed(GLFW_KEY_C)) {
                    drawState = 2;
                } else {
                    if (window.isKeyPressed(GLFW_KEY_V)) {
                        drawState = 3;
                    }
                }
            }
        }
    }

    public void inputAdi() {
        if (window.isKeyPressed(GLFW_KEY_W)) {
            // Rotasi
//            pokeball.rotateObject(10f, 1.0f, 0.0f, 0.0f);
            regice.rotateObject(10f, 1.0f, 0.0f, 0.0f);
        }
        if (window.isKeyPressed(GLFW_KEY_A)) {
            // Rotasi
//            pokeball.rotateObject(10f, 0.0f, 1.0f, 0.0f);
            regice.rotateObject(10f, 0.0f, 1.0f, 0.0f);
        }
        if (window.isKeyPressed(GLFW_KEY_S)) {
            // Rotasi
//            pokeball.rotateObject(-10f, 1.0f, 0.0f, 0.0f);
            regice.rotateObject(-10f, 1.0f, 0.0f, 0.0f);
        }
        if (window.isKeyPressed(GLFW_KEY_D)) {
            // Rotasi
//            pokeball.rotateObject(-10f, 0.0f, 1.0f, 0.0f);
            regice.rotateObject(-10f, 0.0f, 1.0f, 0.0f);
        }

        if (window.isKeyPressed(GLFW_KEY_I)) {
            // Translasi
//            pokeball.translateObject(0.0f, 0.1f, 0.0f);
            regice.translateObject(0.0f, 0.01f, 0.0f);
        }
        if (window.isKeyPressed(GLFW_KEY_J)) {
            // Translasi
//            pokeball.translateObject(-0.1f, 0.0f, 0.0f);
            regice.translateObject(-0.01f, 0.0f, 0.0f);
        }
        if (window.isKeyPressed(GLFW_KEY_K)) {
            // Translasi
//            pokeball.translateObject(0.0f, -0.1f, 0.0f);
            regice.translateObject(0.0f, -0.01f, 0.0f);
        }
        if (window.isKeyPressed(GLFW_KEY_L)) {
            // Translasi
//            pokeball.translateObject(0.1f, 0.0f, 0.0f);
            regice.translateObject(0.01f, 0.0f, 0.0f);
        }

        if (window.isKeyPressed(GLFW_KEY_T)) {
            // Scale
//            pokeball.scaleObject(1.1f, 1.1f, 1.1f);
            regice.scaleObject(1.1f, 1.1f, 1.1f);
        }
        if (window.isKeyPressed(GLFW_KEY_G)) {
            // Scale
//            pokeball.scaleObject(0.9f, 0.9f, 0.9f);
            regice.scaleObject(0.9f, 0.9f, 0.9f);
        }

        if (window.isKeyPressed(GLFW_KEY_R)) {
            // Reset ke posisi awal
            regice.reset();
        }
    }

    public void inputLouis() {
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

    public void inputRyan() {

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
//            System.out.println(pos.x + "f, " + pos.y + "f, 0.0f");
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

        // Keluar pokeball
        if(window.isKeyPressed(GLFW_KEY_8)){
            for (int i = 0; i < Oshawott.objectEllipsoid.size(); i++) {
                Oshawott.objectEllipsoid.get(i).translateObject(-0.01f, -0.01f, 0.0f);
            }
            for (int i = 0; i < Oshawott.objectsSphere.size(); i++) {
                Oshawott.objectsSphere.get(i).translateObject(-0.01f, -0.01f, 0.0f);
            }
            Oshawott.objectsHS.get(0).translateObject(-0.01f, -0.01f, 0.0f);
            Oshawott.objectsCylinder.get(0).translateObject(-0.01f, -0.01f, 0.0f);
            for (int i = 0; i < Oshawott.objectEllipsoid.size(); i++) {
                Oshawott.objectEllipsoid.get(i).scaleObject(1.011f, 1.011f, 1.011f);
            }
            for (int i = 0; i < Oshawott.objectsSphere.size(); i++) {
                Oshawott.objectsSphere.get(i).scaleObject(1.011f, 1.011f, 1.011f);
            }
            Oshawott.objectsHS.get(0).scaleObject(1.011f, 1.011f, 1.011f);
            Oshawott.objectsCylinder.get(0).scaleObject(1.011f, 1.011f, 1.011f);
        }

        // reset ke posisi default
        if (window.isKeyPressed(GLFW_KEY_R)) {
            Oshawott.objects.clear();
            Oshawott.objectsHS.clear();
            Oshawott.objectEllipsoid.clear();
            Oshawott.objectsCylinder.clear();
            Oshawott.objectEP.clear();
            Oshawott.objectsSphere.clear();
            Oshawott.berzier1.clear();
            Oshawott.berzier2.clear();
            Oshawott.init();
        }
    }

    public void loop() {
        while (window.isOpen()) {
            window.update();
            glClearColor(1.0f,
                    0.3f, 0.95f,
                    0.0f);
            GL.createCapabilities();

            //code
            environtment.loop();

            // Cek drawState
            inputDrawState();

            // Draw looping berdasarkan drawState
            switch (drawState) {
                case 0:
                    // Adi
                    glClearColor(1.0f,
                            0.3f, 0.95f,
                            0.0f);
                    inputAdi();
                    regice.loop(window.isKeyPressed(GLFW_KEY_B));
                    break;
                case 1:
                    // Louis
                    glClearColor(15f,192/255f,203/255f,0.0f);
                    inputLouis();
                    magnemite.loop();
                    break;
                case 2:
                    // Ryan
                    glClearColor(0.0f,
                            1.0f, 0.5f,
                            0.0f);
                    inputRyan();
                    pokeball.loop();
                    Oshawott.loop();
                    break;
                case 3:
                    // Timotius

                    break;
            }

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
        new MainGabung().run();
    }
}

import Engine.*;
import Adi.*;
import Louis.*;
import Ryan.*;

import Timotius.Marill;
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
                    (800, 800, "Proyek Grafkom - Pokemon");

    // Object Engine
    private Environtment environtment = new Environtment();

    // Draw State
    /*
    0: Adi, tekan Z untuk ke Adi
    1: Louis, tekan X untuk ke Louis
    2: Ryan, tekan C untuk ke Ryan
    3: Timotius, tekan V untuk ke Timotius
    4: Battle state, tekan B untuk Battle state
    */
    int drawState = 0;
    boolean battleState = false;
    boolean changeState = false;

    // Object Adi
    private Regice regice = new Regice();
    int checkBeam = 0;
    boolean arahBeam = true;

    // Object Louis
    private Magnemite magnemite = new Magnemite();

    // Object Ryan
    private Oshawott Oshawott = new Oshawott();
    private Pokeball pokeball = new Pokeball();
    int checkTangan = 0;
    boolean checkArahTangan = true;
    int checkKaki = 0;
    boolean checkArahKaki = true;
    int checkBadan = 0;
    boolean checkArahBadan = true;
    boolean battle = false;

    // Object Timotius
    private Marill marill = new Marill();


    public void init() {
        window.init();
        GL.createCapabilities();
        glEnable(GL_DEPTH_TEST);

        // Code
        // Engine
        environtment.init();

        // Adi
//        pokeball.init();
        regice.init();

        // Louis
        // init object magnemite
        magnemite.init();

        // Ryan
        pokeball.init();
        pokeball.translateObject(0.7825f, 0.81f, -0.5f);
        Oshawott.init();

        // Timotius
        marill.init();

    }

    public void initBattleState() {
        // Code

        // Adi
//        pokeball.init();
        regice.reset();
        regice.rotateObject(215.0f,0.0f,1.0f,0.0f);
        regice.scaleObject(0.5f, 0.5f, 0.5f);
        regice.translateObject(-0.6f, -0.3f, 0.25f);

//        // Louis
//        // init object magnemite
        magnemite.deleteObject();
        magnemite.init();
        magnemite.rotateMagnemite(15f, 0.0f, 1.0f, 0.0f);
        magnemite.scaleMagnemite(0.5f, 0.5f, 0.5f);
        magnemite.translateMagnemite(0.7225f, 0.1f, 0.0f);
//
//        // Ryan
//        pokeball.init();
//        pokeball.translateObject(0.7825f, 0.81f, -0.5f);
        Oshawott.reset();
        // Rotate
        for (int i = 0; i < Oshawott.objectEllipsoid.size(); i++) {
            Oshawott.objectEllipsoid.get(i).rotateObject((float) Math.toRadians(15), 0.0f, 1.0f, 0.0f);
        }
        for (int i = 0; i < Oshawott.objectsSphere.size(); i++) {
            Oshawott.objectsSphere.get(i).rotateObject((float) Math.toRadians(15), 0.0f, 1.0f, 0.0f);
        }
        Oshawott.objectsHS.get(0).rotateObject((float) Math.toRadians(15), 0.0f, 1.0f, 0.0f);

        Oshawott.objectsCylinder.get(0).rotateObject((float) Math.toRadians(15), 0.0f, 1.0f, 0.0f);

        // Scale
        for (int i = 0; i < Oshawott.objectEllipsoid.size(); i++) {
            Oshawott.objectEllipsoid.get(i).scaleObject(0.5f, 0.5f, 0.5f);
        }
        for (int i = 0; i < Oshawott.objectsSphere.size(); i++) {
            Oshawott.objectsSphere.get(i).scaleObject(0.5f, 0.5f, 0.5f);
        }
        Oshawott.objectsHS.get(0).scaleObject(0.5f, 0.5f, 0.5f);
        Oshawott.objectsCylinder.get(0).scaleObject(0.5f, 0.5f, 0.5f);

        // Translate
        for (int i = 0; i < Oshawott.objectEllipsoid.size(); i++) {
            Oshawott.objectEllipsoid.get(i).translateObject(0.39f, 0.3775f, 0.0f);
        }
        for (int i = 0; i < Oshawott.objectsSphere.size(); i++) {
            Oshawott.objectsSphere.get(i).translateObject(0.39f, 0.3775f, 0.0f);
        }
        Oshawott.objectsHS.get(0).translateObject(0.39f, 0.3775f, 0.0f);
        Oshawott.objectsCylinder.get(0).translateObject(0.39f, 0.3775f, 0.0f);

        // Timo
        marill.reset();
        // Rotate
        for (int i = 0; i < marill.objectsSphere.size(); i++) {
            marill.objectsSphere.get(i).rotateObject((float) Math.toRadians(215.0f), 0.0f, 1f, 0.0f);
        }
        for (int i = 0; i < marill.objectsEllipsoid.size(); i++) {
            marill.objectsEllipsoid.get(i).rotateObject((float) Math.toRadians(215.0f), 0.0f, 1f, 0.0f);
        }
        for (int i = 0; i < marill.berzier.size(); i++) {
            marill.berzier.get(i).rotateObject((float) Math.toRadians(215.0f), 0.0f, 1f, 0.0f);
        }
        for (int i = 0; i < marill.cylinder.size(); i++) {
            marill.cylinder.get(i).rotateObject((float) Math.toRadians(215.0f), 0.0f, 1f, 0.0f);
        }

        // Scale
        for (int i = 0; i < marill.objectsSphere.size(); i++) {
            marill.objectsSphere.get(i).scaleObject(0.5f,0.5f, 0.5f);
        }
        for (int i = 0; i < marill.objectsEllipsoid.size(); i++) {
            marill.objectsEllipsoid.get(i).scaleObject(0.5f,0.5f, 0.5f);
        }
        for (int i = 0; i < marill.berzier.size(); i++) {
            marill.berzier.get(i).scaleObject(0.5f,0.5f, 0.5f);
        }
        for (int i = 0; i < marill.cylinder.size(); i++) {
            marill.cylinder.get(i).scaleObject(0.5f,0.5f, 0.5f);
        }

        // Translate
        for (int i = 0; i < marill.objectsSphere.size(); i++) {
            marill.objectsSphere.get(i).translateObject(-0.38f, -0.6f, 0.15f);
        }
        for (int i = 0; i < marill.objectsEllipsoid.size(); i++) {
            marill.objectsEllipsoid.get(i).translateObject(-0.38f, -0.6f, 0.15f);
        }
        for (int i = 0; i < marill.berzier.size(); i++) {
            marill.berzier.get(i).translateObject(-0.38f, -0.6f, 0.15f);
        }
        for (int i = 0; i < marill.cylinder.size(); i++) {
            marill.cylinder.get(i).translateObject(-0.38f, -0.6f, 0.15f);
        }
    }

    public void inputDrawState() {
        if (window.isKeyPressed(GLFW_KEY_Z)) {
            drawState = 0;
            changeState = true;
        } else{
            if (window.isKeyPressed(GLFW_KEY_X)) {
                drawState = 1;
                changeState = true;
            } else {
                if (window.isKeyPressed(GLFW_KEY_C)) {
                    drawState = 2;
                    changeState = true;
                } else {
                    if (window.isKeyPressed(GLFW_KEY_V)) {
                        drawState = 3;
                        changeState = true;
                    } else {
                        if (window.isKeyPressed(GLFW_KEY_B)) {
                            drawState = 4;
                            changeState = true;
                        }
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

        if (window.isKeyPressed(GLFW_KEY_Q)) {
            if (checkBeam < 1100 && arahBeam) {
                Oshawott.objectsSphere.get(2).scaleObject(1.001f, 1.001f, 1.001f);
                Oshawott.objectsSphere.get(2).translateObject(0.0f, -0.0003f, 0.0f);
                checkBeam++;
            }
            if (checkBeam > -1100 && !arahBeam) {
                Oshawott.objectsSphere.get(2).translateObject(0.0f, 0.0f, -10.0f);
                checkBeam--;
            }
            if (checkBeam >= 1100) {
                checkBeam = 1100;
                arahBeam = false;
            }
            if (checkBeam <= -1100) {
                checkBeam = -1100;
                arahBeam = true;
            }
        }
    }

    public void inputTimo(){
        if (window.getMouseInput().isLeftButtonPressed()) {
            Vector2f pos = window.getMouseInput().getCurrentPos();
            System.out.println("x : " + pos.x + "y : " + pos.y);

            // dinormalisasi biar titik 0,0 itu di tengah
            pos.x = (pos.x - (window.getWidth()) / 2.0f) / (window.getWidth() / 2.0f);
            pos.y = (pos.y - (window.getHeight()) / 2.0f) / (-window.getHeight() / 2.0f);
        }
        if (window.isKeyPressed(GLFW_KEY_A)) {
            Vector3f tmp = marill.objectsSphere.get(0).updateCenterPoint();

            for (int i = 0; i < marill.objectsSphere.size(); i++) {
                marill.objectsSphere.get(i).translateObject(-tmp.x, -tmp.y, -tmp.z);
                marill.objectsSphere.get(i).rotateObject((float) Math.toRadians(1f), 0.0f, 1f, 0.0f);
                marill.objectsSphere.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }
            for (int i = 0; i < marill.objectsEllipsoid.size(); i++) {
                marill.objectsEllipsoid.get(i).translateObject(-tmp.x, -tmp.y, -tmp.z);
                marill.objectsEllipsoid.get(i).rotateObject((float) Math.toRadians(1f), 0.0f, 1f, 0.0f);
                marill.objectsEllipsoid.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }
            for (int i = 0; i < marill.berzier.size(); i++) {
                marill.berzier.get(i).translateObject(-tmp.x, -tmp.y, -tmp.z);
                marill.berzier.get(i).rotateObject((float) Math.toRadians(1f), 0.0f, 1f, 0.0f);
                marill.berzier.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }
            for (int i = 0; i < marill.cylinder.size(); i++) {
                marill.cylinder.get(i).translateObject(-tmp.x, -tmp.y, -tmp.z);
                marill.cylinder.get(i).rotateObject((float) Math.toRadians(1f), 0.0f, 1f, 0.0f);
                marill.cylinder.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_D)) {
            Vector3f tmp = marill.objectsSphere.get(0).updateCenterPoint();

            for (int i = 0; i < marill.objectsSphere.size(); i++) {
                marill.objectsSphere.get(i).translateObject(-tmp.x, -tmp.y, -tmp.z);
                marill.objectsSphere.get(i).rotateObject((float) Math.toRadians(1f), 0.0f, -1f, 0.0f);
                marill.objectsSphere.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }
            for (int i = 0; i < marill.objectsEllipsoid.size(); i++) {
                marill.objectsEllipsoid.get(i).translateObject(-tmp.x, -tmp.y, -tmp.z);
                marill.objectsEllipsoid.get(i).rotateObject((float) Math.toRadians(1f), 0.0f, -1f, 0.0f);
                marill.objectsEllipsoid.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }
            for (int i = 0; i < marill.berzier.size(); i++) {
                marill.berzier.get(i).translateObject(-tmp.x, -tmp.y, -tmp.z);
                marill.berzier.get(i).rotateObject((float) Math.toRadians(1f), 0.0f, -1f, 0.0f);
                marill.berzier.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }
            for (int i = 0; i < marill.cylinder.size(); i++) {
                marill.cylinder.get(i).translateObject(-tmp.x, -tmp.y, -tmp.z);
                marill.cylinder.get(i).rotateObject((float) Math.toRadians(1f), 0.0f, -1f, 0.0f);
                marill.cylinder.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_W)) {
            Vector3f tmp = marill.objectsSphere.get(0).updateCenterPoint();

            for (int i = 0; i < marill.objectsSphere.size(); i++) {
                marill.objectsSphere.get(i).translateObject(-tmp.x, -tmp.y, -tmp.z);
                marill.objectsSphere.get(i).rotateObject((float) Math.toRadians(1f), 1.0f, 0.0f, 0.0f);
                marill.objectsSphere.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }
            for (int i = 0; i < marill.objectsEllipsoid.size(); i++) {
                marill.objectsEllipsoid.get(i).translateObject(-tmp.x, -tmp.y, -tmp.z);
                marill.objectsEllipsoid.get(i).rotateObject((float) Math.toRadians(1f), 1.0f, 0.0f, 0.0f);
                marill.objectsEllipsoid.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }
            for (int i = 0; i < marill.berzier.size(); i++) {
                marill.berzier.get(i).translateObject(-tmp.x, -tmp.y, -tmp.z);
                marill.berzier.get(i).rotateObject((float) Math.toRadians(1f), 1.0f, 0.0f, 0.0f);
                marill.berzier.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }
            for (int i = 0; i < marill.cylinder.size(); i++) {
                marill.cylinder.get(i).translateObject(-tmp.x, -tmp.y, -tmp.z);
                marill.cylinder.get(i).rotateObject((float) Math.toRadians(1f), 1.0f, 0.0f, 0.0f);
                marill.cylinder.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_S)) {
            Vector3f tmp = marill.objectsSphere.get(0).updateCenterPoint();

            for (int i = 0; i < marill.objectsSphere.size(); i++) {
                marill.objectsSphere.get(i).translateObject(-tmp.x, -tmp.y, -tmp.z);
                marill.objectsSphere.get(i).rotateObject((float) Math.toRadians(1f), -1.0f, 0.0f, 0.0f);
                marill.objectsSphere.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }
            for (int i = 0; i < marill.objectsEllipsoid.size(); i++) {
                marill.objectsEllipsoid.get(i).translateObject(-tmp.x, -tmp.y, -tmp.z);
                marill.objectsEllipsoid.get(i).rotateObject((float) Math.toRadians(1f), -1.0f, 0.0f, 0.0f);
                marill.objectsEllipsoid.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }
            for (int i = 0; i < marill.berzier.size(); i++) {
                marill.berzier.get(i).translateObject(-tmp.x, -tmp.y, -tmp.z);
                marill.berzier.get(i).rotateObject((float) Math.toRadians(1f), -1.0f, 0.0f, 0.0f);
                marill.berzier.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }
            for (int i = 0; i < marill.cylinder.size(); i++) {
                marill.cylinder.get(i).translateObject(-tmp.x, -tmp.y, -tmp.z);
                marill.cylinder.get(i).rotateObject((float) Math.toRadians(1f), -1.0f, 0.0f, 0.0f);
                marill.cylinder.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_LEFT)) {
            for (int i = 0; i < marill.objectsSphere.size(); i++) {
                marill.objectsSphere.get(i).translateObject(-0.01f,0.0f, 0.0f);
            }
            for (int i = 0; i < marill.objectsEllipsoid.size(); i++) {
                marill.objectsEllipsoid.get(i).translateObject(-0.01f,0.0f, 0.0f);
            }
            for (int i = 0; i < marill.berzier.size(); i++) {
                marill.berzier.get(i).translateObject(-0.01f,0.0f, 0.0f);
            }
            for (int i = 0; i < marill.cylinder.size(); i++) {
                marill.cylinder.get(i).translateObject(-0.01f,0.0f, 0.0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_RIGHT)) {
            for (int i = 0; i < marill.objectsSphere.size(); i++) {
                marill.objectsSphere.get(i).translateObject(0.01f,0.0f, 0.0f);
            }
            for (int i = 0; i < marill.objectsEllipsoid.size(); i++) {
                marill.objectsEllipsoid.get(i).translateObject(0.01f,0.0f, 0.0f);
            }
            for (int i = 0; i < marill.berzier.size(); i++) {
                marill.berzier.get(i).translateObject(0.01f,0.0f, 0.0f);
            }
            for (int i = 0; i < marill.cylinder.size(); i++) {
                marill.cylinder.get(i).translateObject(0.01f,0.0f, 0.0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_UP)) {
            for (int i = 0; i < marill.objectsSphere.size(); i++) {
                marill.objectsSphere.get(i).translateObject(0.0f,0.01f, 0.0f);
            }
            for (int i = 0; i < marill.objectsEllipsoid.size(); i++) {
                marill.objectsEllipsoid.get(i).translateObject(0.0f,0.01f, 0.0f);
            }
            for (int i = 0; i < marill.berzier.size(); i++) {
                marill.berzier.get(i).translateObject(0.0f,0.01f, 0.0f);
            }
            for (int i = 0; i < marill.cylinder.size(); i++) {
                marill.cylinder.get(i).translateObject(0.00f,0.01f, 0.0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_DOWN)) {
            for (int i = 0; i < marill.objectsSphere.size(); i++) {
                marill.objectsSphere.get(i).translateObject(0.0f,-0.01f, 0.0f);
            }
            for (int i = 0; i < marill.objectsEllipsoid.size(); i++) {
                marill.objectsEllipsoid.get(i).translateObject(0.0f,-0.01f, 0.0f);
            }
            for (int i = 0; i < marill.berzier.size(); i++) {
                marill.berzier.get(i).translateObject(0.0f,-0.01f, 0.0f);
            }
            for (int i = 0; i < marill.cylinder.size(); i++) {
                marill.cylinder.get(i).translateObject(0.00f,-0.01f, 0.0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_1)) {
            for (int i = 0; i < marill.objectsSphere.size(); i++) {
                marill.objectsSphere.get(i).scaleObject(0.999f,0.999f, 0.999f);
            }
            for (int i = 0; i < marill.objectsEllipsoid.size(); i++) {
                marill.objectsEllipsoid.get(i).scaleObject(0.999f,0.999f, 0.999f);
            }
            for (int i = 0; i < marill.berzier.size(); i++) {
                marill.berzier.get(i).scaleObject(0.999f,0.999f, 0.999f);
            }
            for (int i = 0; i < marill.cylinder.size(); i++) {
                marill.cylinder.get(i).scaleObject(0.999f,0.999f, 0.999f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_2)) {
            for (int i = 0; i < marill.objectsSphere.size(); i++) {
                marill.objectsSphere.get(i).scaleObject(1.001f,1.001f, 1.001f);
            }
            for (int i = 0; i < marill.objectsEllipsoid.size(); i++) {
                marill.objectsEllipsoid.get(i).scaleObject(1.001f,1.001f, 1.001f);
            }
            for (int i = 0; i < marill.berzier.size(); i++) {
                marill.berzier.get(i).scaleObject(1.001f,1.001f, 1.001f);
            }
            for (int i = 0; i < marill.cylinder.size(); i++) {
                marill.cylinder.get(i).scaleObject(1.001f,1.001f, 1.001f);
            }
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
                    // Battle state
                    if (changeState) {
                        regice.reset();
                        changeState = false;
                    }
//                    glClearColor(1.0f,
//                            0.3f, 0.95f,
//                            0.0f);
                    glClearColor(116/255f, 189/255f, 34/255f, 0.0f);
                    inputAdi();
                    regice.loop(window.isKeyPressed(GLFW_KEY_Q));
                    break;
                case 1:
                    // Louis
                    // Battle state
                    if (changeState) {
                        magnemite.deleteObject();
                        magnemite.init();
                        changeState = false;
                    }
//                    glClearColor(15f,192/255f,203/255f,0.0f);
                    glClearColor(116/255f, 189/255f, 34/255f, 0.0f);
                    inputLouis();
                    magnemite.loop(window.isKeyPressed(GLFW_KEY_9), false);
                    break;
                case 2:
                    // Ryan
                    if (changeState) {
                        Oshawott.objects.clear();
                        Oshawott.objectsHS.clear();
                        Oshawott.objectEllipsoid.clear();
                        Oshawott.objectsCylinder.clear();
                        Oshawott.objectEP.clear();
                        Oshawott.objectsSphere.clear();
                        Oshawott.berzier1.clear();
                        Oshawott.berzier2.clear();
                        Oshawott.init();
                        changeState = false;
                    }
//                    glClearColor(0.0f,
//                            1.0f, 0.5f,
//                            0.0f);
                    glClearColor(116/255f, 189/255f, 34/255f, 0.0f);
                    inputRyan();
                    pokeball.loop();
                    Oshawott.loop();
                    break;
                case 3:
                    // Timotius
                    if (changeState) {
                        marill.objectsSphere.clear();
                        marill.objectsEllipsoid.clear();
                        marill.cylinder.clear();
                        marill.berzier.clear();
                        marill.init();
                        changeState = false;
                    }
//                    glClearColor(0.0f,
//                            1.0f, 0.5f,
//                            0.0f);
                    glClearColor(116/255f, 189/255f, 34/255f, 0.0f);
                    inputTimo();
                    marill.loop();

                    break;
                case 4:
                    // Battle state
                    if (changeState) {
                        initBattleState();
                        changeState = false;
                    }
                    glClearColor(116/255f, 189/255f, 34/255f, 0.0f);
//                    inputAdi();
                    regice.loop(window.isKeyPressed(GLFW_KEY_Q));
//                    inputLouis();
                    magnemite.loop(window.isKeyPressed(GLFW_KEY_9), true);
//                    inputRyan();
//                    pokeball.loop();
                    Oshawott.loop();
//                    inputTimo();
                    marill.loop();
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

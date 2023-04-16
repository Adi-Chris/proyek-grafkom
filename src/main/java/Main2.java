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
    boolean keyPressed = false;
    boolean animated = false;

    public void init() {
        window.init();
        GL.createCapabilities();
        glEnable(GL_DEPTH_TEST);
        MouseInput mouseInput = window.getMouseInput();

        // init object magnemite
        magnemite.init();
    }

    public void input() {
        // rotate offsetY
        if (window.isKeyPressed(GLFW_KEY_1) && animated == false) {
            Vector3f tmp = magnemite.objectsSphere.get(0).updateCenterPoint();
            magnemite.objectsSphere.get(0).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
            magnemite.objectsSphere.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
            magnemite.objectsSphere.get(0).translateObject(tmp.x, tmp.y, tmp.z);

            for (int i = 1; i < magnemite.objectsSphere.size(); i++) {
                magnemite.objectsSphere.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                magnemite.objectsSphere.get(i).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
                magnemite.objectsSphere.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }

            for (int i = 0; i < magnemite.objectsHalfTorus.size(); i++) {
                magnemite.objectsHalfTorus.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                magnemite.objectsHalfTorus.get(i).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
                magnemite.objectsHalfTorus.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }

            for (int i = 0; i < magnemite.objectCube.size(); i++) {
                magnemite.objectCube.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                magnemite.objectCube.get(i).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
                magnemite.objectCube.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }

            for (int i = 0; i < magnemite.objectsHalfSphere.size(); i++) {
                magnemite.objectsHalfSphere.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                magnemite.objectsHalfSphere.get(i).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
                magnemite.objectsHalfSphere.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }

            for (int i = 0; i < magnemite.objectsCylinder.size(); i++) {
                magnemite.objectsCylinder.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                magnemite.objectsCylinder.get(i).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
                magnemite.objectsCylinder.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }
        }

        // rotate offsetX
        if (window.isKeyPressed(GLFW_KEY_2) && animated == false) {
            Vector3f tmp = magnemite.objectsSphere.get(0).updateCenterPoint();
            magnemite.objectsSphere.get(0).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
            magnemite.objectsSphere.get(0).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
            magnemite.objectsSphere.get(0).translateObject(tmp.x, tmp.y, tmp.z);

            for (int i = 0; i < magnemite.objectsSphere.size(); i++) {
                magnemite.objectsSphere.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                magnemite.objectsSphere.get(i).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
                magnemite.objectsSphere.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }

            for (int i = 0; i < magnemite.objectsHalfTorus.size(); i++) {
                magnemite.objectsHalfTorus.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                magnemite.objectsHalfTorus.get(i).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
                magnemite.objectsHalfTorus.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }

            for (int i = 0; i < magnemite.objectCube.size(); i++) {
                magnemite.objectCube.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                magnemite.objectCube.get(i).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
                magnemite.objectCube.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }

            for (int i = 0; i < magnemite.objectsHalfSphere.size(); i++) {
                magnemite.objectsHalfSphere.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                magnemite.objectsHalfSphere.get(i).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
                magnemite.objectsHalfSphere.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }

            for (int i = 0; i < magnemite.objectsCylinder.size(); i++) {
                magnemite.objectsCylinder.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                magnemite.objectsCylinder.get(i).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
                magnemite.objectsCylinder.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }
        }

        // rotate offsetZ
        if (window.isKeyPressed(GLFW_KEY_3) && animated == false) {
            Vector3f tmp = magnemite.objectsSphere.get(0).updateCenterPoint();
            magnemite.objectsSphere.get(0).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
            magnemite.objectsSphere.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
            magnemite.objectsSphere.get(0).translateObject(tmp.x, tmp.y, tmp.z);

            for (int i = 0; i < magnemite.objectsSphere.size(); i++) {
                magnemite.objectsSphere.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                magnemite.objectsSphere.get(i).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
                magnemite.objectsSphere.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }

            for (int i = 0; i < magnemite.objectsHalfTorus.size(); i++) {
                magnemite.objectsHalfTorus.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                magnemite.objectsHalfTorus.get(i).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
                magnemite.objectsHalfTorus.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }

            for (int i = 0; i < magnemite.objectCube.size(); i++) {
                magnemite.objectCube.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                magnemite.objectCube.get(i).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
                magnemite.objectCube.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }

            for (int i = 0; i < magnemite.objectsHalfSphere.size(); i++) {
                magnemite.objectsHalfSphere.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                magnemite.objectsHalfSphere.get(i).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
                magnemite.objectsHalfSphere.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }


            for (int i = 0; i < magnemite.objectsCylinder.size(); i++) {
                magnemite.objectsCylinder.get(i).translateObject(tmp.x * -1, tmp.y * -1, tmp.z * -1);
                magnemite.objectsCylinder.get(i).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
                magnemite.objectsCylinder.get(i).translateObject(tmp.x, tmp.y, tmp.z);
            }
        }

        // geser atas
        if (window.isKeyPressed(GLFW_KEY_W) && animated == false) {
            for (int i = 0; i < magnemite.objectsSphere.size(); i++) {
                magnemite.objectsSphere.get(i).translateObject(0.0f, 0.01f, 0.0f);
            }

            for (int i = 0; i < magnemite.objectsHalfTorus.size(); i++) {
                magnemite.objectsHalfTorus.get(i).translateObject(0.0f, 0.01f, 0.0f);
            }

            for (int i = 0; i < magnemite.objectCube.size(); i++) {
                magnemite.objectCube.get(i).translateObject(0.0f, 0.01f, 0.0f);
            }

            for (int i = 0; i < magnemite.objectsHalfSphere.size(); i++) {
                magnemite.objectsHalfSphere.get(i).translateObject(0.0f, 0.01f, 0.0f);
            }

            for (int i = 0; i < magnemite.objectsCylinder.size(); i++) {
                magnemite.objectsCylinder.get(i).translateObject(0.0f, 0.01f, 0.0f);
            }
        }

        // geser kiri
        if (window.isKeyPressed(GLFW_KEY_A) && animated == false) {
            for (int i = 0; i < magnemite.objectsSphere.size(); i++) {
                magnemite.objectsSphere.get(i).translateObject(-0.01f, 0.0f, 0.0f);
            }

            for (int i = 0; i < magnemite.objectsHalfTorus.size(); i++) {
                magnemite.objectsHalfTorus.get(i).translateObject(-0.01f, 0.0f, 0.0f);
            }

            for (int i = 0; i < magnemite.objectCube.size(); i++) {
                magnemite.objectCube.get(i).translateObject(-0.01f, 0.0f, 0.0f);
            }

            for (int i = 0; i < magnemite.objectsHalfSphere.size(); i++) {
                magnemite.objectsHalfSphere.get(i).translateObject(-0.01f, 0.0f, 0.0f);
            }

            for (int i = 0; i < magnemite.objectsCylinder.size(); i++) {
                magnemite.objectsCylinder.get(i).translateObject(-0.01f, 0.0f, 0.0f);
            }
        }

        // geser kanan
        if (window.isKeyPressed(GLFW_KEY_D) && animated == false) {
            for (int i = 0; i < magnemite.objectsSphere.size(); i++) {
                magnemite.objectsSphere.get(i).translateObject(0.01f, 0.0f, 0.0f);
            }

            for (int i = 0; i < magnemite.objectsHalfTorus.size(); i++) {
                magnemite.objectsHalfTorus.get(i).translateObject(0.01f, 0.0f, 0.0f);
            }

            for (int i = 0; i < magnemite.objectCube.size(); i++) {
                magnemite.objectCube.get(i).translateObject(0.01f, 0.0f, 0.0f);
            }

            for (int i = 0; i < magnemite.objectsHalfSphere.size(); i++) {
                magnemite.objectsHalfSphere.get(i).translateObject(0.01f, 0.0f, 0.0f);
            }

            for (int i = 0; i < magnemite.objectsCylinder.size(); i++) {
                magnemite.objectsCylinder.get(i).translateObject(0.01f, 0.0f, 0.0f);
            }
        }

        // geser bawah
        if (window.isKeyPressed(GLFW_KEY_S) && animated == false) {
            for (int i = 0; i < magnemite.objectsSphere.size(); i++) {
                magnemite.objectsSphere.get(i).translateObject(0.0f, -0.01f, 0.0f);
            }

            for (int i = 0; i < magnemite.objectsHalfTorus.size(); i++) {
                magnemite.objectsHalfTorus.get(i).translateObject(0.0f, -0.01f, 0.0f);
            }

            for (int i = 0; i < magnemite.objectCube.size(); i++) {
                magnemite.objectCube.get(i).translateObject(0.0f, -0.01f, 0.0f);
            }

            for (int i = 0; i < magnemite.objectsHalfSphere.size(); i++) {
                magnemite.objectsHalfSphere.get(i).translateObject(0.0f, -0.01f, 0.0f);
            }

            for (int i = 0; i < magnemite.objectsCylinder.size(); i++) {
                magnemite.objectsCylinder.get(i).translateObject(0.0f, -0.01f, 0.0f);
            }
        }

        // kecilin
        if (window.isKeyPressed(GLFW_KEY_4) && animated == false) {
            for (int i = 0; i < magnemite.objectsSphere.size(); i++) {
                magnemite.objectsSphere.get(i).scaleObject(0.999f, 0.999f, 0.999f);
            }

            for (int i = 0; i < magnemite.objectsHalfTorus.size(); i++) {
                magnemite.objectsHalfTorus.get(i).scaleObject(0.999f, 0.999f, 0.999f);
            }

            for (int i = 0; i < magnemite.objectCube.size(); i++) {
                magnemite.objectCube.get(i).scaleObject(0.999f, 0.999f, 0.999f);
            }

            for (int i = 0; i < magnemite.objectsHalfSphere.size(); i++) {
                magnemite.objectsHalfSphere.get(i).scaleObject(0.999f, 0.999f, 0.999f);
            }

            for (int i = 0; i < magnemite.objectsCylinder.size(); i++) {
                magnemite.objectsCylinder.get(i).scaleObject(0.999f, 0.999f, 0.999f);
            }
        }

        // besarin
        if (window.isKeyPressed(GLFW_KEY_5) && animated == false) {
            for (int i = 0; i < magnemite.objectsSphere.size(); i++) {
                magnemite.objectsSphere.get(i).scaleObject(1.001f, 1.001f, 1.001f);
            }

            for (int i = 0; i < magnemite.objectsHalfTorus.size(); i++) {
                magnemite.objectsHalfTorus.get(i).scaleObject(1.001f, 1.001f, 1.001f);
            }

            for (int i = 0; i < magnemite.objectCube.size(); i++) {
                magnemite.objectCube.get(i).scaleObject(1.001f, 1.001f, 1.001f);
            }

            for (int i = 0; i < magnemite.objectsHalfSphere.size(); i++) {
                magnemite.objectsHalfSphere.get(i).scaleObject(1.001f, 1.001f, 1.001f);
            }

            for (int i = 0; i < magnemite.objectsCylinder.size(); i++) {
                magnemite.objectsCylinder.get(i).scaleObject(1.001f, 1.001f, 1.001f);
            }
        }

        // animasi preparing to attack
        // saat key 6 pertama kali dipencet
        if (window.isKeyPressed(GLFW_KEY_6) && keyPressed == false) {
            if (animated == false) {
                keyPressed = true;
                animated = true;

                // magnemite terbang (naik dari posisi semula)
                for (int i = 0; i < magnemite.objectsSphere.size(); i++) {
                    magnemite.objectsSphere.get(i).translateObject(0.0f, 0.2f, 0.0f);
                }

                for (int i = 0; i < magnemite.objectsHalfTorus.size(); i++) {
                    magnemite.objectsHalfTorus.get(i).translateObject(0.0f, 0.2f, 0.0f);
                }

                for (int i = 0; i < magnemite.objectCube.size(); i++) {
                    magnemite.objectCube.get(i).translateObject(0.0f, 0.2f, 0.0f);
                }

                for (int i = 0; i < magnemite.objectsHalfSphere.size(); i++) {
                    magnemite.objectsHalfSphere.get(i).translateObject(0.0f, 0.2f, 0.0f);
                }

                for (int i = 0; i < magnemite.objectsCylinder.size(); i++) {
                    magnemite.objectsCylinder.get(i).translateObject(0.0f, 0.2f, 0.0f);
                }

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
                // animasi saat key 6 telah dilepas lalu dihold lagi
            } else {
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
            }
        }

        // animasi saat key 6 dihold
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
        }

        if (window.isKeyReleased(GLFW_KEY_6)) {
            keyPressed = false;
        }

        // animasi bola mata gerak
        if (window.isKeyPressed(GLFW_KEY_7)) {
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
        if (window.isKeyPressed(GLFW_KEY_0)) {
            for (int i = magnemite.objectsSphere.size() - 1; i >= 0; i--) {
                magnemite.objectsSphere.remove(i);
            }

            for (int i = magnemite.objectsHalfTorus.size() - 1; i >= 0; i--) {
                magnemite.objectsHalfTorus.remove(i);
            }

            for (int i = magnemite.objectCube.size() - 1; i >= 0; i--) {
                magnemite.objectCube.remove(i);
            }

            for (int i = magnemite.objectsHalfSphere.size() - 1; i >= 0; i--) {
                magnemite.objectsHalfSphere.remove(i);
            }

            for (int i = magnemite.objectsCylinder.size() - 1; i >= 0; i--) {
                magnemite.objectsCylinder.remove(i);
            }

            for (int i = magnemite.objectsBezier1.size() - 1; i >= 0; i--) {
                magnemite.objectsBezier1.remove(i);
            }

            for (int i = magnemite.objectsBezier2.size() - 1; i >= 0; i--) {
                magnemite.objectsBezier2.remove(i);
            }

            for (int i = magnemite.objectsBezier3.size() - 1; i >= 0; i--) {
                magnemite.objectsBezier3.remove(i);
            }

            for (int i = magnemite.objectsBezier4.size() - 1; i >= 0; i--) {
                magnemite.objectsBezier4.remove(i);
            }

            for (int i = magnemite.objectsBezier5.size() - 1; i >= 0; i--) {
                magnemite.objectsBezier5.remove(i);
            }

            for (int i = magnemite.objectsBezier6.size() - 1; i >= 0; i--) {
                magnemite.objectsBezier6.remove(i);
            }

            magnemite.init();
            keyPressed = false;
            animated = false;
        }
    }

    public void loop() {
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GL.createCapabilities();
            input();

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
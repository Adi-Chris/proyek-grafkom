import Engine.*;
import Ryan.Ellipsoid;
import Timotius.Cylinder;
import Timotius.Marill;
import Timotius.Sphere;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main4 {
    private Window window =
            new Window(800, 800, "Uji");

    int idleFrameCount = 0;
    boolean idleBigger = true;

    private Marill marill = new Marill();

    private Environtment envi = new Environtment();


//    Camera camera = new Camera();
//    Projection projection = new Projection(window.getWidth(), window.getHeight());

    public void init() {
        window.init();
        GL.createCapabilities();
        marill.init();
        envi.init();
    }

    public void input() {
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
            glClearColor(1.0f, 0.0f, 0.0f, 0.0f);
            GL.createCapabilities();
            input();
            marill.loop();
            envi.loop();

            glfwPollEvents();
        }
    }

//    private static int combination(int n, int k) {
//        int result = 1;
//        for (int i = 1; i <= k; i++) {
//            result *= n - i + 1;
//            result /= i;
//        }
//        return result;
//    }

//    public static ArrayList<Object> calcBezierCurve(ArrayList <multiRect> list){
//        int n = list.size() - 1;
//        ArrayList<Object> objectsBezier = new ArrayList<>();
//        objectsBezier.add(new Object(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.0f,1.0f,1.0f,1.0f)
//        ));
//
//        for (float i = 0; i <= 1; i += 0.01f) {
//            float x = 0;
//            float y = 0;
//            for (int j = 0; j <= n; j++) {
//                double factor = combination(n, j) * Math.pow(1 - i, n - j) * Math.pow(i, j);
//                x += factor * list.get(j).getCenterX();
//                y += factor * list.get(j).getCenterY();
//            }
//            objectsBezier.get(0).addVertices((new Vector3f(x, y, 0)));
//        }
//        return objectsBezier;
//    }

    public void run() {
        init();
        loop();

        // Terminate GLFW and
        // free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }
    public static void main(String[] args) {
        new Main4().run();
    }
}

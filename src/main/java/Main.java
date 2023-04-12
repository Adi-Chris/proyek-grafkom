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
                    (800,800,"Hello World");
    private ArrayList<Object> objects
            = new ArrayList<>();
    private ArrayList<Object> objectsRectangle
            = new ArrayList<>();

    private ArrayList<Object> objectsPointsControl
            = new ArrayList<>();

    private Pokeball pokeball = new Pokeball();

    private MouseInput mouseInput;
    int countDegree = 0;

    public void init(){
        window.init();
        GL.createCapabilities();
        mouseInput = window.getMouseInput();

        //code
        pokeball.init();
//        // Matahari
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneTransform.frag", GL_FRAGMENT_SHADER)
//                ),
//                new Vector3f(0, 0, 0),
//                0.1f,
//                0.1f,
//                0.1f,
//                36,
//                36,
//                new Vector4f(1.0f, 1.0f, 0.0f, 0.0f)
//        ));
    }

    public void input(){
                if (window.isKeyPressed(GLFW_KEY_W)) {
                    countDegree++;
                    //rotasi terhadap matahari
                    pokeball.rotateObject((float) Math.toRadians(10f), 0.0f, 1.0f, 0.0f);
                }
//        if (window.isKeyPressed(GLFW_KEY_W)) {
//            countDegree++;
//            //rotasi terhadap matahari
//            objects.get(0).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);
//            for(Object child:objects.get(0).getChildObject()){
//                List<Float> temp = new ArrayList<>(child.getCenterPoint());
//                //rotasi terhadap sumbu masing-masing planet
//                child.translateObject(temp.get(0)*-1,temp.get(1)*-1,temp.get(2)*-1);
//                child.rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);
//                child.translateObject(temp.get(0)*1,temp.get(1)*1,temp.get(2)*1);
//                for(Object y:objects.get(0).getChildObject().get(1).getChildObject()){
//                    //rotasi terhadap bumi
//                    List<Float> temp1 = new ArrayList<>(objects.get(0).getChildObject().get(1).getCenterPoint());
//                    y.translateObject(temp1.get(0)*-1,temp1.get(1)*-1,temp1.get(2)*-1);
//                    y.rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);
//                    y.translateObject(temp1.get(0)*1,temp1.get(1)*1,temp1.get(2)*1);
//                    //rotasi terhadap sumbunya sendiri
//                    temp1 = new ArrayList<>(objects.get(0).getChildObject().get(1).getChildObject().get(0).getCenterPoint());
//                    y.translateObject(temp1.get(0)*-1,temp1.get(1)*-1,temp1.get(2)*-1);
//                    y.rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);
//                    y.translateObject(temp1.get(0)*1,temp1.get(1)*1,temp1.get(2)*1);
//                }
//                child.rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);
//            }
//        }
//        if(mouseInput.isLeftButtonPressed()){
//            Vector2f pos = mouseInput.getCurrentPos();
////            System.out.println("x : "+pos.x+" y : "+pos.y);
//            pos.x = (pos.x - (window.getWidth())/2.0f) /
//                    (window.getWidth()/2.0f);
//            pos.y = (pos.y - (window.getHeight())/2.0f) /
//                    (-window.getHeight()/2.0f);
//            //System.out.println("x : "+pos.x+" y : "+pos.y);
//
//            if((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1))){
//                System.out.println("x : "+pos.x+" y : "+pos.y);
////                objectsPointsControl.get(0).addVertices(new Vector3f(pos.x,pos.y,0));
//            }
//        }

    }

    public void loop(){
        while (window.isOpen()) {
            window.update();
            glClearColor(1.0f,
                    0.3f, 0.95f,
                    0.0f);
            GL.createCapabilities();
            input();

            //code
            pokeball.loop();
//            for(Object object: objects){
//                object.draw();
//            }
//            for(Object object: objectsRectangle){
//                object.draw();
//            }
//            for(Object object: objectsPointsControl){
//                object.drawLine();
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
    public static void main(String[] args) {
        new Main().run();
    }
}
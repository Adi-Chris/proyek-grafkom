package Engine;

import org.joml.Vector3f;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

public class Utils {

    public static String readFile(String filePath) {
        String str;
        try {
            str = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException excp) {
            throw new RuntimeException("Error reading file [" + filePath + "]", excp);
        }
        return str;
    }

    public static float[] listoFloat(List<Vector3f> arraylist){
        float[] arr = new float[arraylist.size()*3];
        int index = 0;
        for(int i = 0;i<arraylist.size();i++){
            arr[index++] = arraylist.get(i).x;
            arr[index++] = arraylist.get(i).y;
            arr[index++] = arraylist.get(i).z;
        }
        return arr;
    }

    public static int[] listoInt(List<Integer> arraylist){
        int[] arr = new int[arraylist.size()];
        for(int i = 0;i<arraylist.size();i++){
            arr[i] = arraylist.get(i);
        }
        return arr;
    }

    // Dummy vertice value (untuk class childnya Object2D yang mengcalculate verticesnya setelah super constructor dicall. Contohnya Ellipse.java)
    public static List<Vector3f> dummyVerticeValue() {
        return new ArrayList<>(
                        List.of(
                                new Vector3f(0, 0, 0)
                        )
                );
    }

    // Rumus Mencari Combination
    public static int combination(int n, int r) {
        if (r > n) {
            return 0;
        }
        int result = 1;
        for (int i = 1; i <= r; i++) {
            result *= n - i + 1;
            result /= i;
        }
        return result;
    }

    // Rumus Linear Interpolation untuk Bezier Curve
    public static Vector3f interpolation(Vector3f point, float t, int d, int i) {
        double perkalianT = Math.pow((1-t), d-i) * Math.pow(t, i);
//        System.out.println("(1-t): " + (1-t) + ", ^: " + (d-i));
//        System.out.println("t: " + t + ", ^: " + i);
//        System.out.println(perkalianT);
        Vector3f hasil = new Vector3f(0, 0, 0);
        point.mul((float)perkalianT, hasil);
//        System.out.println(point);
//        System.out.println(hasil);
        return hasil;
    }

    public static List<Vector3f> bezierCurve(List<Vector3f> handlePoints, int amountOfBezierVerticesPerHandlePoint) {
        List<Vector3f> bezierCurvePoints = new ArrayList<Vector3f>();
        int maxLoopNumber = handlePoints.size() - 1;
        double step = 1.0/amountOfBezierVerticesPerHandlePoint;

        // Generate points dengan loop
        for (double i = step; i <= 1.0; i += step) {
            Vector3f nextBezierCurvePoint = new Vector3f(0, 0, 0);

            // Hitung hasil sigma
            for (int j = 0; j < handlePoints.size(); j++) {
                nextBezierCurvePoint.add(interpolation(handlePoints.get(j), (float)i, maxLoopNumber, j).mul(combination(maxLoopNumber, j)));
            }

            // Tambahkan hasil sigma ke bezierCurvePoints
            bezierCurvePoints.add(nextBezierCurvePoint);
        }

        return bezierCurvePoints;
    }

}

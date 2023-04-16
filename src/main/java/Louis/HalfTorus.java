package Louis;

import Engine.*;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL30.*;

public class HalfTorus extends Object {
    float centerX;
    float centerY;
    float centerZ;
    List<Integer> index = new ArrayList<>();
    int ibo;

    // Constructor untuk Torus dengan custom startSector dan endSector (Bisa untuk half torus, dll yang tanpa handle)
    public HalfTorus(List<ShaderModuleData> shaderModuleDataList, float centerX, float centerY, float centerZ, float radiusToCenterTube, float radiusofTube, int sectorCount, int stackCount, int startSector, int endSector, Vector4f color) {
        super(shaderModuleDataList, Utils.dummyVerticeValue(), color);

        // Set the actual vertice value
        this.vertices = calculateTorusVertices(centerX, centerY, centerZ, radiusToCenterTube, radiusofTube, sectorCount, stackCount);
        this.centerX = centerX;
        this.centerY = centerY;
        this.centerZ = centerZ;

        // Call Setup
        setupVAOVBO();
        setupIBO(sectorCount, stackCount, startSector, endSector);
    }

    @Override
    public void draw() {
        drawSetup();
        glLineWidth(1);
        glPointSize(10);
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        // HARUS GL_TRIANGLES kalo mau gaada handle
        glDrawElements(GL_TRIANGLES, index.size(), GL_UNSIGNED_INT, 0);
    }

    public List<Vector3f> calculateTorusVertices(float centerX, float centerY, float centerZ, float radiusToCenterTube, float radiusofTube, int sectorCount, int stackCount) {
        ArrayList<Vector3f> torusVertices = new ArrayList<>();

        float pi = (float) Math.PI;

        float sectorStep = 2 * pi / sectorCount;
        float stackStep = 2 * pi / stackCount;
        float sectorAngle, stackAngle;
        float x, y, z;

        for (int i = 0; i <= stackCount; ++i) {
            stackAngle = i * stackStep;                // starting from 0 to 2pi
            x = radiusToCenterTube + radiusofTube * (float) Math.sin(stackAngle);
            y = radiusToCenterTube + radiusofTube * (float) Math.sin(stackAngle);
            z = radiusofTube * (float) Math.cos(stackAngle);

            // add (sectorCount+1) vertices per stack
            // the first and last vertices have same position and normal, but different tex coords
            for (int j = 0; j <= sectorCount; ++j) {
                sectorAngle = j * sectorStep;           // starting from 0 to 2pi
                Vector3f tempVector = new Vector3f();

                tempVector.x = centerX + x * (float) Math.sin(sectorAngle);
                tempVector.y = centerY + y * (float) Math.cos(sectorAngle);
                tempVector.z = centerZ + z;
                torusVertices.add(tempVector);
            }
        }
        return torusVertices;
    }

    // ASUMSI: startSector >= 0, endSector < sectorCount
    public void setupIBO(int sectorCount, int stackCount, int startSector, int endSector) {
        // Setup urutan index dan ibo
//        index = Arrays.asList(0, 3, 3, 1, 1, 4, 4, 2, 2, 0);

        // Stack = Rownya (Yang melingkar searah putaran donut)
        // Sector = Columnnya (Yang melingkar tegak lurus putaran donut)
//        List<List<Vector3f>> torusStacks = new ArrayList<>();
//        for (int i = 0; i < stackCount - 1; i++) {
//            torusStacks.add(this.vertices.subList(sectorCount * i, sectorCount * (i + 1)));
//        }

        // Buat masukin ke indexnya
        for (int i = 0; i < stackCount; i++) {
            for (int j = startSector; j <= endSector; j++) {
//        for (int i = startSector; i <= endSector; i++) {
//            for (int j = 0; j < sectorCount; j++) {
                // Titiknya: stack sekarang sector sekarang, stack selanjutnya sector sekarang, stack sekarang sector selanjutnya
                index.add(((sectorCount + 1) * i) + j);
                index.add(((sectorCount + 1) * (i + 1)) + j);
                index.add(((sectorCount + 1) * i) + j + 1);

                // Titiknya: stack selanjutnya sector selanjutnya, stack sekarang sector selanjutnya, stack selanjutnya sector selanjutnya
                index.add(((sectorCount + 1) * (i + 1)) + j);
                index.add(((sectorCount + 1) * i) + j + 1);
                index.add(((sectorCount + 1) * (i + 1)) + j + 1);
            }

//            System.out.println("First:");
//            System.out.printf("%d, %d, %d\n", (sectorCount * (i + 1)) - 1, ((sectorCount * (i + 2)) - 1), (stackCount * i));
//            // Jadi agar sector akhir ke awalnya ngeloop
//            // Titiknya: Stack sekarang sector terakhir, stack selanjutnya sector terakhir, stack sekarang sector pertama
//            index.add((sectorCount * (i + 1)) - 1);
//            index.add((sectorCount * (i + 2)) - 1);
//            index.add(stackCount * i);
//
//            System.out.println("First2:");
//            System.out.printf("%d, %d, %d\n", ((sectorCount * (i + 2)) - 1), (stackCount * i), sectorCount * (i + 1));
//            // Titiknya: Stack selanjutnya sector terakhir, stack sekarang sector pertama, stack selanjutnya sector pertama
//            index.add((sectorCount * (i + 2)) - 1);
//            index.add(stackCount * i);
//            index.add(sectorCount * (i + 1));
        }

//        // Untuk stack terakhir dan pertama
//        // Jadi agar stack terakhir dan pertama ngeloop
//        for (int j = 0; j < sectorCount; j++) {
//        // Titiknya: stack terakhir sector sekarang, stack pertama sector sekarang, stack terakhir sector selanjutnya
//        index.add((stackCount * (stackCount - 1)) + j);
//        index.add(0 + j);
//        index.add((stackCount * (stackCount - 1)) + j + 1);
//
//        // Titiknya: stack pertama sector selanjutnya, stack terakhir sector selanjutnya, stack pertama sector selanjutnya
//        index.add(0 + j);
//        index.add((stackCount * (stackCount - 1)) + j + 1);
//        index.add(0 + j + 1);
//        }

//        System.out.println(index);

        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, Utils.listoInt(index), GL_STATIC_DRAW);
    }

    public void setCenterX(float centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(float centerY) {
        this.centerY = centerY;
    }

    public void setCenterZ(float centerZ) {
        this.centerZ = centerZ;
    }

    public float getCenterX() {
        return centerX;
    }

    public float getCenterY() {
        return centerY;
    }

    public float getCenterZ() {
        return centerZ;
    }
}
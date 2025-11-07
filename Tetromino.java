package gameFile;

import java.util.Random;

public class Tetromino {
    public static final Tetromino NoShape = new Tetromino();

    public static final Tetromino[] shapes = {
        new Tetromino(new int[][]{{0, 0}, {1, 0}, {0, 1}, {1, 1}}), // Square
        new Tetromino(new int[][]{{0, 0}, {1, 0}, {2, 0}, {3, 0}}), // Line
        new Tetromino(new int[][]{{0, 0}, {1, 0}, {2, 0}, {1, 1}}), // T
        new Tetromino(new int[][]{{0, 0}, {1, 0}, {0, 1}, {0, 2}}), // L
        new Tetromino(new int[][]{{0, 0}, {0, 1}, {1, 1}, {2, 1}})  // J
    };

    private int[][] coords;
    private int shapeIndex;

    public Tetromino() {
        coords = new int[0][0];
    }

    public Tetromino(int[][] coords) {
        this.coords = coords;
        this.shapeIndex = 0; // Default shape index
    }

    public static Tetromino randomTetromino() {
        Random rand = new Random();
        return shapes[rand.nextInt(shapes.length)];
    }

    public int x(int index) {
        return coords[index][0];
    }

    public int y(int index) {
        return coords[index][1];
    }

    public int minY() {
        int min = coords[0][1];
        for (int i = 1; i < coords.length; i++) {
            min = Math.min(min, coords[i][1]);
        }
        return min;
    }

    public Tetromino rotate() {
        // Implement rotation logic if needed
        return this; // Placeholder
    }

    public Tetromino getShape() {
        return this;
    }

    public void setShape(Tetromino shape) {
        this.coords = shape.coords;
    }

    public int ordinal() {
        return shapeIndex;
    }
}

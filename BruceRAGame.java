package gameFile;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class BruceRAGame {
    private static final int BOARD_WIDTH = 10;
    private static final int BOARD_HEIGHT = 20;
    private Tetromino currentPiece;
    private Tetromino[] board;
    private int currentX;
    private int currentY;
    private boolean gameOver;
    private int linesCleared;

    public BruceRAGame(BruceRATetris board) {
        this.board = new Tetromino[BOARD_WIDTH * BOARD_HEIGHT];
        clearBoard();
        newPiece();
    }

    public void draw(Graphics g) {
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                Tetromino shape = shapeAt(j, i);
                if (shape != Tetromino.NoShape) {
                    drawSquare(g, j * 30, (BOARD_HEIGHT - i - 1) * 30, shape);
                }
            }
        }

        if (currentPiece.getShape() != Tetromino.NoShape) {
            for (int i = 0; i < 4; i++) {
                int x = currentX + currentPiece.x(i);
                int y = currentY - currentPiece.y(i);
                drawSquare(g, x * 30, (BOARD_HEIGHT - y - 1) * 30, currentPiece.getShape());
            }
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void update() {
        if (!gameOver) {
            oneLineDown();
        }
    }

    private void newPiece() {
        currentPiece = Tetromino.randomTetromino();
        currentX = BOARD_WIDTH / 2 - 1;
        currentY = BOARD_HEIGHT - 1 + currentPiece.minY();

        if (!tryMove(currentPiece, currentX, currentY)) {
            currentPiece.setShape(Tetromino.NoShape);
            gameOver = true;
        }
    }

    private boolean tryMove(Tetromino newPiece, int newX, int newY) {
        for (int i = 0; i < 4; i++) {
            int x = newX + newPiece.x(i);
            int y = newY - newPiece.y(i);

            if (x < 0 || x >= BOARD_WIDTH || y < 0 || y >= BOARD_HEIGHT) {
                return false;
            }

            if (shapeAt(x, y) != Tetromino.NoShape) {
                return false;
            }
        }

        currentPiece = newPiece;
        currentX = newX;
        currentY = newY;
        return true;
    }

    private void oneLineDown() {
        if (!tryMove(currentPiece, currentX, currentY - 1)) {
            pieceDropped();
        }
    }

    private void pieceDropped() {
        for (int i = 0; i < 4; i++) {
            int x = currentX + currentPiece.x(i);
            int y = currentY - currentPiece.y(i);
            board[(y * BOARD_WIDTH) + x] = currentPiece.getShape();
        }
        clearLines();
        newPiece();
    }

    private void clearLines() {
        int numFullLines = 0;

        for (int i = 0; i < BOARD_HEIGHT; i++) {
            boolean lineIsFull = true;

            for (int j = 0; j < BOARD_WIDTH; j++) {
                if (shapeAt(j, i) == Tetromino.NoShape) {
                    lineIsFull = false;
                    break;
                }
            }

            if (lineIsFull) {
                numFullLines++;
                for (int k = i; k < BOARD_HEIGHT - 1; k++) {
                    System.arraycopy(board, (k + 1) * BOARD_WIDTH, board, k * BOARD_WIDTH, BOARD_WIDTH);
                }
            }
        }

        if (numFullLines > 0) {
            linesCleared += numFullLines;
            for (int i = 0; i < numFullLines; i++) {
                board[(BOARD_HEIGHT - 1 - i) * BOARD_WIDTH] = Tetromino.NoShape;
            }
        }
    }

    private Tetromino shapeAt(int x, int y) {
        return board[(y * BOARD_WIDTH) + x];
    }

    private void drawSquare(Graphics g, int x, int y, Tetromino shape) {
        Color[] colors = {
            Color.BLACK, Color.RED, Color.GREEN, Color.BLUE,
            Color.YELLOW, Color.MAGENTA, Color.CYAN, Color.ORANGE
        };

        g.setColor(colors[shape.ordinal()]);
        g.fillRect(x + 1, y + 1, 28, 28);
        g.setColor(colors[shape.ordinal()].darker());
        g.drawRect(x, y, 30, 30);
    }
}

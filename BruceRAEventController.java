package gameFile;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BruceRAEventController extends KeyAdapter {
    private BruceRAGame game;

    public BruceRAEventController(BruceRAGame game) {
        this.game = game;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (game.isGameOver()) {
            return;
        }

        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                game.tryMove(game.getCurrentPiece(), game.getCurrentX() - 1, game.getCurrentY());
                break;
            case KeyEvent.VK_RIGHT:
                game.tryMove(game.getCurrentPiece(), game.getCurrentX() + 1, game.getCurrentY());
                break;
            case KeyEvent.VK_DOWN:
                game.oneLineDown();
                break;
            case KeyEvent.VK_UP:
                game.tryMove(game.getCurrentPiece().rotate(), game.getCurrentX(), game.getCurrentY());
                break;
            case KeyEvent.VK_SPACE:
                game.dropDown();
                break;
        }
    }
}

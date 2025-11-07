package gameFile;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BruceRATetris extends JPanel {

    private BruceRAGame game;
    private Timer timer;

    public BruceRATetris() {
        game = new BruceRAGame(this);
        JFrame frame = new JFrame("BruceRATetris");
        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 550);
        frame.setVisible(true);
        
        BruceRAEventController eventController = new BruceRAEventController(game);
        frame.addKeyListener(eventController);
        setBackground(Color.YELLOW);
        
        timer = new Timer(400, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.update();
                repaint();
            }
        });
        timer.start();
    }

    public void update() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.draw(g);
        if (game.isGameOver()) {
            g.setFont(new Font("Palatino", Font.BOLD, 40));
            g.setColor(Color.BLACK);
            g.drawString("GAME OVER", 80, 300);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BruceRATetris());
    }
}

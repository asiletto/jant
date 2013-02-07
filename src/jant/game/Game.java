package jant.game;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Game extends JFrame {
	
    public static final int G_HEIGHT = 500;
	public static final int G_WIDTH = 500;

	public Game() {
        add(new Board());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(G_WIDTH, G_HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Test game");
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Game();
    }
}
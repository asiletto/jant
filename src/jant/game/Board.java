package jant.game;


import jant.game.objects.GameEntity;
import jant.game.objects.impl.Ant;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Board extends JPanel implements ActionListener {

	private Timer timer;
    private List<GameEntity> entities;
    
    public Board() {

    	entities = new ArrayList<GameEntity>();

    	addRandomAnts(25);
    	
        setFocusable(true);
        setBackground(Color.WHITE);
        setDoubleBuffered(true);

        setSize(Game.G_WIDTH, Game.G_HEIGHT);

        timer = new Timer(100, this);
        timer.start();
    }

    public void addRandomAnts(int num){
    	for (int i = 0; i < num; i++) {
    		entities.add(new Ant());
		}
    }
    
    public void paint(Graphics g) {
        super.paint(g);

            Graphics2D g2d = (Graphics2D)g;
            for (GameEntity entity : entities) {
				g2d.drawImage(entity.getImageRotated(), entity.getXpos(), entity.getYpos(), this);
            }

            g2d.setColor(Color.LIGHT_GRAY);

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
        for (GameEntity entity : entities) {
        	entity.move();
        }
		repaint();
	}

}
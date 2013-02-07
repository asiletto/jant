package jant.game;


import jant.game.objects.GameEntity;
import jant.game.objects.impl.Ant;
import jant.game.objects.impl.Nest;
import jant.game.objects.impl.WalkPheromone;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Board extends JPanel implements ActionListener {

	private Timer timer;
    private Set<GameEntity> entities;
    private Map<String,WalkPheromone> pheromoneMatrix = new HashMap<String,WalkPheromone>();
    
    public Board() {

    	entities = new HashSet<GameEntity>();

    	addRandomAnts(25);
    	Nest nest = new Nest(this);
    	entities.add(nest);
    	
        setFocusable(true);
        setBackground(Color.WHITE);
        setDoubleBuffered(true);

        setSize(Game.G_WIDTH, Game.G_HEIGHT);

        timer = new Timer(100, this);
        timer.start();
    }

    public void addRandomAnts(int num){
    	for (int i = 0; i < num; i++) {
    		entities.add(new Ant(this));
		}
    }
    
    public void paint(Graphics g) {
        super.paint(g);

            Graphics2D g2d = (Graphics2D)g;
            	//draw entities
            	for (Iterator<GameEntity> iterator = entities.iterator(); iterator.hasNext();) {
    				GameEntity entity = iterator.next();
					g2d.drawImage(entity.getImageRotated(), entity.getXpos(), entity.getYpos(), this);
	            }
            	//draw pheromones
            	for (Iterator<String> iterator = pheromoneMatrix.keySet().iterator(); iterator.hasNext();) {
    				String key = iterator.next();
    				WalkPheromone p = pheromoneMatrix.get(key);
   					g2d.drawImage(p.getImageRotated(), p.getXpos(), p.getYpos(), this);
    	        }

            g2d.setColor(Color.LIGHT_GRAY);

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
			//loop on entities
			for (Iterator<GameEntity> iterator = entities.iterator(); iterator.hasNext();) {
				GameEntity entity = iterator.next();
	        	entity.loop();
	        }

			//loop on pheromones (on a differen for because some entities add pheromones to the board and cause concurrent modification exception)
			Iterator<Map.Entry<String,WalkPheromone>> iter = pheromoneMatrix.entrySet().iterator();
			while (iter.hasNext()) {
			    Map.Entry<String,WalkPheromone> entry = iter.next();
	        	entry.getValue().loop();
			    if(entry.getValue().value<0){
			        iter.remove();
			    }
			}
		repaint();
	}

	public Map<String,WalkPheromone> getPheromoneMatrix() {
		return pheromoneMatrix;
	}

	public void addPheromoneMatrix(int xpos, int ypos, WalkPheromone p1) {
		pheromoneMatrix.put(""+xpos+"-"+ypos, p1);
	}
	
	public void removePheromoneMatrix(int xpos, int ypos){
		pheromoneMatrix.remove(""+xpos+"-"+ypos);
	}
	
	public WalkPheromone getPheromoneMatrix(int xpos, int ypos){
		return pheromoneMatrix.get(""+xpos+"-"+ypos);
	}
}
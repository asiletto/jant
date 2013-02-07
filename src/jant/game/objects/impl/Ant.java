package jant.game.objects.impl;

import jant.game.Board;
import jant.game.Game;
import jant.game.objects.GameEntity;

import javax.swing.ImageIcon;

public class Ant extends GameEntity {

	public Ant(Board board) {
		super(board);
		this.forwardSpeed = 3;
		this.angleSpeed = 50;
		this.image = new ImageIcon(this.getClass().getResource("ant-worker.png")).getImage();
		this.angle = rand.nextInt(ANGLE_360);
		this.xpos = Game.G_HEIGHT/2;
		this.ypos = Game.G_WIDTH/2;
		int w = image.getWidth(null);
		int h = image.getHeight(null);
		this.maxImageLen = w>h?w:h;
	}
	
	@Override
	public void loop() {
			randomMove();
		
	}

	public void randomMove() {
		double dx = Math.sin(Math.toRadians(angle)) * forwardSpeed;
		double dy = -Math.cos(Math.toRadians(angle)) *  forwardSpeed;
		
		xpos += dx;
		ypos += dy;

		if(rand.nextBoolean())
			angle += rand.nextInt(angleSpeed);
		else
			angle -= rand.nextInt(angleSpeed);

		if(ypos+maxImageLen>Game.G_HEIGHT)
			ypos = Game.G_HEIGHT-maxImageLen;
		if(ypos<0)
			ypos = 0;

		if(xpos>Game.G_WIDTH)
			xpos = Game.G_WIDTH;
		if(xpos<0)
			xpos = 0;

		if(angle>ANGLE_360)
			angle = 0;
		if(angle<0)
			angle = ANGLE_360;
		
		try{
			board.getPheromoneMatrix(xpos,ypos).reinforce();
		}catch (Exception e) {
			WalkPheromone p1 = new WalkPheromone(board, xpos, ypos+(maxImageLen/2), WalkPheromone.DEFAULT_VALUE);
			board.addPheromoneMatrix(xpos,ypos,p1);
		}
	}
	
}

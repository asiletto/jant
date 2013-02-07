package jant.game.objects.impl;

import jant.game.Game;
import jant.game.objects.GameEntity;

import javax.swing.ImageIcon;

public class Ant extends GameEntity{

	int forwardSpeed = 5;
	int angleSpeed = 15;
	int maxImageLen;
	
	public Ant() {
		this.image = new ImageIcon(this.getClass().getResource("ant-worker.png")).getImage();
		this.angle = rand.nextInt(ANGLE_360);
		this.xpos = rand.nextInt(Game.G_HEIGHT);
		this.ypos = rand.nextInt(Game.G_WIDTH);
		int w = image.getWidth(null);
		int h = image.getHeight(null);
		this.maxImageLen = w>h?w:h;
	}
	
	@Override
	public void move() {
		moveForward();
	}

	public void moveForward() {
		double dx = Math.sin(Math.toRadians(angle)) * forwardSpeed;
		double dy = -Math.cos(Math.toRadians(angle)) *  forwardSpeed;
		
		xpos += dx;
		ypos += dy;

		if(rand.nextBoolean())
			angle += angleSpeed;
		else
			angle -= angleSpeed;

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
	}
}

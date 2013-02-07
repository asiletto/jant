package jant.game.objects.impl;

import jant.game.Game;
import jant.game.objects.GameEntity;

import java.security.SecureRandom;


import javax.swing.ImageIcon;

public class Ant extends GameEntity{

	protected SecureRandom rand = new SecureRandom();
	int forwardSpeed = 5;
	int strafeSpeed = 0;
	int angleSpeed = 15;
	int fullAngle = 360;
	
	public Ant() {
		this.image = new ImageIcon(this.getClass().getResource("ant-worker.png")).getImage();
		this.angle = rand.nextInt(fullAngle);
		this.xpos = rand.nextInt(Game.G_HEIGHT);
		this.ypos = rand.nextInt(Game.G_WIDTH);
	}
	
	@Override
	public void move() {
		moveForward();
	}

	public void moveForward() {
		double dy = Math.cos(Math.toRadians(angle)) *  forwardSpeed + Math.sin(Math.toRadians(angle)) * strafeSpeed;
		double dx = -Math.cos(Math.toRadians(angle)) * strafeSpeed + Math.sin(Math.toRadians(angle)) * forwardSpeed;
		
		xpos += dx;
		ypos -= dy;

		if(rand.nextBoolean())
			angle += angleSpeed;
		else
			angle -= angleSpeed;

		if(xpos>Game.G_HEIGHT-image.getHeight(null))
			xpos = Game.G_HEIGHT-image.getHeight(null);
		if(xpos<0)
			xpos = 0;

		if(ypos>Game.G_WIDTH-image.getWidth(null))
			ypos = Game.G_WIDTH-image.getWidth(null);
		if(ypos<0)
			ypos = 0;

		if(angle>fullAngle)
			angle = 0;
		if(angle<0)
			angle = fullAngle;
	}
}

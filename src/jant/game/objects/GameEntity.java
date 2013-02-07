package jant.game.objects;


import jant.game.Game;
import jant.game.Utils;

import java.awt.Image;
import java.security.SecureRandom;

/**
 * representing a general entity on the board
 * @author Alessandro
 */
public abstract class GameEntity {
	
	protected SecureRandom rand = new SecureRandom();
	public static final int ANGLE_360 = 360;
	
	protected int xpos;
	protected int ypos;	
	protected Image image;
	protected int angle;
	
	protected int forwardSpeed;
	protected int angleSpeed;
	protected int maxImageLen;

	public abstract void loop();
	
	public void randomMove() {
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
	
	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Image getImageRotated() {
		return Utils.rotateImage(image, angle);
	}

	public int getXpos() {
		return xpos;
	}

	public void setXpos(int xpos) {
		this.xpos = xpos;
	}

	public int getYpos() {
		return ypos;
	}

	public void setYpos(int ypos) {
		this.ypos = ypos;
	}
	
}

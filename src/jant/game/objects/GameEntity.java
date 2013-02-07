package jant.game.objects;


import jant.game.Board;
import jant.game.Utils;

import java.awt.Image;
import java.security.SecureRandom;

/**
 * representing a general entity on the board
 * @author Alessandro
 */
public abstract class GameEntity {
	protected Board board;
	
	public GameEntity(Board board) {
		this.board = board;
	}
	
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

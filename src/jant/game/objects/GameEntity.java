package jant.game.objects;


import jant.game.Utils;

import java.awt.Image;


public abstract class GameEntity {
	
	protected int xpos;
	protected int ypos;	
	protected Image image;
	protected int angle;

	public abstract void move();
	
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

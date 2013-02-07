package jant.game.objects.impl;

import jant.game.Game;
import jant.game.objects.GameEntity;

import javax.swing.ImageIcon;

public class Ant extends GameEntity {

	private DEVELOPMENT_STAGE stage;
	
	public Ant() {
		this.forwardSpeed = 15;
		this.angleSpeed = 15;
		this.image = new ImageIcon(this.getClass().getResource("ant-worker.png")).getImage();
		this.angle = rand.nextInt(ANGLE_360);
		this.xpos = rand.nextInt(Game.G_HEIGHT);
		this.ypos = rand.nextInt(Game.G_WIDTH);
		int w = image.getWidth(null);
		int h = image.getHeight(null);
		this.maxImageLen = w>h?w:h;
		
		this.stage = DEVELOPMENT_STAGE.WORKER;
	}
	
	@Override
	public void loop() {
		if(DEVELOPMENT_STAGE.WORKER==stage)
			randomMove();
		
	}

	enum DEVELOPMENT_STAGE {
		EGG,
		LARVA,
		PUPA_WORKER,
		PUPA_QUEEN,
		PUPA_DRONE,
		WORKER,
		QUEEN,
		PRINCESS,
		DRONE
	}
	
}

package jant.game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Utils {

	static public Image rotateImage(Image picture, double angle) {   
        int w = picture.getWidth(null);  
        int h = picture.getHeight(null);  
        int type = BufferedImage.TRANSLUCENT;
        BufferedImage image = new BufferedImage(h, w, type);  
        Graphics2D g2 = image.createGraphics();  
        double x = (h - w)/2.0;  
        double y = (w - h)/2.0;  
        AffineTransform at = AffineTransform.getTranslateInstance(x, y);  
        at.rotate(Math.toRadians(angle), w/2.0, h/2.0);  
        g2.drawImage(picture, at, null);  
        g2.dispose();  
        return image;
    }
	
}

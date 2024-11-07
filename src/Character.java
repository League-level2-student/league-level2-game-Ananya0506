import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Character extends GameObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    //gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	Character(int x, int y, int width, int height) {
		super(x, y, width, height, 0);
		if (needImage) {
		    loadImage ("");
		//idk about the image yet
		}
	}

	public void draw(Graphics g) {
		if (isActive) {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		} else {
			g.setColor(Color.PINK);
			g.fillRect(x, y, width, height);
		}
		
		
//		if (isActive) {
//			if (gotImage) {
//	        	g.drawImage(image, x, y, width, height, null);
//	        } else {
//	        	g.setColor(Color.BLUE);
//	        	g.fillRect(x, y, width, height);
//	        }
//		}
		
	}
	public void update() {
		super.update();
		
	}




}

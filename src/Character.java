import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Character extends GameObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	int gravity = 2; 
	int yVelocity = 0; 
	int jumpPower = 20;
	int yLimit = 600; 
	boolean canJump = false;
	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		   gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	Character(int x, int y, int width, int height) {
		super(x, y, width, height, 0);
		if (needImage) {
		    loadImage ("dog.jpg");
		
		}
	}

	public void draw(Graphics g) {
		if (isActive) {
		if (gotImage) {
        	g.drawImage(image, x, y, width, height, null);
        } else {
        	g.setColor(Color.BLUE);
        	g.fillRect(x, y, width, height);
        }
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
	
	public void jump() {
	if(canJump) {	
		yVelocity-= jumpPower;
		canJump = false;
	}
	}
	public void update() {
		super.update();
		yVelocity += gravity; 
		y += yVelocity;
		
		if (y>= yLimit) {
			y = yLimit;
			yVelocity = 0; 
			canJump = true;
		}
	}




}

import java.awt.Color;
import java.awt.Graphics;

public class Obstacle extends GameObject {

	

	public boolean squareCounted;

	Obstacle(int x, int y, int width, int height, int speed, boolean squareCounted) {
		super(x, y, width, height, speed);
	this.squareCounted = squareCounted;
	}

	public void update() {
		x -= speed;
		if(x < GamePanel.WIDTH && x > -20) {
			isActive = true;
		}else {
			isActive = false;
		}
		super.update();
	}

	public void draw(Graphics g) {

		if (isActive) {
			g.setColor(Color.GREEN.darker().darker());
			g.fillRect(x, y, width, height);
		} else {
			g.setColor(Color.RED);
			g.fillRect(x, y, width, height);
		}

	}

}

import java.awt.Color;
import java.awt.Graphics;

public class Obstacle extends GameObject {

	Obstacle(int x, int y, int width, int height, int speed) {
		super(x, y, width, height, speed);

	}

	public void update() {
		x -= speed;
		super.update();
	}

	public void draw(Graphics g) {

		if (isActive) {
			g.setColor(Color.GREEN);
			g.fillRect(x, y, width, height);
		} else {
			g.setColor(Color.RED);
			g.fillRect(x, y, width, height);
		}

	}

}

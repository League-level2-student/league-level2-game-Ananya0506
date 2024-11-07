import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	Character c;
	ArrayList<Obstacle> obstacles = new ArrayList<>();

	ObjectManager(Character c) {
		this.c = c;
		obstacles.add(new Obstacle(1500, 200, 20, 10, 15));
	}

	void draw(Graphics g) {
		c.draw(g);
		for (Obstacle o : obstacles) {
			o.draw(g);
		}
	}

	public void update() {
		c.update();
		for (Obstacle o : obstacles) {
			o.update();
			if (o.y > GamePanel.HEIGHT) {
				o.isActive = false;
			}
		}

	}

	public void checkCollision() {
		for(Obstacle o: obstacles) {
		
			if (c.collisionBox.intersects(o.collisionBox)) {
				
				o.isActive = false;
				c.isActive = false;
			}
		}
		}
	
}

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ObjectManager {
	Character c;
	ArrayList<Obstacle> obstacles = new ArrayList<>();
	int score = 0; 
	
	
	ObjectManager(Character c) {
		this.c = c;
		obstacles = addObstacles();
	
	}

	private ArrayList<Obstacle> addObstacles() {
		ArrayList<Obstacle> a = new ArrayList<>(); 
		Random ran = new Random();
		
				
		int lastX = 1500;
		for(int i = 0; i<100; i++) {
			
			int r = ran.nextInt(5);
			int l = ran.nextInt(500) + 200;
		a.add(new Obstacle(lastX + l, 600 - r*10, 20, 10 + r*10, 10, false));
		lastX = lastX+l;
		}
		
		
	
		return a;
	}

	void draw(Graphics g) {
		c.draw(g);
		for (Obstacle o : obstacles) {
			if(o.isActive) {
				o.draw(g);
			}
		}
	}

	public void update() {
		
		c.update();
		
		Iterator<Obstacle> iter = obstacles.iterator();
		while(iter.hasNext()) {
			Obstacle o = iter.next();
		
			if(o.x < -20) {
				iter.remove();
			}
			o.update();	
		}

	}

	public void checkCollision() {
		for(Obstacle o: obstacles) {
		
			if (c.collisionBox.intersects(o.collisionBox)) {
				
				GamePanel.currentState = GamePanel.END; 
			
				c.isActive = false;
			
			}
		
		if (o.x <= c.x && o.squareCounted == false) {
			score = score+1;
			o.squareCounted = true;
		}
		if (!c.isActive) {
			obstacles = addObstacles();
		}
		}
		
	}
	public int getScore() {
		return score;
		
	}
}

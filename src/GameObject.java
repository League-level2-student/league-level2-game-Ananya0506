import java.awt.Rectangle;

public class GameObject {

	int x; 
	int y; 
	int width; 
	int height;
	int speed;
	boolean isActive = true;
	Rectangle collisionBox;
	

	GameObject(int x, int y, int width, int height, int speed){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.collisionBox = new Rectangle(x, y, width, height);
	}

	public void update() {
			 collisionBox.setBounds(x, y, width, height);
	}
}

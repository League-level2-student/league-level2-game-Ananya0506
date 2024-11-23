import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	
	JFrame frame;
	static final int WIDTH = 1600;
	static final int HEIGHT = 800;
	Timer timer;
	Font titleFont;
	Font subtitleFont;
	final static int MENU = 0;
	final static int GAME = 1;
	final static int END = 2;
	static int currentState = MENU;
	int score = 0;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	Character c = new Character(200, 600, 20, 10);
	ObjectManager manager = new ObjectManager(c);
	
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
	GamePanel(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		frame.add(this);
		frame.pack();
		frame.setVisible(true);
		frame.addKeyListener(this);
		 titleFont = new Font("Pacifico", Font.PLAIN, 50);
		  subtitleFont = new Font("Comfortaa", Font.PLAIN, 20);
		 timer = new Timer(1000/60,this);
		   timer.start();
		   if (needImage) {
			    loadImage ("landscape.jpg");
			}
	}
	 
	  void updateMenuState() {
		 manager.score=0;
	  }
 void updateGameState() {

	 manager.update();
	 manager.checkCollision();	  
	 if(c.isActive == false) {
			currentState  = END;
		}
	 setFont(subtitleFont);
	 
	  }
 void updateEndState() {
	  
 }
	    
	void drawMenuState(Graphics g) { 
		g.setColor(new Color(205, 177, 224));
		g.fillRect(0, 0, WIDTH , HEIGHT);
		g.setFont(titleFont);
		g.setColor(new Color(255, 247, 3));
		g.drawString("UNTITLED GAME", 100, 100);
		g.setFont(subtitleFont);
		g.drawString("Press ENTER to start", 100, 300);
		g.drawString("Rules:", 100, 400);
		g.drawString("-The objective of the game is to jump over the obstacles and get the highest score possible.", 100, 450);
		g.drawString("-To jump, you can either press the space or the up key.", 100, 500);
		g.drawString("-You CANNOT double jump, you can only jump once, no matter how many times you press the space/jump key.", 100, 550);
		g.drawString("GOOD LUCK!", 100, 600);
	
	}
	void drawGameState(Graphics g) { 
		
		if (gotImage) {
        	g.drawImage(image, 0, 0, WIDTH, HEIGHT, null);
        } else {
        	g.setColor(Color.LIGHT_GRAY);
        	g.fillRect(0, 0, WIDTH, HEIGHT);
        }
		
		manager.draw(g);
		g.drawString(String.valueOf(manager.getScore()), 10,10);
		
	}
	void drawEndState(Graphics g)  { 
		g.setColor(new Color(222, 197, 175));
		g.fillRect(0, 0, WIDTH , HEIGHT );
		g.setFont(titleFont);
		g.setColor(new Color(0, 252, 248));
		g.drawString("GAME OVER", 100, 100);
		g.setFont(subtitleFont);
		g.drawString("Press ENTER to restart", 100, 500);
		g.drawString("Final Score: " + manager.getScore(), 100, 600);
		manager.getScore();
	}
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}		
		repaint();
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		       
		       currentState = MENU;
		    } else {
		      
		    	currentState++;
		    	if(currentState == GAME) {
		    		c.isActive = true;
		    	} else if (currentState == END) {
		    		
		    	}
		    } 
		}   
		if (e.getKeyCode()==KeyEvent.VK_SPACE || e.getKeyCode()==KeyEvent.VK_UP) {
			c.jump();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

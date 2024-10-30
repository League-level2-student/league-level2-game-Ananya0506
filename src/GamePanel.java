import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener{

	JFrame frame;
	static final int WIDTH = 1600;
	static final int HEIGHT = 800;
	Timer timer;
	Font titleFont;
	Font subtitleFont;
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	
	GamePanel(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		frame.add(this);
		frame.pack();
		frame.setVisible(true);
		 titleFont = new Font("Pacifico", Font.PLAIN, 50);
		  subtitleFont = new Font("Comfortaa", Font.PLAIN, 20);
		 timer = new Timer(1000/60,this);
		   timer.start();
	}
	 
	  void updateMenuState() {
		  
	  }
 void updateGameState() {
		  
	  }
 void updateEndState() {
	  
 }
	    
	void drawMenuState(Graphics g) { 
		g.setColor(new Color(214, 138, 255));
		g.fillRect(0, 0, WIDTH , HEIGHT );
		g.setFont(titleFont);
		g.setColor(new Color(252, 226, 159));
		g.drawString("UNTITLED GAME", 100, 100);
		g.setFont(subtitleFont);
		g.drawString("Press ENTER to start", 100, 300);
		g.drawString("Press SPACE for instructions", 100, 500);
	}
	void drawGameState(Graphics g) { 
		
	
	}
	void drawEndState(Graphics g)  { 
		g.setColor(new Color(252, 188, 159));
		g.fillRect(0, 0, WIDTH , HEIGHT );
		g.setFont(titleFont);
		g.setColor(new Color(159, 224, 252));
		g.drawString("GAME OVER", 100, 100);
		g.setFont(subtitleFont);
		g.drawString("Press ENTER to restart", 100, 500);
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

}

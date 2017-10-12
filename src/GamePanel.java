import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	Timer t;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = 0;
	Font titleFont;
	Rocketship ship;
	ObjectManager om;
GamePanel(){
	t = new Timer(1000/60, this);
	ship = new Rocketship(250,200,50,50);
	om = new ObjectManager();
	om.addObject(ship);
}
void StartGame(){
	t.start();
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		if(currentState == MENU_STATE){
			updatems();
		}else if(currentState == GAME_STATE){
			updategs();
		}else if(currentState == END_STATE){
			updatees();
		}

	}
	void updatems(){
		
	}
	void updategs(){
		om.update();
	}
	
	void updatees(){
		
	}
	void drawms(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(0, 0,  1000, 1000);
		g.setColor(Color.yellow);
		g.setFont(titleFont);
		g.drawString("Totally NOT", 190, 100);
		g.drawString("Astriods", 190, 135);
	}
	void drawgs(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 10000,100000);    
		om.draw(g);

	}
	void drawes(Graphics g){
	g.setColor(Color.RED);
	g.fillRect(0, 0, 1000, 1000);
	g.setColor(Color.BLACK);
	g.setFont(titleFont);
	g.drawString("Game", 190, 100);
	g.drawString("Over :'(", 190, 135);
	}
public void paintComponent(Graphics g){
	if(currentState == MENU_STATE){
		drawms(g);
	}else if(currentState == GAME_STATE){
		drawgs(g);
	}else if(currentState == END_STATE){
		drawes(g);
	}

	}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	System.out.println("pizza");
}
@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	System.out.println("bob");
	if(e.getKeyCode()==KeyEvent.VK_ENTER){
		currentState++;
	}
	if(currentState > END_STATE){
		currentState = MENU_STATE;
	}
	if(e.getKeyCode()==KeyEvent.VK_LEFT){
		ship.aspeed=5;
	}
	else if (e.getKeyCode()== KeyEvent.VK_RIGHT){
		ship.aspeed=-5;
	}
	else if(e.getKeyCode()==KeyEvent.VK_UP){
		ship.ospeed=5;
	}
	else if(e.getKeyCode()==KeyEvent.VK_DOWN){
		ship.ospeed=-5;
	}
else if (e.getKeyCode()==KeyEvent.VK_SPACE){
	om.addObject(new Projectiles(ship.x+ship.width/2, ship.y, 10, 10));
	}

}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	System.out.println("chicken");
	if(e.getKeyCode()==KeyEvent.VK_LEFT){
		ship.aspeed=0;
	}
	else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
		ship.aspeed=0;
	}
	else if(e.getKeyCode()==KeyEvent.VK_UP){
		ship.ospeed=0;
	}
	else if(e.getKeyCode()==KeyEvent.VK_DOWN){
		ship.ospeed=0;
	}
	
}

}

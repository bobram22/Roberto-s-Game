import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer t;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = 0;
	Font titleFont;
	Rocketship ship;
	public static BufferedImage playerImage;
	public static BufferedImage AstriodImage;
	public static BufferedImage BackGroundImage;
	ObjectManager om;
	AudioClip music;
	GamePanel() {
		t = new Timer(1000 / 60, this);

		om = new ObjectManager();

		try {
			playerImage = ImageIO.read(this.getClass().getResourceAsStream("ship.png"));
			AstriodImage = ImageIO.read(this.getClass().getResourceAsStream("Astriod.png"));
			BackGroundImage = ImageIO.read(this.getClass().getResourceAsStream("maxresdefault.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void StartGame() {
		t.start();
		om.reset();
		om.makeAstriods();
		ship = new Rocketship(400, 400, 50, 50);
		om.addObject(ship);
		om.setScore(0);
		om.numLives = 3;
		music = playSound("MFG.wav");
	}

	AudioClip playSound(String fileName) {        
            AudioClip noise = JApplet.newAudioClip(getClass().getResource(fileName));
            noise.play();
			return noise;     
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		if (currentState == MENU_STATE) {
			updatems();
		} else if (currentState == GAME_STATE) {
			updategs();
		} else if (currentState == END_STATE) {
			updatees();
		}

	}

	void updatems() {

	}

	void updategs() {
		om.update();
		if (om.numLives == 0) {
			currentState = END_STATE;
			music.stop();
		}
		System.out.println(om.numAstriods);
		if (om.numAstriods == 0) {
			om.makeAstriods();
		}
		if(ship.isAlive==false){
			ship = new Rocketship(400, 400, 50, 50);
			om.addObject(ship);
		}
	}

	void updatees() {

	}

	void drawms(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 1000, 1000);
		g.setColor(Color.yellow);
		g.setFont(titleFont);
		g.drawString("Totally NOT", 190, 100);
		g.drawString("Astriods", 190, 135);
	}

	void drawgs(Graphics g) {
		g.drawImage(BackGroundImage, 0, 0, 1920, 1080, null);
				om.draw(g);
		g.setColor(Color.magenta);
		String lives = Integer.toString(om.numLives);
		String score = Integer.toString(om.score);
		g.drawString("Score: "+score, 190, 125);
		g.drawString("Number of Lives: "+lives, 190, 135);
	}

	void drawes(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, 1000, 1000);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("Game", 190, 100);
		g.drawString("Over :'(", 190, 135);
	}

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawms(g);
		} else if (currentState == GAME_STATE) {
			drawgs(g);
		} else if (currentState == END_STATE) {
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
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(currentState == MENU_STATE){
				currentState = GAME_STATE;
				StartGame();
			}
			else if (currentState == END_STATE){
				currentState = MENU_STATE;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			ship.aspeed = 5;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			ship.aspeed = -5;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			ship.speed = 5;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			ship.speed = -5;
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (ship.isAlive) {
				om.addObject(new Projectiles(ship.x + ship.width / 2, ship.y, 10, 10, ship.angle));
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("chicken");
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			ship.aspeed = 0;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			ship.aspeed = 0;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			ship.speed = 0;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			ship.speed = 0;
		}

	}

}

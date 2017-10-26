import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class Rocketship extends GameObject {
	
	int speed;
	int ospeed;
	int angle=0;
	int aspeed;
	Rocketship(int x, int y, int w, int h){
		super(x,y,w,h);
		int speed = 5;
	}
	void update(){
		x-=speed*Math.cos(Math.toRadians(angle));
		y-=speed*Math.sin(Math.toRadians(angle));
		angle-=aspeed;
	}
	
	void draw(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		g2d.translate(x, y);
		g2d.rotate(Math.toRadians(angle));
		
	/*	g2d.setColor(Color.BLUE);
		g2d.fillRect(-width/2, -height/2, width, height);
		*/
		g2d.drawImage(GamePanel.playerImage, x, y, width, height);
		g2d.setTransform(new AffineTransform());
		
	}
}

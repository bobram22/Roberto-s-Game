import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class Rocketship extends GameObject {
	
	int speed;
	float xspeed;
	float yspeed;
	int ospeed;
	int angle=0;
	int aspeed;
	Rocketship(int x, int y, int w, int h){
		super(x,y,w,h);
		int speed = 5;
	}
	void update(){
		xspeed+=speed*Math.cos(Math.toRadians(angle));
		yspeed+=speed*Math.sin(Math.toRadians(angle));
		xspeed *= .95;
		yspeed *= .95;
		x+=xspeed;
		y+=yspeed;
		angle-=aspeed;
		if(x<0){
			System.out.println("turtle");
			x=800;
		}
		else if(x>800){
			x=0;
		}
		if(y<0){
			y=800;
		}
		else if(y>800){
			y=0;
		}
		}
	
	void draw(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		g2d.translate(x, y);
		g2d.rotate(Math.toRadians(angle));
		
	/*	g2d.setColor(Color.BLUE);
		g2d.fillRect(-width/2, -height/2, width, height);
		*/
		g2d.drawImage(GamePanel.playerImage, -width/2, -height/2, width, height, null);
		g2d.setTransform(new AffineTransform());
		
	}
}

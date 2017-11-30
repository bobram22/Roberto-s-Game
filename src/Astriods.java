import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class Astriods extends GameObject {
public Astriods(int x, int y, int w, int h, int xspeed, int yspeed) {
		super(x, y, w, h);
		this.height= h;
		this.width=w;
		this.x=x;
		this.y=y;
		this.xspeed=xspeed;
		this.yspeed=yspeed;
		
		// TODO Auto-generated constructor stub
	}
int angle=0;
int xspeed;
int yspeed;
void update(){
	super.update();
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
	x+=xspeed;
	y+=yspeed;
	}
void draw(Graphics g){
	Graphics2D g2d = (Graphics2D)g;
	g2d.translate(x, y);
	g2d.rotate(Math.toRadians(angle));
	
/*	g2d.setColor(Color.BLUE);
	g2d.fillRect(-width/2, -height/2, width, height);
	*/
	g2d.drawImage(GamePanel.AstriodImage, -width/2, -height/2, width, height, null);
	g2d.setTransform(new AffineTransform());

}

}

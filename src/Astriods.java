import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class Astriods extends GameObject {
public Astriods(int x, int y, int w, int h) {
		super(x, y, w, h);
		this.height= h;
		this.width=w;
		this.x=x;
		this.y=y;
		// TODO Auto-generated constructor stub
	}
int angle=0;
int speed = 30;
void update(){
	super.update();
	y+=speed;}
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

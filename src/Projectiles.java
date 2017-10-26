import java.awt.Color;
import java.awt.Graphics;

public class Projectiles extends GameObject{
	int speed = 10;
	int angle = 0;
	void update(){
		super.update();
		y-=speed*Math.sin(Math.toRadians(angle));
		x-=speed*Math.cos(Math.toRadians(angle));
		if(y==0){
			isAlive=false;
		}
	}
		void draw(Graphics g){
			g.setColor(Color.RED);
			g.fillRect(x, y, width, height);

		}
Projectiles(int x,int y,int w,int h,int angle){
	super(x,y,w,h);
	this.angle=angle;
	
}
}
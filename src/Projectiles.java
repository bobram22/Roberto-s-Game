import java.awt.Color;
import java.awt.Graphics;

public class Projectiles extends GameObject{
	int speed = 10;
	int angle = 0;
	int aliveCountDown=60;
	void update(){
		super.update();
		aliveCountDown--;
		if(aliveCountDown==0){
			isAlive=false;
		}
		y+=speed*Math.sin(Math.toRadians(angle));
		x+=speed*Math.cos(Math.toRadians(angle));
		
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
			g.setColor(Color.RED);
			g.fillRect((int)x, (int)y, width, height);

		}
Projectiles(float x,float y,int w,int h,int angle){
	super(x,y,w,h);
	this.angle=angle;
	
}
}
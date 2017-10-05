import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	
	int speed;
	int ospeed;
	
	Rocketship(int x, int y, int w, int h){
		super(x,y,w,h);
		int speed = 5;
	}
	void update(){
		x-=speed;
		y-=ospeed;
	}
	
	void draw(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);

	}
}

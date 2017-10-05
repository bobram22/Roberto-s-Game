import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	int x=10;
	int y=10;
	int width;
	int height;
	boolean isAlive= true;
	Rectangle collisionBox;
public GameObject(int x, int y, int w, int h) {
		// TODO Auto-generated constructor stub
	this.x=x;
	this.y=y;
	this.width=w;
	this.height=h;
	}
void update(){
	x++;
	y++;
	
}
void draw(Graphics g){
	g.fillRect(x, y, 20, 20);
}
}

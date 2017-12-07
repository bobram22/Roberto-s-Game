import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	float x=10;
	float y=10;
	int width;
	int height;
	boolean isAlive= true;
	Rectangle collisionBox;
public GameObject(float x, float y, int w, int h) {
		// TODO Auto-generated constructor stub
	this.x=x;
	this.y=y;
	this.width=w;
	this.height=h;
	collisionBox = new Rectangle((int)x,(int)y,w,h);
	}
void update(){
	
	collisionBox.setBounds((int)x, (int)y, width, height);
}
void draw(Graphics g){
}
}

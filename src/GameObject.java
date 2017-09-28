import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	int x=10;
	int y=10;
	int width;
	int height;

void update(){
	x++;
	y++;
	
}
void draw(Graphics g){
	g.fillRect(x, y, 20, 20);
}
}

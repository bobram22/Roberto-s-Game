import java.awt.Graphics;

public class GameObject {
	int x;
	int y;
	int width;
	int height;

void update(){
	
}
void draw(Graphics g){
	g.drawLine(10, 10, 80, 70);
	g.drawLine(10, 10, 10, 80);
	g.drawLine(10,80 ,80, 70);
}
}

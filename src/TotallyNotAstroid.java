import javax.swing.JFrame;

public class TotallyNotAstroid {
	JFrame f;
	GamePanel gp;
public static void main(String[] args) {
	TotallyNotAstroid TNA = new TotallyNotAstroid();
}
TotallyNotAstroid(){
	f = new JFrame();
	gp = new GamePanel();
	setup();
}
void setup(){
	f.add(gp);
	f.setSize(800, 800);
	f.setVisible(true);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.addKeyListener(gp);
}

}

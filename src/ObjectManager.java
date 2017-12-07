
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	ArrayList<GameObject> objects;
	Random num = new Random();
	private int score = 0;

	long enemyTimer = 0;
	int enemySpawnTime = 200;
	int numAstriods = 4;
	int numLives = 3;

	public ObjectManager() {
		objects = new ArrayList<GameObject>();
	}

	public void addObject(GameObject o) {
		objects.add(o);
	}

	public void update() {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.update();
		}
		checkCollision();
		purgeObjects();
	}

	public void draw(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.draw(g);
		}
	}

	private void purgeObjects() {
		for (int i = 0; i < objects.size(); i++) {
			if (!objects.get(i).isAlive) {
				objects.remove(i);
			}
		}
	}

	public void manageEnemies() {

	}

	public void makeAstriods() {
		for (int i = 0; i < 4; i++) {
			addObject(new Astriods(num.nextInt(500), num.nextInt(500), 50, 50, num.nextInt(10) - 5,
					num.nextInt(30) - 15));
		}
		numAstriods = 4;
	}

	public void checkCollision() {
		for (int i = 0; i < objects.size(); i++) {
			for (int j = i + 1; j < objects.size(); j++) {
				GameObject o1 = objects.get(i);
				GameObject o2 = objects.get(j);
				if (o1.isAlive && o2.isAlive) {
					if (o1.collisionBox.intersects(o2.collisionBox)) {
						if ((o1 instanceof Astriods && o2 instanceof Projectiles)
								|| (o2 instanceof Astriods && o1 instanceof Projectiles)) {

							score++;
							System.out.println(score);
							numAstriods--;
							o1.isAlive = false;
							o2.isAlive = false;
						}

						else if ((o1 instanceof Astriods && o2 instanceof Rocketship)
								|| (o2 instanceof Astriods && o1 instanceof Rocketship)) {
							numLives--;
							o1.isAlive = false;
							numAstriods--;
							o2.isAlive = false;
						}
					}
				}
			}
		}
	}

	public int getScore() {
		return score;
	}

	public void setScore(int s) {
		score = s;
	}

	public void reset() {
		objects.clear();
	}
}

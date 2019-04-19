package nl.han.ica.tetrismania;

import java.util.List;
import java.util.Random;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.tetrismania.Tetrismania;
import processing.core.PApplet;
import processing.core.PGraphics;

/**
 * dit is een steen
 * 
 * @author cc //TODO
 */
public class Steen extends GameObject implements ICollidableWithGameObjects {

	private int steenGrootte = 40;
	private String name;
	private boolean stop;
	private boolean coll;
	private boolean curr;
	private SteenTile t1;
	private SteenTile t2;
	private SteenTile t3;
	private SteenTile t4;
	String[] steenType = { "T", "V", "L", "S" };
	private int pos;

	public Steen(int x, int y, Tetrismania tm) {
		super(x, y, 140, 140);
		Random randint = new Random();
		stop = false;
		setCurr(true);
		pos = 0;
		int randomN = randint.nextInt(steenType.length);
		String typeS = steenType[randomN];
		name = typeS;
		switch (typeS) {
		case ("V"):
			t1 = new SteenTile(40, 40);
			t2 = new SteenTile(40, 80);
			t3 = new SteenTile(80, 40);
			t4 = new SteenTile(80, 80);
			tm.addGameObject(t1);
			tm.addGameObject(t2);
			tm.addGameObject(t3);
			tm.addGameObject(t4);
			break;

		case ("T"):
			t1 = new SteenTile(40, 40);
			t2 = new SteenTile(40, 80);
			t3 = new SteenTile(40, 120);
			t4 = new SteenTile(80, 80);
			tm.addGameObject(t1);
			tm.addGameObject(t2);
			tm.addGameObject(t3);
			tm.addGameObject(t4);

			break;

		case ("L"):
			t1 = new SteenTile(40, 40);
			t2 = new SteenTile(40, 80);
			t3 = new SteenTile(40, 120);
			t4 = new SteenTile(80, 120);
			tm.addGameObject(t1);
			tm.addGameObject(t2);
			tm.addGameObject(t3);
			tm.addGameObject(t4);

			break;

		case ("S"):
			t1 = new SteenTile(40, 40);
			t2 = new SteenTile(40, 80);
			t3 = new SteenTile(80, 80);
			t4 = new SteenTile(80, 120);
			tm.addGameObject(t1);
			tm.addGameObject(t2);
			tm.addGameObject(t3);
			tm.addGameObject(t4);

			break;
		}
	}

	@Override
	public void update() {
		if (!this.stop && this.getCurr()) {
			y += 1;
			int t1Y = t1.getyPos();
			int t2Y = t2.getyPos();
			int t3Y = t3.getyPos();
			int t4Y = t4.getyPos();
			t1.setyPos(t1Y + 1);
			t2.setyPos(t2Y + 1);
			t3.setyPos(t3Y + 1);
			t4.setyPos(t4Y + 1);


 		} 

		if (y >= 470) {
			this.stop = true;
			this.setCurr(false);
		}
	}

	public void steenNaarRechts() {
		x += 40;
		int t1X = t1.getxPos();
		int t2X = t2.getxPos();
		int t3X = t3.getxPos();
		int t4X = t4.getxPos();
		t1.setxPos(t1X + 40);
		t2.setxPos(t2X + 40);
		t3.setxPos(t3X + 40);
		t4.setxPos(t4X + 40);
	}

	public void steenNaarLinks() {
		x -= 40;
		int t1X = t1.getxPos();
		int t2X = t2.getxPos();
		int t3X = t3.getxPos();
		int t4X = t4.getxPos();
		t1.setxPos(t1X - 40);
		t2.setxPos(t2X - 40);
		t3.setxPos(t3X - 40);
		t4.setxPos(t4X - 40);
	}

	public void steenDraaiRechts() {
		if (this.getPos() == 3) {
			this.setPos(0);
		} else {
			this.setPos(this.getPos() + 1);
		}
		switch (this.name) {
		case ("V"):

			break;

		case ("T"):

			int[][] VxPlace = {
					{(int) x+40, (int) x+80, (int) x+120, (int) x+80},
					{(int) x+40,(int) x+40,(int) x+80,(int) x+40},
					{(int) x+80,(int) x+40,(int) x+80,(int) x+120},
					{(int) x+80,(int) x+40,(int) x+80,(int) x+80}
			};
			int[][] VyPlace = {
					{(int) y, (int) y, (int) y,(int) y+40},
					{(int) y, (int) y+40, (int) y+40,(int) y+80},
					{(int) y, (int) y+40, (int) y+40,(int) y+40},
					{(int) y, (int) y+40, (int) y+40,(int) y+80}
			};
			this.t1.setxPos(VxPlace[this.pos][0]);
			this.t1.setyPos(VyPlace[this.pos][0]);
			this.t2.setxPos(VxPlace[this.pos][1]);
			this.t2.setyPos(VyPlace[this.pos][1]);
			this.t3.setxPos(VxPlace[this.pos][2]);
			this.t3.setyPos(VyPlace[this.pos][2]);
			this.t4.setxPos(VxPlace[this.pos][3]);
			this.t4.setyPos(VyPlace[this.pos][3]);
			System.out.println(y);
			break;

		case ("L"):
			int[][] LxPlace = {
					{(int) x+40, (int) x+40, (int) x+40, (int) x+80},
					{(int) x+40,(int) x+80,(int) x+120,(int) x+40},
					{(int) x+40,(int) x+80,(int) x+80,(int) x+80},
					{(int) x+120,(int) x+40,(int) x+80,(int) x+120}
			};
			int[][] LyPlace = {
					{(int) y, (int) y+40, (int) y+80,(int) y+80},
					{(int) y, (int) y, (int) y,(int) y+40},
					{(int) y, (int) y, (int) y+40,(int) y+80},
					{(int) y, (int) y+40, (int) y+40,(int) y+40}
			};
			this.t1.setxPos(LxPlace[this.pos][0]);
			this.t1.setyPos(LyPlace[this.pos][0]);
			this.t2.setxPos(LxPlace[this.pos][1]);
			this.t2.setyPos(LyPlace[this.pos][1]);
			this.t3.setxPos(LxPlace[this.pos][2]);
			this.t3.setyPos(LyPlace[this.pos][2]);
			this.t4.setxPos(LxPlace[this.pos][3]);
			this.t4.setyPos(LyPlace[this.pos][3]);
			break;

		case ("S"):

			int[][] SxPlace = {
					{(int) x+40, (int) x+40, (int) x+80, (int) x+80},
					{(int) x+80,(int) x+120,(int) x+40,(int) x+80},
					{(int) x+40, (int) x+40, (int) x+80, (int) x+80},
					{(int) x+80,(int) x+120,(int) x+40,(int) x+80},
			};
			int[][] SyPlace = {
					{(int) y, (int) y+40, (int) y+40,(int) y+80},
					{(int) y, (int) y, (int) y+40,(int) y+40},
					{(int) y, (int) y+40, (int) y+40,(int) y+80},
					{(int) y, (int) y, (int) y+40,(int) y+40},
			};
			this.t1.setxPos(SxPlace[this.pos][0]);
			this.t1.setyPos(SyPlace[this.pos][0]);
			this.t2.setxPos(SxPlace[this.pos][1]);
			this.t2.setyPos(SyPlace[this.pos][1]);
			this.t3.setxPos(SxPlace[this.pos][2]);
			this.t3.setyPos(SyPlace[this.pos][2]);
			this.t4.setxPos(SxPlace[this.pos][3]);
			this.t4.setyPos(SyPlace[this.pos][3]);
			break;
		}
	}

	public void steenDraaiLinks() {
		if (this.getPos() == 0) {
			this.setPos(3);
		} else {
			this.setPos(this.getPos() - 1);
		}
	}

	public void steenNaarBodem() {
		this.y = 470;
		this.stop = true;
		this.setCurr(false);

	}

	public void steenNaarBeneden() {
		y += 10;
	}

	@Override
	public void draw(PGraphics g) {



	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		System.out.println(collidedGameObjects.size());
		
		
	}

	public boolean getCurr() {
		return curr;
	}

	public void setCurr(boolean curr) {
		this.curr = curr;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}
}
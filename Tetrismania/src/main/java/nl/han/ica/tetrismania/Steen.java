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
	private boolean curr;
	private SteenTile t1;
	private SteenTile t2;
	private SteenTile t3;
	private SteenTile t4;
	String[] steenType = { "T", "V", "L", "S" };
	private int pos;

	public Steen(int x, int y, Tetrismania tm) {
		super(x, y, 40, 40);
		Random randint = new Random();
		stop = false;
		setCurr(true);
		pos = 0;
		int randomN = randint.nextInt(steenType.length);
		String typeS = steenType[2];
		name = typeS;
		switch (typeS) {
		case ("V"):
			t1 = new SteenTile(40, 40);
			t2 = new SteenTile(40, 80);
			t3 = new SteenTile(80, 40);
			t4 = new SteenTile(80, 80);
			tm.addGameObject(t1, 38,38);
			tm.addGameObject(t2, 38,76);
			tm.addGameObject(t3, 76,38);
			tm.addGameObject(t4, 76,76);
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
			t1.setY(t1.getY() +1);
			t2.setY(t2.getY() +1);
			t3.setY(t3.getY() +1);
			t4.setY(t4.getY() +1);


 		} 

		if (y >= 470) {
			this.stop = true;
			this.setCurr(false);
		}
	}

	public void steenNaarRechts() {
		t1.setX(t1.getX() +40);
		t2.setX(t2.getX() +40);
		t3.setX(t3.getX() +40);
		t4.setX(t4.getX() +40);
	}

	public void steenNaarLinks() {
		t1.setX(t1.getX() -40);
		t2.setX(t2.getX() -40);
		t3.setX(t3.getX() -40);
		t4.setX(t4.getX() -40);
	}

	public void steenDraaiRechts() {
		
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
			this.t1.setX(VxPlace[this.pos][0]);
			this.t1.setY(VyPlace[this.pos][0]);
			this.t2.setX(VxPlace[this.pos][1]);
			this.t2.setY(VyPlace[this.pos][1]);
			this.t3.setX(VxPlace[this.pos][2]);
			this.t3.setY(VyPlace[this.pos][2]);
			this.t4.setX(VxPlace[this.pos][3]);
			this.t4.setY(VyPlace[this.pos][3]);
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
			this.t1.setX(LxPlace[this.pos][0]);
			this.t1.setY(LyPlace[this.pos][0]);
			this.t2.setX(LxPlace[this.pos][1]);
			this.t2.setY(LyPlace[this.pos][1]);
			this.t3.setX(LxPlace[this.pos][2]);
			this.t3.setY(LyPlace[this.pos][2]);
			this.t4.setX(LxPlace[this.pos][3]);
			this.t4.setY(LyPlace[this.pos][3]);
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
			this.t1.setX(SxPlace[this.pos][0]);
			this.t1.setY(SyPlace[this.pos][0]);
			this.t2.setX(SxPlace[this.pos][1]);
			this.t2.setY(SyPlace[this.pos][1]);
			this.t3.setX(SxPlace[this.pos][2]);
			this.t3.setY(SyPlace[this.pos][2]);
			this.t4.setX(SxPlace[this.pos][3]);
			this.t4.setY(SyPlace[this.pos][3]);
			break;
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
		System.out.println("Collasdasd");
		
	}

	public boolean getCurr() {
		return curr;
	}

	public void setCurr(boolean curr) {
		this.curr = curr;
	}
}
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
	public enum Rot { S,R,B,L}; // .ordinal();
	private String name;
	private boolean stop;
	private boolean coll;
	private boolean curr;
	String[] steenType = { "T", "V", "L", "S" };
	private Tetrismania tm; 
	private int pos;

	public Steen(int x, int y) {
		super(x, y, 140, 140);
		Random randint = new Random();
		stop = false;
		coll = false;
		setCurr(true);

		int pos = 0;
		int randomN = randint.nextInt(steenType.length);
		this.name = steenType[randomN];
	}

	@Override
	public void update() {
		if (!this.stop && !this.coll && this.getCurr()) {
			y += 1;

 		} 

		if (y >= 470) {
			this.stop = true;
			this.setCurr(false);
		}

	}

	public void groei() {
		this.steenGrootte += 10;
	}

	public void steenNaarRechts() {
		this.x += 10;
	}

	public void steenNaarLinks() {
		this.x -= 10;
	}

	public void steenDraaiRechts() {
		if (this.getPos() == 3) {
			this.setPos(0);
		} else {
			this.setPos(this.getPos() + 1);
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
		g.noStroke();
		switch (this.name) {
		case ("V"):

			g.rect(x, y, steenGrootte, steenGrootte);
			g.rect(x + steenGrootte, y + steenGrootte, steenGrootte, steenGrootte);
			g.rect(x, y + steenGrootte, steenGrootte, steenGrootte);
			g.rect(x + steenGrootte, y, steenGrootte, steenGrootte);
			break;
			
		case ("T"):
			
			int[][] VxPlace = {
					{(int) x+40, (int) x+80, (int) x+120, (int) x+80},
					{(int) x+40,(int) x+40,(int) x+80,(int) x+40},
					{(int) x+80,(int) x+40,(int) x+80,(int) x+120},
					{(int) x+80,(int) x+40,(int) x+80,(int) x+80}
			};
			int[][] VyPlace = {
					{(int) y, (int) y, (int) y,(int) (y+40)},
					{(int) y, (int) y+40, (int) y+40,(int) (y+80)},
					{(int) y, (int) y+40, (int) y+40,(int) (y+40)},
					{(int) y, (int) y+40, (int) y+40,(int) (y+80)}
			};
			g.rect(VxPlace[this.getPos()][0], VyPlace[this.getPos()][0], steenGrootte, steenGrootte);
			g.rect(VxPlace[this.getPos()][1], VyPlace[this.getPos()][1], steenGrootte, steenGrootte);
			g.rect(VxPlace[this.getPos()][2], VyPlace[this.getPos()][2], steenGrootte, steenGrootte);
			g.rect(VxPlace[this.getPos()][3], VyPlace[this.getPos()][3], steenGrootte, steenGrootte);
			break;
			
		case ("L"):
			
			int[][] LxPlace = {
					{(int) x+40, (int) x+40, (int) x+40, (int) x+80},
					{(int) x+40,(int) x+80,(int) x+120,(int) x+40},
					{(int) x+40,(int) x+80,(int) x+80,(int) x+80},
					{(int) x+120,(int) x+40,(int) x+80,(int) x+120}
			};
			int[][] LyPlace = {
					{(int) y, (int) y+40, (int) y+80,(int) (y+80)},
					{(int) y, (int) y, (int) y,(int) (y+40)},
					{(int) y, (int) y, (int) y+40,(int) (y+80)},
					{(int) y, (int) y+40, (int) y+40,(int) (y+40)}
			};
			g.rect(LxPlace[this.getPos()][0], LyPlace[this.getPos()][0], steenGrootte, steenGrootte);
			g.rect(LxPlace[this.getPos()][1], LyPlace[this.getPos()][1], steenGrootte, steenGrootte);
			g.rect(LxPlace[this.getPos()][2], LyPlace[this.getPos()][2], steenGrootte, steenGrootte);
			g.rect(LxPlace[this.getPos()][3], LyPlace[this.getPos()][3], steenGrootte, steenGrootte);
			break;
			
		case ("S"):
			
			int[][] SxPlace = {
					{(int) x+40,(int) x+40,(int) x+80,(int) x+80},
					{(int) x+80,(int) x+120,(int) x+40,(int) x+80},
					{(int) x+40,(int) x+40,(int) x+80,(int) x+80},
					{(int) x+80,(int) x+120,(int) x+40,(int) x+80},
			};
			int[][] SyPlace = {
					{(int) y, (int) y+40, (int) y+40,(int) (y+80)},
					{(int) y, (int) y, (int) y+40,(int) (y+40)},
					{(int) y, (int) y+40, (int) y+40,(int) (y+80)},
					{(int) y, (int) y, (int) y+40,(int) (y+40)},
			};

			g.rect(SxPlace[this.getPos()][0], SyPlace[this.getPos()][0], steenGrootte, steenGrootte);
			g.rect(SxPlace[this.getPos()][1], SyPlace[this.getPos()][1], steenGrootte, steenGrootte);
			g.rect(SxPlace[this.getPos()][2], SyPlace[this.getPos()][2], steenGrootte, steenGrootte);
			g.rect(SxPlace[this.getPos()][3], SyPlace[this.getPos()][3], steenGrootte, steenGrootte);
			break;
		}

	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		stop = true;
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
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
public class SteenTile extends GameObject implements ICollidableWithGameObjects {

	protected boolean move;
	public SteenTile(int x, int y) {
		super(x, y, 38, 38);
		move = true;
		this.setX(x);
		this.setY(y);
	}

	@Override
	public void update() {		
		if (move) {
			this.setY(this.getY() + 1);
		}
	}

	@Override
	public void draw(PGraphics g) {
		g.fill(255,0,0);
		g.rect(getX(), getY(), 40, 40);	
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		System.out.println("coll" + collidedGameObjects.size());
		
	}

}
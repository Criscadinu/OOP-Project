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

	private int xPos;
	private int yPos;
	public SteenTile(int x, int y) {
		this.setxPos(x);
		this.setyPos(y);
	}

	@Override
	public void update() {		
		
	}

	@Override
	public void draw(PGraphics g) {
		g.fill(255,0,0);
		g.rect(getxPos(), getyPos(), 40, 40);	
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		System.out.println("coll" + collidedGameObjects.size());
		
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
}
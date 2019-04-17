package nl.han.ica.tetrismania;

import java.util.List;
import java.util.Random;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
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
	String[] steenType = { "T", "V", "L", "S" };

	public Steen(int x, int y) {
		super(x, y, 40, 40);
		Random randint = new Random();
		stop = false;

		int test = randint.nextInt(steenType.length);
		this.name = steenType[test];
	}

	@Override
	public void update() {
		if (!stop) {
			y += 1;

 		}
		if (y == 750) {
			stop = true;
		}

	}

	public void groei() {
		steenGrootte += 10;
	}

	public void steenNaarRechts() {
		x += 10;
	}

	public void steenNaarLinks() {
		x -= 10;
	}

	public void steenNaarBodem() {
		y = 870;
		stop = true;

	}
	
	public void steenNaarBeneden() {
		y += 10;
	}

	@Override
	public void draw(PGraphics g) {
		switch (this.name) {
		case ("V"):

			g.rect(x, y, steenGrootte, steenGrootte);
			g.rect(x + steenGrootte, y + steenGrootte, steenGrootte, steenGrootte);
			g.rect(x, y + steenGrootte, steenGrootte, steenGrootte);
			g.rect(x + steenGrootte, y, steenGrootte, steenGrootte);
			break;
		case ("T"):

			g.rect(x, y, steenGrootte, steenGrootte);
			g.rect(x + steenGrootte, y, steenGrootte, steenGrootte);
			g.rect(x + steenGrootte * 2, y, steenGrootte, steenGrootte);
			g.rect(x + steenGrootte, y + steenGrootte, steenGrootte, steenGrootte);
			break;
		case ("L"):

			g.rect(x, y, steenGrootte, steenGrootte);
			g.rect(x + steenGrootte, y, steenGrootte, steenGrootte);
			g.rect(x + steenGrootte * 2, y, steenGrootte, steenGrootte);
			g.rect(x + steenGrootte * 2, y + steenGrootte, steenGrootte, steenGrootte);
			break;
		case ("S"):

			g.rect(x + steenGrootte, y, steenGrootte, steenGrootte);
			g.rect(x + steenGrootte, y + steenGrootte, steenGrootte, steenGrootte);
			g.rect(x, y + steenGrootte, steenGrootte, steenGrootte);
			g.rect(x + steenGrootte * 2, y, steenGrootte, steenGrootte);
			break;
		}

	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		System.out.println("BOTSING");
	}
}
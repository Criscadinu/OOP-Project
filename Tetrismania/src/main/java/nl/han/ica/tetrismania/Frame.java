package nl.han.ica.tetrismania;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import processing.core.PGraphics;

public class Frame extends GameObject implements ICollidableWithGameObjects {

	public Frame(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
	}

	@Override
	public void update() {

	}

	@Override
	public void draw(PGraphics g) {
		// onzichtbaar element, hoeft niks te tekenen
	}

}

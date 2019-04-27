package nl.han.ica.tetrismania;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import processing.core.PGraphics;

/**
 * dit is een steen
 * 
 * @author cc //TODO
 */
public class SteenTile extends GameObject implements ICollidableWithGameObjects {

	public final static int GROOTTE = 40;
	private boolean gestopt = false;
	private Steen steen;

	private int ms;

	public SteenTile(int x, int y, Steen steen) {
		super(x, y, GROOTTE, GROOTTE);
		this.steen = steen;

		ms = 0;
	}

	@Override
	public void update() {

		ms++;
		if (ms % 40 == 1) {
			if (!gestopt) {
				y += 40;
			}
			ms = 1;
		}

	}

	@Override
	public void draw(PGraphics g) {
		g.fill(255, 0, 0);
		g.rect(x, y, width, height);
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		steen.stop();
		for(int i = 0; i < collidedGameObjects.size(); i++) {
			System.out.println(collidedGameObjects.get(i).getX());
			System.out.println(collidedGameObjects.get(i).getY());
		}
		

	}

	public void stop() {
		if (!gestopt)
			y -= 40;
		gestopt = true;

	}

}
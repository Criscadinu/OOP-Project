package nl.han.ica.tetrismania;

import java.util.List;
import java.util.Random;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.tetrismania.stenen.Vierkant;
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
	private int r, g, b;

	private int ms;

	public SteenTile(int x, int y, int r, int g, int b, Steen steen) {
		super(x, y, GROOTTE, GROOTTE);
		this.steen = steen;
		this.r = r;
		this.g = g;
		this.b = b;

		ms = 0;
	}
	/**
	 * 
	 * @author Cris
	 *
	 */
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

	/**
	 * 
	 * @author Cris
	 *
	 */
	@Override
	public void draw(PGraphics p) {
		p.fill(r, g, b);
		p.rect(x, y, width, height);
	}

	/**
	 * 
	 * @author Cris
	 *
	 */
	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		steen.stop();
	}

	/**
	 * 
	 * @author Cris
	 *
	 */
	public void stop() {
		if (!gestopt)
			y -= 40;
		gestopt = true;

	}

}
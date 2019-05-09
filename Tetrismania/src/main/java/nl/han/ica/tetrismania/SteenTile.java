package nl.han.ica.tetrismania;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import processing.core.PGraphics;

/**
 * 
 * @author Danny & Cris
 * In deze klasse wordt een Steentile-object aangemaakt.
 * In een Steen-object zitten 4 Steentiles. Hier wordt ook de collision op gedecteerd (per Steentile).
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
	 *  Methode-omschrijving:
	 *  Hier wordt een steentile getekend.
	 *
	 */
	@Override
	public void draw(PGraphics p) {
		p.fill(r, g, b);
		p.rect(x, y, width, height);
	}

	/**
	 * 
	 *  Methode-omschrijving:
	 *  Collision detectie vindt hier plaats. Als er collision is dan stopt het Steen-object.
	 *
	 */
	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		steen.stop();
	}

	/**
	 * 
	 * Methode-omschrijving:
	 * Per tile de y-versnelling stoppen.
	 *
	 */
	public void stop() {
		if (!gestopt)
			y -= 40;
		gestopt = true;

	}

}
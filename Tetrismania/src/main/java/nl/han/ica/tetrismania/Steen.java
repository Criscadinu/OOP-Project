package nl.han.ica.tetrismania;

/**
 * dit is een steen
 * 
 * @author cc //TODO
 */
public abstract class Steen {

	protected SteenTile[] tiles = new SteenTile[4];
	protected boolean gestopt = false;

	public final static double GRAVITY_SPEED = 0.2;

	
	public Steen() {
	}

	public void naarLinks() {
		if(!gestopt) {
		for (int i = 0; i < tiles.length; i++) {
			tiles[i].setX(tiles[i].getX() - 40);
		}
		}
	}

	public void naarRechts() {
		if(!gestopt) {
		for (int i = 0; i < tiles.length; i++) {
			tiles[i].setX(tiles[i].getX() + 40);
		}
		}
	}

	public void naarBeneden() {
		if(!gestopt) {
			for (int i = 0; i < tiles.length; i++) {

				tiles[i].setY(tiles[i].getY() + 40 );
			}}

	}

	public void valNaarBodem() {

	}

	public void stop() {
		for (int i = 0; i < tiles.length; i++) {
			tiles[i].stop();
		}
		gestopt = true;
	}

	public abstract void draaiLinksom();

	public abstract void draaiRechtsom();

}
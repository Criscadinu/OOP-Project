package nl.han.ica.tetrismania;

/**
 * dit is een steen
 * 
 * @author cc //TODO
 */
public abstract class Steen {

	protected SteenTile[] tiles = new SteenTile[4];
	protected boolean gestopt = false;

	protected Tetrismania tm;
	public final static double GRAVITY_SPEED = 0.2;
	private static final int GROOTTE = 40;

	public Steen(Tetrismania tm) {
		this.tm = tm;
	}

	/**
	 * 
	 * @author Danny
	 *
	 */
	public void naarLinks() {
		if (!gestopt) {
			for (int i = 0; i < tiles.length; i++) {
				if (tiles[i].getX() == 0) {
					return;
				}
			}
			if (tm.geplaatsteTiles.size() != 0) {
				for (SteenTile steen : tm.geplaatsteTiles) {
					float x = steen.getX();
					float y = steen.getY();
					for (int i = 0; i < tiles.length; i++) {
						if (tiles[i].getX()-40 == x && tiles[i].getY() == y) {
							return;
						}
					}
				}
				for (int i = 0; i < tiles.length; i++) {
					tiles[i].setX(tiles[i].getX() - 40);
				}
			} else {
				for (int i = 0; i < tiles.length; i++) {
					tiles[i].setX(tiles[i].getX() - 40);
				}

			}
		}
	}

	/**
	 * 
	 * @author Danny
	 *
	 */
	public void naarRechts() {
		if (!gestopt) {
			for (int i = 0; i < tiles.length; i++) {
				if (tiles[i].getX() == 600 - 40) {
					return;
				}
			}
			if (tm.geplaatsteTiles.size() != 0) {
				for (SteenTile steen : tm.geplaatsteTiles) {
					float x = steen.getX();
					float y = steen.getY();
					for (int i = 0; i < tiles.length; i++) {
						if (tiles[i].getX() + 40 == x && tiles[i].getY() == y) {
							System.out.println("doesnt work");
							return;
						}
					}
				}
				for (int i = 0; i < tiles.length; i++) {
					tiles[i].setX(tiles[i].getX() + 40);
				}
			} else {
				for (int i = 0; i < tiles.length; i++) {
					tiles[i].setX(tiles[i].getX() + 40);
				}

			}
		}
	}

	/**
	 * 
	 * @author Danny
	 *
	 */
	public void naarBeneden() {
		if (!gestopt) {
			for (int i = 0; i < tiles.length; i++) {

				tiles[i].setY(tiles[i].getY() + 40);
			}
		}

	}

	/**
	 * 
	 * @author Cris
	 *
	 */
	public abstract void valNaarBodem();

	public void checkInVeld() {
		if (tiles[0].getX() < 0 || tiles[1].getX() < 0 || tiles[2].getX() < 0 || tiles[3].getX() < 0) {
			tiles[0].setX(tiles[0].getX() + 40);
			tiles[1].setX(tiles[1].getX() + 40);
			tiles[2].setX(tiles[2].getX() + 40);
			tiles[3].setX(tiles[3].getX() + 40);
		}
		if (tiles[0].getX() > 600 - 40 || tiles[1].getX() > 600 - 40 || tiles[2].getX() > 600 - 40
				|| tiles[3].getX() > 600 - 40) {
			tiles[0].setX(tiles[0].getX() - 40);
			tiles[1].setX(tiles[1].getX() - 40);
			tiles[2].setX(tiles[2].getX() - 40);
			tiles[3].setX(tiles[3].getX() - 40);
		}
	}

	/**
	 * 
	 * @author Danny
	 *
	 */
	public void stop() {
		for (int i = 0; i < tiles.length; i++) {
			tiles[i].stop();
		}
		gestopt = true;
	}

	/**
	 * 
	 * @author Cris
	 *
	 */
	public abstract void draaiLinksom();

	/**
	 * 
	 * @author Cris
	 *
	 */
	public abstract void draaiRechtsom();

}
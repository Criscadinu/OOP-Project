package nl.han.ica.tetrismania.stenen;

import nl.han.ica.tetrismania.Steen;
import nl.han.ica.tetrismania.SteenTile;
import nl.han.ica.tetrismania.Tetrismania;

/**
 * 
 * @author Cris & Danny
 * De LVorm rechts
 *
 */
public class LVormRechts extends Steen {

	private int positie;


	public LVormRechts(int x, int y, int r, int g, int b, Tetrismania tetrismania) {
		super(r, g, b, tetrismania);
		tekenLvormRechts(x, y, tetrismania);

	}

	private void tekenLvormRechts(int x, int y,  Tetrismania tetrismania) {
		SteenTile steenLBoven = new SteenTile(x, y, r, g, b, this);
		SteenTile steenMiddenLinks = new SteenTile(x, y + 40, r, g, b, this);
		SteenTile steenMiddenRechts = new SteenTile(x, y + 80, r, g, b, this);
		SteenTile steenRBeneden = new SteenTile(x + 40, y + 80, r, g, b, this);
		tiles[0] = steenLBoven;
		tiles[1] = steenMiddenLinks;
		tiles[2] = steenMiddenRechts;
		tiles[3] = steenRBeneden;
		tetrismania.addGameObject(steenLBoven);
		tetrismania.addGameObject(steenMiddenLinks);
		tetrismania.addGameObject(steenMiddenRechts);
		tetrismania.addGameObject(steenRBeneden);
	}

	/**
	 * 
	 * Methode-omschrijving: Hier vindt een controle plaats zodat die niet met een
	 * andere steen kan samenmelten.
	 */

	private boolean isLinksMogelijk() {
		for (SteenTile st : super.tm.geplaatsteTiles) {
			float x = st.getX();
			float y = st.getY();
			for (int i = 0; i < 3; i++) {
				if (tiles[i].getX() - 40 == x && tiles[i].getY() == y) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean isRechtsMogelijk() {
		for (SteenTile st : super.tm.geplaatsteTiles) {
			float x = st.getX();
			float y = st.getY();
			for (int i = 0; i < 3; i++) {
				if (tiles[i].getX() + 40 == x && tiles[i].getY() == y) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public void draaiLinksom() {
		if (positie == 3) {
			positie = 0;
		} else {
			positie += 1;
		}
		if (isRechtsMogelijk()) {
			switch (positie) {
			case 0:
				tiles[0].setX(tiles[0].getX() + 40);
				tiles[1].setX(tiles[1].getX() + 0);
				tiles[2].setX(tiles[2].getX() - 40);
				tiles[3].setX(tiles[3].getX() + 0);

				tiles[0].setY(tiles[0].getY() - 40);
				tiles[1].setY(tiles[1].getY() + 0);
				tiles[2].setY(tiles[2].getY() + 40);
				tiles[3].setY(tiles[3].getY() + 80);
				break;
			case 1:
				tiles[0].setX(tiles[0].getX() + 40);
				tiles[1].setX(tiles[1].getX() + 0);
				tiles[2].setX(tiles[2].getX() - 40);
				tiles[3].setX(tiles[3].getX() - 80);

				tiles[0].setY(tiles[0].getY() + 40);
				tiles[1].setY(tiles[1].getY() + 0);
				tiles[2].setY(tiles[2].getY() - 40);
				tiles[3].setY(tiles[3].getY() + 0);
				break;
			case 2:
				tiles[0].setX(tiles[0].getX() - 40);
				tiles[1].setX(tiles[1].getX() + 0);
				tiles[2].setX(tiles[2].getX() + 40);
				tiles[3].setX(tiles[3].getX() + 0);

				tiles[0].setY(tiles[0].getY() + 40);
				tiles[1].setY(tiles[1].getY() + 0);
				tiles[2].setY(tiles[2].getY() - 40);
				tiles[3].setY(tiles[3].getY() - 80);
				break;
			case 3:
				tiles[0].setX(tiles[0].getX() - 40);
				tiles[1].setX(tiles[1].getX() + 0);
				tiles[2].setX(tiles[2].getX() + 40);
				tiles[3].setX(tiles[3].getX() + 80);

				tiles[0].setY(tiles[0].getY() - 40);
				tiles[1].setY(tiles[1].getY() + 0);
				tiles[2].setY(tiles[2].getY() + 40);
				tiles[3].setY(tiles[3].getY() + 0);
				break;
			}
		}

		this.checkInVeld();
	}

	@Override
	public void draaiRechtsom() {
		if (positie == 3) {
			positie = 0;
		} else {
			positie += 1;
		}
		if (isLinksMogelijk()) {
			switch (positie) {
			case 0:
				tiles[0].setX(tiles[0].getX() - 40);
				tiles[1].setX(tiles[1].getX() + 0);
				tiles[2].setX(tiles[2].getX() + 40);
				tiles[3].setX(tiles[3].getX() + 80);

				tiles[0].setY(tiles[0].getY() - 40);
				tiles[1].setY(tiles[1].getY() + 0);
				tiles[2].setY(tiles[2].getY() + 40);
				tiles[3].setY(tiles[3].getY() + 0);
				break;
			case 1:
				tiles[0].setX(tiles[0].getX() - 40);
				tiles[1].setX(tiles[1].getX() + 0);
				tiles[2].setX(tiles[2].getX() + 40);
				tiles[3].setX(tiles[3].getX() + 0);

				tiles[0].setY(tiles[0].getY() + 40);
				tiles[1].setY(tiles[1].getY() + 0);
				tiles[2].setY(tiles[2].getY() - 40);
				tiles[3].setY(tiles[3].getY() - 80);
				break;
			case 2:
				tiles[0].setX(tiles[0].getX() + 40);
				tiles[1].setX(tiles[1].getX() + 0);
				tiles[2].setX(tiles[2].getX() - 40);
				tiles[3].setX(tiles[3].getX() - 80);

				tiles[0].setY(tiles[0].getY() + 40);
				tiles[1].setY(tiles[1].getY() + 0);
				tiles[2].setY(tiles[2].getY() - 40);
				tiles[3].setY(tiles[3].getY() + 0);
				break;
			case 3:
				tiles[0].setX(tiles[0].getX() + 40);
				tiles[1].setX(tiles[1].getX() + 0);
				tiles[2].setX(tiles[2].getX() - 40);
				tiles[3].setX(tiles[3].getX() + 0);

				tiles[0].setY(tiles[0].getY() - 40);
				tiles[1].setY(tiles[1].getY() + 0);
				tiles[2].setY(tiles[2].getY() + 40);
				tiles[3].setY(tiles[3].getY() + 80);
				break;
			}
		}
		this.checkInVeld();

	}

}

package nl.han.ica.tetrismania.stenen;

import nl.han.ica.tetrismania.Steen;
import nl.han.ica.tetrismania.SteenTile;
import nl.han.ica.tetrismania.Tetrismania;

/**
 * 
 * @author Cris & Danny
 * Dit is de LVorm Links
 *
 */
public class LVormLinks extends Steen {

	private int positie;


	public LVormLinks(int x, int y, int r, int g, int b, Tetrismania tetrismania) {
		super(r, g, b, tetrismania);
		tekenLvormLinks(x, y, tetrismania);

	}


	private void tekenLvormLinks(int x, int y, Tetrismania tetrismania) {
		positie = 0;
		SteenTile steenBoven = new SteenTile(x, y, r, g, b, this);
		SteenTile steenMidden = new SteenTile(x, y + 40, r, g, b, this);
		SteenTile steenBeneden = new SteenTile(x, y + 80, r, g, b, this);
		SteenTile steenBenedenLinks = new SteenTile(x - 40, y + 80, r, g, b, this);
		tiles[0] = steenBoven;
		tiles[1] = steenMidden;
		tiles[2] = steenBeneden;
		tiles[3] = steenBenedenLinks;
		tetrismania.addGameObject(steenBoven);
		tetrismania.addGameObject(steenMidden);
		tetrismania.addGameObject(steenBeneden);
		tetrismania.addGameObject(steenBenedenLinks);
	}

		
	/**
	 * 
	 * Methode-omschrijving:
	 * Hier vindt een controle plaats zodat die niet met een andere steen kan samenmelten.
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
				tiles[3].setY(tiles[3].getY() - 80);
				break;
			case 1:
				tiles[0].setX(tiles[0].getX() + 40);
				tiles[1].setX(tiles[1].getX() + 0);
				tiles[2].setX(tiles[2].getX() - 40);
				tiles[3].setX(tiles[3].getX() + 0);

				tiles[0].setY(tiles[0].getY() + 40);
				tiles[1].setY(tiles[1].getY() + 0);
				tiles[2].setY(tiles[2].getY() - 40);
				tiles[3].setY(tiles[3].getY() - 80);
				break;
			case 2:
				tiles[0].setX(tiles[0].getX() - 40);
				tiles[1].setX(tiles[1].getX() + 0);
				tiles[2].setX(tiles[2].getX() + 40);
				tiles[3].setX(tiles[3].getX() + 80);

				tiles[0].setY(tiles[0].getY() + 40);
				tiles[1].setY(tiles[1].getY() + 0);
				tiles[2].setY(tiles[2].getY() - 40);
				tiles[3].setY(tiles[3].getY() + 0);
				break;
			case 3:
				tiles[0].setX(tiles[0].getX() - 40);
				tiles[1].setX(tiles[1].getX() + 0);
				tiles[2].setX(tiles[2].getX() + 40);
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

	/**
	 * 
	 */

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
				tiles[3].setX(tiles[3].getX() + 0);

				tiles[0].setY(tiles[0].getY() - 40);
				tiles[1].setY(tiles[1].getY() + 0);
				tiles[2].setY(tiles[2].getY() + 40);
				tiles[3].setY(tiles[3].getY() + 80);
				break;
			case 1:
				tiles[0].setX(tiles[0].getX() - 40);
				tiles[1].setX(tiles[1].getX() + 0);
				tiles[2].setX(tiles[2].getX() + 40);
				tiles[3].setX(tiles[3].getX() + 80);

				tiles[0].setY(tiles[0].getY() + 40);
				tiles[1].setY(tiles[1].getY() + 0);
				tiles[2].setY(tiles[2].getY() - 40);
				tiles[3].setY(tiles[3].getY() + 0);
				break;
			case 2:
				tiles[0].setX(tiles[0].getX() + 40);
				tiles[1].setX(tiles[1].getX() + 0);
				tiles[2].setX(tiles[2].getX() - 40);
				tiles[3].setX(tiles[3].getX() + 0);

				tiles[0].setY(tiles[0].getY() + 40);
				tiles[1].setY(tiles[1].getY() + 0);
				tiles[2].setY(tiles[2].getY() - 40);
				tiles[3].setY(tiles[3].getY() - 80);
				break;
			case 3:
				tiles[0].setX(tiles[0].getX() + 40);
				tiles[1].setX(tiles[1].getX() + 0);
				tiles[2].setX(tiles[2].getX() - 40);
				tiles[3].setX(tiles[3].getX() - 80);

				tiles[0].setY(tiles[0].getY() - 40);
				tiles[1].setY(tiles[1].getY() + 0);
				tiles[2].setY(tiles[2].getY() + 40);
				tiles[3].setY(tiles[3].getY() + 0);
				break;
			}
		}
		this.checkInVeld();
	}


}

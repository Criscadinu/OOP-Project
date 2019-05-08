package nl.han.ica.tetrismania.stenen;

import nl.han.ica.tetrismania.Steen;
import nl.han.ica.tetrismania.SteenTile;
import nl.han.ica.tetrismania.Tetrismania;

public class LvormRechts extends Steen {
	
	private int positie;
	private int r, g, b;

	public LvormRechts(int x, int y, int r, int g, int b, Tetrismania tetrismania) {
		this.r = r;
		this.g = g;
		this.b = b;
		tekenLvormRechts(x, y, this.r, this.g, this.b, tetrismania);

	}

	private void tekenLvormRechts(int x, int y, int r, int g, int b, Tetrismania tetrismania) {
		SteenTile steenLBoven = new SteenTile(x , y, r, g, b, this);
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

	@Override
	public void draaiLinksom() {
		if (positie == 3) {
			positie = 0;
		} else {
			positie += 1;
		}
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

	@Override
	public void draaiRechtsom() {
		if (positie == 3) {
			positie = 0;
		} else {
			positie += 1;
		}
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

	@Override
	public void valNaarBodem() {
		// TODO Auto-generated method stub
		
	}

}
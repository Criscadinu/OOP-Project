package nl.han.ica.tetrismania.stenen;

import nl.han.ica.tetrismania.Steen;
import nl.han.ica.tetrismania.SteenTile;
import nl.han.ica.tetrismania.Tetrismania;

public class LvormLinks extends Steen {

	private int positie;

	public LvormLinks(int x, int y, Tetrismania tm) {
		tekenLvormLinks(x, y, tm);

	}

	private void tekenLvormLinks(int x, int y, Tetrismania app) {
		SteenTile steenBoven = new SteenTile(x + 40, y, this);
		SteenTile steenMidden = new SteenTile(x + 40, y + 40, this);
		SteenTile steenBeneden = new SteenTile(x + 40, y + 80, this);
		SteenTile steenBenedenLinks = new SteenTile(x, y + 80, this);
		tiles[0] = steenBoven;
		tiles[1] = steenMidden;
		tiles[2] = steenBeneden;
		tiles[3] = steenBenedenLinks;
		app.addGameObject(steenBoven);
		app.addGameObject(steenMidden);
		app.addGameObject(steenBeneden);
		app.addGameObject(steenBenedenLinks);
	}

	@Override
	public void draaiLinksom() {
		System.out.println(positie);
		if (positie == 3) {
			positie = 0;
		} else {
			positie += 1;
		}
		System.out.println(positie);
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

	@Override
	public void draaiRechtsom() {
		// TODO Auto-generated method stub

	}

}

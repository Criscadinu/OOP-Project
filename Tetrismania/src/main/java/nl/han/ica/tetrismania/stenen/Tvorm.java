package nl.han.ica.tetrismania.stenen;

import nl.han.ica.tetrismania.Steen;
import nl.han.ica.tetrismania.SteenTile;
import nl.han.ica.tetrismania.Tetrismania;

public class Tvorm extends Steen {

	private int positie;

	public Tvorm(int x, int y, Tetrismania tm, int randomPos) {
		tekenVierkant(x, y, tm, randomPos);
	}

	private void tekenVierkant(int x, int y, Tetrismania app, int randomPos) {
		positie = 0;
		SteenTile steenLBoven = new SteenTile(x, y, this);
		SteenTile steenRBoven = new SteenTile(x + 40, y, this);
		SteenTile steenLBeneden = new SteenTile(x + 80, y, this);
		SteenTile steenRBeneden = new SteenTile(x + 40, y + 40, this);
		tiles[0] = steenLBoven;
		tiles[1] = steenRBoven;
		tiles[2] = steenLBeneden;
		tiles[3] = steenRBeneden;
		app.addGameObject(steenLBoven);
		app.addGameObject(steenRBoven);
		app.addGameObject(steenLBeneden);
		app.addGameObject(steenRBeneden);
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
			tiles[3].setX(tiles[3].getX() + 40);

			tiles[0].setY(tiles[0].getY() + 40);
			tiles[1].setY(tiles[1].getY() + 0);
			tiles[2].setY(tiles[2].getY() - 40);
			tiles[3].setY(tiles[3].getY() + 40);
			break;
		case 1:
			tiles[0].setX(tiles[0].getX() + 40);
			tiles[1].setX(tiles[1].getX() + 0);
			tiles[2].setX(tiles[2].getX() - 40);
			tiles[3].setX(tiles[3].getX() + 40);

			tiles[0].setY(tiles[0].getY() + 80);
			tiles[1].setY(tiles[1].getY() + 40);
			tiles[2].setY(tiles[2].getY() + 0);
			tiles[3].setY(tiles[3].getY() + 0);
			break;
		case 2:
			tiles[0].setX(tiles[0].getX() + 40);
			tiles[1].setX(tiles[1].getX() + 0);
			tiles[2].setX(tiles[2].getX() - 40);
			tiles[3].setX(tiles[3].getX() - 40);

			tiles[0].setY(tiles[0].getY() - 40);
			tiles[1].setY(tiles[1].getY() + 0);
			tiles[2].setY(tiles[2].getY() + 40);
			tiles[3].setY(tiles[3].getY() - 40);
			break;
		case 3:
			tiles[0].setX(tiles[0].getX() - 40);
			tiles[1].setX(tiles[1].getX() + 0);
			tiles[2].setX(tiles[2].getX() + 40);
			tiles[3].setX(tiles[3].getX() - 40);

			tiles[0].setY(tiles[0].getY() - 40);
			tiles[1].setY(tiles[1].getY() + 0);
			tiles[2].setY(tiles[2].getY() + 40);
			tiles[3].setY(tiles[3].getY() + 40);
			break;
		}
	}

	@Override
	public void draaiRechtsom() {
	}

}

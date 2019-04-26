package nl.han.ica.tetrismania.stenen;

import nl.han.ica.tetrismania.Steen;
import nl.han.ica.tetrismania.SteenTile;
import nl.han.ica.tetrismania.Tetrismania;

public class Vierkant extends Steen {

	public Vierkant(int x, int y, Tetrismania tm) {
		tekenVierkant(x, y, tm);

	}

	private void tekenVierkant(int x, int y, Tetrismania app) {
		SteenTile steenLBoven = new SteenTile(x, y, this);
		SteenTile steenRBoven = new SteenTile(x + 40, y, this);
		SteenTile steenLBeneden = new SteenTile(x, y + 40, this);
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
	}

	@Override
	public void draaiRechtsom() {
	}

}

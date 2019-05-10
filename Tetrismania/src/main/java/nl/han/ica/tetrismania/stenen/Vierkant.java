package nl.han.ica.tetrismania.stenen;

import nl.han.ica.tetrismania.Steen;
import nl.han.ica.tetrismania.SteenTile;
import nl.han.ica.tetrismania.Tetrismania;

public class Vierkant extends Steen {
	Tetrismania tetrismania;
	private int r, g, b;

	public Vierkant(int x, int y, int r, int g, int b, Tetrismania tetrismania) {
		super(tetrismania);
		this.r = r;
		this.g = g;
		this.b = b;
		tekenVierkant(x, y, this.r, this.g, this.b, tetrismania);
		this.tetrismania = tetrismania;
	}

	private void tekenVierkant(int x, int y, int r, int g, int b, Tetrismania tetrismania) {
		SteenTile steenLBoven = new SteenTile(x, y, r, g, b, this);
		SteenTile steenRBoven = new SteenTile(x + 40, y, r, g, b, this);
		SteenTile steenLBeneden = new SteenTile(x, y + 40, r, g, b, this);
		SteenTile steenRBeneden = new SteenTile(x + 40, y + 40, r, g, b, this);
		tiles[0] = steenLBoven;
		tiles[1] = steenRBoven;
		tiles[2] = steenLBeneden;
		tiles[3] = steenRBeneden;
		tetrismania.addGameObject(steenLBoven);
		tetrismania.addGameObject(steenRBoven);
		tetrismania.addGameObject(steenLBeneden);
		tetrismania.addGameObject(steenRBeneden);
	}

	@Override
	public void draaiLinksom() {
	}

	@Override
	public void draaiRechtsom() {
	}

}

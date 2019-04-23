package nl.han.ica.tetrismania.stenen;

import nl.han.ica.tetrismania.Steen;
import nl.han.ica.tetrismania.SteenTile;
import nl.han.ica.tetrismania.Tetrismania;

public class Tvorm extends Steen{
	
	public Tvorm(int x, int y, Tetrismania tm) {
		tekenTvorm(x, y, tm);
	}
	
	public void tekenTvorm(int x, int y, Tetrismania app) {
		SteenTile steenLinks = new SteenTile(x, y);
		SteenTile steenMidden = new SteenTile(x + 40, y);
		SteenTile steenRechts = new SteenTile(x + 80, y);
		SteenTile steenOnder = new SteenTile(x + 40, y + 40);
		tiles[0] = steenLinks;
		tiles[1] = steenMidden;
		tiles[2] = steenRechts;
		tiles[3] = steenOnder;
		app.addGameObject(steenLinks);
		app.addGameObject(steenMidden);
		app.addGameObject(steenRechts);
		app.addGameObject(steenOnder);
	}

	@Override
	public void draaiLinksom() {
		
		
	}

	@Override
	public void draaiRechtsom() {
		
		
	}

}

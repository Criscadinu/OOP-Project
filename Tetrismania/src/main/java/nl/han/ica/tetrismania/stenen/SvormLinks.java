package nl.han.ica.tetrismania.stenen;

import nl.han.ica.tetrismania.Steen;
import nl.han.ica.tetrismania.SteenTile;
import nl.han.ica.tetrismania.Tetrismania;

public class SvormLinks extends Steen {
	
	public SvormLinks(int x, int y, Tetrismania tm) {
		tekenSvormLinks(x, y, tm);

	}

	private void tekenSvormLinks(int x, int y, Tetrismania app) {
		SteenTile steenLBoven = new SteenTile(x, y, this);
		SteenTile steenMiddenLinks = new SteenTile(x, y + 40, this);
		SteenTile steenMiddenRechts = new SteenTile(x + 40, y + 40, this);
		SteenTile steenRBeneden = new SteenTile(x + 40, y + 80, this);
		tiles[0] = steenLBoven;
		tiles[1] = steenMiddenLinks;
		tiles[2] = steenMiddenRechts;
		tiles[3] = steenRBeneden;
		app.addGameObject(steenLBoven);
		app.addGameObject(steenMiddenLinks);
		app.addGameObject(steenMiddenRechts);
		app.addGameObject(steenRBeneden);
	}

	@Override
	public void draaiLinksom() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draaiRechtsom() {
		// TODO Auto-generated method stub
		
	}

}

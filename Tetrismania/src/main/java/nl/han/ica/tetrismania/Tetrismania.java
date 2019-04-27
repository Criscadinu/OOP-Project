
package nl.han.ica.tetrismania;

import java.util.ArrayList;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import nl.han.ica.tetrismania.stenen.LvormLinks;
import nl.han.ica.tetrismania.stenen.LvormRechts;
import nl.han.ica.tetrismania.stenen.SvormLinks;
import nl.han.ica.tetrismania.stenen.Tvorm;
import nl.han.ica.tetrismania.stenen.Vierkant;
import processing.core.PApplet;

import java.util.Random;

@SuppressWarnings("serial")
public class Tetrismania extends GameEngine {

	private ArrayList<SteenTile> geplaatsteTiles = new ArrayList<>();
	private ArrayList<SteenTile> geplaatsteYTiles = new ArrayList<>();
	private Steen vallendeSteen;
	private UserInput ui;
	private final int BREEDTE = 600;
	private final int HOOGTE = 800;

	public static void main(String args[]) {
		PApplet.main(new String[] { "nl.han.ica.tetrismania.Tetrismania" });

	}

	@Override
	public void setupGame() {
		int worldWidth = BREEDTE;
		int worldHeight = HOOGTE;
		createViewWithoutViewport(worldWidth, worldHeight);
		vulStenenLijst();
		maakBodemframe();
		maakNieuweSteen();

	}

	public void vulStenenLijst() {
	}

	public Steen getRandomSteen() {
		Steen s = null;
		Random random = new Random();
		int randomInt = random.nextInt(4 + 1);
		int randomPos = random.nextInt(3 + 1);
		switch (randomInt) {
		case 0:
			s = new Vierkant(0, 0, this);
			break;
		case 1:
			s = new Tvorm(0, 0, this, randomPos);
			break;
		case 2:
			s = new SvormLinks(0, 0, this);
			break;
		case 3:
			s = new LvormLinks(0, 0, this);
			break;
		case 4:
			s = new LvormRechts(0, 0, this);
			break;

		}
		return s;
	}

	public void maakNieuweSteen() {
		vallendeSteen = getRandomSteen();
		ui = new UserInput(vallendeSteen, this);
		addGameObject(ui);
	}

	public void maakBodemframe() {
		Frame bodemframe = new Frame(0, HOOGTE, BREEDTE, 10);
		addGameObject(bodemframe);
	}

	private void createViewWithoutViewport(int screenWidth, int screenHeight) {
		View view = new View(screenWidth, screenHeight);
		view.setBackground(150, 208, 158);

		setView(view);
		size(screenWidth, screenHeight);
	}

	/**
	 * dit is een steen
	 * 
	 * @author cc //Op het moment dat een rij beneden niks vol heeft en de rij
	 *         erboven wel valt alles alsnog naar beneden. De rij eronder moet
	 *         gewoon blijven staan
	 */
	@Override
	public void update() {
		if (vallendeSteen.gestopt) {
			for (int i = 0; i < vallendeSteen.tiles.length; i++) {
				geplaatsteTiles.add(vallendeSteen.tiles[i]);

			}
			this.maakNieuweSteen();

		}

		regelVerwijderenVanStenen();

	}
	
	/**
	 * Deze functie zorgt voor het detecteren van een volle rij en verwijderd dan de stenen van die rij(en).
	 * 
	 * @author cc //Op het moment dat een rij beneden niks vol heeft en de rij
	 *         erboven wel valt alles alsnog naar beneden. De rij eronder moet
	 *         gewoon blijven staan
	 */
	private void regelVerwijderenVanStenen() {
		for (int listY = 0; listY < this.HOOGTE / 40; listY++) {
			int arrayY = 99999;

			for (SteenTile steen : geplaatsteTiles) {
				if (steen.getY() / 40 == listY) {
					geplaatsteYTiles.add(steen);
				}
			}
			if (geplaatsteYTiles.size() == this.BREEDTE / 40) {
				arrayY = listY / this.HOOGTE;
				for (int c = 0; c < geplaatsteYTiles.size(); c++) {
					geplaatsteYTiles.get(c).setHeight(0);
					geplaatsteYTiles.get(c).setWidth(0);
				}
				for (SteenTile steen : geplaatsteTiles) {
					if (steen.getY() / 40 > arrayY) {
						steen.setY(steen.getY() + 40);
					}
				}
				arrayY = 99999;
			}

			geplaatsteYTiles.clear();

		}

	}

	public int getHOOGTE() {
		return HOOGTE;
	}

	public int getBREEDTE() {
		return BREEDTE;
	}

}
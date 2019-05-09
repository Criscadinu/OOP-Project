
package nl.han.ica.tetrismania;

import java.util.ArrayList;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.TextObject;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import nl.han.ica.tetrismania.stenen.LvormLinks;
import nl.han.ica.tetrismania.stenen.LvormRechts;
import nl.han.ica.tetrismania.stenen.SvormLinks;
import nl.han.ica.tetrismania.stenen.SvormRechts;
import nl.han.ica.tetrismania.stenen.Tvorm;
import nl.han.ica.tetrismania.stenen.Verticaalvorm;
import nl.han.ica.tetrismania.stenen.Vierkant;
import processing.core.PApplet;

import java.util.Random;


@SuppressWarnings("serial")
public class Tetrismania extends GameEngine {

	protected ArrayList<SteenTile> geplaatsteTiles = new ArrayList<>();
	private ArrayList<SteenTile> geplaatsteYTiles = new ArrayList<>();
	private Steen vallendeSteen;
	private UserInput ui;
	private final int BREEDTE = 600;
	private final int HOOGTE = 800;
	private int score = 0;

	private TextObject txt = new TextObject(Integer.toString(score), 20);

	public static void main(String args[]) {
		PApplet.main(new String[] { "nl.han.ica.tetrismania.Tetrismania" });

	}

	@Override
	public void setupGame() {
		int worldWidth = BREEDTE;
		int worldHeight = HOOGTE;
		createViewWithoutViewport(worldWidth, worldHeight);
		setTekst();
		vulStenenLijst();
		maakBodemframe();
		maakNieuweSteen();

	}

	public void vulStenenLijst() {
	}

	public Steen getRandomSteen() {
		Steen s = null;
		Random random = new Random();
		int randomInt = random.nextInt(6 + 1);
		int randomPos = random.nextInt(3 + 1);
		int r = random.nextInt(256);
		int g = random.nextInt(256);
		int b = random.nextInt(256);
		switch (1) {
		case 0:
			s = new Vierkant(BREEDTE / 2 + 20, 40, r, g, b, this);
			break;
		case 1:
			s = new Tvorm(BREEDTE / 2 + 20, 40, r, g, b, this);
			break;
		case 2:
			s = new SvormLinks(BREEDTE / 2 + 20, 40, r, g, b, this);
			break;
		case 3:
			s = new SvormRechts(BREEDTE / 2 + 20, 40, r, g, b, this);
			break;
		case 4:
			s = new LvormRechts(BREEDTE / 2 + 20, 40, r, g, b, this);
			break;
		case 5:
			s = new LvormLinks(BREEDTE / 2 + 20, 40, r, g, b, this);
			break;
		case 6:
			s = new Verticaalvorm(BREEDTE / 2 + 20, 40, r, g, b, this);
			break;

		}
		return s;
	}

	public void maakNieuweSteen() {
		vallendeSteen = getRandomSteen();
		ui = new UserInput(vallendeSteen, this);
		addGameObject(ui);
	}

	public void setTekst() {
		fill(0, 102, 153, 204);
		txt.setX(10);
		txt.setY(20);
		addGameObject(txt);
		txt.draw(g);
	}

	public void setGameOverTekst() {
		fill(255,0,0);
		txt.setX(100);
		txt.setY(120);
		txt.setFontSize(50);
		txt.setText("GAME OVER !!!!!");
		addGameObject(txt);
		txt.draw(g);
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
			if(checkPlayable()) {
				this.maakNieuweSteen();
			} else {
				setGameOverTekst();
			}

			regelVerwijderenVanStenen();
		}


	}

	/**
	 * Deze functie zorgt voor het detecteren van een volle rij en verwijderd dan de
	 * stenen van die rij(en).
	 * 
	 * @author cc //Op het moment dat een rij beneden niks vol heeft en de rij
	 *         erboven wel valt alles alsnog naar beneden. De rij eronder moet
	 *         gewoon blijven staan
	 */
	private void regelVerwijderenVanStenen() {
		for (int listY = 0; listY < this.HOOGTE / 40; listY++) {
			int arrayY = -1;

			for (SteenTile steen : geplaatsteTiles) {
				if (steen.getY() / 40 == listY) {
					geplaatsteYTiles.add(steen);
				}
			}
			if (geplaatsteYTiles.size() == this.BREEDTE / 40) {
				arrayY = listY / this.HOOGTE;
				System.out.println(arrayY);
				for (SteenTile steen : geplaatsteYTiles) {
					steen.setHeight(0);
					steen.setWidth(0);
				}
				for (SteenTile steen : geplaatsteTiles) {
					if (steen.getY() / 40 < listY) {
						steen.setY(steen.getY() + 40);
					}
				}
				geplaatsteYTiles.clear();
				setScore(100);
				setText();
				arrayY = -1;
				return;
			} else {
				geplaatsteYTiles.clear();
			}
			geplaatsteYTiles.clear();

		}

	}

	public boolean checkPlayable() {
		for (SteenTile steen : geplaatsteTiles) {
			if(steen.getY() <=120 && steen.getX() >= getBREEDTE() / 2 - 60 && steen.getX() >= getBREEDTE() / 2 + 60 ) {
				return false;
			}
		}
		return true;
		
	}

	public void setScore(int addValue) {
		this.score += addValue;
	}

	public void setText() {
		txt.setText(Integer.toString(score));
		txt.draw(g);
	}

	public int getHOOGTE() {
		return HOOGTE;
	}

	public int getBREEDTE() {
		return BREEDTE;
	}

}
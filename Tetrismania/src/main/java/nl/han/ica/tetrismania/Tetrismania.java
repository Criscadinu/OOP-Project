package nl.han.ica.tetrismania;

import java.util.ArrayList;
import java.util.Random;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.TextObject;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import nl.han.ica.tetrismania.stenen.LVormLinks;
import nl.han.ica.tetrismania.stenen.LVormRechts;
import nl.han.ica.tetrismania.stenen.SVormLinks;
import nl.han.ica.tetrismania.stenen.SVormRechts;
import nl.han.ica.tetrismania.stenen.TVorm;
import nl.han.ica.tetrismania.stenen.VerticaalVorm;
import nl.han.ica.tetrismania.stenen.Vierkant;
import processing.core.PApplet;

/**
 * 
 * @auteur Cris & Danny Dit is het hoofdprogramma van Tetrismania.
 */
@SuppressWarnings("serial")
public class Tetrismania extends GameEngine {

	private Sound achtergrondMuziek;
	private Sound explosie;
	public ArrayList<SteenTile> geplaatsteTiles = new ArrayList<>();
	private Steen vallendeSteen;
	private UserInput ui;
	private final int BREEDTE = 600;
	private final int HOOGTE = 800;
	private int score = 0;
	boolean spelGestart = false;
	Mainmenu hoofdmenu = new Mainmenu(this);

	private TextObject txt = new TextObject(Integer.toString(score), 20);

	public static void main(String args[]) {
		PApplet.main(new String[] { "nl.han.ica.tetrismania.Tetrismania" });

	}

	@Override
	public void setupGame() {
		int worldWidth = BREEDTE;
		int worldHeight = HOOGTE;
		createViewWithoutViewport(worldWidth, worldHeight);
		toonMenu();

	}

	/**
	 * 
	 * @return Steen Methode-omschrijving: Deze methode geeft een willekeurig Steen
	 *         object terug.
	 */
	public Steen getRandomSteen() {
		Steen s = null;
		Random random = new Random();
		int randomInt = random.nextInt(6 + 1);
		int r = random.nextInt((256 - 50) + 1) + 50;
		int g = random.nextInt((256 - 50) + 1) + 50;
		int b = random.nextInt((256 - 50) + 1) + 50;
		randomInt = 6;
		switch (randomInt) {
		case 0:
			s = new Vierkant(BREEDTE / 2 + 20, 40, r, g, b, this);
			break;
		case 1:
			s = new TVorm(BREEDTE / 2 + 20, 40, r, g, b, this);
			break;
		case 2:
			s = new SVormLinks(BREEDTE / 2 + 20, 40, r, g, b, this);
			break;
		case 3:
			s = new SVormRechts(BREEDTE / 2 + 20, 40, r, g, b, this);
			break;
		case 4:
			s = new LVormRechts(BREEDTE / 2 + 20, 40, r, g, b, this);
			break;
		case 5:
			s = new LVormLinks(BREEDTE / 2 + 20, 40, r, g, b, this);
			break;
		case 6:
			s = new VerticaalVorm(BREEDTE / 2 + 20, 40, r, g, b, this);
			break;

		}
		return s;
	}

	public void startSpel() {
		initialiseerGeluid();
		initialiseerExplosieGeluid();
		tekenTekst();
		maakBodemframe();
		maakNieuweSteen();
		spelGestart = true;

	}

	public void toonMenu() {
		addGameObject(hoofdmenu);
	}

	public void verbergMenu() {
		deleteGameObject(hoofdmenu);
	}

	/**
	 * Methode-omschrijving: Hier wordt een Steen-object toegevoegd als GameObject
	 * 
	 */
	public void maakNieuweSteen() {
		vallendeSteen = getRandomSteen();
		ui = new UserInput(vallendeSteen, this);
		addGameObject(ui);
	}

	/**
	 * Methode-omschrijving: Deze geeft de score weer op het scherm.
	 */
	public void tekenTekst() {
		fill(0, 102, 153, 204);
		txt.setX(10);
		txt.setY(20);
		addGameObject(txt);
		txt.draw(g);
	}

	/**
	 * Methode-omschrijving: Deze geeft de Game-Over tekst weer op het scherm.
	 */
	public void setGameOverTekst() {
		fill(255, 0, 0);
		txt.setX(100);
		txt.setY(120);
		txt.setFontSize(50);
		txt.setText("GAME OVER !!!!!");
		addGameObject(txt);
		txt.draw(g);
		deleteAllGameObjectsOfType(SteenTile.class);
		toonMenu();
	}

	/**
	 * Methode-omschrijving: Hier wordt een bodemframe als GameObject gemaakt om zo
	 * te voorkomen dat de stenen niet door het scherm heen gaan.
	 */
	private void maakBodemframe() {
		Frame bodemframe = new Frame(0, HOOGTE, BREEDTE, 10);
		addGameObject(bodemframe);
	}

	/**
	 * 
	 * @param screenWidth
	 * @param screenHeight Methode-omschrijving: Hier wordt het daadwerkelijke
	 *                     scherm weergegeven.
	 */
	private void createViewWithoutViewport(int screenWidth, int screenHeight) {
		View view = new View(screenWidth, screenHeight);
		view.setBackground(95, 95, 95);

		setView(view);
		size(screenWidth, screenHeight);
	}

	private void initialiseerGeluid() {
		achtergrondMuziek = new Sound(this, "src/main/java/nl/han/ica/tetrismania/media/tetris-gameboy-02.mp3");
		achtergrondMuziek.loop(-1);
	}

	private void initialiseerExplosieGeluid() {
		explosie = new Sound(this, "src/main/java/nl/han/ica/tetrismania/media/clear.wav");
	}

	/**
	 * Methode-omschrijving: De dynamiek van het spel gebeurt hier.
	 */
	@Override
	public void update() {
		if (spelGestart) {
			if (vallendeSteen.gestopt) {
				for (int i = 0; i < vallendeSteen.tiles.length; i++) {
					geplaatsteTiles.add(vallendeSteen.tiles[i]);
				}
				if (checkPlayable()) {
					this.maakNieuweSteen();
				} else {
					setGameOverTekst();
				}

				ArrayList<Integer> volleRijen = detecteerVolleRijen();
				for (int rijIndex : volleRijen) {
					verwijderRij(rijIndex);

				}
				if (volleRijen.size() > 0) {
					explosie.rewind();
					explosie.play();
					voegScoreToe(100 * volleRijen.size());
					setText();

				}

			}
		}

	}

	/**
	 * Deze functie regelt het verwijderen van rij met index 'rij' en laat de
	 * overige tiles naar beneden vallen.
	 * 
	 * @param rij
	 */
	private void verwijderRij(int rij) {

		ArrayList<SteenTile> teVerwijderenTiles = new ArrayList<>(); // we gooien de te verwijderen tiles in een aparte
																		// lijst omdat we de for-each loop niet kunnen
																		// storen.

		for (SteenTile tile : geplaatsteTiles) {
			if (tile.getY() / Steen.GROOTTE == rij) {
				deleteGameObject(tile);
				teVerwijderenTiles.add(tile);
			} else if (tile.getY() / Steen.GROOTTE < rij) {
				tile.setY(tile.getY() + Steen.GROOTTE);
			}
		}
		for (SteenTile t : teVerwijderenTiles) {
			geplaatsteTiles.remove(t);
		}
	}

	private ArrayList<Integer> detecteerVolleRijen() {
		ArrayList<Integer> gedetecteerd = new ArrayList<Integer>();
		for (int rij = 0; rij < HOOGTE / Steen.GROOTTE; rij++) {
			int tileTeller = 0;
			for (SteenTile tile : geplaatsteTiles) {
				if (tile.getY() / Steen.GROOTTE == rij) {
					tileTeller++;
				}
			}
			if (tileTeller == BREEDTE / Steen.GROOTTE)
				gedetecteerd.add(rij);
		}

		return gedetecteerd;
	}


	/**
	 * 
	 * @return boolean Methode-omschrijving: Hier wordt gekeken of een Steen-object
	 *         het 'plafond' heeft bereikt en de speler dus Game-Over is.
	 */
	public boolean checkPlayable() {
		for (SteenTile steen : geplaatsteTiles) {
			if (steen.getY() <= 200 && steen.getX() >= BREEDTE / 2 - 60 && steen.getX() >= BREEDTE / 2 + 60) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @param addValue Methode-omschrijving: Hier wordt de score opgehoogd.
	 */
	public void voegScoreToe(int addValue) {
		this.score += addValue;
	}

	/**
	 * Methode-omschrijving: Hier wordt de waarde van score ingezet.
	 */
	public void setText() {
		txt.setText(Integer.toString(score));
		txt.draw(g);
	}

}
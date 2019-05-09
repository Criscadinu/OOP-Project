package nl.han.ica.tetrismania;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import processing.core.PGraphics;

/**
 * 
 * @Auteur Danny & Cris
 * Deze klasse handelt de user input af. De stenen kunnen bewegen met de aangegeven toetsen in het commentaar in de keyPressed methode.
 *
 */
public class UserInput extends GameObject {

	private Steen steen;
	private Tetrismania tm;

	public UserInput(Steen s, Tetrismania tetrismania) {
		this.steen = s;
		this.tm = tetrismania;
	}

	@Override
	public void update() {

	}

	@Override
	public void draw(PGraphics g) {

	}

	public void updateSteen(Steen steen) {
		this.steen = steen;
	}
	
	/**
	 * @param keyCode
	 * @param key
	 * Methode-omschrijving:
	 * Op het moment dat de specifieke keycode wordt ingedrukt vindt er een interactie plaats.
	 */
	public void keyPressed(int keyCode, char key) {
		if(steen.gestopt != true) {
			if (keyCode == 39) { // Pijltjestoets rechts
				steen.naarRechts();
			} else if (keyCode == 37) { // Pijltjestoets links
				steen.naarLinks();
			} else if (keyCode == 32) { // Spatie
				steen.valNaarBodem();
			} else if (keyCode == 40) { // Pijltjestoets beneden
				steen.naarBeneden();
			} else if (keyCode == 65) { // A
				steen.draaiRechtsom();
			} else if (keyCode == 68) { // D
				steen.draaiRechtsom();
			} else if (keyCode == 82) { 
				tm.maakNieuweSteen();
			}	
		}
		
	}

	/**
	 * @param keyCode
	 * @param key
	 */
	public void keyReleased(int keyCode, char key) {
	}

}

    
package nl.han.ica.tetrismania;

import java.util.ArrayList;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import processing.core.PApplet;

@SuppressWarnings("serial")
public class Tetrismania extends GameEngine {

	private ArrayList<Steen> geplaatsteStenen = new ArrayList<>();
	private Steen vallendeSteen;
	private UserInput ui;
	private final int BREEDTE = 800;
	private final int HOOGTE = 800;

	public static void main(String args[]) {
		PApplet.main(new String[] { "nl.han.ica.tetrismania.Tetrismania" });
	}

	@Override
	public void setupGame() {
		int worldWidth = BREEDTE;
		int worldHeight = HOOGTE; 	

		createViewWithoutViewport(worldWidth, worldHeight);
		ui = new UserInput(vallendeSteen, this);
		addGameObject(ui);
		maakNieuweSteen();
	}

	public void maakNieuweSteen() {
		geplaatsteStenen.add(vallendeSteen);
		vallendeSteen = new Steen(0, 0,this);
		addGameObject(vallendeSteen);
		ui.updateSteen(vallendeSteen);
	}
	
	public void voegExtraSteenToe() {
		Steen nieuweSteen = new Steen(20, 20, this);
		addGameObject(nieuweSteen, 50, 0);
	}

	


	private void createViewWithoutViewport(int screenWidth, int screenHeight) {
		View view = new View(screenWidth, screenHeight);
		view.setBackground(150, 208, 158);

		setView(view);
		size(screenWidth, screenHeight);
	}

	@Override
	public void update() {
			
		}

	}
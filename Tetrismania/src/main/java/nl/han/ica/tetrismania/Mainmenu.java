package nl.han.ica.tetrismania;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import processing.core.PGraphics;

/**
 * 
 * @author Danny & Cris
 * Dit is de klasse met alle functionaliteiten van het Hoofdmenu
 */
public class Mainmenu extends GameObject {
	private Tetrismania tm;
	boolean rectOver = false;
	PlayKnop playbtn;
	protected int PlayKnopX = 50;
	protected int PlayKnopY= 400;
	protected int PlayKnopHoogte = 40;
	protected int PlayKnopBreedte = 100;
	LevelKnop lvl1;
	LevelKnop lvl2;
	LevelKnop lvl3;
	

	public Mainmenu(Tetrismania tm) {
		this.tm = tm;
		this.playbtn = new PlayKnop("Play", PlayKnopX,PlayKnopY,PlayKnopHoogte,PlayKnopBreedte,this.tm);

		this.lvl1 = new LevelKnop("Makkelijk", PlayKnopX,100,PlayKnopHoogte,PlayKnopBreedte,this.tm);
		this.lvl2 = new LevelKnop("Normaal", PlayKnopX,150,PlayKnopHoogte,PlayKnopBreedte,this.tm);
		this.lvl3 = new LevelKnop("Moeilijk", PlayKnopX,200,PlayKnopHoogte,PlayKnopBreedte,this.tm);
	}

	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(PGraphics g) {
		g.fill(0);
		g.rect(800, 600, 800, 600);
		update(tm.mouseX, tm.mouseY);
		g.background(0);
		tm.addGameObject(playbtn);
		tm.addGameObject(lvl1);
		tm.addGameObject(lvl2);
		tm.addGameObject(lvl3);
		}

	public void mousePressed(int x, int y, int button) {
		if(x >PlayKnopX && x < PlayKnopX+PlayKnopBreedte && y > PlayKnopY && y < PlayKnopY+PlayKnopHoogte) {
			tm.deleteAllGameOBjects();
			tm.startSpel();
			tm.verbergMenu();
		}
		if(x >PlayKnopX && x < PlayKnopX + PlayKnopBreedte && y > 100 && y < 100 + PlayKnopHoogte ) {
			tm.setLvl(40);
			lvl1.setSelected(!lvl1.selected);
			lvl2.setSelected(false);
			lvl3.setSelected(false);
		}
		if(x >PlayKnopX && x < PlayKnopX + PlayKnopBreedte && y > 150 && y < 150 + PlayKnopHoogte ) {
			tm.setLvl(20);
			lvl2.setSelected(!lvl2.selected);
			lvl1.setSelected(false);
			lvl3.setSelected(false);
		}
		if(x >PlayKnopX && x < PlayKnopX + PlayKnopBreedte && y > 200 && y < 200 + PlayKnopHoogte ) {
			tm.setLvl(10);
			lvl3.setSelected(!lvl3.selected);
			lvl2.setSelected(false);
			lvl1.setSelected(false);
		}

	}


	void update(int x, int y) { 
	}

	
}
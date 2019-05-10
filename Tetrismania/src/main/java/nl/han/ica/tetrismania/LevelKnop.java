package nl.han.ica.tetrismania;

import processing.core.PGraphics;


/**
 * 
 * @author Cris & Danny
 * Hierin staat de code voor het bepalen van de moeilijkheidsgraad
 *
 */
public class LevelKnop extends Knop {
	protected Tetrismania tm;
	protected int lvl;
	protected int x,y,breedte,hoogte, textMargin;
	protected String text;
	protected Boolean selected;

	public LevelKnop(String txt, int x, int y, int hoogte, int breedte, Tetrismania tm) {
		super( txt );
		this.text = txt;
		this.x = x;
		this.y = y;
		this.breedte = breedte;
		this.hoogte = hoogte;
		this.tm = tm;
		this.textMargin = 20;
		this.selected = false;
	}


	@Override
	public void onClick() {
		tm.setLvl(lvl);
	}

	@Override
	public void setText(String text) {
		this.text = text;
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(PGraphics g) {
		g.fill(0,255,0);
		if(selected) {
			g.fill(150);
		}
		g.rect(x, y, breedte, hoogte);
		g.fill(0);
		g.text(text, x+textMargin, y+25, breedte);
		
	}


	public Boolean getSelected() {
		return selected;
	}


	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

}
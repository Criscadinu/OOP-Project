package nl.han.ica.tetrismania;

import java.awt.Button;

import processing.core.PGraphics;

@SuppressWarnings("serial")
public class PlayKnop extends Knop{
	protected int x,y,breedte,hoogte, textMargin;
	protected String text;
	protected Tetrismania tm;

	public PlayKnop(String txt, int x, int y, int hoogte, int breedte, Tetrismania tm) {
		super( txt );
		this.text = txt;
		this.x = x;
		this.y = y;
		this.breedte = breedte;
		this.hoogte = hoogte;
		this.tm = tm;
		this.textMargin = 20;
	}

	public void onClick() {
		tm.startSpel();
	}

	public void setText(String text) {
		this.text = text;
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getText() {
		return this.Text;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(PGraphics g) {
		g.fill(0,255,0);
		g.rect(x, y, breedte, hoogte);
		g.fill(0);
		g.text("play", x+textMargin, y+25, breedte);
		// TODO Auto-generated method stub
		
	}


}
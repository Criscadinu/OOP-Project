package nl.han.ica.tetrismania;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;

public abstract class Knop extends GameObject{
	
	protected String Text;
	
	Knop(String txt){
		this.Text = txt;
	}

	public abstract void onClick();

	public abstract void setText(String text);
	
	public abstract String getText();
}

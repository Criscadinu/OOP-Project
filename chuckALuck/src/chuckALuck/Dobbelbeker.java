package chuckALuck;

import java.util.Random;

public class Dobbelbeker {
	Dobbelsteen[] dobbelstenen = new Dobbelsteen[3];
	int aantalDobbelstenen = 3;
	
	Dobbelbeker() {
		
	}

	public int[] schudDobbelstenen() {

		int[] resultaten = new int[3];

		for (int i = 0; i < aantalDobbelstenen; i++) {
			dobbelstenen[i] = new Dobbelsteen();
			resultaten[i] = dobbelstenen[i].nummer;
		}
		return resultaten;

	}

}

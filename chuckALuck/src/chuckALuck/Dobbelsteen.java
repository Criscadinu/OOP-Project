package chuckALuck;

import java.util.Random;

public class Dobbelsteen {
	int nummer;

	Dobbelsteen() {
		Random rand = new Random();

		nummer = rand.nextInt(7);
		

	}

}

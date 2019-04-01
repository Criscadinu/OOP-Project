package chuckALuck;

public class ChuckALuckSpel {
	protected Dobbelbeker beker = new Dobbelbeker();
	protected int saldo;
	

	public ChuckALuckSpel(int saldo) {
		this.saldo = saldo;

	}

	public void speelRonde(int geluksGetal, int inzet) {
		int gelijk = 0;
		
		int[] resultaten = new int[3];
		resultaten = beker.schudDobbelstenen();
		
		for (int i = 0; i < resultaten.length; i++) {
			if (resultaten[i] == geluksGetal) {
				gelijk++;
			}
		}

		if (gelijk == 1) {
			saldo += inzet;
		} else if (gelijk == 2) {
			saldo += inzet * 2;
		} else if (gelijk == 3) {
			saldo += inzet * 10;
		} else {
			saldo -= inzet;
		}

		System.out.println("Geluksgetal: " + geluksGetal);
		System.out.println("Worp: " + resultaten[0] + resultaten[1] + resultaten[2]);
		System.out.println("Saldo: " + saldo);

	}

}

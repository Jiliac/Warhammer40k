package principal.armeC;

import principal.ArmeC;
import principal.Infanterie;

public class AttaqueCInf implements AttaqueC {
	public Infanterie attaquant, defenseur;
	public ArmeC armeC;

	public AttaqueCInf(Infanterie attaquant, Infanterie defenseur, ArmeC armeC) {
		this.attaquant = attaquant;
		this.defenseur = defenseur;
		this.armeC = armeC;
	}

	public void attaquerC() {
		if (armeC.toucherC(attaquant, defenseur)) {
			if (armeC.blesser(attaquant, defenseur))
				armeC.sauver(attaquant, defenseur);
		}
	}
}

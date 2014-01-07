package principal.armeC;

import principal.ArmeC;
import principal.Infanterie;
import principal.vehicule.Marcheur;
import principal.Vehicule;

public class AttaqueCVeh implements AttaqueC {
	protected Infanterie attaquant;
	protected Vehicule defenseur;
	protected ArmeC armeC;

	public AttaqueCVeh(Infanterie attaquant, Vehicule defenseur, ArmeC armeC) {
		this.attaquant = attaquant;
		this.defenseur = defenseur;
		this.armeC = armeC;
	}

	public void attaquerC() {
		if (!(defenseur instanceof Marcheur)) {
			if (armeC.toucherC(attaquant, defenseur)) {
				if (armeC.blesser(attaquant, defenseur))
					armeC.sauver(defenseur);
			}
		} else {
			Marcheur def = (Marcheur) defenseur;
			Infanterie inf = def.getInf();
			if (armeC.toucherC(attaquant, inf)) {
				if (armeC.blesser(attaquant, defenseur))
					armeC.sauver(defenseur);
			}
		}
	}
}

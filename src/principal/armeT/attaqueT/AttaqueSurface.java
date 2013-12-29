package principal.armeT.attaqueT;

import java.util.ArrayList;
import principal.ArmeT;
import principal.Infanterie;
import principal.Unite;
import principal.Vehicule;
import principal.armeT.attaqueTSurface.AttaqueTSurface;

public class AttaqueSurface implements AttaqueT {
	protected AttaqueTSurface ats;
	protected Unite attaquant;
	protected ArmeT armeT;

	public AttaqueSurface(Unite attaquant, AttaqueTSurface ats, ArmeT armeT) {
		this.attaquant = attaquant;
		this.ats = ats;
		this.armeT = armeT;
	}

	// la question subsidiaire etant: est-ce que je dois disable la methode
	// toucher de l'armeT...

	public void attaquerT() {
		ArrayList<Unite> al = ats.toucherT();
		for (Unite defenseur : al) {
			if (defenseur instanceof Infanterie) {
				Infanterie def = (Infanterie) defenseur;
				if (armeT.blesser(attaquant, def))
					armeT.sauver(attaquant, def);
			} else if (defenseur instanceof Vehicule) {
				Vehicule def = (Vehicule) defenseur;
				if (armeT.blesser(attaquant, def))
					armeT.sauver(def);
			}
		}
	}

}

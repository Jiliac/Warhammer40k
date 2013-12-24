package principal.armeT.attaqueT;

import principal.Unite;
import principal.ArmeT;


public class AttaqueTMere {
	Unite attaquant, defenseur;
	ArmeT armeT;

	public AttaqueTMere(Unite attaquant, Unite defenseur, ArmeT armeT) {
		this.attaquant = attaquant;
		this.defenseur = defenseur;
		this.armeT = armeT;
	}
}

package principal.armeT.attaqueT;

import principal.Infanterie;
import principal.Unite;
import principal.ArmeT;


public class AttaqueTMere {
	protected Unite attaquant;
	protected Infanterie defenseur;
	ArmeT armeT;

	public AttaqueTMere(Unite attaquant, Infanterie defenseur, ArmeT armeT) {
		this.attaquant = attaquant;
		this.defenseur = defenseur;
		this.armeT = armeT;
	}
}

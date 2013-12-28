package principal.Blesse;

import principal.Unite;
import principal.Sauvegarde.Sauvegarde;
import principal.Sauvegarde.SauvegardeNormale;
import de.De;
import de.De6;

public class BlessurePerforante extends BlessureMere implements Blessure {
	private int f, e;
	private Unite defenseur;
	public BlessurePerforante(Unite attaquant, Unite defenseur) {
		super(attaquant, null);
		this.defenseur=defenseur;
		this.f = attaquant.getF();
		this.e = defenseur.getE();
	}

	public Sauvegarde blesser() {
		De de = new De6();
		int jet = de.jet();
		Sauvegarde retour;

		//la il faut envisager le cas où on attaque un vehicule et le cas où on attaque infanterie
		if (jet == 6) {
			attaquant.getArmeT().setPa(2);
			retour = new SauvegardeNormale(attaquant, defenseur);
		} else {
			BlessureNormale blessure = new BlessureNormale(attaquant,
					defenseur, jet);
			retour = blessure.blesser();
		}
		return retour;
	}
}

package principal.Blesse;

import principal.Unite;
import principal.Sauvegarde.Sauvegarde;
import principal.Sauvegarde.SauvegardeNormale;
import de.De6;

public class BlessureSniper extends BlessureMere implements Blessure {
	public BlessureSniper(Unite attaquant, Unite defenseur) {
		super(attaquant, defenseur);
		// TODO Auto-generated constructor stub
	}

	public Sauvegarde blesser() {
		De6 de = new De6();
		int jet = de.jet();
		Sauvegarde retour;
		if (jet == 6) {
			Unite at = attaquant;
			attaquant.getArmeT().setPa(2);
			retour = new SauvegardeNormale(at, defenseur);
		} else if (jet >= 4)
			retour = new SauvegardeNormale(attaquant, defenseur);
		else {
			BlessureNormale blessure = new BlessureNormale(attaquant,
					defenseur, jet);
			retour = blessure.blesser();
		}
		return retour;
	}
}

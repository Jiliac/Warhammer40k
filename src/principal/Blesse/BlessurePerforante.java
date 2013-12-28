package principal.Blesse;

import principal.Infanterie;
import principal.Unite;
import de.De;
import de.De6;

public class BlessurePerforante extends BlessureMere implements Blessure {

	public BlessurePerforante(Unite attaquant, Infanterie defenseur) {
		super(attaquant, defenseur);
	}

	public boolean blesser() {
		De de = new De6();
		int jet = de.jet();
		boolean retour;

		// la il faut envisager le cas où on attaque un vehicule et le cas où on
		// attaque infanterie
		if (jet == 6) {
			attaquant.getArmeT().setPa(2);
			retour = true;
		} else {
			BlessureNormale blessure = new BlessureNormale(attaquant,
					defenseur, jet);
			retour = blessure.blesser();
		}
		return retour;
	}
}

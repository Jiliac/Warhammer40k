package principal.Blesse;

import principal.ArmeT;
import principal.Infanterie;
import principal.Unite;
import de.De;
import de.De6;

public class BlessurePerforante extends BlessureMere implements Blessure {

	protected ArmeT armeT;

	public BlessurePerforante(Unite attaquant, Infanterie defenseur, ArmeT armeT) {
		super(attaquant, defenseur);
		this.armeT = armeT;
	}

	public boolean blesser() {
		De de = new De6();
		int jet = de.jet();
		boolean retour;

		// la il faut envisager le cas où on attaque un vehicule et le cas où
		// on
		// attaque infanterie
		if (jet == 6) {
			this.armeT.setPa(2);
			retour = true;
		} else {
			BlessureNormale blessure = new BlessureNormale(attaquant,
					defenseur, jet);
			retour = blessure.blesser();
		}
		return retour;
	}
}

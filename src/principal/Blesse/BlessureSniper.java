package principal.Blesse;

import principal.ArmeT;
import principal.Infanterie;
import principal.Unite;
import de.De6;

public class BlessureSniper extends BlessureMere implements Blessure {

	protected ArmeT armeT;
	public BlessureSniper(Unite attaquant, Infanterie defenseur, ArmeT armeT) {
		super(attaquant, defenseur);
		this.armeT = armeT;
	}

	public boolean blesser() {
		De6 de = new De6();
		int jet = de.jet();
		boolean retour;
		
		// idem que pour blessure perforante...
		if (jet == 6) {
			this.armeT.setPa(2);
			retour = true;
		} else if (jet >= 4)
			retour = true;
		else {
			retour = false;
		}
		return retour;
	}
}

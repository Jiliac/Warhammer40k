package principal.Blesse;

import principal.Infanterie;
import principal.Unite;
import de.De6;

public class BlessureSniper extends BlessureMere implements Blessure {
	public BlessureSniper(Unite attaquant, Infanterie defenseur) {
		super(attaquant, defenseur);
		// TODO Auto-generated constructor stub
	}

	public boolean blesser() {
		De6 de = new De6();
		int jet = de.jet();
		boolean retour;
		
		// idem que pour blessure perforante...
		if (jet == 6) {
			attaquant.getArmeT().setPa(2);
			retour = true;
		} else if (jet >= 4)
			retour = true;
		else {
			retour = false;
		}
		return retour;
	}
}

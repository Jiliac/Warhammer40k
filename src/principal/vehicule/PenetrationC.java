package principal.vehicule;

import de.De6;
import principal.Infanterie;
import principal.Vehicule;
import principal.Blesse.Blessure;

public class PenetrationC extends Penetration implements Blessure {
	protected Infanterie attaquant;
	protected Vehicule defenseur;

	public PenetrationC(Infanterie attaquant, Vehicule defenseur) {
		this.attaquant = attaquant;
		this.defenseur = defenseur;
	}

	public boolean blesser() {
		boolean retour;
		int blindage = defenseur.associerBlindage(attaquant, defenseur);
		De6 de = new De6();
		int jet = de.jet();
		if (jet + attaquant.getF() == blindage) {
			retour = true;
			egalite = true;
		} else if (jet + attaquant.getF() > blindage) {
			retour = true;
		} else
			retour = false;
		return retour;
	}
}

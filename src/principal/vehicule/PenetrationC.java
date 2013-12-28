package principal.vehicule;

import de.De6;
import principal.Infanterie;
import principal.Vehicule;
import principal.Blesse.Blessure;
import principal.Sauvegarde.Sauvegarde;


public class PenetrationC implements Blessure {
	protected Infanterie attaquant;
	protected Vehicule defenseur;

	public PenetrationC(Infanterie attaquant, Vehicule vehicule) {
		this.attaquant = attaquant;
		this.defenseur = vehicule;
	}

	public Sauvegarde blesser() {
		Sauvegarde retour;
		int blindage = defenseur.associerBlindage(attaquant, defenseur);
		De6 de = new De6();
		int jet = de.jet();
		int jetDegat;
		if (jet + attaquant.getF() >= blindage) {
			/*
			 * y'a vraiment bcp de truc a refaire ici, il y le cas > et le cas
			 * == a distinguer
			 */
			jetDegat = de.jet();
			jetDegat = this.modificateur(jetDegat);
		} else
			jetDegat = 0;
		retour = new EffetDegat(jetDegat, defenseur);
		return retour;
	}

	private int modificateur(int jetDegat) {
		int retour = jetDegat;

		// la il faut distinguer tous les cas en fonction de l'attaquant, du
		// defenseur et de son arme

		return retour;
	}
}

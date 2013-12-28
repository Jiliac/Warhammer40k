package principal.vehicule;

import de.De6;
import principal.Vehicule;
import principal.Sauvegarde.Sauvegarde;

public class EffetDegat implements Sauvegarde {
	private int jetDegat;
	private Vehicule vehicule;

	public EffetDegat(Vehicule defenseur, Penetration pen) {
		this.vehicule = defenseur;
		De6 de = new De6();
		jetDegat = de.jet();
		if (pen.isEgalite() == true)
			jetDegat += -2;
	}

	public void sauver() {
		jetDegat = this.modificateur(jetDegat);
		if (jetDegat == 1)
			vehicule.secouer();
		else if (jetDegat == 2)
			vehicule.sonne();
		else if (jetDegat == 3)
			vehicule.armeDetruite();
		else if (jetDegat == 4)
			vehicule.immobilise();
		else if (jetDegat == 5)
			vehicule.epave();
		else if (jetDegat == 6)
			vehicule.explosion();
	}

	private int modificateur(int jetDegat) {
		int retour = jetDegat;

		// la il faut distinguer tous les cas en fonction de l'attaquant, du
		// defenseur et de son arme

		return retour;
	}

}
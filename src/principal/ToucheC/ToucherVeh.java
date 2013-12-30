package principal.ToucheC;

import de.De6;
import principal.Infanterie;
import principal.Vehicule;

public class ToucherVeh implements ToucheC {
	protected Infanterie attaquant;
	protected Vehicule defenseur;

	public ToucherVeh(Infanterie attaquant, Vehicule defenseur) {
		this.attaquant = attaquant;
		this.defenseur = defenseur;
	}

	public boolean toucherC() {
		boolean retour = false;
		De6 de = new De6();
		String em = defenseur.getEtatMouvement();
		if (em == "immobile") {
			retour = true;
		} else if (em == "combat") {
			if (de.jet() >= 4)
				retour = true;
			else
				retour = false;
		} else if (em == "manoeuvre") {
			if (de.jet() == 6)
				retour = true;
			else
				retour = false;
		}
		return retour;
	}
}

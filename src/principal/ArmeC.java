package principal;

import principal.Blesse.Blessure;
import principal.Blesse.BlessureInutile;
import principal.Blesse.BlessureNormale;
import principal.Sauvegarde.Sauvegarde;
import principal.Sauvegarde.SauvegardeInutile;
import principal.Sauvegarde.SauvegardeNormale;
import principal.ToucheC.ToucheC;
import principal.ToucheC.ToucheCNormale;

public abstract class ArmeC {
	//ils peuvent p-e modifier la cc? donc il faudrait un attribut cc pour cette classe?
	
	// ************* les actions ************

	public void attaquerC(Unite attaquant, Unite defenseur) {
		ToucheC toucheC = this.associationToucheC(attaquant, defenseur);
		
		Blessure blessure = this.associationBlessure(attaquant, defenseur,
				toucheC.toucherC());
		Sauvegarde sauvegarde = this.associationSauvegarde(attaquant,
				defenseur, blessure.blesser());
		sauvegarde.sauver();
	}

	// ********* constructeur ***************

	protected String typeToucheC, typeBlessure, typeSauvegarde;

	protected ArmeC(String typeToucheC, String typeBlessure,
			String typeSauvegarde) {
		this.typeToucheC = typeToucheC;
		this.typeBlessure = typeBlessure;
		this.typeSauvegarde = typeSauvegarde;
	}

	protected ArmeC() {
		this("normal", "normal", "normal");
	}

	// ***************** les constructeurs de combat ********************

	public ToucheC associationToucheC(Unite attaquant, Unite defenseur) {
		ToucheC retour = null;
		if (typeToucheC == "normal")
			retour = new ToucheCNormale(attaquant, defenseur);

		return retour;
	}

	public Blessure associationBlessure(Unite attaquant, Unite defenseur,
			Blessure blessure) {
		Blessure retour = null;

		if (blessure instanceof BlessureInutile)
			retour = blessure;
		else if (typeBlessure == "normal")
			retour = new BlessureNormale(attaquant, defenseur);

		return retour;
	}

	public Sauvegarde associationSauvegarde(Unite attaquant, Unite defenseur,
			Sauvegarde sauvegarde) {
		Sauvegarde retour = null;

		if (sauvegarde instanceof SauvegardeInutile)
			retour = sauvegarde;
		else if (typeSauvegarde == "normal")
			retour = new SauvegardeNormale(attaquant, defenseur);

		return retour;
	}

	// ************** les setters ***************

	protected void setTypeToucheC(String typeToucheC) {
		this.typeToucheC = typeToucheC;
	}

	protected void setTypeBlessure(String typeBlessure) {
		this.typeBlessure = typeBlessure;
	}

	protected void setTypeSauvegarde(String sauvegarde) {
		this.typeSauvegarde = sauvegarde;
	}
}

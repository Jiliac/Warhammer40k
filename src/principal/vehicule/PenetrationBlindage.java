package principal.vehicule;

import principal.ArmeT;
import principal.Unite;
import principal.Vehicule;
import principal.Blesse.Blessure;
import de.De6;

public class PenetrationBlindage extends Penetration implements Blessure {
	Unite attaquant;
	Vehicule vehicule;
	ArmeT armeT;

	public PenetrationBlindage(Unite attaquant, Vehicule defenseur, ArmeT armeT) {
		this.attaquant = attaquant;
		this.vehicule = defenseur;
		this.armeT = armeT;
	}

	public boolean blesser() {
		int blindage = vehicule.associerBlindage(attaquant, vehicule);
		boolean retour;
		
		De6 de = new De6();
		int jetPenetration = de.jet();
		if (jetPenetration + armeT.getF() == blindage) {
			retour=true;
			egalite=true;
		}
		else if (jetPenetration + armeT.getF() > blindage)
			retour = true;
		else
			retour = false;
		return retour;
	}
}

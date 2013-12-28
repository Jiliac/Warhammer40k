package principal.vehicule;

import de.De6;
import principal.Infanterie;
import principal.Vehicule;
import principal.Blesse.Blessure;
import principal.Blesse.BlessureFausse;
import principal.ToucheC.ToucheC;

public class ToucheCVehicule implements ToucheC {
	protected Infanterie attaquant;
	protected Vehicule defenseur;

	public ToucheCVehicule(Infanterie attaquant, Vehicule vehicule) {
		this.attaquant = attaquant;
		this.defenseur = defenseur;
	}

	public Blessure toucherC(){
		Blessure retour;
		String str = defenseur.getEtatMouvement();
		De6 de = new De6();
		int jet = de.jet();
		
		if(str=="immobilisé"){
			retour = new PenetrationC(attaquant, defenseur);
		}
		else if(str=="combat") {
			if(jet>=4)
				retour = new PenetrationC(attaquant,defenseur);
			else
				retour = new BlessureFausse(attaquant,defenseur);
		}
		else if(str=="manoeuvre"){
			if(jet==6)
				retour = new PenetrationC(attaquant,defenseur);
			else
				retour = new BlessureFausse(attaquant,defenseur);
		}
		else{
			retour = null;
			System.out.println("on aurait pas du aller ici...");
		}
		
		return retour;
	}
}

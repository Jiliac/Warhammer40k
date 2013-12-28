package principal.vehicule;

import de.De6;
import principal.Infanterie;
import principal.Vehicule;
import principal.ToucheC.ToucheC;

public class ToucheCVehicule implements ToucheC {
	protected Infanterie attaquant;
	protected Vehicule defenseur;

	public ToucheCVehicule(Infanterie attaquant, Vehicule defenseur) {
		this.attaquant = attaquant;
		this.defenseur = defenseur;
	}

	public boolean toucherC(){
		boolean retour;
		String str = defenseur.getEtatMouvement();
		De6 de = new De6();
		int jet = de.jet();
		
		if(str=="immobilise"){
			retour = true;
		}
		else if(str=="combat") {
			if(jet>=4)
				retour = true;
			else
				retour = false;
		}
		else if(str=="manoeuvre"){
			if(jet==6)
				retour = true;
			else
				retour = false;
		}
		else{
			retour = false;
			System.out.println("on aurait pas du aller ici...");
		}
		
		return retour;
	}
}

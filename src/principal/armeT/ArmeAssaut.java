package principal.armeT;

import principal.ArmeT;
import principal.Unite;
import principal.Blesse.Blessure;
import principal.Blesse.BlessureNormale;
import principal.Sauvegarde.Sauvegarde;

public class ArmeAssaut extends ArmeT {
	protected ArmeAssaut(int portee, int f, int pa, int nbTir) {
		super(portee, f, pa, nbTir);
		this.used=false;
	}

	public void attaquerT(Unite attaquant, Unite defenseur, Blessure blessure) {
		// EN FAIT C'EST TELLEMENT UN COMPORTEMENT PAS DEFAUT QUE JE PENSE LE METTRE EN INTERFACE??
		
		if (attaquant.aPorte(portee, defenseur)) {
			boolean reussite=false;
			this.used=true;
			if (blessure.getClass().toString() == BlessureNormale.class
					.toString()) {
				if (this.getTypeOption() == "") {
					Sauvegarde sauvegarde = blessure.blesser();
					reussite = sauvegarde.sauver();
				}
				else{
					//ATTENTION ICI, C'EST A DEFINIR SELON LES OPTIONS DES ARMES!!!
				}
			}
			if (reussite==true)
				defenseur.pertePv();
		}
	}
	
	public boolean isAbleToCharge(){
		return true;
	}
}

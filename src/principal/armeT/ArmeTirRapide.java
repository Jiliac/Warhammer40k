package principal.armeT;

import principal.ArmeT;
import principal.Unite;
import principal.Blesse.Blessure;
import principal.Sauvegarde.Sauvegarde;
import principal.ToucheT.ToucheT;
import principal.armeT.attaqueT.AttaqueTClassique;

public class ArmeTirRapide extends ArmeT {
	protected ArmeTirRapide(int portee, int f, int pa) {
		super(portee, f, pa, 1);
	}

	public void attaquerT(Unite attaquant, Unite defenseur) {
		// defini le comportement d'une arme de TirRapide
		if (attaquant.aPorte(12, defenseur)) {
			this.portee = 12;
			this.nbTir = 2;
		} else if (!this.aPorte(attaquant, defenseur)
				|| attaquant.isDeplace() == true)
			return;
		
		AttaqueTClassique atc = new AttaqueTClassique(attaquant,defenseur,this);
		atc.attaquerT();

	}

	public boolean isAbleToCharge() {
		return false;
	}

}

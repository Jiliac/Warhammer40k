package principal.armeT.type;

import principal.ArmeT;
import principal.Infanterie;
import principal.Unite;

public class ArmeTirRapide extends ArmeT {
	protected ArmeTirRapide(int portee, int f, int pa) {
		super(portee, f, pa, 1);
	}

	public void attaquerT(Unite attaquant, Infanterie defenseur) {
		// defini le comportement d'une arme de TirRapide
		if (attaquant.aPorte(12, defenseur)) {
			this.portee = 12;
			this.nbTir = 2;
		} else if (!this.aPorte(attaquant, defenseur)
				|| attaquant.isDeplace() == true)
			return;
		
		if (this.toucherT(attaquant, defenseur)) {
			if (this.blesser(attaquant, defenseur))
				this.sauver(attaquant, defenseur);
		}
	}

	public boolean isAbleToCharge() {
		return false;
	}

}

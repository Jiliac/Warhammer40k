package principal;

import principal.Blesse.Blessure;
import principal.Blesse.BlessureNormale;
import principal.Sauvegarde.Sauvegarde;
import principal.Sauvegarde.SauvegardeNormale;
import principal.ToucheC.ToucheC;
import principal.ToucheC.ToucheCNormale;


public abstract class ArmeC {
	//ils peuvent p-e modifier la cc? donc il faudrait un attribut cc pour cette classe?
	
	// ******************* les trois phases *******************

	protected boolean toucherC(Infanterie attaquant, Infanterie defenseur) {
		ToucheC tt = new ToucheCNormale(attaquant, defenseur);
		return tt.toucherC();
	}

	protected boolean blesser(Infanterie attaquant, Infanterie defenseur) {
		Blessure bls = new BlessureNormale(attaquant, defenseur);
		return bls.blesser();
	}

	protected void sauver(Infanterie attaquant, Infanterie defenseur) {
		Sauvegarde sauv = new SauvegardeNormale(attaquant, defenseur);
		sauv.sauver();
	}
	
	
	// ************* les actions ************

	public void attaquerC(Infanterie attaquant, Infanterie defenseur) {
		if (this.toucherC(attaquant, defenseur)) {
			if (this.blesser(attaquant, defenseur))
				this.sauver(attaquant, defenseur);
		}
	}
}

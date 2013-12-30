package principal;

import principal.Blesse.Blessure;
import principal.Blesse.BlessureNormale;
import principal.Sauvegarde.Sauvegarde;
import principal.Sauvegarde.SauvegardeNormale;
import principal.ToucheC.ToucheC;
import principal.ToucheC.ToucheCNormale;
import principal.ToucheC.ToucherVeh;
import principal.armeC.AttaqueC;
import principal.armeC.AttaqueCInf;
import principal.armeC.AttaqueCVeh;
import principal.vehicule.EffetDegat;
import principal.vehicule.Penetration;
import principal.vehicule.PenetrationC;

public class ArmeC {
	
	// ******************* les trois phases *******************

	public boolean toucherC(Infanterie attaquant, Infanterie defenseur) {
		ToucheC tt = new ToucheCNormale(attaquant, defenseur);
		return tt.toucherC();
	}

	public boolean blesser(Infanterie attaquant, Infanterie defenseur) {
		Blessure bls = new BlessureNormale(attaquant, defenseur);
		return bls.blesser();
	}

	public void sauver(Infanterie attaquant, Infanterie defenseur) {
		Sauvegarde sauv = new SauvegardeNormale(attaquant, defenseur,
				new ArmeT());
		sauv.sauver();
	}

	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

	public boolean toucherC(Infanterie attaquant, Vehicule defenseur) {
		ToucheC tc = new ToucherVeh(attaquant, defenseur);
		return tc.toucherC();
	}

	protected Penetration pen;

	public boolean blesser(Infanterie attaquant, Vehicule defenseur) {
		PenetrationC bls = new PenetrationC(attaquant, defenseur);
		pen = bls;
		return bls.blesser();
	}

	public void sauver(Vehicule defenseur) {
		Sauvegarde sauvegarde = new EffetDegat(defenseur, this.pen);
		sauvegarde.sauver();
	}

	// ************* les actions ************

	public void attaquerC(Infanterie attaquant, Infanterie defenseur) {
		AttaqueC ac = new AttaqueCInf(attaquant, defenseur, this);
		ac.attaquerC();
	}

	public void attaquerC(Infanterie attaquant, Vehicule defenseur) {
		AttaqueC ac = new AttaqueCVeh(attaquant, defenseur, this);
		ac.attaquerC();
	}
}

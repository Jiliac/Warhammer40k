package principal.armeT;

import principal.ArmeT;
import principal.Infanterie;
import principal.Unite;

public class ArmeLourde extends ArmeT {
	protected boolean utilisable = true;
	protected ArmeLourde(int portee, int f, int pa, int nbTir) {
		super(portee, f, pa, nbTir);
		this.used = false;
	}

	public void attaquerT(Unite attaquant, Infanterie defenseur) {
		// comportement d'une armeLourde
		if (attaquant instanceof Infanterie)
			this.utilisable = !attaquant.isDeplace();
		if (this.utilisable == false || !this.aPorte(attaquant, defenseur))
			return;
		else
			used = true;
		
		if (this.toucherT(attaquant, defenseur)) {
			if (this.blesser(attaquant, defenseur))
				this.sauver(attaquant, defenseur);
		}
		

	}

	public boolean isAbleToCharge() {
		return !used;
	}

}

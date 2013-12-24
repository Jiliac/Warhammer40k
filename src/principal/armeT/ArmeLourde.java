package principal.armeT;

import principal.ArmeT;
import principal.Unite;
import principal.Blesse.Blessure;
import principal.Sauvegarde.Sauvegarde;
import principal.ToucheT.ToucheT;
import principal.armeT.attaqueT.AttaqueTClassique;

public class ArmeLourde extends ArmeT {
	protected ArmeLourde(int portee, int f, int pa, int nbTir) {
		super(portee, f, pa, nbTir);
		this.used = false;
	}

	public void attaquerT(Unite attaquant, Unite defenseur) {
		//comportement d'une armeLourde
		if (attaquant.isDeplace() == true)
			return;
		else
			used = true;

		AttaqueTClassique atc = new AttaqueTClassique(attaquant,defenseur,this);
		atc.attaquerT();
	}

	public boolean isAbleToCharge() {
		return !used;
	}

}

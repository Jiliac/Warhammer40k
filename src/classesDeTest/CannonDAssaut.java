package classesDeTest;

import principal.Infanterie;
import principal.Unite;
import principal.Blesse.Blessure;
import principal.Blesse.BlessurePerforante;
import principal.armeT.type.ArmeLourde;

public class CannonDAssaut extends ArmeLourde {
	public CannonDAssaut() {
		super(24, 6, 4, 4);
	}

	public boolean blesser(Unite attaquant, Infanterie defenseur) {
		Blessure bls = new BlessurePerforante(attaquant, defenseur, this);
		return bls.blesser();
	}
}

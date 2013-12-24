package principal.Blesse;

import principal.Unite;
import principal.Sauvegarde.Sauvegarde;
import principal.Sauvegarde.SauvegardeInutile;

public class BlessureInutile extends BlessureMere implements Blessure{

	public BlessureInutile(Unite attaquant, Unite defenseur) {
		super(attaquant, defenseur);
		// TODO Auto-generated constructor stub
	}

	
	public Sauvegarde blesser() {
		// TODO Auto-generated method stub
		Sauvegarde sauv = new SauvegardeInutile(attaquant,defenseur);
		return sauv;
	}

}

package principal.Sauvegarde;

import principal.Unite;

public class SauvegardeInutile extends SauvegardeMere implements Sauvegarde{

	public SauvegardeInutile(Unite attaquant, Unite defenseur) {
		super(attaquant, defenseur);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean sauver() {
		return true;
	}

}

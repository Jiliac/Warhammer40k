package principal.Sauvegarde;

import principal.Infanterie;
import principal.Unite;

public class SauvegardeFausse
		/* je suis pas sur que ca soit bien necessaire... */extends
		SauvegardeMere implements Sauvegarde {
	public SauvegardeFausse(Unite attaquant, Infanterie defenseur) {
		super(attaquant, defenseur);
		// TODO Auto-generated constructor stub
	}

	public void sauver() {
		this.defenseur.pertePv();
	}
}

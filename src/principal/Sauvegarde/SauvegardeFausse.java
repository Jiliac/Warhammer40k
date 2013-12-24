package principal.Sauvegarde;

import principal.Unite;

public class SauvegardeFausse
		/* je suis pas sur que ca soit bien necessaire... */extends
		SauvegardeMere implements Sauvegarde {
	public SauvegardeFausse(Unite attaquant, Unite defenseur) {
		super(attaquant, defenseur);
		// TODO Auto-generated constructor stub
	}

	public boolean sauver() {
		System.out.println("test de sauvegardeFausse");
		return false;
	}
}

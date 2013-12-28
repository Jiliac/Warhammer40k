package principal.Sauvegarde;

import principal.Infanterie;
import principal.Unite;

public class SauvegardeFausse
		/* je suis pas sur que ca soit bien necessaire... */extends
		SauvegardeMere implements Sauvegarde {
	public SauvegardeFausse(Unite attaquant, Infanterie defenseur) {
		super(null,null);
		// TODO Auto-generated constructor stub
	}
	public SauvegardeFausse(Unite attaquant, Unite defenseur){
		super(null,null);
	}
	
	public SauvegardeFausse(){
		super(null,null);
	}

	public void sauver() {
		this.defenseur.pertePv();
	}
}

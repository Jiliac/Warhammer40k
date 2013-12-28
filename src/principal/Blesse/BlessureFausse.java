package principal.Blesse;

import principal.Infanterie;
import principal.Unite;
import principal.Sauvegarde.Sauvegarde;
import principal.Sauvegarde.SauvegardeFausse;

public class BlessureFausse extends BlessureMere implements Blessure{

	public BlessureFausse(Unite attaquant, Infanterie defenseur) {
		super(attaquant, defenseur);
		// TODO Auto-generated constructor stub
	}
	public BlessureFausse(Unite attaquant, Unite defenseur){
		super(null,null);
	}
	public BlessureFausse(){
		super(null,null);
	}
	
	public Sauvegarde blesser(){
		Sauvegarde sf = new SauvegardeFausse(null,null);
		return sf;
	}
	
}

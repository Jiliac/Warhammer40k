package principal.Blesse;

import principal.Infanterie;
import principal.Unite;

public class BlessureMere {
	protected Unite attaquant;
	protected Infanterie defenseur;
	public BlessureMere(Unite attaquant,Infanterie defenseur){
		this.attaquant=attaquant;
		this.defenseur=defenseur;
	}
}

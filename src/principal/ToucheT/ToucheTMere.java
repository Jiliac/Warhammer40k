package principal.ToucheT;

import principal.Unite;

public class ToucheTMere {
	Unite attaquant,defenseur;
	int ct;
	public ToucheTMere(Unite attaquant,Unite defenseur){
		this.attaquant=attaquant;
		this.defenseur=defenseur;
		this.ct=attaquant.getCt();
	}
}

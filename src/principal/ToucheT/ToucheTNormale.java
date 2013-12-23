package principal.ToucheT;

import principal.Unite;
import principal.Blesse.Blessure;
import principal.Blesse.BlessureFausse;
import principal.Blesse.BlessureNormale;
import de.De;
import de.De6;

public class ToucheTNormale extends ToucheTMere implements ToucheT{
	int jet=-1;
	public ToucheTNormale(Unite attaquant, Unite defenseur) {
		super(attaquant, defenseur);
	}
	public ToucheTNormale(Unite attaquant,Unite defenseur,int jet){
		this(attaquant,defenseur);
		this.jet=jet;
	}

	public Blessure toucheT() {
		Blessure retour;
		De de = new De6();
		if(jet==-1)
			jet=de.jet();
		if (ct < 6) {
			if (jet >= (7 - ct))
				retour = new BlessureNormale(attaquant, defenseur);
			else
				retour = new BlessureFausse(attaquant, defenseur);
		} else {
			if (jet >= 2)
				retour = new BlessureNormale(attaquant, defenseur);
			else {
				if (jet >= 12 - ct)
					retour = new BlessureNormale(attaquant, defenseur);
				else
					retour = new BlessureFausse(attaquant, defenseur);
			}
		}
		return retour;
	}
}

package principal.ToucheT;

import principal.Unite;
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

	public boolean toucherT() {
		boolean retour;
		De de = new De6();
		if(jet==-1)
			jet=de.jet();
		if (ct < 6) {
			//considere les cas vehicule et infanterie...
			if (jet >= (7 - ct))
				retour = true;
			else
				retour = false;
		} else {
			if (jet >= 2)
				retour = true;
			else {
				if (jet >= 12 - ct)
					retour = true;
				else
					retour = false;
			}
		}
		return retour;
	}
}

package principal.ToucheC;

import de.De;
import de.De6;
import principal.Infanterie;

public class ToucheCNormale extends ToucheCMere implements ToucheC {
	private int ccAt, ccDef;

	public ToucheCNormale(Infanterie attaquant, Infanterie defenseur) {
		super(attaquant, defenseur);
		this.ccAt = attaquant.getCc();
		this.ccDef = defenseur.getCc();
	}

	public boolean toucherC() {
		De de = new De6();
		boolean retour;
		int jet = de.jet();
		int tableJet[][] = { { 4, 4, 5, 5, 5, 5, 5, 5, 5, 5 },
				{ 3, 4, 4, 4, 5, 5, 5, 5, 5, 5 },
				{ 3, 3, 4, 4, 4, 4, 5, 5, 5, 5 },
				{ 3, 3, 3, 4, 4, 4, 4, 4, 5, 5 },
				{ 3, 3, 3, 3, 4, 4, 4, 4, 4, 4 },
				{ 3, 3, 3, 3, 3, 4, 4, 4, 4, 4 },
				{ 3, 3, 3, 3, 3, 3, 4, 4, 4, 4 },
				{ 3, 3, 3, 3, 3, 3, 3, 4, 4, 4 },
				{ 3, 3, 3, 3, 3, 3, 3, 3, 4, 4 },
				{ 3, 3, 3, 3, 3, 3, 3, 3, 3, 4 } };
		if (jet >= tableJet[ccAt - 1][ccDef - 1])
			retour = true;
		else
			retour = false;
		return retour;
	}
}

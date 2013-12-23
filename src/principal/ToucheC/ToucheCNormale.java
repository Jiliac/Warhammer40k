package principal.ToucheC;

import de.De;
import de.De6;
import principal.Unite;
import principal.Blesse.Blessure;
import principal.Blesse.BlessureFausse;
import principal.Blesse.BlessureNormale;

public class ToucheCNormale extends ToucheCMere implements ToucheC{
	private int ccAt,ccDef;
	public ToucheCNormale(Unite attaquant, Unite defenseur) {
		super(attaquant, defenseur);
		this.ccAt=attaquant.getCc();
		this.ccDef=defenseur.getCc();
	}
	
	public Blessure toucherC(){
		De de = new De6();
		Blessure blessure;
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
		if (de.jet() >= tableJet[ccAt - 1][ccDef - 1])
			blessure=new BlessureNormale(attaquant,defenseur);
		else
			blessure=new BlessureFausse(attaquant,defenseur);
		return blessure;
	}
}

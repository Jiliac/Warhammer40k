package principal.Blesse;

import de.De;
import de.De6;
import principal.Unite;
import principal.Sauvegarde.Sauvegarde;
import principal.Sauvegarde.SauvegardeInutile;
import principal.Sauvegarde.SauvegardeNormale;

public class BlessureNormale extends BlessureMere implements Blessure {
	private int f, e;
	private int jet = -1;

	public BlessureNormale(Unite attaquant, Unite defenseur) {
		super(attaquant, defenseur);
		this.f = attaquant.getF();
		this.e = defenseur.getE();
	}

	public BlessureNormale(Unite attaquant, Unite defenseur, int jet) {
		this(attaquant, defenseur);
		this.jet = jet;
	}

	public Sauvegarde blesser() {
		if (jet == -1) {
			De de = new De6();
			jet = de.jet();
		}
		Sauvegarde retour;
		int tableJet[][] = { { 4, 5, 6, 6, 7, 7, 7, 7, 7, 7 },
				{ 3, 4, 5, 6, 6, 7, 7, 7, 7, 7 },
				{ 2, 3, 4, 5, 6, 6, 7, 7, 7, 7 },
				{ 2, 2, 3, 4, 5, 6, 6, 7, 7, 7 },
				{ 2, 2, 2, 3, 4, 5, 6, 6, 7, 7 },
				{ 2, 2, 2, 2, 3, 4, 5, 6, 6, 7 },
				{ 2, 2, 2, 2, 2, 3, 4, 5, 6, 6 },
				{ 2, 2, 2, 2, 2, 2, 3, 4, 5, 6 },
				{ 2, 2, 2, 2, 2, 2, 2, 3, 4, 5 },
				{ 2, 2, 2, 2, 2, 2, 2, 2, 3, 4 } };
		if (jet >= tableJet[f - 1][e - 1])
			retour = new SauvegardeNormale(attaquant, defenseur);
		else
			retour = new SauvegardeInutile(attaquant,defenseur);

		return retour;
	}
}

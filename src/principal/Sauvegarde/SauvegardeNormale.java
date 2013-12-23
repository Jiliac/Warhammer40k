package principal.Sauvegarde;

import classesDeTest.UniteTest;
import de.De;
import de.De6;
import principal.Unite;
import principal.Sauvegarde.Sauvegarde;

public class SauvegardeNormale extends SauvegardeMere implements Sauvegarde {
	private int svg;
	private int pa;

	public SauvegardeNormale(Unite attaquant, Unite defenseur) {
		super(attaquant,defenseur);
		this.pa=attaquant.getArmeT().getPa();
		this.svg=defenseur.getSvg();
	}

	public boolean sauver() {
		De de = new De6();
		boolean reussite = false;
		if (de.jet() >= svg && pa > svg)
			reussite = true;
		return reussite;
	}
}

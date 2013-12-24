package principal.Sauvegarde;

import de.De;
import de.De6;
import principal.Unite;
import principal.UniteTest;
import principal.Sauvegarde.Sauvegarde;

public class SauvegardeNormale extends SauvegardeMere implements Sauvegarde {
	private int svg;
	private int pa;

	public SauvegardeNormale(Unite attaquant, Unite defenseur) {
		super(attaquant,defenseur);
		if(attaquant.getArmeT()!=null)
			this.pa=attaquant.getArmeT().getPa();
		else
			System.out.println(attaquant.getArmeT());
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

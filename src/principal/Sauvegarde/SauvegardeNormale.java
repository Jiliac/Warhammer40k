package principal.Sauvegarde;

import de.De;
import de.De6;
import principal.ArmeT;
import principal.Infanterie;
import principal.Unite;
import principal.Sauvegarde.Sauvegarde;

public class SauvegardeNormale extends SauvegardeMere implements Sauvegarde {
	private int svg;
	private int pa;

	public SauvegardeNormale(Unite attaquant, Infanterie defenseur, ArmeT armeT) {
		super(attaquant,defenseur,armeT);
		if(armeT!=null)
			this.pa=armeT.getPa();
		this.svg=defenseur.getSvg();
	}

	public void sauver() {
		De de = new De6();
		boolean reussite;
		if (de.jet() >= svg && pa > svg)
			reussite = true;
		else
			reussite=false;
		if (reussite == false)
			defenseur.pertePv();
	}
}

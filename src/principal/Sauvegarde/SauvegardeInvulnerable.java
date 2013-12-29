package principal.Sauvegarde;

import de.De;
import de.De6;
import principal.ArmeT;
import principal.Infanterie;
import principal.Unite;
import principal.Sauvegarde.Sauvegarde;

public class SauvegardeInvulnerable extends SauvegardeMere implements
		Sauvegarde {
	private int svgi;

	public SauvegardeInvulnerable(Unite attaquant,Infanterie defenseur, ArmeT armeT, int svgi) {
		super(attaquant, defenseur, armeT);
		this.svgi = svgi;
	}

	public SauvegardeInvulnerable(SauvegardeNormale sauv, int svgi) {
		this(sauv.getAttaquant(), sauv.getDefenseur(), sauv.getArmeT(), svgi);
	}

	public void sauver() {
		boolean reussite;
		De de = new De6();
		if (de.jet() >= svgi)
			reussite = true;
		else
			reussite = false;
		if (reussite == false)
			defenseur.pertePv();
	}
}

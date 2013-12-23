package principal.Sauvegarde;

import de.De;
import de.De6;
import principal.Unite;
import principal.Sauvegarde.Sauvegarde;

public class SauvegardeInvulnerable extends SauvegardeNormale implements Sauvegarde{
	private int svg;
	public SauvegardeInvulnerable(Unite attaquant,Unite defenseur){
		super(attaquant,defenseur);
		this.svg=defenseur.getSvg();
	}
	
	public SauvegardeInvulnerable(SauvegardeNormale sauv){
		this(sauv.getAttaquant(),sauv.getDefenseur());
	}
	
	public boolean sauver(){
		De de = new De6();
		boolean reussite = false;
		if (de.jet() >= svg)
			reussite = true;
		return reussite;
	}
}

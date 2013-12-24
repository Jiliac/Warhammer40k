package principal.Sauvegarde;

import de.De;
import de.De6;
import principal.Unite;
import principal.Sauvegarde.Sauvegarde;

public class SauvegardeInvulnerable extends SauvegardeNormale implements Sauvegarde{
	private int svgi;
	public SauvegardeInvulnerable(Unite attaquant,Unite defenseur,int svgi){
		super(attaquant,defenseur);
		this.svgi=svgi;
	}
	
	public SauvegardeInvulnerable(SauvegardeNormale sauv,int svgi){
		this(sauv.getAttaquant(),sauv.getDefenseur(),svgi);
	}
	
	public boolean sauver(){
		De de = new De6();
		boolean reussite = false;
		if (de.jet() >= svgi)
			reussite = true;
		return reussite;
	}
}

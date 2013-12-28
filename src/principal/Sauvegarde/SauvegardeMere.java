package principal.Sauvegarde;

import principal.Infanterie;
import principal.Unite;

public abstract class SauvegardeMere {
	protected Unite attaquant=null;
	protected Infanterie defenseur=null;

	public SauvegardeMere(Unite attaquant,Infanterie defenseur) {
		this.attaquant = attaquant;
		this.defenseur = defenseur;
	}
	
	public Unite getAttaquant(){
		return this.attaquant;
	}
	public Infanterie getDefenseur(){
		return this.defenseur;
	}
}

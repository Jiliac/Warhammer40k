package principal.Sauvegarde;

import principal.Unite;

public abstract class SauvegardeMere {
	protected Unite attaquant=null, defenseur=null;

	public SauvegardeMere(Unite attaquant, Unite defenseur) {
		this.attaquant = attaquant;
		this.defenseur = defenseur;
	}
	
	public Unite getAttaquant(){
		return this.attaquant;
	}
	public Unite getDefenseur(){
		return this.defenseur;
	}
}

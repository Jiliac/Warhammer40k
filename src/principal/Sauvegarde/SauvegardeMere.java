package principal.Sauvegarde;

import principal.ArmeT;
import principal.Infanterie;
import principal.Unite;

public abstract class SauvegardeMere {
	protected Unite attaquant=null;
	protected Infanterie defenseur=null;
	protected ArmeT armeT;

	public SauvegardeMere(Unite attaquant,Infanterie defenseur,ArmeT armeT) {
		this.attaquant = attaquant;
		this.defenseur = defenseur;
		this.armeT = armeT;
	}
	
	public Unite getAttaquant(){
		return this.attaquant;
	}
	public Infanterie getDefenseur(){
		return this.defenseur;
	}
	public ArmeT getArmeT(){
		return this.armeT;
	}
}

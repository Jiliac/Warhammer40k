package classesDeTest;

import principal.ArmeT;

public class ArmeCEnergetique extends ArmeT {
	
	/*
	 * En gros c'est une arme qui sert juste dans la methode sauver() de ArmeC
	 * On met new SauvegardeNormale(attaquant,defenseur, new ArmeCEnergetique() )
	 * Comme elle a une PA de 2, ca enleve les sauvegarde de base.
	 */
	
	public ArmeCEnergetique(){
		super();
		this.setPa(2);
	}
}

package principal.vehicule;

import principal.ArmeT;
import principal.Unite;
import principal.Vehicule;
import principal.Blesse.Blessure;
import principal.Blesse.BlessureFausse;
import principal.Sauvegarde.Sauvegarde;
import principal.ToucheT.ToucheT;
import de.De6;

public class PenetrationBlindage implements Blessure{
	Unite attaquant;
	Vehicule vehicule;
	ArmeT armeT;
	ToucheT toucheT;
	public PenetrationBlindage(Unite attaquant, Vehicule vehicule, ArmeT armeT, ToucheT toucheT){
		this.attaquant=attaquant;
		this.vehicule=vehicule;
		this.armeT=armeT;
		this.toucheT=toucheT;
	}
	
	public Sauvegarde blesser(){
		int blindage = vehicule.associerBlindage(attaquant,vehicule);
		//la il faudrait un arbre de decision mais je commence comme ca
		int jetDegat;
		if(toucheT.toucherT() instanceof BlessureFausse)
			jetDegat=7;
		else{
			De6 de = new De6();
			int jetPenetration = de.jet();
			if(jetPenetration+armeT.getF()>=blindage/*y'a vraiment bcp de truc a refaire
			ici, il y le cas > et le cas == a distinguer*/){
				
				jetDegat = de.jet();
				jetDegat = this.modificateur(jetDegat);
				
			}
			else
				jetDegat=0;
		}
		EffetDegat ef = new EffetDegat(jetDegat, vehicule);
		return ef;
	}
	
	private int modificateur(int jetDegat){
		int retour = jetDegat;
		
		//la il faut distinguer tous les cas en fonction de l'attaquant, du defenseur et de son arme
		
		return retour;
	}
}

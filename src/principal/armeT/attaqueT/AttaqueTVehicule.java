package principal.armeT.attaqueT;

import de.De6;
import principal.ArmeT;
import principal.Unite;
import principal.Vehicule;
import principal.Blesse.BlessureFausse;
import principal.ToucheT.ToucheT;

public class AttaqueTVehicule implements AttaqueT{
	Unite attaquant;
	Vehicule vehicule;
	ArmeT armeT;
	ToucheT toucheT;
	public AttaqueTVehicule(Unite attaquant, Vehicule vehicule, ArmeT armeT, ToucheT toucheT){
		this.attaquant=attaquant;
		this.vehicule=vehicule;
		this.armeT=armeT;
		this.toucheT=toucheT;
	}
	
	public void attaquerT(){
		int blindage = vehicule.associerBlindage(attaquant,vehicule);
		//la il faudrait un arbre de decision mais je commence comme ca
		if(!(toucheT.toucherT() instanceof BlessureFausse)){
			De6 de = new De6();
			int jetPenetration = de.jet();
			if(jetPenetration+armeT.getF()>=blindage/*y'a vraiment bcp de truc a refaire
			ici, il y le cas > et le cas == a distinguer*/){
				int jetDegat = de.jet();
				//et la il y a tout les cas a distinguer...
			}
		}
	}
}

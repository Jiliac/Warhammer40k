package principal.armeT.attaqueT;

import principal.ArmeT;
import principal.Unite;
import principal.Vehicule;

public class AttaqueTVeh implements AttaqueT{
	Unite attaquant;
	Vehicule defenseur;
	ArmeT armeT;
	public AttaqueTVeh(Unite attaquant, Vehicule defenseur, ArmeT armeT){
		this.attaquant = attaquant;
		this.defenseur = defenseur;
		this.armeT = armeT;
	}
	
	public void attaquerT(){
		if (armeT.aPorte(attaquant, defenseur)) {
			if (armeT.toucherT(attaquant, defenseur)) {
				if (armeT.blesser(attaquant, defenseur))
					armeT.sauver(defenseur);
			}
		}
	}
}
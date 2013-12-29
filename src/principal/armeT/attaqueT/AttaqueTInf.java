package principal.armeT.attaqueT;

import principal.ArmeT;
import principal.Infanterie;
import principal.Unite;

public class AttaqueTInf implements AttaqueT{
	Unite attaquant;
	Infanterie defenseur;
	ArmeT armeT;
	public AttaqueTInf(Unite attaquant, Infanterie defenseur, ArmeT armeT){
		this.attaquant = attaquant;
		this.defenseur = defenseur;
		this.armeT = armeT;
	}
	
	public void attaquerT(){
		if (armeT.aPorte(attaquant, defenseur)) {
			if (armeT.toucherT(attaquant, defenseur)) {
				if (armeT.blesser(attaquant, defenseur))
					armeT.sauver(attaquant, defenseur);
			}
		}
	}
}

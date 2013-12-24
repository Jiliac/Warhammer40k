package principal.armeT.attaqueT;

import principal.ArmeT;
import principal.Unite;
import principal.Blesse.Blessure;
import principal.Sauvegarde.Sauvegarde;
import principal.ToucheT.ToucheT;

public class AttaqueTClassique extends AttaqueTMere implements AttaqueT{
	public AttaqueTClassique(Unite attaquant, Unite defenseur, ArmeT armeT) {
		super(attaquant, defenseur, armeT);
		// TODO Auto-generated constructor stub
	}

	public void attaquerT(){
		ToucheT toucheT = armeT.associationToucheT(attaquant, defenseur);
		Blessure blessure = armeT.associationBlessure(attaquant, defenseur,
				toucheT.toucherT());
		Sauvegarde sauvegarde = armeT.associationSauvegarde(attaquant,
				defenseur, blessure.blesser());
		sauvegarde.sauver();
	}
}

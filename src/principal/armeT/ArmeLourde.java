package principal.armeT;

import principal.ArmeT;
import principal.Unite;
import principal.Blesse.Blessure;

public class ArmeLourde extends ArmeT{
	protected ArmeLourde(int portee, int f, int pa, int nbTir) {
		super(portee, f, pa, nbTir);
		this.used=false;
	}

	public void attaquerT(Unite attaquant,Unite defenseur,Blessure blessure){
		if(attaquant.isDeplace()==false){
			//C'EST VRAIMENT TROP MOCHE DE FAIRE CA...	
			ArmeAssaut arme = new ArmeAssaut(portee,f,pa,nbTir);
			arme.attaquerT(attaquant, defenseur, blessure);
			
		}
	}
	
	public boolean isAbleToCharge(){
		return !used;
	}

}

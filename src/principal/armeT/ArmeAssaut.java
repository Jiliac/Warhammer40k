package principal.armeT;

import principal.ArmeT;
import principal.Unite;
import principal.Blesse.Blessure;
import principal.Blesse.BlessureNormale;
import principal.Sauvegarde.Sauvegarde;
import principal.ToucheT.ToucheT;

public class ArmeAssaut extends ArmeT {
	protected ArmeAssaut(int portee, int f, int pa, int nbTir) {
		super(portee, f, pa, nbTir);
		this.used=false;
	}
	
	public boolean isAbleToCharge(){
		return true;
	}
}

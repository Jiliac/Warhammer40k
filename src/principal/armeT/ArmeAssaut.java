package principal.armeT;

import principal.ArmeT;

public class ArmeAssaut extends ArmeT {
	protected ArmeAssaut(int portee, int f, int pa, int nbTir) {
		super(portee, f, pa, nbTir);
		this.used=false;
	}
	
	public boolean isAbleToCharge(){
		return true;
	}
}

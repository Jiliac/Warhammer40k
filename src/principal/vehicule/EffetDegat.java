package principal.vehicule;

import principal.Vehicule;
import principal.Sauvegarde.Sauvegarde;

public class EffetDegat implements Sauvegarde{
	private int jetDegat;
	private Vehicule vehicule;
	public EffetDegat (int jetDegat, Vehicule vehicule){
		this.jetDegat=jetDegat;
		this.vehicule=vehicule;
	}
	
	public void sauver(){
		if(jetDegat==1)
			vehicule.secouer();
		else if(jetDegat==2)
			vehicule.sonne();
		else if(jetDegat==3)
			vehicule.armeDetruite();
		else if(jetDegat==4)
			vehicule.immobilise();
		else if(jetDegat==5)
			vehicule.epave();
		else if(jetDegat==6)
			vehicule.explosion();
	}
}
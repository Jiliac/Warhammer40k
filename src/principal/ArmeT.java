package principal;

import principal.Blesse.Blessure;
import principal.Blesse.BlessureInutile;
import principal.Blesse.BlessureNormale;
import principal.Blesse.BlessurePerforante;
import principal.Blesse.BlessureSniper;
import principal.Sauvegarde.Sauvegarde;
import principal.Sauvegarde.SauvegardeInutile;
import principal.Sauvegarde.SauvegardeNormale;
import principal.ToucheT.ToucheT;
import principal.ToucheT.ToucheTNormale;
import principal.ToucheT.ToucheTSurchauffe;

public abstract class ArmeT {
	protected boolean used;
	protected int portee;
	protected int f;
	protected int pa;
	protected int nbTir;
	protected String typeToucheT, typeBlessure, typeSauvegarde;

	// ********************* les actions **********************

	public abstract boolean isAbleToCharge();

	public boolean aPorte(Unite attaquant, Unite defenseur) {
		return attaquant.aPorte(portee, defenseur);
	}
	
	public void attaquerT(Unite attaquant, Unite defenseur){
		ToucheT toucheT= this.associationToucheT(attaquant, defenseur);
		Blessure blessure = this.associationBlessure(attaquant, defenseur,toucheT.toucherT());
		Sauvegarde sauvegarde = this.associationSauvegarde(attaquant,defenseur,blessure.blesser());
		if(sauvegarde.sauver()==false)
			defenseur.pertePv();
	}

	

	// ********************* constructeur **********************
	protected ArmeT(int portee, int f, int pa, int nbTir, String toucheT,
			String blessure, String sauvegarde) {
		this.portee = portee;
		this.f = f;
		this.pa = pa;
		this.nbTir = nbTir;
		this.typeToucheT = toucheT;
		this.typeBlessure = blessure;
		this.typeSauvegarde = sauvegarde;
	}

	protected ArmeT(int portee, int f, int pa, int nbTir) {
		this(portee, f, pa, nbTir, "normal", "normal", "normal");
	}

	// ************* constructeurs de combat *****************

	public ToucheT associationToucheT(Unite attaquant, Unite defenseur) {
		ToucheT retour = null;
		if (typeToucheT == "normal")
			retour = new ToucheTNormale(attaquant, defenseur);
		else if (typeToucheT == "surchauffe")
			retour = new ToucheTSurchauffe(attaquant, defenseur);

		return retour;
	}

	public Blessure associationBlessure(Unite attaquant, Unite defenseur, Blessure blessure) {
		Blessure retour = null;
		
		if (blessure.getClass().toString()==BlessureInutile.class.toString())
			retour = blessure;
		if (typeBlessure == "normal")
			retour = new BlessureNormale(attaquant, defenseur);
		else if (typeBlessure == "perforante")
			retour = new BlessurePerforante(attaquant, defenseur);
		else if (typeBlessure == "sniper")
			retour = new BlessureSniper(attaquant, defenseur);

		return retour;
	}

	public Sauvegarde associationSauvegarde(Unite attaquant, Unite defenseur, Sauvegarde sauvegarde) {
		Sauvegarde retour = null;
		
		if(sauvegarde.getClass().toString()==SauvegardeInutile.class.toString())
			retour = sauvegarde;
		else if (typeSauvegarde == "normal")
			retour = new SauvegardeNormale(attaquant, defenseur);

		return retour;
	}

	// ******************** getters et setters ***************

	public int getPortee() {
		return portee;
	}

	public int getF() {
		return f;
	}

	public int getPa() {
		return pa;
	}

	public int getNbTir() {
		return nbTir;
	}

	protected void setNbTir(int nbTir) {
		this.nbTir = nbTir;
	}

	public void setPa(int pa) {
		this.pa = pa;
	}
}

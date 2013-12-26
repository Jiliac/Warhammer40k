package principal;

import java.util.ArrayList;

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
import principal.armeT.attaqueT.AttaqueTClassique;
import principal.armeT.attaqueT.AttaqueTSurface;

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

	public void attaquerT(Unite attaquant, Unite defenseur) {
		AttaqueTClassique atc = new AttaqueTClassique(attaquant, defenseur,
				this);
		atc.attaquerT();
	}

	public void attaquerTUT(Unite attaquant, Troupe troupeDef) {
		this.associationTUT(attaquant, troupeDef);
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

	// ************* cAttaque de Surface *****************

	public void associationTUT(Unite attaquant, Troupe troupeDef) {
		if (this.associationAttaqueTSurface(attaquant,troupeDef)==null)
			attaquant.attaquerTUT(troupeDef);
		else
			this.attaqueSurface(attaquant, troupeDef);
	}

	public void attaqueSurface(Unite attaquant, Troupe troupeDef) {
		AttaqueTSurface ats; //ATTENTION ARBRE DE DECISION À FAIRE!!!!!!!!!!!!!
		ats=this.associationAttaqueTSurface(attaquant,troupeDef);
		ArrayList<Blessure> blessures = ats.toucherT();
		for(Blessure blessure : blessures){
			Sauvegarde sauvegarde = blessure.blesser();
			sauvegarde.sauver();
		}
		
		/*
		 * new methode de surface qui retourne des blessures (il va falloir
		 * faire un arbre de decision qi retourne quelle attaque de surface,
		 * mais je peux coder cette methode sans le savoir...) puis
		 * blessure.blesser() puis sauvegarde.sauver()
		 */
	}
	
	public AttaqueTSurface associationAttaqueTSurface(Unite attaquant, Troupe troupeDef){
		AttaqueTSurface retour = null;
		//probleme pour x et y!!!!!!
		int x=0,y=0;
		//a finir
		if(this.typeToucheT=="explosion")
			retour = new ToucheTExplosion();
		else if(this.typeToucheT="grandeExplosion")
			retour = new ToucheTGrandeExplosion();
		else if(this.typeToucheT="souffle")
			retour = new ToucheTSouffle();
		return retour;
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

	public Blessure associationBlessure(Unite attaquant, Unite defenseur,
			Blessure blessure) {
		Blessure retour = null;

		if (blessure instanceof BlessureInutile)
			retour = blessure;
		else if (typeBlessure == "normal")
			retour = new BlessureNormale(attaquant, defenseur);
		else if (typeBlessure == "perforante")
			retour = new BlessurePerforante(attaquant, defenseur);
		else if (typeBlessure == "sniper")
			retour = new BlessureSniper(attaquant, defenseur);

		return retour;
	}

	public Sauvegarde associationSauvegarde(Unite attaquant, Unite defenseur,
			Sauvegarde sauvegarde) {
		Sauvegarde retour = null;

		if (sauvegarde instanceof SauvegardeInutile)
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

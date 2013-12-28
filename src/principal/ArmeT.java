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
import principal.armeT.attaqueT.AttaqueT;
import principal.armeT.attaqueT.AttaqueTClassique;
import principal.armeT.attaqueT.AttaqueTSouffle;
import principal.armeT.attaqueT.AttaqueTSurface;
import principal.armeT.attaqueT.AttaqueTVehicule;
import principal.armeT.attaqueT.ToucheTExplosion;
import principal.armeT.attaqueT.ToucheTGrandeExplosion;

public abstract class ArmeT {
	protected boolean utilisable = true;
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
		AttaqueT at=null;
		if (defenseur instanceof Infanterie) {
			Infanterie def = (Infanterie) defenseur;
			at = new AttaqueTClassique(attaquant, def, this);
		} else if (defenseur instanceof Vehicule) {
			Vehicule def = (Vehicule) defenseur;
			at = new AttaqueTVehicule(attaquant, def, this);
		}

		if (this.utilisable == true)
			at.attaquerT();
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

	// ************* Attaque de Surface *****************

	public void associationTUT(Unite attaquant, Troupe troupeDef) {
		if (this.associationAttaqueTSurface(attaquant) == null)
			attaquant.attaquerTUT(troupeDef);
		else
			this.attaqueSurface(attaquant);
	}

	public void attaqueSurface(Unite attaquant) {
		AttaqueTSurface ats;
		ats = this.associationAttaqueTSurface(attaquant);
		ArrayList<Blessure> blessures = ats.toucherT();
		for (Blessure blessure : blessures) {
			Sauvegarde sauvegarde = blessure.blesser();
			sauvegarde.sauver();
		}
	}

	public AttaqueTSurface associationAttaqueTSurface(Unite attaquant) {
		AttaqueTSurface retour = null;
		// en fait c'est le moment où il faudrait demander à l'utilisateur de
		// décider des position d'attaque
		int x = 0, y = 0;
		// a finir
		if (this.typeToucheT != "") {
			if (this.typeToucheT == "explosion")
				retour = new ToucheTExplosion(attaquant, x, y);
			else if (this.typeToucheT == "grandeExplosion")
				retour = new ToucheTGrandeExplosion(attaquant, x, y);

			else if (this.typeToucheT == "souffle")
				retour = new AttaqueTSouffle(attaquant, x, y);
		}
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

	public boolean isUtilisable() {
		return utilisable;
	}

	public void setUtilisable(boolean utilisable) {
		this.utilisable = utilisable;
	}

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

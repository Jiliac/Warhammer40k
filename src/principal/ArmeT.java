package principal;

import java.util.ArrayList;

import principal.Blesse.Blessure;
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
import principal.armeT.attaqueT.ToucheTExplosion;
import principal.armeT.attaqueT.ToucheTGrandeExplosion;
import principal.vehicule.AttaqueTVehicule;

public abstract class ArmeT {
	protected boolean utilisable = true;
	protected boolean used;
	protected int portee;
	protected int f;
	protected int pa;
	protected int nbTir;

	// ******************* les trois phases *******************

	protected boolean toucherT(Unite attaquant, Infanterie defenseur) {
		ToucheT tt = new ToucheTNormale(attaquant, defenseur);
		return tt.toucherT();
	}

	protected boolean blesser(Unite attaquant, Infanterie defenseur) {
		Blessure bls = new BlessureNormale(attaquant, defenseur);
		return bls.blesser();
	}

	protected void sauver(Unite attaquant, Infanterie defenseur) {
		Sauvegarde sauv = new SauvegardeNormale(attaquant, defenseur);
		sauv.sauver();
	}

	// ********************* les actions **********************

	public abstract boolean isAbleToCharge();

	public boolean aPorte(Unite attaquant, Unite defenseur) {
		return attaquant.aPorte(portee, defenseur);
	}

	public void attaquerT(Unite attaquant, Infanterie defenseur) {
		if (this.toucherT(attaquant, defenseur)) {
			if (this.blesser(attaquant, defenseur))
				this.sauver(attaquant, defenseur);
		}
	}

	public void attaquerTUT(Unite attaquant, Troupe troupeDef) {
		this.associationTUT(attaquant, troupeDef);
	}

	// ********************* constructeur **********************
	protected ArmeT(int portee, int f, int pa, int nbTir) {
		this.portee = portee;
		this.f = f;
		this.pa = pa;
		this.nbTir = nbTir;
	}

	// ************* Attaque de Surface *****************
	// ATTENTION REVOIR APRES AVOIR FAIT LES ATTAQUES CLASSIQUES
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

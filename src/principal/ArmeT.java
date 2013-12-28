package principal;

import principal.Blesse.Blessure;
import principal.Blesse.BlessureNormale;
import principal.Sauvegarde.Sauvegarde;
import principal.Sauvegarde.SauvegardeNormale;
import principal.ToucheT.ToucheT;
import principal.ToucheT.ToucheTNormale;
import principal.vehicule.EffetDegat;
import principal.vehicule.Penetration;
import principal.vehicule.PenetrationBlindage;

public class ArmeT {
	protected boolean used;
	protected int portee;
	protected int f;
	protected int pa;
	protected int nbTir;

	// ******************* les trois phases *******************

	protected boolean toucherT(Unite attaquant, Unite defenseur) {
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

	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

	protected Penetration pen;

	protected boolean blesser(Infanterie attaquant, Vehicule defenseur) {
		PenetrationBlindage bls = new PenetrationBlindage(attaquant, defenseur);
		pen = bls;
		return bls.blesser();
	}

	protected boolean blesser(Vehicule attaquant, Vehicule defenseur) {
		PenetrationBlindage bls = new PenetrationBlindage(attaquant, defenseur,
				this);
		pen = bls;
		return bls.blesser();
	}

	protected boolean blesser(Unite attaquant, Vehicule defenseur) {
		boolean retour = false;
		if (attaquant instanceof Infanterie) {
			Infanterie at = (Infanterie) attaquant;
			retour = this.blesser(at, defenseur);
		} else if (attaquant instanceof Vehicule) {
			Vehicule at = (Vehicule) attaquant;
			retour = this.blesser(at, defenseur);
		}
		return retour;
	}

	protected void sauver(Vehicule defenseur) {
		Sauvegarde sauvegarde = new EffetDegat(defenseur, this.pen);
		sauvegarde.sauver();
	}

	// ********************* les actions **********************

	public boolean isAbleToCharge() {
		return true;
	}

	public boolean aPorte(Unite attaquant, Unite defenseur) {
		return attaquant.aPorte(this.portee, defenseur);
	}

	public void attaquerT(Unite attaquant, Infanterie defenseur) {
		if (this.aPorte(attaquant, defenseur)) {
			if (this.toucherT(attaquant, defenseur)) {
				if (this.blesser(attaquant, defenseur))
					this.sauver(attaquant, defenseur);
			}
		}
	}

	public void attaquerT(Unite attaquant, Vehicule defenseur) {
		if (this.aPorte(attaquant, defenseur)) {
			if (this.toucherT(attaquant, defenseur)) {
				if (this.blesser(attaquant, defenseur))
					this.sauver(defenseur);
			}
		}
	}

	/*
	 * ATTENTION public void attaquerTUT(Unite attaquant, Troupe troupeDef) {
	 * this.associationTUT(attaquant, troupeDef); }
	 */
	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

	public void attaquerT(Unite attaquant, Unite defenseur) {
		if (attaquant instanceof Infanterie) {
			Infanterie at = (Infanterie) attaquant;
			this.attaquerT(at, defenseur);
		} else if (attaquant instanceof Vehicule) {
			Vehicule at = (Vehicule) attaquant;
			this.attaquerT(at, defenseur);
		}
	}

	// ********************* constructeur **********************
	protected ArmeT(int portee, int f, int pa, int nbTir) {
		this.portee = portee;
		this.f = f;
		this.pa = pa;
		this.nbTir = nbTir;
	}

	/*
	 * // ************* Attaque de Surface ***************** // ATTENTION REVOIR
	 * APRES AVOIR FAIT LES ATTAQUES CLASSIQUES public void associationTUT(Unite
	 * attaquant, Troupe troupeDef) { if
	 * (this.associationAttaqueTSurface(attaquant) == null)
	 * attaquant.attaquerTUT(troupeDef); else this.attaqueSurface(attaquant); }
	 * 
	 * public void attaqueSurface(Unite attaquant) { AttaqueTSurface ats; ats =
	 * this.associationAttaqueTSurface(attaquant); ArrayList<Blessure> blessures
	 * = ats.toucherT(); for (Blessure blessure : blessures) { Sauvegarde
	 * sauvegarde = blessure.blesser(); sauvegarde.sauver(); } }
	 * 
	 * public AttaqueTSurface associationAttaqueTSurface(Unite attaquant) {
	 * AttaqueTSurface retour = null; // en fait c'est le moment où il faudrait
	 * demander à l'utilisateur de // décider des position d'attaque int x = 0,
	 * y = 0; // a finir if (this.typeToucheT != "") { if (this.typeToucheT ==
	 * "explosion") retour = new ToucheTExplosion(attaquant, x, y); else if
	 * (this.typeToucheT == "grandeExplosion") retour = new
	 * ToucheTGrandeExplosion(attaquant, x, y);
	 * 
	 * else if (this.typeToucheT == "souffle") retour = new
	 * AttaqueTSouffle(attaquant, x, y); } return retour; }
	 */
	// ******************* constructeur par defaut ***********

	public ArmeT() {
		this.portee = 0;
		this.f = 0;
		this.pa = 7;
		this.nbTir = 1;
	}
	// ********************** visualisation ******************
	
	public String toString(){
		String str;
		str = "Je suis "+this.getClass().toString()+"\n";
		str += "j'ai "+this.f+" force et "+this.pa+" pa.";
		return str;
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

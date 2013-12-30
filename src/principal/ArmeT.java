package principal;

import principal.Blesse.Blessure;
import principal.Blesse.BlessureNormale;
import principal.Sauvegarde.Sauvegarde;
import principal.Sauvegarde.SauvegardeNormale;
import principal.ToucheT.ToucheT;
import principal.ToucheT.ToucheTNormale;
import principal.armeT.attaqueT.AttaqueT;
import principal.armeT.attaqueT.AttaqueTInf;
import principal.armeT.attaqueT.AttaqueTVeh;
import principal.vehicule.EffetDegat;
import principal.vehicule.Penetration;
import principal.vehicule.PenetrationBlindage;

public class ArmeT {
	// ATTENTION IMPLEMENTER la variable utilisable me semble necessaire dans le
	// cas de vehicule...
	// p-e implementer un objet pour gerer cette "collection" de vehicule
	protected boolean used;
	protected int portee;
	protected int f;
	protected int pa;
	protected int nbTir;

	// ******************* les trois phases *******************

	public boolean toucherT(Unite attaquant, Unite defenseur) {
		ToucheT tt = new ToucheTNormale(attaquant, defenseur);
		return tt.toucherT();
	}

	public boolean blesser(Unite attaquant, Infanterie defenseur) {
		Blessure bls = new BlessureNormale(attaquant, defenseur);
		return bls.blesser();
	}

	public void sauver(Unite attaquant, Infanterie defenseur) {
		Sauvegarde sauv = new SauvegardeNormale(attaquant, defenseur, this);
		sauv.sauver();
	}

	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

	protected Penetration pen;

	public boolean blesser(Unite attaquant, Vehicule defenseur) {
		PenetrationBlindage bls = new PenetrationBlindage(attaquant, defenseur,
				this);
		pen = bls;
		return bls.blesser();
	}

	public void sauver(Vehicule defenseur) {
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
		AttaqueT at = new AttaqueTInf(attaquant, defenseur, this);
		at.attaquerT();
	}

	public void attaquerT(Unite attaquant, Vehicule defenseur) {
		AttaqueT at = new AttaqueTVeh(attaquant, defenseur, this);
		at.attaquerT();
	}

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

	// ************* Attaque de Surface *****************
	// ATTENTION REVOIR APRES AVOIR FAIT LES ATTAQUES CLASSIQUES

	// ******************* constructeur par defaut ***********

	public ArmeT() {
		this.portee = 0;
		this.f = 0;
		this.pa = 7;
		this.nbTir = 1;
	}

	// ********************** visualisation ******************

	public String toString() {
		String str;
		str = "Je suis " + this.getClass().toString() + "\n";
		str += "j'ai " + this.f + " force et " + this.pa + " pa.";
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

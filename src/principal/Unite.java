package principal;

import java.util.ArrayList;

public abstract class Unite {
	protected int cc, ct, f, e, pv, i, a, cd, svg;
	protected int blAvant, blFlanc, blArriere;
	protected int posX = 0, posY = 0;
	protected ArrayList<ArmeT> armes = new ArrayList<ArmeT>();

	// ***************** les actions ****************

	public abstract void attaquerC(Infanterie defenseur);

	public abstract void attaquerT(Infanterie defenseur);

	public abstract void attaquerC(Vehicule defenseur);

	public abstract void attaquerT(Vehicule defenseur);

	/* - - - - - - - - - - - - - - - - - - - - - - - - */

	public void attaquerC(Unite defenseur) {
		if (defenseur instanceof Infanterie) {
			Infanterie def = (Infanterie) defenseur;
			this.attaquerC(def);
		} else if (defenseur instanceof Vehicule) {
			Vehicule def = (Vehicule) defenseur;
			this.attaquerC(def);
		}
	}

	public void attaquerT(Unite defenseur) {
		if (defenseur instanceof Infanterie) {
			Infanterie def = (Infanterie) defenseur;
			this.attaquerT(def);
		} else if (defenseur instanceof Vehicule) {
			Vehicule def = (Vehicule) defenseur;
			this.attaquerT(def);
		}
	}

	/* - - - - - - - - - - - - - - - - - - - - - - - - */

	public void attaquerCUT(Troupe troupe) {
		ArrayList<Unite> tr = troupe.getTroupe();
		for (Unite defenseur : tr) {
			for (int i = 0; i < this.getA(); i++) {
				this.attaquerC(defenseur);
				troupe.restructure();
			}
		}
	}

	public void attaquerTUT(Troupe troupe) {
		ArrayList<Unite> tr = troupe.getTroupe();
		for (Unite defenseur : tr) {
			for (int i = 0; i < this.getArmeT().getNbTir(); i++) {
				this.attaquerT(defenseur);
				troupe.restructure();
			}
		}
	}

	// *********** gestion de la position ***********

	public boolean isDeplace() {
		// encore un truc a faire quand je ferais les deplacement...
		return false;
	}

	public double Distance(Unite attaquant, Unite defenseur) {
		int posXA, posYA, posXD, posYD;
		posXA = attaquant.getPosX();
		posYA = attaquant.getPosY();
		posXD = defenseur.getPosX();
		posYD = defenseur.getPosY();
		double distance = Math.sqrt((posXA - posXD) * (posXA - posXD)
				+ (posYA - posYD) * (posYA - posYD));
		return distance;
	}

	public double Distance(Unite defenseur) {
		return this.Distance(this, defenseur);
	}

	public boolean aPorte(int portee, Unite defenseur) {
		boolean retour;
		if (this.Distance(defenseur) <= portee)
			retour = true;
		else
			retour = false;
		return retour;
	}

	// ************ les points de vie ******************

	public void pertePv(int i) {
		this.pv += -i;
	}

	public void pertePv() {
		this.pertePv(1);
	}

	// **************** visualisation ********************
	public String toString() {
		String str;
		str = "je suis un " + this.getClass().toString() + " j'ai "
				+ this.getPv() + " points de vie.";
		return str;
	}

	// *********** les getters et setters **************

	public ArmeT getArmeT() {
		return armes.get(0);
	}

	public void setArmeT(ArmeT arme) {
		if (armes.size() == 0)
			armes.add(arme);
		else
			armes.add(0, arme);
	}

	public int getCc() {
		return cc;
	}

	public int getCt() {
		return ct;
	}

	public int getF() {
		return f;
	}

	public int getE() {
		return e;
	}

	public int getPv() {
		return pv;
	}

	public int getI() {
		return i;
	}

	public int getA() {
		return a;
	}

	public int getCd() {
		return cd;
	}

	public int getSvg() {
		return svg;
	}

	public int getBlAvant() {
		return blAvant;
	}

	public int getBlFlanc() {
		return blFlanc;
	}

	public int getBlArriere() {
		return blArriere;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
}

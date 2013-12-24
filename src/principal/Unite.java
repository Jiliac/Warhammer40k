package principal;

import principal.Blesse.Blessure;
import principal.Sauvegarde.Sauvegarde;
import principal.ToucheC.ToucheC;
import principal.ToucheC.ToucheCNormale;
import classesDeTest.ArmeTTest;

public abstract class Unite {
	protected ArmeT armeT;
	protected ArmeC armeC;
	protected int cc, ct, f, e, pv, i, a, cd, svg;
	protected int blAvant, blFlanc, blArriere;
	protected int posX = 0, posY = 0;

	// *********** les actions ************

	abstract void attaquerC(Unite defenseur);
	
	abstract void attaquerT(Unite defenseur);
	
	// *********** gestion de la position ***********
	
	public abstract boolean isDeplace();
	
	public double Distance(Unite attaquant,Unite defenseur){
		int posXA,posYA,posXD,posYD;
		posXA=attaquant.getPosX();
		posYA=attaquant.getPosY();
		posXD=defenseur.getPosX();
		posYD=defenseur.getPosY();
		double distance=Math.sqrt((posXA-posXD)*(posXA-posXD)+(posYA-posYD)*(posYA-posYD));
		return distance;
	}
	public double Distance(Unite defenseur){
		return this.Distance(this,defenseur);
	}
	public boolean aPorte(int portee, Unite defenseur){
		boolean retour;
		if(this.Distance(defenseur)<=portee)
			retour=true;
		else
			retour=false;
		return retour;
	}


	// ************ constructeur ********************
	public Unite() {
		this.armeT = new ArmeTTest();
		this.armeC = new ArmeCTest();
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
		str = "je suis un "+this.getClass().toString()+" j'ai " + this.getPv() + " points de vie.";
		return str;
	}

	// *********** les getters et setters **************
	public ArmeT getArmeT() {
		return armeT;
	}

	public ArmeC getArmeC() {
		return armeC;
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
	
	public void setArmeT(ArmeT arme){
		this.armeT=arme;
	}
}

package principal;

import classesDeTest.ArmeTTest;

public abstract class Unite {
	protected ArmeT armeT= new ArmeTTest();
	protected ArmeC armeC;
	protected int cc, ct, f, e, pv = 0, i, a, cd, svg;
	protected int blAvant, blFlanc, blArriere;
	protected int posX = 0, posY = 0;

	
	
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
		str = "J'ai " + this.getPv() + " points de vie.";
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
}

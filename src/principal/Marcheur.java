package principal;

import principal.Infanterie;

public class Marcheur extends Vehicule {
	ArmeC armeC;
	protected int cc, f, i, a;

	public Marcheur(int cc, int ct, int f, int blAv, int blFl, int blAr, int i,
			int a) {
		super(ct, blAv, blFl, blAr);
		this.armeC = new ArmeC();
		this.cc = cc;
		this.f = f;
		this.i = i;
		this.a = a;
	}

	// *********** attaque cc du marcheur ************

	public void attaquerC(Infanterie defenseur) {
		this.save();
		this.armeC.attaquerC(this.getInf(), defenseur);
		this.reset();
	}

	public void attaquerC(Vehicule defenseur) {
		this.save();
		this.armeC.attaquerC(this.getInf(), defenseur);
		this.reset();
	}

	// ********** equivalent infanterie d'un marcheur *************

	public Infanterie getInf() {
		Infanterie inf = new Infanterie(cc, ct, f, 0, 1, i, a, 12, 7);
		return inf;
	}

	// ******************* memoire de la classe *******************

	private int ccs, cts, fs, is, as;
	private ArmeC armeCs;

	public void save() {
		this.cts = ct;
		this.blAvS = blAvant;
		this.blFlS = blFlanc;
		this.blArS = blArriere;
		this.armeVs = armeV;

		this.ccs = cc;
		this.cts = ct;
		this.fs = f;
		this.is = i;
		this.as = a;
		this.armeCs = armeC;
	}

	public void reset() {
		this.ct = cts;
		this.blAvant = blAvS;
		this.blFlanc = blFlS;
		this.blArriere = blArS;
		this.armeV = armeVs;

		this.cc = ccs;
		this.ct = cts;
		this.f = fs;
		this.i = is;
		this.a = as;
		this.armeC = armeCs;
	}
}

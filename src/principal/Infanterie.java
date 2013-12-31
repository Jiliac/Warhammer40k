package principal;

import java.util.ArrayList;

public class Infanterie extends Unite {
	protected ArmeC armeC;
	protected ArmeT armeT;

	// ******** les actions *****************

	public void attaquerC(Infanterie defenseur) {
		this.save();
		this.armeC.attaquerC(this, defenseur);
		this.reset();
	}

	public void attaquerT(Infanterie defenseur) {
		this.save();
		this.getArmeT().attaquerT(this, defenseur);
		this.reset();
	}

	public void attaquerC(Vehicule defenseur) {
		this.save();
		this.getArmeC().attaquerC(this, defenseur);
		this.reset();
	}

	public void attaquerT(Vehicule defenseur) {
		this.save();
		this.getArmeT().attaquerT(this, defenseur);
		this.reset();
	}

	// ************** les attaques de troupes *********

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

	// ********** la memoire de la classe ********

	// ATTENTION ces deux methodes s'appellent respectivement au debut et a la
	// fin des methodes de combat!!!

	private int ccs, cts, fs, es, is, as, cdS, svgS;
	private ArmeT armeTs;
	private ArmeC armeCs;

	public void save() {
		this.ccs = cc;
		this.cts = ct;
		this.fs = f;
		this.es = e;
		this.is = i;
		this.as = a;
		this.cdS = cd;
		this.svgS = svg;
		this.armeTs = armeT;
		this.armeCs = armeC;
	}

	public void reset() {
		this.cc = ccs;
		this.ct = cts;
		this.f = fs;
		this.e = es;
		this.i = is;
		this.a = as;
		this.cd = cdS;
		this.svg = svgS;
		this.armeT = armeTs;
		this.armeC = armeCs;
	}

	// *********** les constructeurs ************

	protected Infanterie() {
		this.armeT = new ArmeT();
		this.armeC = new ArmeC();
		this.blAvant = 0;
		this.blFlanc = 0;
		this.blArriere = 0;
	}

	protected Infanterie(int cc, int ct, int f, int e, int pv, int i, int a,
			int cd, int svg) {
		this();
		this.cc = cc;
		this.ct = ct;
		this.f = f;
		this.e = e;
		this.pv = pv;
		this.i = i;
		this.a = a;
		this.cd = cd;
		this.svg = svg;
	}

	// ************* getters ************

	public ArmeC getArmeC() {
		return armeC;
	}

	public void setArmeC(ArmeC armeC) {
		this.armeC = armeC;
	}

	public ArmeT getArmeT() {
		return armeT;
	}

	public void setArmeT(ArmeT armeT) {
		this.armeT = armeT;
	}
}

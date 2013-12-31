package principal;

import java.util.ArrayList;

import de.De;
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

	public void attaquerC(Unite defenseur) {
		this.save();
		if (defenseur instanceof Infanterie) {
			Infanterie def = (Infanterie) defenseur;
			this.armeC.attaquerC(this.getInf(), def);
		} else if (defenseur instanceof Vehicule) {
			Vehicule def = (Vehicule) defenseur;
			this.armeC.attaquerC(this.getInf(), def);
		}
		this.reset();
	}

	public void attaquerCUT(Troupe troupe) {
		// on selectionne le defenseur
		ArrayList<Unite> troupeDef = troupe.getTroupe();
		int size = troupeDef.size();
		De de = new De(size);
		Unite def = troupeDef.get(de.jet() - 1);

		this.attaquerC(def);
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

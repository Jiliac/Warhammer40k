package principal;

import principal.Blesse.Blessure;
import principal.Blesse.BlessureInutile;
import principal.Sauvegarde.Sauvegarde;
import principal.ToucheC.ToucheC;
import principal.ToucheC.ToucheCNormale;
import principal.ToucheT.ToucheT;
import principal.ToucheT.ToucheTNormale;

public class Infanterie extends Unite {

	// ******** les actions *****************

	public void attaquerC(Unite defenseur) {

		// Defenseur vivant??

		// is able to charge??

		ToucheC toucheC;
		Blessure blessure;
		Sauvegarde sauvegarde;
		boolean reussite;

		toucheC = new ToucheCNormale(this, defenseur);
		blessure = toucheC.toucherC();
		sauvegarde = blessure.blesser();
		reussite = sauvegarde.sauver();
		if (reussite == false)
			defenseur.pertePv();
	}

	public void attaquerT(Unite defenseur) {
		this.save();

		this.getArmeT().attaquerT(this, defenseur);
		
		this.reset();
	}

	public boolean isDeplace() {
		// encore un truc a faire quand je ferais les deplacement...
		return false;
	}

	// ********** la memoire de la classe ********

	private int ccs, cts, fs, es, is, as, cds, svgS;
	private ArmeT armeTs;
	private ArmeC armeCs;

	public void save() {
		this.ccs = cc;
		this.cts = ct;
		this.fs = f;
		this.es = e;
		this.is = i;
		this.as = a;
		this.cds = cd;
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
		this.cds = cd;
		this.svg = svgS;
		this.armeT = armeTs;
		this.armeCs = armeC;
	}

	// *********** les constructeurs ************

	protected Infanterie() {
		super();
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
}

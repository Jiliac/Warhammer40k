package principal.vehicule;

import principal.Infanterie;

public class InfanterieMarcheur extends Infanterie {
	private Marcheur marcheur;

	public InfanterieMarcheur(int cc, int ct, int f, int e, int pv, int i,
			int a, int cd, int svg, Marcheur marcheur) {
		super(cc, ct, f, e, pv, i, a, cd, svg);
		this.marcheur = marcheur;
	}

	public void pertePv() {
		this.pertePv();
		marcheur.pertePv();
	}
}

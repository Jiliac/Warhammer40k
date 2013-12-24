package principal;

import java.util.ArrayList;

public class Troupe<T extends Unite> {
	ArrayList<T> troupe;
	int nbMin, nbMax;

	// *********** constructeurs **************

	protected Troupe(int nbMin, int nbMax) {
		this.nbMin = nbMin;
		this.nbMax = nbMax;
		troupe = new ArrayList<T>();
	}

	// *********** ajout d'unite ***************

	public void add(T unite) {
		if (!this.testRempli())
			troupe.add(unite);
	}

	private boolean testRempli() {
		boolean retour = false;
		if (troupe.size() >= nbMax)
			retour = true;
		return retour;
	}

	public void restructure() {
		ArrayList<T> tr = this.getTroupe();
		for (int i = 0; i < tr.size(); i++) {
			T unite = tr.get(i);
			if (unite.getPv() <= 0)
				tr.remove(unite);
		}
		this.setTroupe(tr);
	}
	
	// *********** visualisation ********************+
	
	public String toString() {
		String str = "";
		str += "les points de pv des unites de cette troupe:\n";
		int i = 1;
		for (T unite : this.getTroupe()) {
			int pv = unite.getPv();
			str += "l'unite " + i + " a " + pv + " de point de vie.\n";
			i++;
		}
		System.out.println("cette unite a " + this.getTroupe().size()
				+ " unites");
		return str;
	}

	// ************* getters et setters ****************

	public ArrayList<T> getTroupe() {
		return troupe;
	}

	public int getNbMin() {
		return nbMin;
	}

	public int getNbMax() {
		return nbMax;
	}

	protected void setTroupe(ArrayList<T> troupe) {
		this.troupe = troupe;
	}

	protected void setNbMin(int nbMin) {
		this.nbMin = nbMin;
	}

	protected void setNbMax(int nbMax) {
		this.nbMax = nbMax;
	}

}

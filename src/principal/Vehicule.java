package principal;

import java.util.ArrayList;

import principal.vehicule.ArmeMarquee;
import principal.vehicule.ArmeV;
import de.De6;

//Attaque au cc à faire mais bon, c'est pas important donc je le ferais plus tard
public class Vehicule extends Unite {
	protected String etatMouvement;
	protected ArmeV armeV;

	// ****************** actions **********************

	public void attaquerT(Infanterie defenseur) {
		this.save();
		
		// on set les armes à utiliser
		if (this.etatMouvement == "immobile") {
			armeV.setUtilisable();
		} else if (this.etatMouvement == "combat") {
			ArmeT armeT = this.choisirArme();
			armeV.setUniqueUtilisable(armeT);
		} else if (this.etatMouvement == "manoeuvre") {
			armeV.setInutilisable();
		}

		// et on utilise ces armes
		ArrayList<ArmeT> armeAttaquante = armeV.getUtilisable();
		for (ArmeT armeT : armeAttaquante) {
			armeT.attaquerT(this, defenseur);
		}
		
		this.reset();
	}

	public void attaquerT(Vehicule defenseur) {
		this.save();
		
		// on set les armes à utiliser
		if (this.etatMouvement == "immobile") {
			armeV.setUtilisable();
		} else if (this.etatMouvement == "combat") {
			ArmeT armeT = this.choisirArme();
			armeV.setUniqueUtilisable(armeT);
		} else if (this.etatMouvement == "manoeuvre") {
			armeV.setInutilisable();
		}

		// et on utilise ces armes
		ArrayList<ArmeT> armeAttaquante = armeV.getUtilisable();
		for (ArmeT armeT : armeAttaquante) {
			armeT.attaquerT(this, defenseur);
		}
		
		this.reset();
	}

	private ArmeT choisirArme() {
		// A DEFINIR, choix de l'utilisateur

		// comportement par defaut en attendant
		ArmeT armeT = armeV.get(0);
		return armeT;
	}

	// ************ attaque de troupe ***************

	public void attaquerTUT(Troupe troupe) {
		ArrayList<Unite> tr = troupe.getTroupe();
		for (Unite defenseur : tr) {
			for (int i = 0; i < this.getArmeT().getNbTir(); i++) {
				this.attaquerT(defenseur);
				troupe.restructure();
			}
		}
	}

	// ********** les jets de degats *****************

	public void secouer() {

	}

	public void sonne() {

	}

	public void armeDetruite() {

	}

	public void immobilise() {

	}

	public void epave() {
		this.pertePv();
	}

	public void explosion() {
		this.pertePv();
		De6 de = new De6();
		int rayon = de.jet();
		// et la j'ai plein de problemes, les unites prises dans explosions
	}

	// ************* constructeur de combat ***********
	public int associerBlindage(Unite attaquant, Vehicule vehicule) {
		// A DEFINIR, ca va dependre des position sur le terrain
		return this.blAvant;
	}

	// ************** les constructeurs *****************

	public Vehicule() {
		this.armeV = new ArmeV();
		this.setEtatMouvement("immobile");
		this.cc = 0;
		this.f = 0;
		this.e = 0;
		this.pv = 0;
		this.i = 0;
		this.a = 0;
		this.cd = 0;
		this.svg = 0;
	}

	public Vehicule(int ct, int blAvant, int blFlanc, int blArriere) {
		this();
		this.ct = ct;
		this.blAvant = blAvant;
		this.blFlanc = blFlanc;
		this.blArriere = blArriere;
	}

	public Vehicule(int ct, int blAvant, int blFlanc, int blArriere, ArmeV armeV) {
		this(ct, blAvant, blFlanc, blArriere);
		this.armeV = armeV;
	}

	public void add(ArmeT armeT) {
		this.armeV.add(armeT);
	}

	// ************* m�moire de la classe ***************

	protected int cts, blAvS, blFlS, blArS;
	protected ArmeV armeVs;

	public void save() {
		this.cts = ct;
		this.blAvS = blAvant;
		this.blFlS = blFlanc;
		this.blArS = blArriere;
		this.armeVs = armeV;
	}

	public void reset() {
		this.ct = cts;
		this.blAvant = blAvS;
		this.blFlanc = blFlS;
		this.blArriere = blArS;
		this.armeV = armeVs;
	}

	// ************** getters et setters *****************

	public String getEtatMouvement() {
		return etatMouvement;
	}

	public void setEtatMouvement(String em) {
		if (em != null) {
			String etatm = em.toLowerCase();
			if (etatm == "immobile" || etatm == "combat"
					|| etatm == "manoeuvre")
				this.etatMouvement = em;
		}
	}
}

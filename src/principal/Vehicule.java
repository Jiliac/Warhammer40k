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
	}

	public void attaquerT(Vehicule defenseur) {
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
	}

	private ArmeT choisirArme() {
		// A DEFINIR, choix de l'utilisateur

		// comportement par defaut en attendant
		ArmeT armeT = armeV.get(0);
		return armeT;
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
		De6 de = De6();
		rayon = de.jet();
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
		this.armes = new ArrayList<ArmeT>();
	}

	public void add(ArmeT armeT) {
		this.armeV.add(armeT);
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

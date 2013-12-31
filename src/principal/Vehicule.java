package principal;

import java.util.ArrayList;

import principal.armeT.attaqueT.AttaqueSurface;
import principal.armeT.attaqueT.AttaqueT;
import principal.armeT.attaqueTSurface.ToucheTExplosionMere;
import principal.vehicule.ArmeV;
import de.De;
import de.De6;

//Attaque au cc Ã  faire mais bon, c'est pas important donc je le ferais plus tard
public class Vehicule extends Unite {
	protected String etatMouvement;
	protected ArmeV armeV;

	// ************ attaque de troupe ***************

	public void attaquerTUT(Troupe troupe) {
		// on selectionne le defenseur
		ArrayList<Unite> troupeDef = troupe.getTroupe();
		int size = troupeDef.size();
		De de = new De(size);
		Unite def = troupeDef.get(de.jet() - 1);

		// et on attaque
		ArrayList<ArmeT> armeAttaquante = armeV.getUtilisable();
		for (ArmeT armeT : armeAttaquante) {
			this.save();
			armeT.attaquerT(this, def);
			this.reset();
			troupe.restructure();
		}
	}

	// *********** gestion des armes ****************

	public void setUtilisable() {
		if (this.etatMouvement == "immobile") {
			armeV.setUtilisable();
		} else if (this.etatMouvement == "combat") {
			ArmeT armeT = this.choisirArme();
			armeV.setUniqueUtilisable(armeT);
		} else if (this.etatMouvement == "manoeuvre") {
			armeV.setInutilisable();
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
		ArrayList<ArmeT> al = this.armeV.getUtilisable();
		if(al.size()==0)
			this.immobilise();
		else {
			// EN FAIT IL FAUDRAIT FAIRE UN CHOIX
			De de = new De(al.size());
			ArmeT armeDetruite = al.get(de.jet()-1);
			
			//	PROBLEME AVEC LA MEMOIRE DE LA CLASSE
			// COMMENT FAIRE ? QUELS SONT LES CAS A DISTINGUER ?
		}
	}

	public void immobilise() {
		// modifier la methode seDeplace !!!!!!!!!!!!!!!!!!!!
	}

	public void epave() {
		this.pertePv();
	}

	public void explosion() {
		this.pertePv();

		De6 de = new De6();
		int rayon = de.jet();

		ArmeT armeExplosion = new ArmeT(rayon, 3, 7, 1);
		AttaqueT at = new AttaqueSurface(this, new ToucheTExplosionMere(this,
				this.posX, this.posY, rayon, armeExplosion), armeExplosion);
		at.attaquerT();
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

	// ************* mémoire de la classe ***************

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

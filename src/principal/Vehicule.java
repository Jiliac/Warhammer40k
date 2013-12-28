package principal;

import java.util.ArrayList;

import de.De6;

//Attaque au c à c à faire mais bon, c'est pas important donc je le ferais plus tard
public class Vehicule extends Unite {
	String etatMouvement;

	// ****************** actions **********************
	
	public void attaquerT(Unite defenseur){
		if(this.etatMouvement=="immobile"){
			for(ArmeT armeT : armes)
				armeT.attaquerT(this, defenseur);
		}
		else if(this.etatMouvement=="combat"){
			this.choisirArme(); //ATTENTION A DEFINIR
			for(ArmeT arme : armes){
				if (armes.indexOf(arme)==0)
					arme.attaquerT(this, defenseur);
				else
					arme.setUtilisable(false);
			}
		}
		else if(this.etatMouvement=="manoeuvre"){
			for(ArmeT arme : armes){
				arme.setUtilisable(false);
			}
		}
	}
	
	private void choisirArme() {
		// A DEFINIR, choix de l'utilisateur		
	}
	
	// ********** les jets de degats *****************
	
	public void secouer(){
	
	}
	
	public void sonne(){
		
	}

	public void armeDetruite(){
		
	}
	
	public void immobilisé(){
		
	}
	
	public void epave(){
		this.pertePv();
	}
	
	public void explosion(){
		this.pertePv();
		De6 de = De6();
		rayon = de.jet();
		//et la j'ai plein de problemes, les unites prises dans explosions
	}
	
	// ************* constructeur de combat ***********
	public int associerBlindage(Unite attaquant, Vehicule vehicule) {
		// 	A DEFINIR, ca va dependre des position sur le terrain
		return this.blAvant;
	}
	
	// ************** les constructeurs *****************
	
	public Vehicule() {
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
		this.ct = ct;
		this.blAvant = blAvant;
		this.blFlanc = blFlanc;
		this.blArriere = blArriere;

		this.armes = new ArrayList<ArmeT>();
	}

	// ************** getters et setters *****************

	public String getEtatMouvement() {
		return etatMouvement;
	}

	public void setEtatMouvement(String em) {
		if (em != null) {
			String etatm = em.toLowerCase();
			if(etatm=="immobile" || etatm == "combat" || etatm == "manoeuvre")
				this.etatMouvement = em;
		}
	}
}

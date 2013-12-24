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
		
		//Defenseur vivant??
		
		//is able to charge??
		
		ToucheC toucheC;
		Blessure blessure;
		Sauvegarde sauvegarde;
		boolean reussite;
		
		toucheC = new ToucheCNormale(this,defenseur);
		blessure = toucheC.toucherC();
		sauvegarde = blessure.blesser();
		reussite = sauvegarde.sauver();
		if(reussite==false)
			defenseur.pertePv();
	}
	
	public void attaquerT(Unite defenseur){
		//ATTENTION A FAIRE (en fait je sais pas trop comment gere cette architecture...)
		//sauvegarde de valeur modifiable pour le combat
		int pa = this.getArmeT().getPa();
		
		
		//defenseur vivant??
		
		//is able to fire???
		
		ToucheT toucheT;
		Blessure blessure;
		Sauvegarde sauvegarde;
		boolean reussite;
		
		toucheT = new ToucheTNormale(this,defenseur);
		blessure = toucheT.toucherT();
		if(blessure.getClass().toString()!=BlessureInutile.class.toString())
			this.getArmeT().attaquerT(this, defenseur, blessure);
	}
	
	public boolean isDeplace(){
		//encore un truc a faire quand je ferais les deplacement...
		return false;
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

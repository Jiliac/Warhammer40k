package principal;

import principal.Blesse.Blessure;

public abstract class ArmeT {
	protected boolean used;
	protected int portee;
	protected int f;
	protected int pa;
	protected int nbTir;
	protected String typeOption;

	// ********************* les actions **********************

	public abstract void attaquerT(Unite attaquant, Unite defenseur, Blessure blessure);

	public abstract boolean isAbleToCharge();
	
	public boolean aPorte(Unite attaquant,Unite defenseur){
		return attaquant.aPorte(portee, defenseur);
	}

	// ********************* constructeur **********************
	protected ArmeT(int portee, int f, int pa, int nbTir, String typeOption) {
		this.portee = portee;
		this.f = f;
		this.pa = pa;
		this.nbTir = nbTir;
		this.typeOption = typeOption;
	}

	protected ArmeT(int portee, int f, int pa, int nbTir) {
		this(portee, f, pa, nbTir, "");
	}

	// ******************** getters et setters ***************

	public int getPortee() {
		return portee;
	}

	public int getF() {
		return f;
	}

	public int getPa() {
		return pa;
	}

	public int getNbTir() {
		return nbTir;
	}

	public String getTypeOption() {
		return typeOption;
	}

	protected void setNbTir(int nbTir) {
		this.nbTir = nbTir;
	}

	protected void setTypeOption(String typeOption) {
		this.typeOption = typeOption;
	}

	public void setPa(int pa) {
		this.pa = pa;
	}
}

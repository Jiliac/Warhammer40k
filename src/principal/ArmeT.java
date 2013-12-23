package principal;

public abstract class ArmeT {
	private int portee, f, pa, nbTir;
	private String typeOption;

	// ********************* constructeur **********************
	public ArmeT(int portee, int f, int pa, int nbTir, String typeOption) {
		this.portee = portee;
		this.f = f;
		this.pa = pa;
		this.nbTir = nbTir;
		this.typeOption = typeOption;
	}

	public ArmeT(int portee, int f, int pa, int nbTir) {
		this(portee, f, pa, nbTir, "");
	}
	
	public ArmeT(){
		this(0,0,7,0);
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
	public void setPa(int pa){
		this.pa=pa;
	}
}

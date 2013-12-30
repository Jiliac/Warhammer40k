package principal.vehicule;

import principal.ArmeT;

public class ArmeMarquee {
	private ArmeT armeT;
	private boolean utilisable = true;
	
	public ArmeMarquee(ArmeT armeT){
		this.armeT = armeT;
	}
	
	// ********* getters et setters ************
	
	public ArmeT getArmeT() {
		return armeT;
	}

	public void setArmeT(ArmeT armeT) {
		this.armeT = armeT;
	}

	public boolean isUtilisable() {
		return utilisable;
	}

	public void setUtilisable(boolean utilisable) {
		this.utilisable = utilisable;
	}
}

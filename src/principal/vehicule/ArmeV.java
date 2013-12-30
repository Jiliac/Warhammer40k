package principal.vehicule;

import java.util.ArrayList;

import principal.ArmeT;

public class ArmeV {
	protected ArrayList<ArmeMarquee> al;

	public ArmeV() {
		al = new ArrayList<ArmeMarquee>();
	}

	// *********** gestion collection *************
	
	public void add(ArmeT armeT) {
		ArmeMarquee am = new ArmeMarquee(armeT);
		al.add(am);
	}
	
	public int size(){
		return al.size();
	}
	
	public ArmeT get(int i){
		return al.get(i).getArmeT();
	}

	// ********* gestion d'utilisabilite ****************

	public void isUtilisee(ArmeT armeT) {
		ArmeMarquee am = new ArmeMarquee(armeT);
		int i = al.indexOf(am);
		am = al.get(i);
		am.setUtilisable(false);
	}

	public void setUniqueUtilisable(ArmeT armeT) {
		// on les met tous in-utilisable et on met celle que l'on veut
		// utilisable
		for (ArmeMarquee am : al) {
			am.setUtilisable(false);
		}

		ArmeMarquee am = new ArmeMarquee(armeT);
		int i = al.indexOf(am);
		am = al.get(i);
		am.setUtilisable(false);
	}

	public void setUtilisable() {
		for (ArmeMarquee am : al) {
			am.setUtilisable(true);
		}
	}
	
	public void setInutilisable() {
		for (ArmeMarquee am : al) {
			am.setUtilisable(false);
		}
	}

	public void reset() {
		for (ArmeMarquee am : al) {
			am.setUtilisable(true);
		}
	}

	public ArrayList<ArmeT> getUtilisable() {
		ArrayList<ArmeT> retour = new ArrayList<ArmeT>();
		for (ArmeMarquee am : al) {
			if (am.isUtilisable())
				retour.add(am.getArmeT());
		}
		
		return retour;
	}
}

package principal;

import java.util.ArrayList;

public class Terrain {
	// En fait il faudra faire un classe fille de terrain pour chaque terrain.
	// Ainsi chacune des objet instancie de cette classe fille sera exactement
	// pareil et pourra etre appele de n'importe ou

	public Terrain() {
	}
	
	//cette méthode est utilisé pour les armes a explosion
	public ArrayList<Unite> zone(int rayon,int posX,int posY){
		ArrayList<Unite> al = new ArrayList<Unite>();
		return al;
	}
	
	
	//cette methode est utilise pour les sauvegardes de couvert
	public String getTypeTerrain(int posX,int posY){
		String str=null;
		return str;
		//Classe a preciser evidemment...
		
	}
}

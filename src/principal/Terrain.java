package principal;

import java.util.ArrayList;

public class Terrain {
	/*
	 * En fait il faudra faire un classe fille de terrain pour chaque terrain.
	 * Ainsi chacune des objet instancie de cette classe fille sera exactement
	 * pareil et pourra etre appele de n'importe ou
	 */

	private int largeur, longueur;
	private String typeTerrain;

	// (en fait ‡ long terme il faudra une methode qui retourne pour chaque
	// point un typeTerrain)

	public Terrain(int largeur, int longueur) {
		this.largeur = largeur;
		this.longueur = longueur;
		this.setTypeTerrain("normal");
	}

	// ************ pour les deplacement **********************

	// cette methode est utilise pour les sauvegardes de couvert

	public String getTypeTerrain(int posX, int posY) {
		String str = null;
		return str;
		// Classe a preciser evidemment...
	}

	// ************* pour les tirs *************************

	// cette methode est utilis√© pour les armes surfaces
	public ArrayList<Unite> zoneCercle(int posX, int posY, int rayon) {
		ArrayList<Unite> al = new ArrayList<Unite>();
		return al;
	}

	public ArrayList<Unite> zoneSouffle(int posX, int posY) {
		ArrayList<Unite> al = new ArrayList<Unite>();
		return al;
	}

	// ************ setters *****************

	private void setTypeTerrain(String typeTerrain) {
		if (typeTerrain == "normal" || typeTerrain == "difficile"
				|| typeTerrain == "infranchissable")
			this.typeTerrain = typeTerrain;
		else {
			this.typeTerrain = "normal";
			System.out.println("attention, mauvais terrain en entrer");
		}
	}

	public String getTypeTerrain() {
		return this.typeTerrain;
	}
}

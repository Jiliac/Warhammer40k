package principal.armeT.attaqueTSurface;

import java.util.ArrayList;

import principal.Terrain;
import principal.Unite;
import principal.Blesse.Blessure;
import principal.ToucheT.ToucheTNormale;
import de.DeDir;

public class AttaqueTSouffle implements AttaqueTSurface{
	Unite attaquant;
	int x, y;

	public AttaqueTSouffle(Unite attaquant, int x, int y) {
		this.attaquant = attaquant;
		this.x = x;
		this.y = y;
	}

	// en fait ce sera à faire quand je ferai les unites qui attaques des troupes!!!
	// j'ai besoin de retourner une liste de blessure
	public ArrayList<Blessure> toucherT() {
		DeDir jetDir = new DeDir();
		int[] jet = jetDir.jetPos();
		int posX = jet[0] + x;
		int posY = jet[1] + y;

		Terrain terrain = new Terrain();
		ArrayList<Unite> troupeDef = terrain.zoneSouffle(posX, posY);

		ArrayList<Blessure> retour = new ArrayList<Blessure>();
		for (Unite defenseur : troupeDef) {
			ToucheTNormale ttn = new ToucheTNormale(attaquant, defenseur);
			retour.add(ttn.toucherT());
		}
		
		return retour;
	}

}

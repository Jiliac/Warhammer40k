package principal.armeT.attaqueT;

import java.util.ArrayList;

import de.DeDir;
import principal.Terrain;
import principal.Unite;
import principal.Blesse.Blessure;
import principal.ToucheT.ToucheTNormale;

public class ToucheTExplosionMere implements AttaqueTSurface{
	Unite attaquant;
	int x, y, rayon;

	public ToucheTExplosionMere(Unite attaquant, int x, int y, int rayon) {
		this.x = x;
		this.y = y;
		this.rayon = rayon;
		this.attaquant = attaquant;
	}

	// en fait ce sera à faire quand je ferai les unites qui attaques des troupes!!!
	// j'ai besoin de retourner une liste de blessure
	public ArrayList<Blessure> toucherT() {
		DeDir jetDir = new DeDir();
		int[] jet = jetDir.jetPos();
		int posX = jet[0] + x;
		int posY = jet[1] + y;

		Terrain terrain = new Terrain();
		ArrayList<Unite> troupeDef = terrain.zone(posX, posY, rayon);

		ArrayList<Blessure> retour = new ArrayList<Blessure>();
		for (Unite defenseur : troupeDef) {
			ToucheTNormale ttn = new ToucheTNormale(attaquant, defenseur);
			retour.add(ttn.toucherT());
		}
		
		return retour;
	}

}

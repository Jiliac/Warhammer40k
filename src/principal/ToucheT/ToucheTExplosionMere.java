package principal.ToucheT;

import java.util.ArrayList;

import de.DeDir;
import principal.Terrain;
import principal.Unite;
import principal.Blesse.Blessure;

public class ToucheTExplosionMere implements ToucheT {
	Unite defenseur;
	int x, y, rayon;

	public ToucheTExplosionMere(Unite defenseur, int x, int y, int rayon) {
		this.x = x;
		this.y = y;
		this.rayon = rayon;
		this.defenseur = defenseur;
	}

	// en fait ce sera à faire quand je ferai les unites qui attaques des troupes!!!
	// j'ai besoin de retourner une liste de blessure
	public ArrayList<Blessure> toucherT() {
		DeDir jetDir = new DeDir();
		int[] jet = jetDir.jetPos();
		int posX = jet[0] + x;
		int posY = jet[1] + y;

		Terrain terrain = new Terrain();
		ArrayList<Unite> al = terrain.zone(posX, posY, rayon);

		ArrayList<Blessure> retour = new ArrayList<Blessure>();
		for (Unite unite : al) {
			ToucheTNormale ttn = new ToucheTNormale(unite, defenseur);
			retour.add(ttn.toucherT());
		}

	}

}

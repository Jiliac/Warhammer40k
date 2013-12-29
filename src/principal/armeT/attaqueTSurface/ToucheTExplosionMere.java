package principal.armeT.attaqueTSurface;

import java.util.ArrayList;

import de.DeDir;
import principal.ArmeT;
import principal.Terrain;
import principal.Unite;

public class ToucheTExplosionMere implements AttaqueTSurface {
	Unite attaquant;
	ArmeT armeT;
	int x, y, rayon;

	public ToucheTExplosionMere(Unite attaquant, int x, int y, int rayon,
			ArmeT armeT) {
		this.x = x;
		this.y = y;
		this.rayon = rayon;
		this.attaquant = attaquant;
		this.armeT = armeT;
	}

	public ArrayList<Unite> toucherT() {
		ArrayList<Unite> retour;

		if (this.aPorte()) {

			DeDir jetDir = new DeDir();
			int[] jet = jetDir.jetPos();
			int posX = jet[0] + x;
			int posY = jet[1] + y;

			Terrain terrain = new Terrain();
			retour = terrain.zoneCercle(posX, posY, rayon);
		} else
			retour = new ArrayList<Unite>();

		return retour;
	}

	private boolean aPorte() {
		boolean retour;

		int posX = attaquant.getPosX(), posY = attaquant.getPosY();
		double distance = Math.sqrt((posX - x) * (posX - x) + (posY - y)
				* (posY - y));
		if (distance <= armeT.getPortee())
			retour = true;
		else
			retour = false;

		return retour;
	}

}

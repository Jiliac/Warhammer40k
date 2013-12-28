package principal.ToucheT;

import de.De6;
import principal.Infanterie;
import principal.Unite;
import principal.Sauvegarde.Sauvegarde;
import principal.Sauvegarde.SauvegardeNormale;

public class ToucheTSurchauffe extends ToucheTMere implements ToucheT {

	public ToucheTSurchauffe(Unite attaquant, Unite defenseur) {
		super(attaquant, defenseur);
	}

	public boolean toucherT() {
		// creation des variables...
		De6 de = new De6();
		int jet = de.jet();
		boolean retour;
		if (jet == 1) {
			retour = false;
			if (attaquant instanceof Infanterie) {
				Infanterie at = (Infanterie) attaquant;
				Sauvegarde sauvegarde = new SauvegardeNormale(null, at);
				sauvegarde.sauver();
			}
		} else {
			ToucheT tt = new ToucheTNormale(attaquant, defenseur, jet);
			retour = tt.toucherT();
		}
		return retour;
	}
}
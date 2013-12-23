package principal.ToucheT;

import classesDeTest.UniteTest;
import de.De6;
import principal.Unite;
import principal.Blesse.Blessure;
import principal.Sauvegarde.Sauvegarde;
import principal.Sauvegarde.SauvegardeNormale;

public class ToucheTSurchauffe extends ToucheTMere implements ToucheT{

	public ToucheTSurchauffe(Unite attaquant, Unite defenseur) {
		super(attaquant, defenseur);
	}
	
	public Blessure toucheT(){
		//creation des variables...
		De6 de = new De6();
		int jet = de.jet();
		//on traite le cas particulier
		if(jet==1){
			Sauvegarde sauvegarde = new SauvegardeNormale(new UniteTest(),attaquant);
			if(sauvegarde.sauver()==false)
				attaquant.pertePv();
		}
		
		// et sinon on traite la variable normalement
		ToucheT retour = new ToucheTNormale(attaquant,defenseur,jet);
		return retour.toucheT();
		
	}
} 
package principal.Sauvegarde;


import de.De;
import de.De6;
import principal.Terrain;
import principal.Unite;
import principal.Sauvegarde.Sauvegarde;

public class SauvegardeCouvert extends SauvegardeMere implements Sauvegarde{
	int svgC=7;
	public SauvegardeCouvert(Unite attaquant,Unite defenseur){
		super(attaquant,defenseur);
		this.svgC=this.setSvgC(defenseur);
	}
	
	private int setSvgC(Unite defenseur){
		int svg = 7;
		int posX=defenseur.getPosX(),posY=defenseur.getPosY();
		Terrain terrain = new Terrain();
		String tt=terrain.getTypeTerrain(posX, posY);
		if(tt=="grillage")
			svg=6;
		else if(tt=="cloture")
			svg=5;
		else if(tt=="unite" || tt=="mur")
			svg=4;
		else if(tt=="fortification")
			svg=3;
		return svg;
	}
	
	public void sauver(){
		De de = new De6();
		boolean reussite = false;
		if (de.jet() >= svgC)
			reussite = true;
		if (reussite == false)
			defenseur.pertePv();
	}
}
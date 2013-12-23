package principal.Sauvegarde;

public class SauvegardeFausse
		/* je suis pas sur que ca soit bien necessaire... */extends
		SauvegardeMere implements Sauvegarde {
	public boolean sauver() {
		return false;
	}
}

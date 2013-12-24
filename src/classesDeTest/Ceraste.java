package classesDeTest;

import principal.Infanterie;

public class Ceraste extends Infanterie{
	public Ceraste(){
		super(4,4,3,3,1,6,1,8,6);
	}
	
	public void attaquer(){
		System.out.println("je suis une ceraste qui attaque.");
	}
}

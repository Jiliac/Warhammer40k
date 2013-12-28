package principal;

import classesDeTest.CannonDAssaut;
import classesDeTest.Ceraste;
import classesDeTest.SpaceMarine;

public class Test {
	static public void main(String[] arg0) {
		SpaceMarine sm = new SpaceMarine();
		sm.setArmeT(new CannonDAssaut());
		Ceraste c = new Ceraste();
		
		for(int i=0;i<10;i++)
			sm.attaquerT(c);
		
		System.out.println(c);
		/*
		 * tir d'une unite sur une autre
		 * combat cc
		 * tir vehicule sur unite
		 */
	}
}

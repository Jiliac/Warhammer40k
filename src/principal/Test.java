package principal;

import classesDeTest.Ceraste;
import classesDeTest.SpaceMarine;
import de.De6;

public class Test {
	static public void main(String[] arg0) {
		Unite sm, c;
		sm = new SpaceMarine();
		
		c = new Ceraste();
		
		
		for(int i=0;i<5;i++)
			c.attaquerC(sm);
		System.out.println(sm);
		
		/*
		 * ATTENTION
		 * plein de truc a test:
		 * 1) les tir, combatC,combatT
		 * 2) les types et types optionnelles d'armes...
		 * 
		 * 
		 */
		
		
	}
}

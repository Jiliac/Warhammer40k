package principal;

import principal.Blesse.Blessure;
import principal.Blesse.BlessureNormale;
import classesDeTest.ArmeTTest;
import classesDeTest.Ceraste;
import classesDeTest.SpaceMarine;

public class Test {
	static public void main(String[] arg0) {
		Unite sm, c;
		sm = new SpaceMarine();
		
		c = new Ceraste();
		
		
		for(int i=0;i<5;i++)
			c.attaquerC(sm);
		System.out.println(sm);
	}
}

package de;

public class DeDir extends De {
	De3 de;

	public DeDir() {
		de = new De3();
	}

	public String jetDir() {
		String str = null;
		int jet = de.jet();
		if (jet == 3)
			str = "hit";
		else
			str="fleche";
		return str;
	}
	
	public int angle(){
		return (int) (Math.random()*2*Math.PI);
	}
	public int jetDev(){
		De6 de6=new De6();
		int jets = de6.jet()+de6.jet();
		return jets;
	}
	//compilation des deux methodes precedentes
	public /*ATTENTION int ou double??????*/int[] jetPos(){
		int posX,posY;
		int angle=this.angle();
		int dev = this.jetDev();
		posX=(int) (dev*Math.cos(angle));
		posY=(int) (dev*Math.sin(angle));
		int[] retour={posX,posY};
		return retour;
	}
	
}

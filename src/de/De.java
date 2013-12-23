package de;

public class De {
	int i;
	protected De(){i=-1;}
	protected De(int i) {
		this.i = i;
	}

	public int jet() {
		return (int) (Math.random() * i + 1);
	}

}

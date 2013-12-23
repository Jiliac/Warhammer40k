package principal;

public class Infanterie extends Unite{
	public Infanterie(){
		this.blAvant=0;
		this.blFlanc=0;
		this.blArriere=0;
	}
	public Infanterie(int cc,int ct,int f, int e, int pv, int i, int a, int cd, int svg){
		this();
		this.cc=cc;
		this.ct=ct;
		this.f=f;
		this.e=e;
		this.pv=pv;
		this.i=i;
		this.a=a;
		this.cd=cd;
		this.svg=svg;
	}
}

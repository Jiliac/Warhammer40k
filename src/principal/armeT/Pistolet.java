package principal.armeT;


public class Pistolet extends ArmeAssaut{
	protected Pistolet(int f,int pa){
		super(12,f,pa,1);
	}
	protected void setPortee(int portee){
		this.portee=portee;
	}
}

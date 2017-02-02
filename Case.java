public class Case {
	private int val;
	private int x, y;
	private  Etat murH;
	private Etat murG;
	
	public enum Etat {
		FERME,
		OUVERT;
	}

	public Case(int val, int x, int y){
		this.val=val;
		this.x=x;
		this.y=y;
		murH=Etat.FERME;
		murG=Etat.FERME;
		
	}
	
	public int getY(){
		return y;
	}
	public int getX(){
		return x;
	}
	public int getVal(){
		return val;
	}
	public void setVal(int val){
		this.val=val;
	}
	
	public void affCase(){
		System.out.println("+---");
		System.out.print("| "+val+" ");
	}
	
	public Etat getMurH(){
		return murH;
	}
	public Etat getMurG(){
		return murG;
	}
	
	public void setMurH(Etat MUR){
		murH=MUR;
	}
	public void setMurG(Etat MUR){
		murG=MUR;
	}
	
}


public class Case {
	private int val;
	private int x, y;
	private  Mur murH;
	private Mur murG;
	
	public enum Mur {
		ferme,
		ouvert;
	}

	public Case(int val, int x, int y){
		this.val=val;
		this.x=x;
		this.y=y;
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
	
	
}

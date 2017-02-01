
public class Mur {
	private int x;
	private int y;
	private int m;
	// mur haut=1, m=0 mur gauche
	
	public Mur(int x, int y, int m){
		this.x=x;
		this.y=y;
		this.m=m;
	}
	
	public void setMur(int x, int y, int m){
		this.x=x;
		this.y=y;
		this.m=m;
	}
	
	public int getMurX(){
		return x;
	}
	public int getMurY(){
		return y;
	}
	public int getMurM(){
		return m;
	}
}
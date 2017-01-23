//import Case.Etat;


public class Grille {
	private Case[][] grille;
	private int hauteur;
	private int longueur;

	public Grille(int hauteur, int longueur){
		int val=0;
		this.hauteur=hauteur;
		this.longueur=longueur;
		grille = new Case[hauteur][longueur];
		for (int i=0; i<hauteur;i++){
			for (int j=0; j<longueur;j++){
				val+=1;
				grille[i][j]= new Case(val, i, j);
			}
		}
		System.out.println("ok");
	}
	
	public Grille(){
		this(5,5);
	}

	public void affGrille(){
		for (int i=0; i<hauteur; i++){
			for (int j=0; j<longueur; j++){
				if (grille[i][j].getMurH()==Case.Etat.FERME){
					System.out.print("+---");
				}else{
					System.out.print("+   ");
				}
			}
			System.out.println();
			for (int j=0; j<longueur; j++){
				int a =grille[i][j].getVal();
				if (grille[i][j].getMurG()==Case.Etat.FERME){
					System.out.format("|%2d ",a);
				}else{
					System.out.format("%3d ",a);
				}
			}
			System.out.println();
		}
	}
	
	public void laby(){
		//tirage aleatoire de la case, h pr le i, l pour le j de la case
		int h=(int)Math.round(Math.random()*4.0); 
		int l=(int)Math.round(Math.random()*4.0);
		//determination du mur à faire tomber
		int m=(int)Math.round(Math.random());
		System.out.println(h+", "+l);
		//m=1 : mur haut, m=0 mur gauche
		if (m==1){
			System.out.println("mur haut");
			//si les deux cases n'ont pas la meme valeur, le mur peut être ouvert
			if (grille[h][l].getVal()!=grille[h-1][l].getVal()){
				grille[h][l].setMurH(Case.Etat.OUVERT);
				grille[h-1][l].setVal(grille[h][l].getVal());
			}
		}else{
			if (grille[h][l].getVal()!=grille[h][l-1].getVal()){
				grille[h][l].setMurH(Case.Etat.OUVERT);
				grille[h][l-1].setVal(grille[h][l].getVal());
			}
		}
		//if (grille[h][l])
		
	}

}

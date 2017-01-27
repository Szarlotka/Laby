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
			System.out.println("+");
			for (int j=0; j<longueur; j++){
				int a =grille[i][j].getVal();
				if (grille[i][j].getMurG()==Case.Etat.FERME){
					System.out.format("|%2d ",a);
				}else{
					System.out.format("%3d ",a);
				}
			}
			System.out.println("|");
		}
		for (int i=0; i<longueur; i++){
			System.out.print("+---");
		}
		System.out.println("+");
	}

	public void laby(){
		//while (toutChiffre()==false){
		for (int x=0; x<10; x++){
			//determination du mur à faire tomber
			int m=(int)Math.round(Math.random());
			//tirage aleatoire de la case, h pr le i, l pour le j de la case
			int h, l;
			//m=1 : mur haut, m=0 mur gauche
			if (m==1){
				System.out.println("mur haut");
				h=((int)Math.round(Math.random()*(hauteur-2)))+1; 
				l=(int)Math.round(Math.random()*(longueur-1));
				System.out.println(h+", "+l);
				//si les deux cases n'ont pas la meme valeur, le mur peut être ouvert
				if (grille[h][l].getVal()!=grille[h-1][l].getVal()){
					grille[h][l].setMurH(Case.Etat.OUVERT);
					grille[h-1][l].setVal(grille[h][l].getVal());
					etendreChiffre_rec(h-1,l);
				}
			}else{
				System.out.println("mur gauche");
				h=(int)Math.round(Math.random()*(hauteur-1)); 
				l=((int)Math.round(Math.random()*(longueur-2)))+1;
				System.out.println(h+", "+l);
				if (grille[h][l].getVal()!=grille[h][l-1].getVal()){
					grille[h][l].setMurG(Case.Etat.OUVERT);
					grille[h][l-1].setVal(grille[h][l].getVal());
					etendreChiffre_rec(h,l-1);
				}
			}
			affGrille();
		}
	}

	public boolean toutChiffre(){
		int a = grille[0][0].getVal();
		for (int i=0; i<hauteur; i++){
			for (int j=0; j<longueur; j++){
				if (grille[i][j].getVal()!=a){
					return(false);
				}
			}
		}
		return(true);
	}
	
	//a revoir
	public void etendreChiffre_rec(int x, int y){
		if (grille[x][y].getMurH()==Case.Etat.OUVERT && grille[x][y].getVal()!=grille[x][y-1].getVal()){
			grille[x][y-1].setVal(grille[x][y].getVal());
			System.out.println("a");
		}
		if (grille[x][y-1].getMurH()==Case.Etat.OUVERT && grille[x][y-1].getVal()!=grille[x][y-2].getVal()){
			etendreChiffre_rec(x, y-1);
			System.out.println("b");
		}
		if (grille[x][y].getMurG()==Case.Etat.OUVERT && grille[x][y].getVal()!=grille[x-1][y].getVal()){
			grille[x-1][y].setVal(grille[x][y].getVal());
			System.out.println("c");
		}
		if (grille[x-1][y].getMurG()==Case.Etat.OUVERT && grille[x-1][y].getVal()!=grille[x-2][y].getVal()){
			etendreChiffre_rec(x-1, y);
			System.out.println("d");
		}
	}
	
	
}

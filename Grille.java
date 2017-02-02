import java.util.ArrayList;

//import Case.Etat;


public class Grille {
	private Case[][] grille;
	private int hauteur;
	private int longueur;
	private int choixArrX;
	private int choixArrY;
	private int joueurX;
	private int joueurY;

	public Grille(int hauteur, int longueur){
		int val=-1;
		this.hauteur=hauteur;
		this.longueur=longueur;
		grille = new Case[hauteur][longueur];
		for (int i=0; i<hauteur;i++){
			for (int j=0; j<longueur;j++){
				val+=1;
				grille[i][j]= new Case(val, i, j);
			}
		}
		choixArrX=(int)Math.round(Math.random()*(hauteur-1));
		choixArrY=longueur-1;
		joueurX=(int)Math.round(Math.random()*(hauteur-1));
		joueurY=0;
	}


	public Grille(){
		this(4,4);
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

	public void afflaby(){
		//placement de l'arrivée et du joueur

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
				//placement de l'arrivée
				if (i==choixArrX && j==choixArrY){
					if (grille[i][j].getMurG()==Case.Etat.FERME){
						System.out.print("| A ");
					}else{
						System.out.print("  A ");
					}
				}else if (i==joueurX && j==joueurY){
					if (grille[i][j].getMurG()==Case.Etat.FERME){
						System.out.print("|[1]");
					}else{
						System.out.print(" [1]");
					}
				}else{
					if (grille[i][j].getMurG()==Case.Etat.FERME){
						System.out.print("|   ");
					}else{
						System.out.print("    ");
					}
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
		//Mur mur=new Mur(0,0,0);
		ArrayList<Mur> mursRestants = new ArrayList<Mur>(); 
		for (int i=0; i<hauteur; i++){
			for (int j=0; j<longueur; j++){
				if (j!=0){
					if (grille[i][j].getMurG()==Case.Etat.FERME && grille[i][j-1]!=grille[i][j]){
						Mur mur=new Mur(i,j,0);
						mursRestants.add(mur);
					}
				}
				if (i!=0){
					if (grille[i][j].getMurH()==Case.Etat.FERME && grille[i-1][j]!=grille[i][j]){
						Mur mur=new Mur(i,j,1);
						mursRestants.add(mur);
					}
				}
			}
		}

		int nbMurs;
		int choixMur;
		int murSituation;
		int murX;
		int murY;
		//m=1 : mur haut, m=0 mur gauche
		while (toutChiffre()==false){
			nbMurs=mursRestants.size();
			//System.out.println("nb de murs restants:"+nbMurs);
			choixMur=(int)Math.round(Math.random()*(nbMurs-1));
			//System.out.println(choixMur);
			murSituation=mursRestants.get(choixMur).getMurM();
			murX=mursRestants.get(choixMur).getMurX();
			murY=mursRestants.get(choixMur).getMurY();
			int valAvant=grille[murX][murY].getVal();
			if (murSituation==1){
				if (grille[murX][murY].getVal()==grille[murX-1][murY].getVal()){
					mursRestants.remove(choixMur);
				}else{

					//System.out.println("mur haut");
					grille[murX][murY].setMurH(Case.Etat.OUVERT);
					grille[murX][murY].setVal(grille[murX-1][murY].getVal());
					etendreChiffre(grille[murX-1][murY].getVal(), valAvant);
					mursRestants.remove(choixMur);
				}
			}else{
				if (grille[murX][murY].getVal()==grille[murX][murY-1].getVal()){
					mursRestants.remove(choixMur);
				}else{
					//System.out.println("mur gauche");
					grille[murX][murY].setMurG(Case.Etat.OUVERT);
					grille[murX][murY].setVal(grille[murX][murY-1].getVal());
					etendreChiffre(grille[murX][murY-1].getVal(), valAvant);
					mursRestants.remove(choixMur);
				}
			}
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

	public void etendreChiffre(int val1, int val2){
		int valavant=val2;
		int valnouv=val1;
		if (val1>val2){
			valavant=val1;
			valnouv=val2;
		}
		for (int i=0; i<hauteur; i++){
			for (int j=0; j<longueur; j++){
				if (grille[i][j].getVal()==valavant){
					grille[i][j].setVal(valnouv);
				}
			}
		}
	}	

	public void setDepX(int x){
		joueurX=x;
	}

	public void setDepY(int y){
		joueurY=y;

	}

	public boolean gagner(){
		if (choixArrX==joueurX && choixArrY==joueurY){
			return true;
		}
		return false;
	}

	public boolean bougerPion (String direction) {
		//gauche
		if (direction.equals("q")){
			if (grille[joueurX][joueurY].getMurG()==Case.Etat.FERME){
				return false;
			}else{
				joueurY-=1;
				return true;
			}
		}
		//droite
		if (direction.equals("d")){
			if (grille[joueurX][joueurY+1].getMurG()==Case.Etat.FERME){
				return false;
			}else{
				joueurY+=1;
				return true;
			}
		}
		//haut
		if (direction.equals("z")){
			if (grille[joueurX][joueurY].getMurH()==Case.Etat.FERME){
				return false;
			}else{
				joueurX-=1;
				return true;
			}
		}
		//bas
		if (direction.equals("s")){
			if (grille[joueurX+1][joueurY].getMurH()==Case.Etat.FERME){
				return false;
			}else{
				joueurX+=1;
				return true;
			}
		}
		return false;
	}
}


public class Grille {
	private Case[][] grille;
	private int hauteur;
	private int longueur;

	public Grille(int hauteur, int longueur){
		int val=0;
		grille = new Case[hauteur][longueur];
		for (int i=0; i<hauteur;i++){
			for (int j=0; j<longueur;j++){
				val+=1;
				grille[i][j]= new Case(val, i, j);
			}
		}
	}
	
	/*public Grille(){
		Grille grille = new Grille(5,5);
	}*/

	public void affGrille(){
		for (int i=0; i<hauteur; i++){
			for (int j=0; j<longueur; j++){
				System.out.print(grille[i][j].getVal()+" ");
			}
			System.out.println();
		}
	}

}

import java.util.Scanner;

public class Labyrinthe {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("choisissez la taille du labyrinthe:");
		System.out.println("nombre de cases en longueur:");
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		System.out.println("nombre de cases en hauteur:");
		int h = sc.nextInt();
		Grille grille1 = new Grille(h,l);
		grille1.laby();
		grille1.afflaby();

		while (grille1.gagner()!=true){
			String direction = "a";
			while (!direction.equals("d") && !direction.equals("q") && !direction.equals("z") && !direction.equals("s")){
				System.out.println("Où voulez-vous aller?");
				System.out.println("(droite:d, Gauche:q, Haut:z, Bas:s)");
				direction = sc.next();
			}
			//grille1.bougerPion(direction);
			if (grille1.bougerPion(direction)){
				grille1.afflaby();
			}else{
				System.out.println("vous ne pouvez pas aller par là !");
			}
		}
		System.out.println("Vous avez gagné !");
	}

}

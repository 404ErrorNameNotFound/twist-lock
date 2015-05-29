package pack;

import java.util.ArrayList;

public class fonctions {

	public static int LigneMap(String s)
	{
		String inter = s.replace("|","-");
		String[] truc = inter.split("-");
		
		return truc.length;
	}
	
	public static int ColMap(String s)
	{
		String[] inter = s.replace("|","-").split("-");
		String[] truc = inter[0].split(":");
		return truc.length;
	}
	
	public static int[][] tableauValeur (String s, int ligne, int col)
	{
		int [][] tableau = new int [ligne][col];
		
		for (int i = 0; i<ligne; i++) {
			for (int j = 0; j<col; j++) {
				String[] inter = s.replace("|","-").split("-");
				String[] truc = inter[i].split(":");
				tableau [i][j] = Integer.parseInt(truc [j]);
			}
		}
		return tableau;	
	}
	
	public static void tableauValeur_toString (int [][] tableau) {
		
		
		for (int i = 0; i<tableau.length; i++) {
			System.out.print("| ");
			for (int j = 0; j<tableau[0].length; j++) {
				System.out.print(tableau[i][j] + " | ");
			}
			System.out.println("");
		}
	}
	
	public static int[][] tableauPointsLock (int[][] tableau) {
		
		int [][] tableauPointsLock = new int [tableau.length+1][tableau[0].length+1];
		
		for (int i = 0; i<tableauPointsLock.length; i++) {
			for (int j = 0; j<tableauPointsLock[0].length; j++) {
				
				// En haut à gauche
				if (i==0 && j==0) {
					tableauPointsLock[i][j] = tableau [i][j];
				}
				
				// En haut à droite
				else if (i==0 && j==tableauPointsLock[0].length-1) {
					tableauPointsLock[i][j] = tableau [i][j-1];
				}
				
				// En bas à gauche
				else if (i==tableauPointsLock.length-1 && j==0) {
					tableauPointsLock[i][j] = tableau [i-1][j];
				}
				
				// En bas à droite
				else if (i==tableauPointsLock.length-1 && j==tableauPointsLock[0].length-1) {
					tableauPointsLock[i][j] = tableau [i-1][j-1];
				}
				
				// Ligne haut
				else if (i==0) {
					tableauPointsLock[i][j] = tableau [i][j]+tableau [i][j-1];
				}
				
				// Ligne basse
				else if (i==tableauPointsLock.length-1) {
					tableauPointsLock[i][j] = tableau [i-1][j-1] + tableau [i-1][j];
				}
				
				// Colonne Gauche
				else if (j==0) {
					tableauPointsLock[i][j] = tableau [i-1][j]+tableau [i][j];
				}
				
				// Colonne Droite
				else if (j==tableauPointsLock[0].length-1) {
					tableauPointsLock[i][j] = tableau [i-1][j-1]+tableau [i][j-1];
				}
				
				else {
					tableauPointsLock[i][j] = tableau [i-1][j-1]+tableau [i-1][j]+tableau [i][j]+tableau [i][j-1];
				}
				 
			}
		}
		
		return tableauPointsLock;		
	}
	
	public static void tableauPointsLock_toString (int [][] tableau) {
		
		
		for (int i = 0; i<tableau.length; i++) {
			System.out.print("| ");
			for (int j = 0; j<tableau[0].length; j++) {
				System.out.print(tableau[i][j] + " | ");
			}
			System.out.println("");
		}
	}
	
	public static int[][] initTableauOccupe (int [][] tableau) {
		
		int [][] tableauOccupe = new int [tableau.length][tableau[0].length];
		
		for (int i = 0; i<tableau.length; i++) {
			for (int j = 0; j<tableau[0].length; j++) {
				tableauOccupe [i][j] = 0;
			}
		}
		
		return tableauOccupe;
	}
	
	public static void nouveauCoup (int [][] tableauOccupe, int joueur, String coord) {
		
		String[] coords = coord.split("");
		
		int ligne = Integer.parseInt(coords[0])-1;
		int colonne = (int) coords[1].toUpperCase().charAt(0)-65;

	
		
		if (coords[2].equals("2")) {
			colonne++;
		}
		
		else if (coords[2].equals("3")) {
			ligne++;
			colonne++;
		}
		
		else if (coords[2].equals("4")) {
			ligne++;
		}
		
		if (ligne>tableauOccupe.length-1 || colonne>tableauOccupe[0].length-1) {
			return;
		}

		else {tableauOccupe[ligne][colonne] = joueur;}
	}
	
	public static void tableauOccupe_toString (int [][] tableau) {
		
		
		for (int i = 0; i<tableau.length; i++) {
			System.out.print("| ");
			for (int j = 0; j<tableau[0].length; j++) {
				System.out.print(tableau[i][j] + " | ");
			}
			System.out.println("");
		}
	}

	public static void isOccupied (ArrayList<String> taken, String nbcase)
	{
		taken.add(nbcase);//EX:9B1
		String[] all=nbcase.split("");
		String[] alpha={"Z","A","B","C","D","E","F","G","H","I","J","Y"};
		int i=0;
		
		while(!(all[2].equals(alpha[i])))
		{
			i++;
		}

		String case1=all[1]+alpha[i-1]+(Integer.parseInt(all[3])+1);
		taken.add(case1);//EX:9A2
		String case2=(Integer.parseInt(all[1])-1)+alpha[i-1]+(Integer.parseInt(all[3])+2);
		taken.add(case2);//EX:8A3
		String case3=(Integer.parseInt(all[1])-1)+alpha[i]+(Integer.parseInt(all[3])+3);
		taken.add(case3);//EX:8B4
	}

}

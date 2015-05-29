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
	
	public static int[][] initTableauOccupe (int ligne, int col) {
		
		int [][] tableauOccupe = new int [ligne+1][col+1];
		
		for (int i = 0; i<=ligne; i++) {
			for (int j = 0; j<=col; j++) {
				tableauOccupe [i][j] = 0;
			}
		}
		
		return tableauOccupe;
	}

	public static void nouveauCoup (int [][] tableauValeur, int [][] tableauPoint, int [][] tableauOccupe, int joueur, String coord) {
		
		String[] coords = coord.split("");
		if (coords[1].equals("0"))
				{
					coords[1]=coords[2];
					coords[2]=coords[3];
					coords[0]="10";
				}
		
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
			
		}
		
		else {
			tableauOccupe[ligne][colonne] = joueur;
		}
		
		recalculeTableauPoints(tableauValeur, tableauPoint, ligne,colonne);

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
	
	public static void recalculeTableauPoints (int [][] tableauValeur, int[][] tableauPoint, int x, int y) {
		
			// Milieu 
			tableauPoint [x][y] = 0;
			
			// Haut gauche
			if(!(x-1<0) && !(y-1<0) && !(x>tableauValeur.length-1) && !(y>tableauValeur[0].length-1)){tableauPoint [x-1][y-1] = tableauPoint [x-1][y-1]-tableauValeur[x-1][y-1];}
			
			// Haut
			if(!(x-1<0) && !(y-1<0) && !(x>tableauValeur.length-1) && !(y>tableauValeur[0].length-1)){tableauPoint [x-1][y] = tableauPoint [x-1][y]-tableauValeur[x-1][y-1];}
			if(!(x-1<0) && !(y-1<0) && !(x>tableauValeur.length-1) && !(y>tableauValeur[0].length-1)){tableauPoint [x-1][y] = tableauPoint [x-1][y]-tableauValeur[x-1][y];}
			
			//Haut droit
			if(!(x-1<0) && !(y-1<0) && !(x>tableauValeur.length-1) && !(y>tableauValeur[0].length-1)){tableauPoint [x-1][y+1] = tableauPoint [x-1][y+1]-tableauValeur[x-1][y];}
			
			//Milieu gauche
			if(!(x-1<0) && !(y-1<0) && !(x>tableauValeur.length-1) && !(y>tableauValeur[0].length-1)){tableauPoint [x][y-1] = tableauPoint [x][y-1]-tableauValeur[x-1][y-1];}
			if(!(x-1<0) && !(y-1<0) && !(x>tableauValeur.length-1) && !(y>tableauValeur[0].length-1)){tableauPoint [x][y-1] = tableauPoint [x][y-1]-tableauValeur[x][y-1];}
			
			//Milieu Droit
			if(!(x-1<0) && !(y-1<0) && !(x>tableauValeur.length-1) && !(y>tableauValeur[0].length-1)){tableauPoint [x][y+1] = tableauPoint [x][y+1]-tableauValeur[x-1][y];}
			if(!(x-1<0) && !(y-1<0) && !(x>tableauValeur.length-1) && !(y>tableauValeur[0].length-1)){tableauPoint [x][y+1] = tableauPoint[x][y+1]	-tableauValeur[x][y];}
			
			//Bas gauche
			if(!(x-1<0) && !(y-1<0) && !(x>tableauValeur.length-1) && !(y>tableauValeur[0].length-1)){tableauPoint [x+1][y-1] = tableauPoint [x+1][y-1]-tableauValeur[x][y-1];}
			
			//Bas milieu
			if(!(x-1<0) && !(y-1<0) && !(x>tableauValeur.length-1) && !(y>tableauValeur[0].length-1)){tableauPoint [x+1][y] = tableauPoint [x+1][y]-tableauValeur[x][y-1];}
			if(!(x-1<0) && !(y-1<0) && !(x>tableauValeur.length-1) && !(y>tableauValeur[0].length-1)){tableauPoint [x+1][y] = tableauPoint [x+1][y]-tableauValeur[x][y];}
			
			//Bas droit
			if(!(x-1<0) && !(y-1<0) && !(x>tableauValeur.length-1) && !(y>tableauValeur[0].length-1)){tableauPoint [x+1][y+1] = tableauPoint [x+1][y+1]-tableauValeur[x][y];}
			
			// Remise à Zéro des valeurs négatives
			for (int i = 0; i<tableauPoint.length; i++) {
				for (int j = 0; j<tableauPoint[0].length; j++) {
					if (tableauPoint[i][j] < 0) {tableauPoint[i][j] = 0;}
				}
			}
	}
			
	public static void isOccupied (String nbcase)
	{
		String[] all=nbcase.split("");
		String[] alpha={"Z","A","B","C","D","E","F","G","H","I","J","Y"};
		int i=0;
		
		while(!(all[2].equals(alpha[i])))
		{
			i++;
		}

		String case1=all[1]+alpha[i-1]+(Integer.parseInt(all[3])+1);
		String case2=(Integer.parseInt(all[1])-1)+alpha[i-1]+(Integer.parseInt(all[3])+2);
		String case3=(Integer.parseInt(all[1])-1)+alpha[i]+(Integer.parseInt(all[3])+3);
	}

	public static String coupAJouer (int [][] tableauPoint, int [][] tableauOccupe) {
		
		String[] alpha={"A","B","C","D","E","F","G","H","I","J", "K"};
		String pos = tableauPoint.length-1 + alpha[tableauPoint[0].length-1] + "2";
		int valMax = 0;
		int [] coord = new int [2];
		
		for (int i = 0; i<tableauPoint.length; i++) {
			for (int j = 0; j<tableauPoint[0].length; j++) {
				if (tableauPoint[i][j]>valMax){valMax = tableauPoint[i][j]; coord[0] = i; coord [1] = j; pos = (coord[0]+1) + alpha[coord[1]] + "1";}
				else if (i == tableauPoint.length-1 && j == tableauPoint[0].length-1 && tableauPoint[i][j]==valMax && tableauOccupe [i][j] == 0 && coord[0]==0 && coord[1]==0){valMax = tableauPoint[i][j]; coord[0] = i; coord [1] = j; pos = (coord[0]) + alpha[coord[1]-1] + "3"; }
				else if (j == tableauPoint[0].length-1 && tableauPoint[i][j]==valMax && tableauOccupe [i][j] == 0 && coord[0]==0 && coord[1]==0){valMax = tableauPoint[i][j]; coord[0] = i; coord [1] = j; pos = (coord[0]+1) + alpha[coord[1]-1] + "3"; }
				else if (i == tableauPoint.length-1 && tableauPoint[i][j]==valMax && tableauOccupe [i][j] == 0 && coord[0]==0 && coord[1]==0){valMax = tableauPoint[i][j]; coord[0] = i; coord [1] = j; pos = (coord[0]) + alpha[coord[1]] + "4"; }				
				else if (tableauPoint[i][j]==valMax && tableauOccupe [i][j] == 0 && coord[0]==0 && coord[1]==0){valMax = tableauPoint[i][j]; coord[0] = i; coord [1] = j; pos = (coord[0]+1) + alpha[coord[1]] + "1"; }
			}
		}
		
		return pos;
	}
}

package pack;


import java.util.Scanner;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String val = "25:26:27:45|54:12:13:14|67:34:35:36";
		int col = fonctions.ColMap(val);
		int row = fonctions.LigneMap(val);
		int [][] tableauValeur = fonctions.tableauValeur(val, row, col);
				
		fonctions.tableauValeur_toString(tableauValeur);
		
		int [][] tableauPointsLock = fonctions.tableauPointsLock(tableauValeur);
		
		fonctions.tableauPointsLock_toString(tableauPointsLock);
		
		int [][] tableauOccupe = fonctions.initTableauOccupe(tableauPointsLock);
		
		fonctions.nouveauCoup(tableauOccupe, 2, "2E3");
		
		fonctions.tableauOccupe_toString(tableauOccupe);
		
		System.out.println("Nb row:" + row);
		System.out.println("Nb col:" + col);
	}

}

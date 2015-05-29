package pack;


import java.util.Scanner;


public class test {

	public static void main(String[] args) {
		
		
		String val = "25:26:27:45|54:12:13:14|67:34:35:36";
		int col = fonctions.ColMap(val);
		int row = fonctions.LigneMap(val);
		int [][] tableauValeur = fonctions.tableauValeur(val, row, col);
		int [][] tableauOccupe = fonctions.initTableauOccupe(row, col);
				
		fonctions.tableauValeur_toString(tableauValeur);
		System.out.println("");
		
		int [][] tableauPointsLock = fonctions.tableauPointsLock(tableauValeur);
		
		fonctions.tableauPointsLock_toString(tableauPointsLock);
		
		System.out.println("");
		
		fonctions.nouveauCoup(tableauValeur, tableauPointsLock, tableauOccupe, 2, "2C3");		
		System.out.println("");
		
		fonctions.tableauPointsLock_toString(tableauPointsLock);		
		System.out.println("");
		
		fonctions.tableauOccupe_toString(tableauOccupe);
		System.out.println("");
		
		fonctions.nouveauCoup(tableauValeur, tableauPointsLock, tableauOccupe, 2, "2B3");		
		System.out.println("");
		
		fonctions.tableauPointsLock_toString(tableauPointsLock);
		
		fonctions.tableauOccupe_toString(tableauOccupe);
		System.out.println("");
		
		fonctions.nouveauCoup(tableauValeur, tableauPointsLock, tableauOccupe, 2, "3B1");		
		System.out.println("");
		
		fonctions.tableauPointsLock_toString(tableauPointsLock);
		System.out.println("");
		
		fonctions.tableauOccupe_toString(tableauOccupe);
		System.out.println("");
		
		System.out.println(fonctions.coupAJouer(tableauPointsLock, tableauOccupe));
		
		System.out.println("Nb row:" + row);
		System.out.println("Nb col:" + col);
	}

}

package pack;


import java.util.Scanner;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String val = "25:26:27:45|54:12:13:14|67:34:35:36";
		int col = fonctions.ColMap(val);
		int row = fonctions.LigneMap(val);
		String [][] tableau = fonctions.tableau(val, row, col);
		
		fonctions.tableau_toString(tableau);
		
		System.out.println("Nb row:" + row);
		System.out.println("Nb col:" + col);
	}

}

package pack;


import java.util.Scanner;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String val = "25:26:27:45|54:12:13:14|67:34:35:36";
		String[] truc = fonctions.splitLigne(val);
		String [] machin = fonctions.splitCol(truc[0]);
		int col = fonctions.ColMap(machin);
		int row = fonctions.LigneMap(truc);
		System.out.println("Nb row:" + row);
		System.out.println("Nb col:" + col);
	}

}

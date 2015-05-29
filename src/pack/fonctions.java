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
	
	public static String[][] tableau (String s, int ligne, int col)
	{
		String [][] tableau = new String [ligne][col];
		
		for (int i = 0; i<ligne; i++) {
			for (int j = 0; j<col; j++) {
				String[] inter = s.replace("|","-").split("-");
				String[] truc = inter[i].split(":");
				tableau [i][j] = truc [j];
			}
		}
		return tableau;	
	}
	
	public static void tableau_toString (String [][] tableau) {
		
		for (int i = 0; i<tableau.length; i++) {
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

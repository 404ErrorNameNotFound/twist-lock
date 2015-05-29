package pack;


import java.util.Scanner;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println ("Hello world ! BIAAAAATCH !!");
		Scanner scan = new Scanner (System.in);
		System.out.println ("Tapez la map : ");
		String map = scan.nextLine();
		
		fonctions.nombre_lignes(map);
	}

}

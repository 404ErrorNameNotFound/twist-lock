package pack;

public class fonctions {

public static int nombre_lignes (String map) {
		
		int lignes = 0;
		
		while (map.split("|") != null) {
			lignes ++;
		}
		
		return lignes;
	}
}

package pack;

public class fonctions {

	public static int LigneMap(String[] s)
	{
		return s.length;
	}
	
	public static int ColMap(String[] s)
	{
		return s.length;
	}
	
	public static String[] splitLigne(String s)
	{
		String inter = s.replace("|","-");
		String[] truc = inter.split("-");
		
		/*for (int i = 0; i<truc.length; i++)
			System.out.println(truc[i]);
			*/
		return truc;
		
	}
	
	public static String[] splitCol(String tab)
	{
		String[] truc;
		truc = tab.split(":");
		return truc;
	}
}

package pack;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import sun.security.pkcs11.wrapper.Functions;

public class ia
{
	private int [][] tableauValeur;
	private int [][] tableauPoint;
	private int [][] tableauOccupe;
	
	public ia(String s)
	{
		tableauValeur = fonctions.tableauValeur(s, fonctions.LigneMap(s), fonctions.ColMap(s));
		tableauPoint = fonctions.tableauPointsLock(tableauValeur);
		tableauOccupe = fonctions.initTableauOccupe(fonctions.LigneMap(s), fonctions.ColMap(s));
	}
	
	public void jouer(DatagramSocket sock, InetAddress host, int port)
	{
		String coup = fonctions.coupAJouer(tableauPoint);
		fonctions.nouveauCoup(tableauValeur, tableauPoint, tableauOccupe, 1, coup);
		// socket
		byte[] b = coup.getBytes();
    	DatagramPacket  dp = new DatagramPacket(b , b.length , host , port);
        sock.send(dp);
	}
	
	public void maj(String point, int player)
	{
		fonctions.nouveauCoup(tableauValeur, tableauPoint, tableauOccupe, player, point);
	}
}

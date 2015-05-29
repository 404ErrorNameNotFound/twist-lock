package pack;

import java.io.*;
import java.net.*;
 
public class Connexion_jeux
{
    public static void main(String args[]) throws SocketException, UnknownHostException
    {
        DatagramSocket sock = null;
        int port = 9877;
        String s;
        int tour=0;
        sock = new DatagramSocket();
    	InetAddress host = InetAddress.getByName("172.30.7.16");
    	
        String couleur="";
        String map="";
        String coupennemy="";
        s = "truc";
         
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
         
        try
        {
        	while(true)
        	{
	            if(tour==0)
	            {
	            	
		            byte[] b = s.getBytes();
	            	DatagramPacket  dp = new DatagramPacket(b , b.length , host , port);
		            sock.send(dp);

	            }
	            
	            if(s.contains("|"))
	            {
		            map=getMap(s);
		            // donner la map à l'IA
		            echo("Couleur: "+couleur+"\nMap= "+map);
		            s = "";
	            }
	            else if(s.contains("Vous"))
	            {
		            couleur = getCouleur(s);
		            s = "";
	            }
	            else if(s.contains("10"))
	            {
	            	// A nous de jouer
	            	// mise à jour de la map avec nos données
	            	s = "";
	            }
	            else if(s.contains("20"))
	            {
	        		coupennemy=getCoup(s);
	        		System.out.println("adversaire a joué");
	        		// mise à jour de nos données : map de l'IA
	            	s = "";
	            }
	            else if(s.contains("21"))
	            {
	            	// nous avons mal joué
	            	s = "";
	            }
	            else if(s.contains("50"))
	            	while (true)
	            	{
	            		s = "Fini";
	            		byte[] b = s.getBytes();
		            	DatagramPacket  dp = new DatagramPacket(b , b.length , host , port);
			            sock.send(dp);
	            	}
	            else if(s.contains("88"))
	            	break;
	            else
	            {
	            	//buffer to receive incoming data
	                byte[] buffer = new byte[65536];
	                DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
	                sock.receive(reply);
	                 
	                byte[] data = reply.getData();
	                s = new String(data, 0, reply.getLength());
	                 
	                //echo the details of incoming data - client ip : client port - client message
	                echo(reply.getAddress().getHostAddress() + " : " + reply.getPort() + " - " + s);
	            }

		            
		            
	                tour++;
	         }
        }
         
        catch(IOException e)
        {
            System.err.println("IOException " + e);
        }
    }
     
    //simple function to echo data to terminal
    public static void echo(String msg)
    {
        System.out.println(msg);
    }
    
 // String envoyé par le serveur
 	// Extrait la couleur de la ligne
 	public static String getCouleur(String s)
 	{
 		if (s.toLowerCase().contains("rouge"))
 			return "rouge";
 		else
 			return "vert";
 	}
 	
 	// String envoyé par le serveur
 	// Supprime le "maps="
 	public static String getMap(String s)
 	{
 		String [] exploded = s.split("=");
 		//System.out.println(exploded[1]);
 		return exploded[1];
 	}
 	
 // Examine le type de message
 	// true si le joueur ennemi a bien joué
 	// false si c'est un noob
 	public static boolean getEnemyCoup(String s)
 	{
 		String [] exploded = s.split(":");
 		System.out.println(exploded[0]);
 		if (exploded[0].equals("20"))
 			return true;
 		else
 			return false;
 	}
 	
 	//Retourne seulement le coup joué par l'adversaire
 	public static String getCoup(String s)
 	{
 		String [] exploded = s.split(":");
 		return exploded[2];
 	}
 	
}
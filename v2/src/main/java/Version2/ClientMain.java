package Version2;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.Vector;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

/**
*
* @author Administrator
*/
public class ClientMain {
	
	
	private static Vector NOTIF = new Vector(); 
	public ArrayList<String> pseudo = new ArrayList<>();
	public static ArrayList<String> Joueurjeton = new ArrayList<>(); 
	String Joueur;
	
	

// RMI notification, pour arroser tout les clients 
public static ClientMain getInstance(){        
	ClientMain tmp = new ClientMain();
            if (NOTIF.contains(tmp)) {
                Enumeration enume = NOTIF.elements();
                while (enume.hasMoreElements()) {
                	ClientMain element = (ClientMain) enume.nextElement();
                    if (element.equals(tmp)) {
                        return element;
                    }
                }
            }
            else {
            	NOTIF.add(tmp);
                return tmp;
            }
            return null;
    }



// RMI classique pour serveur
public InterfaceServ connectServer() {
try
	{
	Registry reg= LocateRegistry.getRegistry("localhost",1099);
	InterfaceServ proxy= (InterfaceServ) reg.lookup("serveur");
	System.out.println("On est bien connecté au Serveur ! Merci RMI !");
	return proxy;
	}
	catch(Exception e)
	{
		System.out.println(e);
		return null;
	}
}





// Le client appel le serveur pour recuperer son pseudo pour L'initialisation
public ArrayList<String> getPseudo(InterfaceServ proxy) throws RemoteException {
    pseudo=proxy.getJoueur();
    return pseudo;
    
   
}


// on demande de saisir le nom du joueur
public String saisieJoueur(InterfaceServ proxy, ArrayList<String> NomDuJoueur) throws RemoteException{
    String text = proxy.getinit(" Oui ");  // petit test pour savoir qui est qui
    System.out.println(text);   // doit renvoyer le message client et le message serveur avec le nom du joueur
    Scanner sc = new Scanner(System.in);
    System.out.println("Entrer Nom joueur :");
    String Joueur = sc.nextLine();
    if(NomDuJoueur.contains(Joueur) || Joueur.equals("")){
        return null;
    }else return Joueur;
}


// La grosse methode pour initialiser un Joueur
public void CreationJoueur(InterfaceServ proxy, String j) throws RemoteException{
    proxy.CreerJoueur(j); // fait appel a la création du joueur sur le serveur
         
}









// On va lancer la partie
public void LancementPartie(InterfaceServ RMIjeton) throws RemoteException, InterruptedException{      
    
    Joueurjeton=getPseudo(RMIjeton);     // On recupere le nom du joueur actuel
    Joueur=saisieJoueur(RMIjeton,Joueurjeton);    // on entre le nom du joueur
    while(Joueur==null){
        System.out.println("Erreur recommencez");
        Joueur=saisieJoueur(RMIjeton,Joueurjeton);
    }
    CreationJoueur(RMIjeton, Joueur);    // on appelle la methode de création de joueur
    /*RemplirDesJoueur(RMIjeton, Joueur);
    AfficherDesJoueur(RMIjeton, Joueur);
    AfficherJoueur(RMIjeton);*/
}









// le gros main ( pas en terme de taille)  qui va gérer l'appel des autres mains
public static void main(String args[]) throws RemoteException, InterruptedException{
	ClientMain Joueur = new ClientMain();
	InterfaceServ RMIjeton=Joueur.connectServer();
    if(RMIjeton==null){
         System.out.println("Erreur de connexion");
      }

      Joueur.LancementPartie(RMIjeton);

	
}
}
















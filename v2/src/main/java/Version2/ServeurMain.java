package Version2;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

/**
*
* @author Administrator
*/
public class ServeurMain extends UnicastRemoteObject implements InterfaceServ{
	ArrayList<String> pseudo= new ArrayList<>(); 
	ArrayList<Utilisateur> users= new ArrayList<>();
	ArrayList<Joueur> joueurs= new ArrayList<>();
	
	
	// on init une nouvelle partie , a completer pour les threads !!
	Partie  partie= new Partie("Chat");
	
	
	
public ServeurMain() throws RemoteException
	{
	super();
	}





@Override
public ArrayList<String> getJoueur(){
    return pseudo;
}


// le test pour savoir si on recoit le nom du joueur, si ca marche le RMI FONCTIONNE SA MERRRR
public String getinit(String text) throws RemoteException {
    text = "Si message recu est oui alors on est bon :  "+text;
    return text;
 }


// c'est notre methode mise a jour, on va faire appel a celle ci lorsqu'un nouveau joueur veut ce créer
public void CreerJoueur(String j) throws RemoteException{
    pseudo.add(j);
    Utilisateur NewJ = new Utilisateur(j);     // on va ajouter ce nouvel utilisateur à notre pseudo base 
    users.add(NewJ);
    
    ArrayList<Des> tmp = new ArrayList<>();      // on lui attribue ses des
    tmp.clear();
    Joueur joueur = new Joueur(NewJ, tmp,0);    // on met 0 au dernié champs car il n'a pas encore de passage précis pour lui
    joueurs.add(joueur);
    partie.addjoueur(joueur);	// on ajoute le joueur a la partie
    System.out.println("Creation joueur");
}








// c'est tout ce qu'il y aura sur le serveur mon captain :! 
public static void main(String args[])
	{
	try
		{
		Registry reg = LocateRegistry.createRegistry(1099);
		reg.rebind("serveur", new ServeurMain());
		System.out.println("Server Started");
		}
	catch(Exception e)
	{
		System.out.println(e);
	}
	
	}
}
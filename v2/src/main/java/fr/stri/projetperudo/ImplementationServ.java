/* ICI on va entrer les fonctions des mÃ©thodes, elles pourront etre appellÃ©es via le client si elles sont dans InterfaceServ*/
package fr.stri.projetperudo;

/**
 *
 * @author florian b
 */
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject; 
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;



 public class ImplementationServ extends UnicastRemoteObject implements InterfaceServCli{
    private String nom;
    private String name; 
    private ArrayList<Partie> listePartie = new ArrayList<Partie>();
    
    public ImplementationServ(String s) throws RemoteException {
    super();
    name = s; 
} 
    
    /* Methode CreerPartie*/
    public String CreerPartie(String nomPartie,Integer NbJoueur)throws RemoteException {
         return "c'est bon partie crÃ©Ã©e"; 
     }
     
    /* MÃ©thode SeConnecter */
    public String SeConnecter(String nomJoueur)throws RemoteException {
         return "ConnectÃ©, bienvenu : "+nomJoueur;
    }
    
    /* MÃ©thode LanceDes */
    public String LanceDes(Integer Des)throws RemoteException{
        return "Vous avez fait : "+Des;
    }
     
    
    
    /*Méthode get Liste partie*/
     public ArrayList<Partie> getListePartie ( )
    {
        return listePartie;
    }
     

    /*Methode Creer partier*/
    public String creerPartie(String nomPartie, int nbJoueurs) {
        Partie a = new Partie(nomPartie, nbJoueurs);
        listePartie.add(a);  
        
        return "La Partie a bien était créer ";
    }
    
     
     
     
public static void main(String[] args) throws Exception {
	 	 LocateRegistry.createRegistry(1099);
                 ImplementationServ obj = new ImplementationServ("MonServeur"); 
	 	 Naming.rebind("MonServeur", obj);
	 	 System.out.println("RMI OK");
                 
          
/*
               
                 
                 
                 ICI LE CODE SERVEUR  
                       
                 
                       
                 
                 */


/*

TANT QUE LISTE PARTIE = NULL ATTENDRE 

TANT QUE NB JOUEUR < nb joueur qui soit y avoir
attendre
Fin tanque
    
    TANT QUE La liste de joueur est superieur a 1 faire 

MANCHE SENARIO DE LA PARTIE QUI BOUCLE !!
    
         Debut de manche --> codé avantManche
         Quel joueur Joue
            joueur lance des 
             tant que attente de la class Parti = NUUL atendre METHODE GETATTENTE
 pile  et menteur on va dans fin de manche -->  joueur decide action --> on l'aisse l'interface agir
Si non on continue la boucle (surcharge)
         FIn de la boucle
    fin du sénario
fin de la manche 
REsultat

*/


while()    
{ 
    
}








    
    } //crochet du main
}   // crochet de la classe

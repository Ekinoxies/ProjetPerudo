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
    private String nom; /* liens propre au rmi*/
    private String name; /*liens propre au rmi*/
    private ArrayList<Partie>listePartie = new ArrayList<>();
    
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
     
    
    
    
    /*Créer une partie */
   public String creerPartie (String nomPartie, int nbJoueur)
    {
    Partie a = new Partie(nomPartie,nbJoueur);
        listePartie.add(a);  
      
        return " La partie a était corectement ajouté";
    }
   


    
    
public static void main(String[] args) throws Exception {
	 	 LocateRegistry.createRegistry(1099);
                 ImplementationServ obj = new ImplementationServ("MonServeur"); 
	 	 Naming.rebind("MonServeur", obj);
	 	 System.out.println("RMI OK");





/*          //////////////////////////////////////////////////////////////////////
            //////////////////////////////////////////////////////////////////////
            //////////////////////////////////////////////////////////////////////
            //////////////////////////////////////////////////////////////////////
                                  ICI LE CODE COTé SERVEUR
            //////////////////////////////////////////////////////////////////////
            //////////////////////////////////////////////////////////////////////
            //////////////////////////////////////////////////////////////////////
*/

         
         





  } 

 
 
 
 
 
 }   

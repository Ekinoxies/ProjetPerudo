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



 public class ImplementationServ extends UnicastRemoteObject implements InterfaceServCli{
    private String nom;
    private String name; 
    
    
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
     
    
public static void main(String[] args) throws Exception {
	 	 LocateRegistry.createRegistry(1099);
                 ImplementationServ obj = new ImplementationServ("MonServeur"); 
	 	 Naming.rebind("MonServeur", obj);
	 	 System.out.println("RMI OK");
} 
}   

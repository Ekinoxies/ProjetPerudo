/* ICI on entre les methodes que le client pourra appeller */
package fr.stri.projetperudo;
/**
 *
 * @author florian b
 */

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface InterfaceServCli extends java.rmi.Remote  {
    
    public String CreerPartie(String nomPartie,Integer NbJoueur)throws java.rmi.RemoteException;
  
    public String SeConnecter(String nomJoueur)throws java.rmi.RemoteException;
    
    public String LanceDes(Integer Des)throws java.rmi.RemoteException;
    
   
    
    
    // Ecrire les methodes ici pour consulter le client via le serveur :
     public interface ClientNotification extends Remote {
	 	 public void getNomJoueurs() throws RemoteException;
}
}



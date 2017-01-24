/* ICI on entre les methodes que le client pourra appeller */
package fr.stri.projetperudo;
/**
 *
 * @author florian b
 */

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface InterfaceServCli extends Remote {
    public Integer Erreur(Integer x) throws RemoteException;
    
    public String CreerPartie(String nomPartie,Integer NbJoueur)throws RemoteException;
  
    public String SeConnecter(String nomJoueur)throws RemoteException;
    
    public String LanceDes(Integer Des)throws RemoteException;
}


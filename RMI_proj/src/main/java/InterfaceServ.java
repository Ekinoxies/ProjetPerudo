/* ICI on entre les methodes que le client pourra appeller */


/**
 *
 * @author florian b
 */

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface InterfaceServ extends Remote {
    public Integer Erreur(Integer x) throws RemoteException;
    
    public String CreerPartie(String nomPartie,Integer NbJoueur)throws RemoteException;
  
    public String SeConnecter(String nomJoueur)throws RemoteException;
    
    public String LanceDes(Integer Des)throws RemoteException;
}


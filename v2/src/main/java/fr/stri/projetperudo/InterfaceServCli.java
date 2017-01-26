/* ICI on entre les methodes que le client pourra appeller */
package fr.stri.projetperudo;
/**
 *
 * @author florian b
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


public interface InterfaceServCli extends java.rmi.Remote  {
    
    public String creerPartie(String nomPartie,Integer NbJoueur)throws java.rmi.RemoteException;
  
    public String SeConnecter(String nomJoueur)throws java.rmi.RemoteException;
    
    public String LanceDes(Integer Des)throws java.rmi.RemoteException;
    
   public ArrayList<Partie> getListePartie() throws java.rmi.RemoteException;
    
   public String connexionAunePartie(Joueurs a, String nomP) throws java.rmi.RemoteException;
    
  public String getNomPartieRMI(int nb) throws java.rmi.RemoteException;

    // Ecrire les methodes ici pour consulter le client via le serveur :
     public interface ClientNotification extends Remote {
	 	 public void getNomJoueurs() throws RemoteException;
}
}



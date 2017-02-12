/* ICI on entre les methodes que le client pourra appeller */
package fr.stri.projetperudo;
/**
 *
 * @author florian b
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


public interface InterfaceServeur extends java.rmi.Remote  {
    
   public String creerPartie(String nomPartie,Integer NbJoueur)throws java.rmi.RemoteException;
     
   public ArrayList<Partie> getListePartie() throws java.rmi.RemoteException;
    
   public String connexionAunePartie(Joueurs a, String nomP) throws java.rmi.RemoteException;
    
  public String getNomPartieRMI(int nb) throws java.rmi.RemoteException;

  public void pilRMI(Joueurs j, String nomP) throws java.rmi.RemoteException;
  
  public void menteurRMI(Joueurs j, String nomP) throws java.rmi.RemoteException;
  
  public void surchargeRMI(Joueurs j, int valDes,int nbDes, String nomP) throws java.rmi.RemoteException;
    
  
   
     // Ecrire les methodes ici pour consulter le client via le serveur :
   

    public void actualiserListeDesRMI(Joueurs j, ClientNotification desNotif, String nomP);
    public int actualiserNbDesRMI (Joueurs j,ClientNotification desNotif, String nomP) throws java.rmi.RemoteException;		 
}
    



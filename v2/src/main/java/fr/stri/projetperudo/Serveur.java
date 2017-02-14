/* ICI on entre les methodes que le client pourra appeller */
package fr.stri.projetperudo;
/**
 *
 * @author florian b
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


public interface Serveur extends java.rmi.Remote  {
    
   public String creerPartie(String nomPartie,Integer NbJoueur)throws java.rmi.RemoteException;
     
   public ArrayList<Partie> getListePartie() throws java.rmi.RemoteException;
    
   public String connexionAunePartie(Joueurs a, String nomP) throws java.rmi.RemoteException;
    
  public String getNomPartieRMI(int nb) throws java.rmi.RemoteException;

  public void pilRMI(Joueurs j, String nomP) throws java.rmi.RemoteException;
  
  public void menteurRMI(Joueurs j, String nomP) throws java.rmi.RemoteException;
  
  public void surchargeRMI(Joueurs j, int valDes,int nbDes, String nomP) throws java.rmi.RemoteException;
  
  
    public ArrayList actualiserListeDesRMI(Joueurs j, Client desNotif, String nomP) throws java.rmi.RemoteException;
    public int actualiserNbDesRMI (Joueurs j,Client desNotif, String nomP) throws java.rmi.RemoteException;	
  
  
    
    
    
  /////////////////***///////////////////////////////////////
  boolean transmettreAnnonce(int idJoueur) throws RemoteException;
  int enregistrerClient(Client c) throws RemoteException;
  boolean aMoiDeJouer (int idJoueur, Joueurs j, String nomP) throws RemoteException;
     
   

   	 
}
    



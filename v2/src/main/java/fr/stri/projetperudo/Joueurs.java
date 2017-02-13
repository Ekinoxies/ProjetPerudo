/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.stri.projetperudo;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Quizz
 */
public class Joueurs implements Serializable {
    public String nomJoueurs;
    public int nbDes;
    private ArrayList listeDes = new ArrayList<int []>();
    private Client notif;
    private String j;
    

   
   
    public int getNbDes() {
        return nbDes;
    }

    public void setNbDes(int nbDes) {
        this.nbDes = nbDes;
    }
    
    public void setListeDes(ArrayList<int[]> listeDes) {
        this.listeDes = listeDes;
    }
    
      
    
    
    public ArrayList<int[]> getListeDes() {
        
           
 
        return listeDes;
    }
        public Joueurs(String nomJoueurs) throws RemoteException{
        this.nomJoueurs = nomJoueurs;
        this.nbDes = 5;
    }
        
   
    public String getNomJoueurs() {
        return nomJoueurs;
    }
    
    
    private String notifJoueur;

    public void setNotification(Client notif, String j) {
	 	this.notif = notif;
                notifJoueur = j;
                 
                 
}
    
       
}

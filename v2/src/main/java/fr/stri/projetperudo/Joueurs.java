/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.stri.projetperudo;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
/**
 *
 * @author Quizz
 */
public class Joueurs {
    public String nomJoueurs;
    private int nbDes;
    private ArrayList<int []> listeDes = new ArrayList<int []>();

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
    
    

    public Joueurs(String nomJoueurs) {
        this.nomJoueurs = nomJoueurs;
        this.nbDes = 5;
    }

    public String getNomJoueurs() {
        return nomJoueurs;
    }
    
    void creerPartie(String nomP, int nbJ)
    {
        try {
         Registry registry = LocateRegistry.getRegistry(10000);
         InterfaceServCli stub1 = (InterfaceServCli) registry.lookup("CreerPartie");
         System.out.println(stub1.CreerPartie(nomP,nbJ)); // On entre les parametres pour Methode CreerPartie
          } catch (Exception e) {
            e.printStackTrace();
        }

    }
    void seConnecter(String nomJ)
    {
        try {
        Registry registry = LocateRegistry.getRegistry(10000);
        InterfaceServCli stub2 = (InterfaceServCli) registry.lookup("SeConnecter");
        System.out.println(stub2.SeConnecter(nomJ)); // On entre les parametres pour Methode SeConnecter
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.stri.projetperudo;

/**
 *
 * @author Quizz
 */
public class Joueurs {
    public String nomJoueurs;
    private int nbDes;
    public int ListeDes;

    public String getNomJoueurs() {
        return nomJoueurs;
    }
    
    void creerPartie(String nomP, int nbJ)
    {
         InterfaceServCli stub1 = (InterfaceServCli) registry.lookup("CreerPartie");
         System.out.println(stub1.CreerPartie(nomP,nbJ)); // On entre les parametres pour Methode CreerPartie
    }
    void seConnecter(String nomJ)
    {
        InterfaceServCli stub2 = (InterfaceServCli) registry.lookup("SeConnecter");
        System.out.println(stub2.SeConnecter(nomJ)); // On entre les parametres pour Methode SeConnecter
    }
    
}

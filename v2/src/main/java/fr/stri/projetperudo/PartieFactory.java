/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.stri.projetperudo;

import static fr.stri.projetperudo.ServeurImpl.listePartie;
import java.rmi.RemoteException;

/**
 *
 * @author jerome
 */
public class PartieFactory {
    
     public String creerPartie(String nomPartie, Integer nbJoueurs)throws RemoteException {
        Partie a = new Partie(nomPartie, nbJoueurs);
        listePartie.add(a);  
        System.out.println("La partie :" + nomPartie +" a etait créer avec un nombre de joueur de : " + nbJoueurs);
        
        return "La Partie a bien était créer ";
    }
      
    
    
    
    
}

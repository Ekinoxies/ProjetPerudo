/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.stri.projetperudo;
import static java.lang.Thread.sleep;
import static fr.stri.projetperudo.ServeurImpl.listePartie;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jerome
 */
public class SenarioThread extends Thread {

    private final int numP;
    
    //DEBUT DU THREAD

  public SenarioThread(int numP){
    this.numP = numP;
  }

  Joueurs j; //le joueur qui est en train de jouer
    

    @Override
    public void run () {
    try {
        ServeurImpl s = new ServeurImpl ();
        
        
        s.attJoueur(numP); // On attend que la partie soit complette
        
        while(s.gagnant(numP) == 0) // tant qu'il n'y a pas de gagnant
        {
            listePartie.get(numP).avantManche();
            listePartie.get(numP).setFinManche(0);
            
            /*LA MANCHE*/
            System.out.println(" //////////////////////////////");
            System.out.println("  Début d'une nouvelle Manche  ");
            System.out.println(" //////////////////////////////");
            System.out.println(" ");
            System.out.println(" ");
            
            for (int i = 0; i < listePartie.get(numP).getListeJoueur().size() ; i++)   //TOUR DE TABLE pour lancer les DES
            {
                
               j = listePartie.get(numP).getListeJoueur().get(i);
               //listePartie.get(numP).lanceDes(j); //lancéé de dés
               listePartie.get(numP).getListeJoueur().get(i).setListeDes(listePartie.get(numP).lanceDes(j)); // on va voir
                
            }
            
 
            int i = 0;
            while (listePartie.get(numP).getFinManche()== 0) //fin manche tant que la manche est pas fini;
            {
                

                /*TOUR D'un Joueur */
                listePartie.get(numP).setFinTour(0); // Début d'un nouveau tour
                
                j = listePartie.get(numP).getListeJoueur().get(i); // on recupere le joueur qui doit jouer
                
                System.out.println("Au joueur :" +j.getNomJoueurs()+" de joueur");
                
                
                
                // c'est a ce joueur de jouer :
                
                
                while (listePartie.get(numP).getFinTour()== 0) //tant que le tour du joueur n'est pas fini
                {
                    System.out.println(listePartie.get(numP).getFinTour());
                    sleep(5000);
                    // System.out.println("A TOI DE JOUER :" + j.getNomJoueurs());
                }
                
                // changer de joueur
                if(i == listePartie.get(numP).getListeJoueur().size() -1)
                {
                    i=0;
                }
                else
                {
                    i = i+1;
                }
                
            }
            
            
        }
        
        /* Gestion du gagnant ou perdan dans les fonctiosn pileRMi et menteurRMI */
        sleep(1000);// attente du a t'on gagné ?
        

    } catch (RemoteException ex) {
        Logger.getLogger(SenarioThread.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InterruptedException ex) {
        Logger.getLogger(SenarioThread.class.getName()).log(Level.SEVERE, null, ex);
    }
    
}
    
    
    
    
}

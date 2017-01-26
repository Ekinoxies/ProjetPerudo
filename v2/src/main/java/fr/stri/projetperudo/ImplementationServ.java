/* ICI on va entrer les fonctions des mÃ©thodes, elles pourront etre appellÃ©es via le client si elles sont dans InterfaceServ*/
package fr.stri.projetperudo;

/**
 *
 * @author florian b
 */
import static java.lang.Thread.sleep;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject; 
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;



 public class ImplementationServ extends UnicastRemoteObject implements InterfaceServCli{
    private String nom;
 
       
    private ArrayList<Partie> listePartie = new ArrayList<Partie>();
    
    public ImplementationServ() throws RemoteException {
    super();
 
} 
    
   
     
    
    
           
    
    /*Ajouter un joueur dans la listejoueur d'une partie*/
    public String connexionAunePartie(Joueurs a, String nomP)
    {
         String tmp;
         String retour = "Joueur non ajouté";
             
        for(int i = 0; i < listePartie.size(); i++)
        {
           
            tmp = listePartie.get(i).getNomPartie();
            
            if (tmp == nomP)
            {
                   
                    listePartie.get(i).ajoutJoueur(a);
                    retour = "Le joueurs est ajouté ";
            }
         }
                                
        return retour;
    }
     
    
      /*Methode Creer partier*/
    public String creerPartie(String nomPartie, int nbJoueurs) {
        Partie a = new Partie(nomPartie, nbJoueurs);
        listePartie.add(a);  
        
        return "La Partie a bien était créer ";
    }
    
    
    
    
      
    
    /////////////////////TEST////////////////
    /* MÃ©thode SeConnecter */
    public String SeConnecter(String nomJoueur)throws RemoteException {
         return "ConnectÃ©, bienvenu : "+nomJoueur;
    }
    
    /* MÃ©thode LanceDes */
    public String LanceDes(Integer Des)throws RemoteException{
        return "Vous avez fait : "+Des;
            }
    
    /* Methode CreerPartie*/
    public String CreerPartie(String nomPartie,Integer NbJoueur)throws RemoteException {
         return "c'est bon partie crÃ©Ã©e"; 
     }
  /////////////////////TEST////////////////
    
    
    
        /*Methode propre au sénario*/
    
    
    /*Méthode get Liste partie*/
     public ArrayList<Partie> getListePartie ( )
    {
        return listePartie;
    }
 
     
    /*Methode pour sénario*/
    public void attPartie() throws InterruptedException
    {
        while (listePartie.isEmpty())    
        { 
            sleep(2000);
        }
    }
    
   public void attJoueur (int nb) throws InterruptedException
   {
       ArrayList listeJ = new ArrayList();
       int nbj = listePartie.get(nb).getNbJoueur();
       
      listeJ = listePartie.get(nb).getListeJoueur();
       
 
    while (listeJ.size()<nbj)    
        { 
            sleep(2000);
        }
   }
   
   
   
   public int gagnant(int nb) 
   {
       int val = 0;
         ArrayList listeJ = new ArrayList();  
         listeJ = listePartie.get(nb).getListeJoueur();
         
         if (listeJ.size()==1)
         {
             val = 1;
         }
   return val;
   }  
   
 
     
     
   
   
     
public static void main(String[] args) throws Exception {
	 	 LocateRegistry.createRegistry(1099);
                 
	 	 Naming.rebind("MonServeur", new ImplementationServ());
	 	 System.out.println("RMI OK");
                 
          
/*                                         
                 ICI LE CODE SERVEUR       
                                             
*/

int numP = 0; // variable du numero de partie pour la v1 on l'utilisera a 0 par defaut
                // car on n'a qu'une partie
Joueurs j; //le joueur qui est en train de jouer

ImplementationServ s = new ImplementationServ();

s.attPartie();
s.attJoueur(numP); // v1 du site on attend que la partie 1 soit compplete

while(s.gagnant(numP) == 0)
    {
     s.listePartie.get(numP).avantManche();
     s.listePartie.get(numP).setFinManche(0);
         /*LA MANCHE*/ 
               
         while ( s.listePartie.get(numP).getFinManche()== 0) //fin manche tant que la manche est pas fini;
         {
            
             for (int i = 0; i < s.listePartie.get(numP).getListeJoueur().size();)   //TOUR DE TABLE 
             {    
                          /*TOUR D'un Joueur */
             s.listePartie.get(numP).setFinTour(0); // Début d'un nouveau tour 
             j = s.listePartie.get(numP).getListeJoueur().get(i); // on recupere le joueur qui doit jouer
             s.listePartie.get(numP).lanceDes(j); //lancéé de dés
              // c'est a ce joueur de jouer :
              
                            while (s.listePartie.get(numP).getFinTour()== 0) //tant que le tour du joueur n'est pas fini   
                            {
                              sleep(1000);
                                /*Qui joue et  qui est le prochain    On ajoute les getdes nom joueur dans les methodes pile surcharge et menteurg*/
                            }
                 } 
        
         }
       
     
     
    } 

/*LE GAGNANT EST :::: */




    
    } //crochet du main
}    // crochet de la classe

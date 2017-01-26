

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


/*

TANT QUE LISTE PARTIE = NULL ATTENDRE --> methode attPartie 

TANT QUE NB JOUEUR < nb joueur qui soit y avoir
attendre
Fin tanque  --> attJoueur (int nb)
    
    TANT QUE La liste de joueur est superieur a 1 faire 
--> Y a t'il un gagnant gagnant() qui return 1 ou 0 

MANCHE SENARIO DE LA PARTIE QUI BOUCLE !!
    
         Debut de manche --> codé avantManche
         Quel joueur Joue
            joueur lance des 
             tant que attente de la class Parti = NUUL atendre METHODE GETATTENTE
 pile  et menteur on va dans fin de manche -->  joueur decide action --> on l'aisse l'interface agir
Si non on continue la boucle (surcharge)
         FIn de la boucle
    fin du sénario
fin de la manche 
REsultat

*/
int numP = 0; // variable du numero de partie pour la v1 on l'utilisera a 0 par defaut
                // car on n'a qu'une partie

ImplementationServ s = new ImplementationServ();
s.attPartie();

s.attJoueur(numP); // v1 du site on attend que la partie 1 soit compplete

while(s.gagnant(numP) == 0)
    {
     s.listePartie.get(numP).avantManche();
     
         /*LA MANCHE*/
         
     
     
    }

/*LE GAGNANT EST :::: */




    
    } //crochet du main
}   // crochet de la classe

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
import java.util.HashMap;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;




 public class MainServeur extends UnicastRemoteObject implements InterfaceServeur {
    private String nom;
    private ClientNotification notif;
    HashMap<String, Joueurs> ju;
    HashMap<String, Partie> pa;
   
 
       
    private static ArrayList<Partie> listePartie = new ArrayList<Partie>();
    
    public MainServeur() throws RemoteException {
    super();
}   

    
    /*Ajouter un joueur dans la listejoueur d'une partie*/
    @Override
    public String connexionAunePartie(Joueurs a, String nomP) throws RemoteException
    {
         String tmp;
         String retour = " ERREUR Joueur non ajouté";
             
        for(int i = 0; i < listePartie.size(); i++)
        {
           
            tmp = listePartie.get(i).getNomPartie();
            
            if (tmp.compareToIgnoreCase(nomP)==0)
            {
                   
                    listePartie.get(i).ajoutJoueur(a);
                    System.out.println("Le Joueur" +a.getNomJoueurs()+ " est ajouté a la partie " + nomP );
                    
                    retour = "Le joueurs est ajouté ";
            }
         }
        
                                
        return retour;
    }
     
    
      /*Methode Creer partier*/
   public String creerPartie(String nomPartie, Integer nbJoueurs)throws RemoteException {
        Partie a = new Partie(nomPartie, nbJoueurs);
        listePartie.add(a);  
        System.out.println("La partie :" + nomPartie +" a etait créer avec un nombre de joueur de : " + nbJoueurs);
        
        return "La Partie a bien était créer ";
    }
    
    
    
          /*Methode suplementaire pour le rmi*/
    
   public String getNomPartieRMI(int nb) throws RemoteException{
        
            String nomPartie;
            
            nomPartie=listePartie.get(nb).getNomPartie();
            
            return nomPartie;  // retourne  a nimporte quel client directement 
    }
     
    
   public void pilRMI(Joueurs j, String nomP) throws RemoteException {
      
      String tmp;            
        for(int i = 0; i < listePartie.size(); i++)
        {
            tmp = listePartie.get(i).getNomPartie();
            if (tmp.compareToIgnoreCase(nomP)==0)
            {
                  listePartie.get(i).pileMache(j); 
                  System.out.println("Le joueur " +j.getNomJoueurs() +" annonce Pile");
            }
            else
            {
                System.out.println("Le pile n'a etait effectué sur aucunne partie");
            }
       }      
  }
        
    
  public void menteurRMI(Joueurs j, String nomP) throws RemoteException {
      
      String tmp;            
        for(int i = 0; i < listePartie.size(); i++)
        {
            tmp = listePartie.get(i).getNomPartie();
            if (tmp.compareToIgnoreCase(nomP)==0)
            {
                  listePartie.get(i).menteur(j);
                  System.out.println("Le joueur " +j.getNomJoueurs() +" annonce Menteur");
            }
            else
            {
                System.out.println("Le menteur n'a etait effectué sur aucune partie");
            }
       }      
  }
  
  public void surchargeRMI(Joueurs j, int valDes,int nbDes, String nomP) throws RemoteException {
      
      String tmp;            
        for(int i = 0; i < listePartie.size(); i++)
        {
            tmp = listePartie.get(i).getNomPartie();
            if (tmp == nomP)
            {
                  listePartie.get(i).surcharge(j, valDes, nbDes); 
                  System.out.println("Le joueur " +j.getNomJoueurs() +" annonce Surcharge de " +valDes + nbDes);
            }
            else
            {
                System.out.println("La surcharge n'a etait effectué sur aucune partie");
            }
       }      
  }
        
    
   public ArrayList<Partie> getListePartie ( ) throws RemoteException
    {
        return listePartie;
    }
  
  
    public int actualiserNbDesRMI (Joueurs j,ClientImplementation b, String nomP)  throws RemoteException 
       {
       String tmp;
       int numP,numJ;
       numP = 0;
       numJ = 0;
        
       //On recherche la liste DES du joueurs 
       
              for(int i = 0; i < listePartie.size(); i++)
        {
            tmp = listePartie.get(i).getNomPartie();
            
            if (tmp.compareToIgnoreCase(nomP) ==0 )
            {
                  for(int x = 0; x < listePartie.get(i).getListeJoueur().size() ; x++ )
                  {
                      tmp= j.getNomJoueurs();
                      if (tmp.compareToIgnoreCase(listePartie.get(i).getListeJoueur().get(x).getNomJoueurs() ) ==0)
                      {
                         numP = i;
                         numJ = x;
                       }
                  }
            }
            else
            {
                System.out.println("ERREUR ACTUALISER DES");
            }
       }   
              

        b.notificationNbDes(listePartie.get(numP).getListeJoueur().get(numJ).getNbDes());
            
       return listePartie.get(numP).getListeJoueur().get(numJ).getNbDes() ;
       
       }
  
  
  
   public ArrayList<int[]> actualiserListeDesRMI (Joueurs j,ClientImplementation b, String nomP)  throws RemoteException 
       {
      
       String tmp, tmp2;
       int numP,numJ;
       numP = 0;
       numJ = 0;
              
       //On recherche la liste DES du joueurs 
       
              for(int i = 0; i < listePartie.size(); i++)
        {
            tmp = listePartie.get(i).getNomPartie();
            
            if (tmp.compareToIgnoreCase(nomP) ==0 ) //si non de partie trouvé
            {
                  for(int x = 0; x < listePartie.get(i).getListeJoueur().size() ; x++ )
                  {
                      tmp2= j.getNomJoueurs();
                      if (tmp2.compareToIgnoreCase(listePartie.get(i).getListeJoueur().get(x).getNomJoueurs() ) ==0)
                      {
                          
                         numP = i;
                         numJ = x;
                                               
                       }
                  }
            }
            else
            {
                System.out.println("ERREUR ACTUALISER DES");
            }
       }   
       
      b.notificationDes(listePartie.get(numP).getListeJoueur().get(numJ).getListeDes());

       return listePartie.get(numP).getListeJoueur().get(numJ).getListeDes() ;
       
       }
   
     
    /*Methode pour sénario*/
   public void attPartie() throws InterruptedException
    {
        while (listePartie.isEmpty())    
        { 
            sleep(2000);
            System.out.println("ATTENTE Partie");
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
            System.out.println("ATTENTE JOUEUR");
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
    
       
  ////
   /// MAIN
  ////
   
     
public static void main(String[] args) throws Exception {
	 	 LocateRegistry.createRegistry(1099);
                 
	 	 Naming.rebind("MonServeur", new MainServeur());
	 	 System.out.println("RMI OK");
                 
          
/*                                         
                 ICI LE CODE SERVEUR       
                                             
*/

int numP = 0; // variable du numero de partie pour la v1 on l'utilisera a 0 par defaut
                // car on n'a qu'une partie
Joueurs j; //le joueur qui est en train de jouer

MainServeur s = new MainServeur();

s.attPartie();
s.attJoueur(numP); // v1 du site on attend que la partie 1 soit compplete

while(s.gagnant(numP) == 0)
    {
     listePartie.get(numP).avantManche();
     listePartie.get(numP).setFinManche(0);
     
         /*LA MANCHE*/ 
               
         while (listePartie.get(numP).getFinManche()== 0) //fin manche tant que la manche est pas fini;
         {
              System.out.println("Début d'une nouvelle Manche");
              
             for (int i = 0; i < listePartie.get(numP).getListeJoueur().size();)   //TOUR DE TABLE 
             {    
                          /*TOUR D'un Joueur */
             listePartie.get(numP).setFinTour(0); // Début d'un nouveau tour 
                
             j = listePartie.get(numP).getListeJoueur().get(i); // on recupere le joueur qui doit jouer
             
             System.out.println("Au joueur :" +j.getNomJoueurs()+" de joueur");
             listePartie.get(numP).lanceDes(j); //lancéé de dés
              // c'est a ce joueur de jouer :
              
                            
                            while (listePartie.get(numP).getFinTour()== 0) //tant que le tour du joueur n'est pas fini   
                            {
                             sleep(5000);
                             System.out.println("A TOI DE JOUER :" + j.getNomJoueurs());
                            }
                 } 
        }
       
         
    } 

/*LE GAGNANT EST :::: */




    
    } //crochet du main

    @Override
    public void actualiserListeDesRMI(Joueurs j, ClientNotification desNotif, String nomP) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualiserNbDesRMI(Joueurs j, ClientNotification desNotif, String nomP) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
 
 
 
 
 }    // crochet de la classe


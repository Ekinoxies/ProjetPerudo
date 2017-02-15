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


    public class ServeurImpl extends UnicastRemoteObject implements Serveur {
    private String nom;
    private Client notif;
    
    HashMap<String, Joueurs> ju;
    HashMap<String, Partie> pa;
     
    private static ArrayList<Partie> listePartie = new ArrayList<Partie>();
    
    public ServeurImpl() throws RemoteException {
    super();
}   
    
     int joueurCourant = 0;
    
    private HashMap<Integer, Client> lesClients = new HashMap<Integer, Client>();
    private static final int maxJoueur = 2;
    
    
    
    @Override
    public boolean aMoiDeJouer (int idJoueur, Joueurs j, String nomP) throws RemoteException
    {
    boolean PartiEncour = listePartie.get(0).getPartieEncours(); 
        
        if ((idJoueur == joueurCourant) && (PartiEncour == true))  
//je suis le joueur concerné et la partie est lancé prendre en compte l'annonce
                  {
                        lesClients.get(joueurCourant).aMoiDeJouerReponse(true);
                    
                                        
			return true;
                            }
    
		else
                    {return false;}
    }  
    
    public void envoiMessage (String aEnvoyer, Joueurs j, String nomP) throws RemoteException
    {
           for(int i = 0; i < listePartie.size(); i++)
        {
             String tmp = listePartie.get(i).getNomPartie();
            if (tmp.compareToIgnoreCase(nomP)==0)
            {
                               
                for(int x = 0; x < listePartie.get(i).getListeJoueur().size(); x++)
                {
                    String tmp2 = listePartie.get(i).getListeJoueur().get(x).getNomJoueurs();
                      
                    if (tmp2.compareToIgnoreCase(j.getNomJoueurs())==0)
                       {
                          lesClients.get(x).alerte(aEnvoyer);
                       }
                   

                }
            }
        }
    }
    
    @Override
	public boolean transmettreAnnonce(int idJoueur) throws RemoteException {
		if (idJoueur == joueurCourant ) {
			// prendre en compte l'annonce
			
			// passer au joueur suivant
			joueurCourant++;
                          if (joueurCourant ==maxJoueur)
                             {
                                joueurCourant = 0;
                                        
                    
                                        }
			return true;
		} else
			return false;
	}
        
    @Override
	public int enregistrerClient(Client c) throws RemoteException {
		int idJoueur = joueurCourant;
                lesClients.put(joueurCourant, c);
		
		
		// passer au joueur suivant
		joueurCourant++;
		if (joueurCourant == maxJoueur) {
			joueurCourant = 0;
			// le prévenir
		       
			lesClients.get(joueurCourant).alerte("////////////////////////");
                        lesClients.get(joueurCourant).alerte("//C'est à toi de jouer//");
                        lesClients.get(joueurCourant).alerte("////////////////////////");
                        lesClients.get(joueurCourant).aMoiDeJouerReponse(true);
                        
                   
                        
		}
			
		return idJoueur;
		
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
                    System.out.println("Le Joueur " +a.getNomJoueurs()+ " est ajouté a la partie " + nomP );
                    
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
      String tmp2;
      int nb =0;
        for(int i = 0; i < listePartie.size(); i++)
        {
            tmp = listePartie.get(i).getNomPartie();
            if (tmp.compareToIgnoreCase(nomP)==0)
            {
                boolean nbDes = listePartie.get(i).pileMache(j); 
                // on ajoute les des pour cela on va rechercher le bon joueur
                
                for(int x = 0; x < listePartie.get(i).getListeJoueur().size(); x++)
                {
                    tmp2 = listePartie.get(i).getListeJoueur().get(x).getNomJoueurs();
                      
                    if (tmp2.compareToIgnoreCase(j.getNomJoueurs())==0)
                       {
                           if (nbDes)
                           {
                               nb = listePartie.get(i).getListeJoueur().get(x).getNbDes();
                               nb=nb+1;
                               listePartie.get(i).getListeJoueur().get(x).setNbDes(nb);
                           }
                           else
                           {
                               nb = listePartie.get(i).getListeJoueur().get(x).getNbDes();
                               nb=nb-1;
                               listePartie.get(i).getListeJoueur().get(x).setNbDes(nb);
                           }
                       }
                    else
                    {
                        
                    
                    }
                
                
                
                }
                
                
                
                
                
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
      String tmp2;
      int nb =0;
        for(int i = 0; i < listePartie.size(); i++)
        {
            tmp = listePartie.get(i).getNomPartie();
            if (tmp.compareToIgnoreCase(nomP)==0)
            {
                boolean nbDes = listePartie.get(i).menteur(j); 
                // on ajoute les des pour cela on va rechercher le bon joueur
                
                for(int x = 0; x < listePartie.get(i).getListeJoueur().size(); x++)
                {
                    tmp2 = listePartie.get(i).getListeJoueur().get(x).getNomJoueurs();
                      
                    if (tmp2.compareToIgnoreCase(j.getNomJoueurs())==0)
                       {
                           if (nbDes)
                           {
                               nb = listePartie.get(i).getListeJoueur().get(x).getNbDes();
                               nb=nb+1;
                               listePartie.get(i).getListeJoueur().get(x).setNbDes(nb);
                           }
                           else
                           {
                               nb = listePartie.get(i).getListeJoueur().get(x).getNbDes();
                               nb=nb-1;
                               listePartie.get(i).getListeJoueur().get(x).setNbDes(nb);
                           }
                       }
                    else
                    {
                        
                    
                    }
                
                
                
                }
                
                
                
                
                
                System.out.println("Le joueur " +j.getNomJoueurs() +" annonce Menteur");
            }
            else
            {
                System.out.println("Le menteur n'a etait effectué sur aucunne partie");
            }
       }      
  }
  
  public void surchargeRMI(Joueurs j, int valDes,int nbDes, String nomP) throws RemoteException {
      
      String tmp;            
        for(int i = 0; i < listePartie.size(); i++)
        {
            tmp = listePartie.get(i).getNomPartie();
            if (tmp.compareToIgnoreCase(nomP)==0)
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
        
    
   public ArrayList<Partie> getListePartie () throws RemoteException
    {
        return listePartie;
    }
  
  
    public int actualiserNbDesRMI (Joueurs j,ClientImpl b, String nomP)  throws RemoteException 
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
  
  
     public ArrayList actualiserListeDesRMI (Joueurs j,ClientImpl b, String nomP)  throws RemoteException 
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
   listePartie.get(nb).setPartieEncours(true); //on déclare la partie en cours 
    
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
                 
	 	 Naming.rebind("MonServeur", new ServeurImpl());
	 	 System.out.println("RMI OK");
                 
          
/*                                         
                 ICI LE CODE SERVEUR       
                                             
*/

int numP = 0; // variable du numero de partie pour la v1 on l'utilisera a 0 par defaut
                // car on n'a qu'une partie
Joueurs j; //le joueur qui est en train de jouer

ServeurImpl s = new ServeurImpl();

s.attPartie();
s.attJoueur(numP); // v1 du site on attend que la partie 1 soit compplete

while(s.gagnant(numP) == 0)
    {
     listePartie.get(numP).avantManche();
     listePartie.get(numP).setFinManche(0);
     
         /*LA MANCHE*/ 
             System.out.println("//////////////////////////////");
             System.out.println("Début d'une nouvelle Manche");
             System.out.println("//////////////////////////////");
             System.out.println("");
             System.out.println("");
             for (int i = 0; i < listePartie.get(numP).getListeJoueur().size(); i++)   //TOUR DE TABLE 
             { 
             j = listePartie.get(numP).getListeJoueur().get(i);
             listePartie.get(numP).lanceDes(j); //lancéé de dés
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

/*LE GAGNANT EST :::: */




    
    } //crochet du main




@Override
public int actualiserNbDesRMI(Joueurs j, Client desNotif, String nomP) throws RemoteException {
	// TODO Auto-generated method stub
	return 0;
}

    @Override
    public ArrayList actualiserListeDesRMI(Joueurs j, Client desNotif, String nomP) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}    // crochet de la classe

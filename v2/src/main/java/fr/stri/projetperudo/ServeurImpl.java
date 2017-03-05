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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServeurImpl extends UnicastRemoteObject implements Serveur {
    private String nom;
    private Client notif;
    HashMap<String, Joueurs> ju;
    HashMap<String, Partie> pa;  
    static String desEnv; // a synchroniser
    
   
   public static ArrayList<Partie> listePartie = new ArrayList<Partie>();
    int joueurCourant = 0;
    private HashMap<Integer, Client> lesClients = new HashMap<Integer, Client>();
    private static final int maxJoueur = 2;
    int numP =0;
    
    public static ArrayList<SenarioThread> listeThread = new ArrayList<SenarioThread>();
    
    
    /*Constructeur*/
    public ServeurImpl() throws RemoteException 
    {
        super();
    }   
   
 
    
    
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
    
    @Override //fait changer de joueur
	public boolean transmettreAnnonce(int idJoueur) throws RemoteException {
		if (idJoueur == joueurCourant ) {
			// On annonce au joueur qu'il a finis sont tour
                        lesClients.get(joueurCourant).alerte(" ");
                        lesClients.get(joueurCourant).alerte(" ");
               	      lesClients.get(joueurCourant).alerte("////////////////////////");
                        lesClients.get(joueurCourant).alerte("//Tu as finis ton tour//");
                        lesClients.get(joueurCourant).alerte("////////////////////////");                    
                        lesClients.get(joueurCourant).alerte(" ");
                        

                       
			// passer au joueur suivant
			joueurCourant++;
                          if (joueurCourant ==maxJoueur)
                             {
                                joueurCourant = 0;
                                        
                    
                              }
                          
                          //ANNONCE DE DEBUT DE TOUR
            lesClients.get(joueurCourant).alerte("");          
            lesClients.get(joueurCourant).alerte("Heeee ... , tu peux jouer je crois");
                          return true;
                        
		} 
                else
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
			lesClients.get(joueurCourant).alerte("Tu es enregistré dans la partie");
                       lesClients.get(joueurCourant).aMoiDeJouerReponse(true);

		}
                // Bienvenue dans la partie
      //          
                //lesClients.get(joueurCourant).aMoiDeJouerReponse(true);
			
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
        
        listeThread.add(new SenarioThread(listePartie.size()-1)); // Création du thread
         
        return "La Partie a bien était créer ";
    }

    public static void setDesEnv (String messEnv) {
        ServeurImpl.desEnv = messEnv;
    }
    
              
   
   /*Methode suplementaire pour le rmi*/
    
    @Override
  public String getNomPartieRMI(int nb) throws RemoteException{
        
            String nomPartie;
            
            nomPartie=listePartie.get(nb).getNomPartie();
            
            return nomPartie;  // retourne  a nimporte quel client directement 
    }
       
    @Override
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
                               envoiMessage("Bien vue tu gagne un Des", j, nomP);
                           }
                           else
                           {
                               nb = listePartie.get(i).getListeJoueur().get(x).getNbDes();
                               nb=nb-1;
                               listePartie.get(i).getListeJoueur().get(x).setNbDes(nb);
                               envoiMessage("Tu a perdu un Des, hummm ", j, nomP);
                       
                              //////On se demande si il nous reste des DES //////////////////
                               if (listePartie.get(i).getListeJoueur().get(x).getListeDes().isEmpty() )
                               {
                                        envoiMessage("Tu a perdu !!!!", j, nomP);
                                        listePartie.get(numP).getListeJoueur().remove(i);
                                        
                                }
                               
                           //////////////////////////////////////////////////////////////////////////////
                           }
                       }
                    else
                    {
                         // ce else est trés util 
                    }
                
                }
                                                       
               //System.out.println("Le joueur " +j.getNomJoueurs() +" annonce Pile");
               // envoiMessage("PILE VALIDE", j, nomP);
            }
            else
            {
                System.out.println("Le pile n'a etait effectué sur aucunne partie");
            }
       }         
  }
        
    
    @Override
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
                               envoiMessage("Bien vue tu gagne un Des", j, nomP);
                           }
                           else
                           {
                               nb = listePartie.get(i).getListeJoueur().get(x).getNbDes();
                               nb=nb-1;
                               listePartie.get(i).getListeJoueur().get(x).setNbDes(nb);
                               envoiMessage("Tu a perdu un Des, hummm ", j, nomP);
        
                               
                          //////On se demande si il nous reste des DES //////////////////
                               if (listePartie.get(i).getListeJoueur().get(x).getListeDes().isEmpty() )
                               {
                                        
                                        listePartie.get(numP).getListeJoueur().remove(i);
                                        envoiMessage("Tu a perdu !!!!", j, nomP);
                                }
                               
                           //////////////////////////////////////////////////////////////////////////////
                           }
                       }
                    else
                    {
                        
                    
                    }
                
                
                
                }
                
           }
            else
            {
                System.out.println("Le menteur n'a etait effectué sur aucunne partie");
            }
       }      
  }
  
    @Override
  public void surchargeRMI(Joueurs j, int valDes,int nbDes, String nomP) throws RemoteException {
      
      String tmp;            
        for(int i = 0; i < listePartie.size(); i++)
        {
            tmp = listePartie.get(i).getNomPartie();
            if (tmp.compareToIgnoreCase(nomP)==0)
            {
                  listePartie.get(i).surcharge(j, valDes, nbDes); 
                  //System.out.println("Le joueur " +j.getNomJoueurs() +" annonce Surcharge de " +valDes + nbDes);
                  envoiMessage("Ok c'est noté !!! ", j, nomP);
            }
            else
            {
                System.out.println("La surcharge n'a etait effectué sur aucune partie");
            }
       }      
  }
        
  
  
    @Override
  public void desRMI(Joueurs j, String nomP) throws RemoteException 
  {
      String tmp; 
      String tmp2;
      int nb =0;
        for(int i = 0; i < listePartie.size(); i++)
        {
       tmp = listePartie.get(i).getNomPartie();
            System.out.println("TMP : "+ tmp);
            if (tmp.compareToIgnoreCase(nomP)==0)
            {
                                
                for(int x = 0; x < listePartie.get(i).getListeJoueur().size(); x++)
                {
                    tmp2 = listePartie.get(i).getListeJoueur().get(x).getNomJoueurs();
                       System.out.println("/////TMP 2 : "+ tmp2);
                    if (tmp2.compareToIgnoreCase(j.getNomJoueurs())==0)
                       {
                           
                            System.out.println("i x: "+ i +x);
                           
                        try {
                            ///////*/////////////////////////////////////////////*//////////
                            /*DESRMI est la premiere methode apeller par le RMi client a chaque neveau tour,
                            notre programme yan un temps de réponse de 2 sec
                            on utilise un temprisateur de 3sec afin d'eviter de "jouer trop vite" */
                            
                            sleep(3000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ServeurImpl.class.getName()).log(Level.SEVERE, null, ex);
                        }
                           
                           ///////////////////////////////////////////////////////////////////
                           ////////////////////l'etat de la partie
                           int miseval = listePartie.get(i).getDesValeur();
                           int nbmis = listePartie.get(i).getNbVdes();
                           String envvv = "L'état actuel de la mise est de : " + nbmis +" de valeur " + miseval;
                           envoiMessage(envvv, j, nomP);
                           ////////////////////LES DES///
                           String DesEnv = listePartie.get(i).getListeJoueur().get(x).getListeDes().toString() ;
                           System.out.println("fr.stri.projetperudo.ServeurImpl.desRMI() " + DesEnv);
                           String tmpenvv = "Tu as : "+listePartie.get(i).getListeJoueur().get(x).getNbDes() +" Des" ;
                           envoiMessage(tmpenvv, j, nomP);
                           envoiMessage(DesEnv, j, nomP);
                           ///////*/////////////////////////////////////////////*//////////
                       }
                }
            }
        }
      
  }
  
  
    
    @Override
   public ArrayList<Partie> getListePartie () throws RemoteException
    {
        return listePartie;
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
             //ENVOI LA GAGNANT EST AVEC RMI INVERSE
         }
   return val;
   }   
            
  ////////////////////////////
  //// /// MAIN///////////////
  //// ////////////////////
     
public static void main(String[] args) throws Exception {
	 	 LocateRegistry.createRegistry(1099);
                 
	 	 Naming.rebind("MonServeur", new ServeurImpl());
	 	 System.out.println("RMI OK");
                 
          
/*                                         
                 ICI LE CODE SERVEUR       
                                             
*/

 ServeurImpl s = new ServeurImpl ();
s.attPartie();

int a = 1;
while(listePartie.size() != 0)  
{
    
    
    
    for (int i=0;i<=listeThread.size()-1;i++)    
    {
         if (listeThread.get(i).isAlive())
         {
             //System.out.println("La partie "+listePartie.get(i).getNomPartie()+" est en cours" );
         }
    else
         {
            listeThread.get(i).start();
         }
    }
    
    
    

}
    System.out.println("TOUTES LES PARTIES DONT FINIS");


} //crochet du main


}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.stri.projetperudo;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import fr.stri.projetperudo.Client;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author florian b
 */
public class ClientImpl  extends UnicastRemoteObject implements Client  {
 
    static Boolean amoidejouer;
    static int miseFace; //la face du dés misé
    static int miseNb; // le nombre de face du dé misé annoncé
  
   

protected ClientImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

@Override
   public void notificationNbDes(int nbDes) throws RemoteException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

@Override
   public void notificationDes(ArrayList listeDes) throws RemoteException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
   }

@Override
public void alerte(String s) throws RemoteException {
		System.out.println(s);
	}
   
@Override
public void aMoiDeJouerReponse(boolean bo) throws RemoteException {
	if (bo ==true)
        {amoidejouer =true;}
  
      System.out.println(amoidejouer);
	}



        public String choixP(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Entrez nom Partie");
            String NomPartie = sc.nextLine();
            return NomPartie;
        }
             
     
        
        public int choixAction ()
                {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Entrez l'action a réaliser");
                    System.out.println("1 pour pile");
                    System.out.println("2 pour menteur");
                    System.out.println("3 pour Surcharge");
                    int action = sc.nextInt();
                    return action;
                }
        
        public int nbJoueur(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Entrez le nombre de Joueur");
            int NbJoueur= sc.nextInt();
            return NbJoueur;
        }
        
        public void surcharge()
        {
            
               
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Quelle face choisi tu ?");
                    miseFace = sc.nextInt();
                    System.out.println("Quelle nombre de dés de la face : " + miseFace);
                    miseNb = sc.nextInt();
        
            
        }
        
   
   public static void main(String[] args) throws NotBoundException, RemoteException, MalformedURLException {
       ClientImpl c = new ClientImpl();
       Serveur proxy = (Serveur) Naming.lookup("rmi://localhost:1099/MonServeur");
       Scanner sc = new Scanner(System.in);
       int nbJ = 0;
       // Récuperation du Joueur
       System.out.println("Entrez nom Joueur");
       String NomJoueur = sc.nextLine();
       Joueurs validejoueur = new Joueurs(NomJoueur);
       Joueurs envoijoueur;
       envoijoueur = validejoueur;
       
       System.out.println("Voulez vous Créer une partie ? si oui tapez oui sinon tapez non");
       String RepPartie = sc.nextLine();
       
       switch (RepPartie) {
       case "oui": 
        String partie = c.choixP();
        nbJ =c.nbJoueur();
            
            System.out.println(proxy.creerPartie(partie,nbJ));
       break;
       
       case "non": 
          System.out.println("Vous allez devoir rejoindre une partie"); 
       break;
        
        default:
            System.out.println("Erreur Saisie"); 
       }
       

          System.out.println("Entrez la partie à rejoindre"); 
          String NomPartieRE = sc.nextLine();
          System.out.println(proxy.connexionAunePartie(envoijoueur, NomPartieRE));
       
          
 // l'Enregistrement 
int idJoueur = proxy.enregistrerClient(c);
System.out.println(idJoueur);


boolean fin = false; // initialisation fin de partie

while (fin != true)
    {
       amoidejouer = false;// par defaut ce n'est pas a moi de jouer
       
        proxy.aMoiDeJouer(idJoueur,envoijoueur,NomPartieRE); // je demande au serveur si je doit jouer
        
                    if (amoidejouer) // c'est a moi de jouer ?
                        {
                            // On joue
				System.out.println("Annonce bien prise en compte");
                                System.out.println("/////////////////");
                                // vos des sont
                               
                               int choix = c.choixAction(); 
                               switch (choix)
                               {
                                    case 1: //PILE
                                    {
                                    proxy.pilRMI(envoijoueur, NomPartieRE);
                                    System.out.println("Tu as dit pil quel courage");
                                    }
                                    case 2: //MENTEUR
                                    {
                                    proxy.menteurRMI(envoijoueur, NomPartieRE);
                                    System.out.println("Menteur ... ok on va voir");
                                    }
                                    
                                    case 3: //Surcharge
                                    {
                                          c.surcharge();
                                          proxy.surchargeRMI(envoijoueur, miseFace, miseNb,NomPartieRE);
                                    }   
                                }
                         }
                                
                    else
                        {
				// on fait rien c'est pas notre tour                                               
                        }
         
                                
    }                                          
       
   }
   }


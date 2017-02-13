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
   
   
        public String choixP(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Entrez nom Partie");
            String NomPartie = sc.nextLine();
            return NomPartie;
        }
                
 
        public int nbJoueur(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Entrez le nombre de Joueur");
            int NbJoueur= sc.nextInt();
            return NbJoueur;
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
       
          
 // le grand test    
     int idJoueur = proxy.enregistrerClient(c);
System.out.println(idJoueur);
			if (!proxy.transmettreAnnonce(idJoueur))
				System.out.println("Ce n'est pas à toi de jouer");
			else
				System.out.println("Annonce bien prise en compte");
      
       
   }
   }


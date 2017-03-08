/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.stri.projetperudo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import fr.stri.projetperudo.Client;
import static java.lang.Thread.sleep;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.Scanner;

/**
 *
 * @author florian b
 */
public class ClientImpl extends UnicastRemoteObject implements Client {

    static Boolean amoidejouer; // BOOlean qui renvoi vrai quand c'est a notre joueur de jouer 
    static int miseFace; //la face du dés misé
    static int miseNb; // le nombre de face du dé misé annoncé
    static int nbDes;
    ArrayList listeDes;

    protected ClientImpl() throws RemoteException {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void alerte(String s) throws RemoteException {
        System.out.println(s);
    }

    @Override
    public void aMoiDeJouerReponse(boolean bo) throws RemoteException {
        if (bo == true) {
            amoidejouer = true;
        }
    }

    public String choixP() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez nom Partie");
        String NomPartie = sc.nextLine();
        return NomPartie;
    }

    public int choixAction() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez l'action à réaliser");
        System.out.println("1 pour pile");
        System.out.println("2 pour menteur");
        System.out.println("3 pour surcharge");
        int action = sc.nextInt();
        return action;
    }

    public int nbJoueur() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez le nombre de joueurs");
        int NbJoueur = sc.nextInt();
        return NbJoueur;
    }

    public void surcharge() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quelle face choisis-tu ?");
        miseFace = sc.nextInt();
        System.out.println("Quel nombre de dés de la face : " + miseFace);
        miseNb = sc.nextInt();
    }

///////////////////////////////////////////////////////////////////////////
////////////////////MAIN /////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) throws NotBoundException, RemoteException, MalformedURLException, InterruptedException {
        ClientImpl c = new ClientImpl();
        Serveur proxy = (Serveur) Naming.lookup("rmi://localhost:1099/MonServeur");
        Scanner sc = new Scanner(System.in);
        int nbJ = 0;
        // Récuperation du Joueur
        System.out.println("Quel est votre nom ?");
        String NomJoueur = sc.nextLine();
        Joueurs validejoueur = new Joueurs(NomJoueur);
        Joueurs envoijoueur;
        envoijoueur = validejoueur;
        System.out.println("");
        System.out.println("");
        System.out.println("/////////////////////////////");
        System.out.println("BIENVENU AU JEU DU PERUDO " + envoijoueur.getNomJoueurs());
        System.out.println("/////////////////////////////");
        System.out.println("");
        System.out.println("TAPER 1 pour créer une partie");
        System.out.println("TAPER 2 pour rejoindre une partie");
        String RepPartie = sc.nextLine();

        switch (RepPartie) {
            case "1":
                String partie = c.choixP();
                nbJ = c.nbJoueur();

                System.out.println(proxy.creerPartie(partie, nbJ));
                break;

            case "2":
                System.out.println("Vous allez rejoindre une partie");
                break;

            default:
                System.out.println("Erreur Saisie");
        }

        System.out.println("Entrez la partie à rejoindre");
        String NomPartieRE = sc.nextLine();
        System.out.println(proxy.connexionAunePartie(envoijoueur, NomPartieRE));

        // l'Enregistrement 
        int idJoueur = proxy.enregistrerClient(c, NomPartieRE);
//System.out.println(idJoueur);

        boolean fin = false; // initialisation fin de partie

        while (fin != true) {
            amoidejouer = false;// par defaut ce n'est pas a moi de jouer

            proxy.aMoiDeJouer(idJoueur, envoijoueur, NomPartieRE); // je demande au serveur si je doit jouer

            if (amoidejouer) // c'est a moi de jouer ?
            {
                sleep(1000); // On attend que les DES soit disctribué
                proxy.desRMI(envoijoueur, NomPartieRE);

                int choix = c.choixAction();
                switch (choix) {
                    case 1: //PILE
                    {
                        proxy.pilRMI(envoijoueur, NomPartieRE);
                        //System.out.println("Tu as dit pile, quel courage !");
                        break;
                    }
                    case 2: //MENTEUR
                    {
                        proxy.menteurRMI(envoijoueur, NomPartieRE);
                        //System.out.println("Menteur ... ok on va voir");
                        break;
                    }

                    case 3: //Surcharge
                    {
                        c.surcharge();
                        proxy.surchargeRMI(envoijoueur, miseFace, miseNb, NomPartieRE);
                        break;
                    }
                    default:
                        System.out.println("Erreur Saisie");
                }

                System.out.println(proxy.transmettreAnnonce(idJoueur, NomPartieRE));  // On change de joueur   
            } else {
                // on fait rien c'est pas notre tour                                               
            }

        }     // Crochet du While                                     

    }// Crochet du main 

} // Corchet de la class


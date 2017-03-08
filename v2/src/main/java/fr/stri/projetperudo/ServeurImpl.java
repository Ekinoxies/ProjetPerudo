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
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServeurImpl extends UnicastRemoteObject implements Serveur {

    private String nom;
    private Client notif;
    HashMap<String, Joueurs> ju;
    HashMap<String, Partie> pa;
    static String desEnv; // a synchroniser
    public static ArrayList<Partie> listePartie = new ArrayList<Partie>();
    //la variable liste partie etant utilisé sur plusieur thread toute methode qui la modifie sera donc synchronisé
    private static final int maxJoueur = 2;
    public static ArrayList<SenarioThread> listeThread = new ArrayList<SenarioThread>();

    
    /*Constructeur*/
    public ServeurImpl() throws RemoteException {
        super();
    }

    //Permet d'indiquer si le joueur qui appelle la methode doit jouer
    @Override
    public synchronized boolean aMoiDeJouer(int idJoueur, Joueurs j, String nomP) throws RemoteException {
        boolean retour = false;
        for (int i = 0; i < listePartie.size(); i++) {
            String tmp = listePartie.get(i).getNomPartie();
            if (tmp.compareToIgnoreCase(nomP) == 0) {

                boolean PartiEncour = listePartie.get(i).getPartieEncours();
                int jc = listePartie.get(i).getJoueurCourant();
                if ((idJoueur == jc) && (PartiEncour == true)) //je suis le joueur concerné et la partie est lancée prendre en compte l'annonce
                {
                    HashMap<Integer, Client> lesClients = listePartie.get(i).getLesClients();
                    lesClients.get(jc).aMoiDeJouerReponse(true);

                    retour = true;
                }

            }
        }
        return retour;
    }

    //Methode pour simplifier l'envoi de message au client conserné via RMI
    public synchronized void envoiMessage(String aEnvoyer, Joueurs j, String nomP) throws RemoteException {
        for (int i = 0; i < listePartie.size(); i++) {
            String tmp = listePartie.get(i).getNomPartie();
            if (tmp.compareToIgnoreCase(nomP) == 0) {

                for (int x = 0; x < listePartie.get(i).getListeJoueur().size(); x++) {
                    String tmp2 = listePartie.get(i).getListeJoueur().get(x).getNomJoueurs();

                    if (tmp2.compareToIgnoreCase(j.getNomJoueurs()) == 0) {
                        HashMap<Integer, Client> lesClients = listePartie.get(i).getLesClients();
                        lesClients.get(x).alerte(aEnvoyer);
                    }

                }
            }
        }
    }

    //Permet de changer de Joueur
    @Override 
    public synchronized boolean transmettreAnnonce(int idJoueur, String nomP) throws RemoteException {
        //
        boolean etat = false;
        for (int i = 0; i < listePartie.size(); i++) {
            String tmp = listePartie.get(i).getNomPartie();
            if (tmp.compareToIgnoreCase(nomP) == 0) {

                System.err.println("PARTIE TROUVER");
                //jc corespond au joueur qui doit jouer le joueur courant
                int jc = listePartie.get(i).getJoueurCourant();

                System.out.println(".transmettreAnnonce JC " + jc);
                System.out.println("transmettreAnnonce IfJ " + idJoueur);

                if (idJoueur == jc) {
                    // On annonce au joueur qu'il a finis son tour
                    HashMap<Integer, Client> lesClients = listePartie.get(i).getLesClients();
                    System.out.println("fr.stri.projetperudo.ServeurImpl.transmettreAnnonce JC " + jc);
                    lesClients.get(jc).alerte("////////////////////////");
                    lesClients.get(jc).alerte("//Tu as finis ton tour//");
                    lesClients.get(jc).alerte(" ");
                    lesClients.get(jc).alerte("Attente des adversaires");
                    lesClients.get(jc).alerte(" ");

                    // passer au joueur suivant
                    jc++;

                    if (jc == maxJoueur) {

                        jc = 0;

                    }
                   
                    listePartie.get(i).setJoueurCourant(jc);

                    //ANNONCE DE DEBUT DE TOUR
                    lesClients.get(jc).alerte(" ");
                    lesClients.get(jc).alerte("//////////////////////////////////");
                    lesClients.get(jc).alerte("Heeee ... , tu peux jouer je crois");
                    lesClients.get(jc).alerte(" ");
                    etat = true;

                }
                etat = false;
            } else {
                System.err.println("PARTIE PAS TROUVEE");
            }

        }
        return etat;
    }

    //Permet d'enregistrer le client/joueur dans la ListePartie
    @Override
    public int enregistrerClient(Client c, String nomP) throws RemoteException {

        int jc = 99;
        for (int i = 0; i < listePartie.size(); i++) {

            String tmp = listePartie.get(i).getNomPartie();
            if (tmp.compareToIgnoreCase(nomP) == 0) {
                jc = listePartie.get(i).getJoueurCourant();

                jc++;

                HashMap<Integer, Client> lesClients = listePartie.get(i).getLesClients();
                lesClients.put(jc, c);
                listePartie.get(i).setLesClients(lesClients);

                listePartie.get(i).setJoueurCourant(jc);
            }

        }

        return jc;
    }

    /*Ajouter un joueur dans la listejoueur d'une partie*/
    @Override
    public synchronized String connexionAunePartie(Joueurs a, String nomP) throws RemoteException {
        String tmp;
        String retour = " ERREUR Joueur non ajouté";

        for (int i = 0; i < listePartie.size(); i++) {

            tmp = listePartie.get(i).getNomPartie();

            if (tmp.compareToIgnoreCase(nomP) == 0) {

                listePartie.get(i).ajoutJoueur(a);
                System.out.println("Le Joueur " + a.getNomJoueurs() + " est ajouté a la partie " + nomP);

                retour = "Le joueur est ajouté ";
            }
        }

        return retour;
    }

    /*Methode Creer partie*/
    public synchronized String creerPartie(String nomPartie, Integer nbJoueurs) throws RemoteException {
        Partie a = new Partie(nomPartie, nbJoueurs);
        listePartie.add(a);
        System.out.println("La partie :" + nomPartie + " a ete créé avec un nombre de joueur de : " + nbJoueurs);

        listeThread.add(new SenarioThread(listePartie.size() - 1)); // Création du thread

        return "La Partie a bien été créé ";
    }

    public static void setDesEnv(String messEnv) {
        ServeurImpl.desEnv = messEnv;
    }

    /*Methode suplementaire pour le rmi*/
    @Override
    public synchronized String getNomPartieRMI(int nb) throws RemoteException {

        String nomPartie;

        nomPartie = listePartie.get(nb).getNomPartie();

        return nomPartie;  // retourne  a nimporte quel client directement 
    }

    @Override
    public synchronized void pilRMI(Joueurs j, String nomP) throws RemoteException {

        String tmp;
        String tmp2;
        int nb = 0;
        for (int i = 0; i < listePartie.size(); i++) {
            tmp = listePartie.get(i).getNomPartie();
            if (tmp.compareToIgnoreCase(nomP) == 0) {
                boolean nbDes = listePartie.get(i).pileMache(j); //On réalise la pil Manche
               
                 // on ajoute les des pour cela on va rechercher le bon joueur
                for (int x = 0; x < listePartie.get(i).getListeJoueur().size(); x++) {
                    tmp2 = listePartie.get(i).getListeJoueur().get(x).getNomJoueurs();

                    if (tmp2.compareToIgnoreCase(j.getNomJoueurs()) == 0) {
                        if (nbDes == true) 
                        {
                            nb = listePartie.get(i).getListeJoueur().get(x).getNbDes();
                            nb = nb + 1;
                            listePartie.get(i).getListeJoueur().get(x).setNbDes(nb);
                            envoiMessage("Bien vu tu gagnes un Des", j, nomP);

                            //////////////////Mise en memoire du message a affiché en fin de partie
                            String tmpMess = "Le joueur " + j.getNomJoueurs() + " a eu raison de dire pile, il gagne un des";
                            listePartie.get(i).setMessgae(tmpMess);
                        } 
                        else {
                            nb = listePartie.get(i).getListeJoueur().get(x).getNbDes();
                            nb = nb - 1;
                            listePartie.get(i).getListeJoueur().get(x).setNbDes(nb);
                            envoiMessage("Tu as perdu un Des, hummm ", j, nomP);

                            //////////////////Mise en memoire du message a affiché en fin de partie
                            String tmpMess = "Le joueur " + j.getNomJoueurs() + " a eu tort  de dire pile, il perd un des";
                            listePartie.get(i).setMessgae(tmpMess);

                            //////On ce demande si il nous reste des DES //////////////////
                            if (listePartie.get(i).getListeJoueur().get(x).getListeDes().isEmpty()) {
                                envoiMessage("Tu as perdu !!!!", j, nomP);
                                listePartie.get(i).getListeJoueur().remove(x);

                            }

                            //////////////////////////////////////////////////////////////////////////////
                        }
                    } else {
                        System.out.println("Le Joueur n'a pas était trouvé");
                    }

                }

            } else {
                System.out.println("Le pile n'a ete effectué sur aucune partie");
            }
        }
    }

    @Override
    public synchronized void menteurRMI(Joueurs j, String nomP) throws RemoteException {

        String tmp;
        String tmp2;
        int nb = 0;
        for (int i = 0; i < listePartie.size(); i++) {
            tmp = listePartie.get(i).getNomPartie();
            if (tmp.compareToIgnoreCase(nomP) == 0) {
                boolean nbDes = listePartie.get(i).menteur(j);
                // on ajoute les des pour cela on va rechercher le bon joueur

                for (int x = 0; x < listePartie.get(i).getListeJoueur().size(); x++) {
                    tmp2 = listePartie.get(i).getListeJoueur().get(x).getNomJoueurs();

                    if (tmp2.compareToIgnoreCase(j.getNomJoueurs()) == 0) {
                        if (nbDes == true) {
                            nb = listePartie.get(i).getListeJoueur().get(x).getNbDes();
                            nb = nb + 1;
                            listePartie.get(i).getListeJoueur().get(x).setNbDes(nb);
                            envoiMessage("Bien vu tu gagnes un Des", j, nomP);

                            //////////////////Mise en memoire du message a affiché en fin de partie
                            String tmpMess = "Le joueur " + j.getNomJoueurs() + " a eu raison de dire menteur, il gagne un des";
                            listePartie.get(i).setMessgae(tmpMess);
                        } else {
                            nb = listePartie.get(i).getListeJoueur().get(x).getNbDes();
                            nb = nb - 1;
                            listePartie.get(i).getListeJoueur().get(x).setNbDes(nb);
                            envoiMessage("Tu as perdu un Des, hummm ", j, nomP);

                            //////////////////Mise en memoire du message a affiché en fin de partie
                            String tmpMess = "Le joueur " + j.getNomJoueurs() + " a eu tort de dire menteur, il perd un des";
                            listePartie.get(i).setMessgae(tmpMess);

                            //////On se demande si il nous reste des DES //////////////////
                            if (listePartie.get(i).getListeJoueur().get(x).getListeDes().isEmpty()) {
                                envoiMessage("Tu as perdu !!!!", j, nomP);
                                listePartie.get(i).getListeJoueur().remove(x);

                            }

                            //////////////////////////////////////////////////////////////////////////////
                        }
                    } else {
                        System.out.println("Le joueur n'a pas était trouvé");

                    }

                }

            } else {
                System.out.println("Le menteur n'a ete effectué sur aucune partie");
            }
        }
    }

    @Override
    public synchronized void surchargeRMI(Joueurs j, int valDes, int nbDes, String nomP) throws RemoteException {

        String tmp;
        for (int i = 0; i < listePartie.size(); i++) {
            tmp = listePartie.get(i).getNomPartie();
            if (tmp.compareToIgnoreCase(nomP) == 0) {
                listePartie.get(i).surcharge(j, valDes, nbDes);
                //System.out.println("Le joueur " +j.getNomJoueurs() +" annonce Surcharge de " +valDes + nbDes);
                envoiMessage("Ok c'est noté !!! ", j, nomP);

                //////////////////Mise en memoire du message a affiché en fin de parti
                listePartie.get(i).setMessgae(" "); // On a rien a dire donc on dit rien 
            } else {
                System.out.println("La surcharge n'a ete effectué sur aucune partie");
            }
        }
    }

    @Override
    public synchronized void desRMI(Joueurs j, String nomP) throws RemoteException {
        String tmp;
        String tmp2;
        int nb = 0;
        for (int i = 0; i < listePartie.size(); i++) {
            tmp = listePartie.get(i).getNomPartie();
            
            if (tmp.compareToIgnoreCase(nomP) == 0) {

                for (int x = 0; x < listePartie.get(i).getListeJoueur().size(); x++) {
                    tmp2 = listePartie.get(i).getListeJoueur().get(x).getNomJoueurs();
                    
                    if (tmp2.compareToIgnoreCase(j.getNomJoueurs()) == 0) {

                       try {
                            ///////*/////////////////////////////////////////////*//////////
                            /*DESRMI est la premiere methode apeller par le RMi client a chaque nouveau tour,
                            notre programme a un temps de réponse de 2 sec
                            on utilise un temporisateur de 3sec afin d'eviter de "jouer trop vite" */
                            sleep(3000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ServeurImpl.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        ///////////////////////////////////////////////////////////////////
                        ////////////////////l'etat de la partie
                        envoiMessage(listePartie.get(i).getMessgae(), j, nomP);
                        envoiMessage(" ", j, nomP);
                        int miseval = listePartie.get(i).getDesValeur();
                        int nbmis = listePartie.get(i).getNbVdes();
                        String envvv = "L'état actuel de la mise est de : " + nbmis + " de valeur " + miseval;
                        envoiMessage(envvv, j, nomP);
                        ////////////////////LES DES///
                        String DesEnv = listePartie.get(i).getListeJoueur().get(x).getListeDes().toString();
                        System.out.println("fr.stri.projetperudo.ServeurImpl.desRMI() " + DesEnv);
                        String tmpenvv = "Tu as : " + listePartie.get(i).getListeJoueur().get(x).getNbDes() + " Des";
                        envoiMessage(tmpenvv, j, nomP);
                        envoiMessage(DesEnv, j, nomP);
                        ///////*/////////////////////////////////////////////*//////////
                    }
                }
            }
        }

    }
  
    @Override
    public ArrayList<Partie> getListePartie() throws RemoteException {
        synchronized (this) {
            return listePartie;
        }

    }

    
    public synchronized void attPartie() throws InterruptedException {
        while (listePartie.isEmpty()) {
            sleep(2000);
           // System.out.println("ATTENTE Partie");
        }
    }

    
    public synchronized void attJoueur(int nb) throws InterruptedException {
        ArrayList listeJ = new ArrayList();
        int nbj = listePartie.get(nb).getNbJoueur();

        listeJ = listePartie.get(nb).getListeJoueur();

        while (listeJ.size() < nbj) {
            sleep(2000);
            System.out.println("ATTENTE JOUEUR");
        }
        listePartie.get(nb).setPartieEncours(true); //on déclare la partie en cours 

    }

    public synchronized int gagnant(int nb) {
        int val = 0;
        ArrayList listeJ = new ArrayList();
        listeJ = listePartie.get(nb).getListeJoueur();

        if (listeJ.size() == 1) {
            val = 1;
            //ENVOI LA GAGNANT EST AVEC RMI INVERSE
        }
        return val;
    }

    ////    //////////  //////////
    ////   /// MAIN//  //////////
    ////  /////////  //////////
    
    public static void main(String[] args) throws Exception {
        LocateRegistry.createRegistry(1099);

        Naming.rebind("MonServeur", new ServeurImpl());
        System.out.println("RMI OK");

        ///////Implémentation serveur
        ServeurImpl s = new ServeurImpl();
        s.attPartie(); // Attente d'une partie pour pouvoir lancer la boucle de lancement des threads

       
        /*Dans cette boucle on associe une partie a un thread,si la partie a été créé on lance le thread*/
        while (!listePartie.isEmpty()) {

            for (int i = 0; i <= listeThread.size() - 1; i++) {
                if (listeThread.get(i).isAlive()) {

                   System.out.println("La partie "+listePartie.get(i).getNomPartie()+" est en cours" );
                } else {
                    listeThread.get(i).start();
                    System.out.println("LA PARTIE "+listePartie.get(i).getNomPartie()+" EST LANCEE");
                }
                sleep(2000); //le temps de réaction pour le debut d'une partiE n'a pas besoin d'etre elevé
            }

        }
        System.out.println("TOUTES LES PARTIES SONT FINIS");

    } //crochet du main

} // crochet de la class

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.stri.projetperudo;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author jerome
 */
public class Partie{
    
    /* Arguments */
    private String nomPartie;
    private int nbJoueur;
    private ArrayList<Joueurs> listeJoueur = new ArrayList<Joueurs>();
    
    int desValeur;
    int nbVdes;
    private int finTour;
    private int finManche;
    private int valeur;
    private boolean partieEncours;
    int joueurCourant = 0;
    private HashMap<Integer, Client> lesClients = new HashMap<Integer, Client>();    
    String messgae;
    
    /*Constructeur*/
    public Partie(String nomPartie,int nbJoueur) 
    {
    this.nomPartie=nomPartie;
    this.nbJoueur = nbJoueur;
    this.partieEncours = false;
    this.desValeur=0;
    this.nbVdes=0;
    this.joueurCourant = -1;
    this.messgae =" ";
    }
       
    /*GET SET*/
     public ArrayList<Joueurs> getListeJoueur() {
        return listeJoueur;
    }

    public void setPartieEncours(boolean partieEncours) {
        this.partieEncours = partieEncours;
    }
    
    public boolean getPartieEncours()
    {
    return partieEncours;
    }

    public int getNbJoueur() {
        return nbJoueur;
    }

    public void ajoutJoueur(Joueurs a) {
       listeJoueur.add(a);
        
    }
     
    public String getNomPartie(){
        return nomPartie;
    }

    public int getFinManche() {
        return finManche;
    }

    public int getFinTour() {
        return finTour;
    }

    public void setFinManche(int finManche) {
        this.finManche = finManche;
    }

    public void setFinTour(int finTour) {
        this.finTour = finTour;
    }

    public  int getNbVdes() {
        return nbVdes;
    }

    public int getDesValeur() {
        return desValeur;
    }

    public synchronized int getJoueurCourant() {
        return joueurCourant;
    }

    public synchronized void setJoueurCourant(int joueurCourant) {
        this.joueurCourant = joueurCourant;
    }

    public HashMap<Integer, Client> getLesClients() {
        return lesClients;
    }

    public void setLesClients(HashMap<Integer, Client> lesClients) {
        this.lesClients = lesClients;
    }

    public void setNbVdes(int nbVdes) {
        this.nbVdes = nbVdes;
    }

    public void setDesValeur(int desValeur) {
        this.desValeur = desValeur;
    }

    public void setMessgae(String messgae) {
        this.messgae = messgae;
    }

    public String getMessgae() {
        return messgae;
    }
    
    
    
       
        
    /*Test Avant de débuter une manche*/
    public String avantManche ()
    {
    String retour;
    retour = "La Manche peut commencer";
      
    for(int i = 0; i <nbJoueur; i++)
       {
           /*on déroula la liste joueur et on regarde le nombre de dé de chaque 
           personne et on vires les gents qui on pas des Des */
       }
        return retour;
    }
   
    
    /*Methode pile manche*/
      boolean pileMache(Joueurs j) {
     /*Récupère la liste de DES de chaque joueur et regarde si 
     la valeur correspond aux annonces en cours (valeurDes nbDes) */
     ArrayList listeDes = new ArrayList();
      int val;
      int compter = 0;
          
     for(int i = 0; i < listeJoueur.size(); i++)
    {
     
        listeDes = listeJoueur.get(i).getListeDes(); // on recup la liste de des d'un joueur
     
   
        
        for(int x = 0; x < listeDes.size(); x++)
        {
     
            val = (int) listeDes.get(i);
            if ( val == desValeur || val == 1)  //le 1 en perrudo est un joker 
            {
                
               compter = compter +1;              
            }
        }
    }
        boolean nb;
    if ( compter == nbVdes)
    {
        // + true
        nb = true;
      //  j.setNbDes(nb);
    }
    else
    {
        nb =false;
        //j.setNbDes(nb);
    }
    
    finTour =1;
    finManche = 1;
    return nb;
}

      /*Methode menteur*/
      boolean menteur(Joueurs j) {
    /*Récupère la liste de DES de chaque joueur et regarde si 
     la valeur correspond aux annonces en cours (valeurDes nbDes) */
     ArrayList listeDes = new ArrayList();
      int val;
      int compter = 0;
     
     for(int i = 0; i < listeJoueur.size(); i++)
    {
     
        listeDes = listeJoueur.get(i).getListeDes(); // on recup la liste de des d'un joueur
     
        for(int x = 0; x < listeDes.size(); x++)
        {
            val = (int) listeDes.get(i);
            if ( val == desValeur || val == 1)  //le 1 en perrudo est un joker 
            {
               compter = compter +1;
               
            }
        }
    }
    boolean nb;
    if ( compter != nbVdes)
    {
        nb = false;
        //-1 false
      //  j.setNbDes(nb);
    }
    else
    {
       nb = true;
      //  j.setNbDes(nb);
    
    }
   
    finTour =1;
    finManche = 1;
    
    return nb;
}
           
    public void surcharge ( Joueurs j, int valDes,int nbDes) 
    {
       
     if ( valDes < 7 && valDes > 0 && desValeur <= valDes ){
        desValeur = valDes;
        }
        
        if ( nbDes < 30 && nbDes > 0 && nbVdes <= nbDes ){
        nbVdes = nbDes;   
        }
   finTour =1;
 }
 
 
 public ArrayList lanceDes(Joueurs j){
            // liste 
               int nb = j.getNbDes();
               String tmp2;
             //  System.out.println("Quel lancé de des du Joueur : " + j.getNomJoueurs());
             //  System.out.println("Vous avez : " + nb+" nombre de dès");
               ArrayList listeDes = new ArrayList();
              
               for (int i=0;i<=nb-1;i++)
                    {
                    valeur = (int)(1+ 6*Math.random());  
                    listeDes.add(valeur);
                    
                    }
               
//               for(int i = 0; i < listeJoueur.size() ; i++ )
//                  {
//                      tmp2= listeJoueur.get(i).getNomJoueurs();
//                      if (tmp2.compareToIgnoreCase(listeJoueur.get(i).getNomJoueurs() ) ==0)
//                      {
//                        listeJoueur.get(i).setListeDes(listeDes);                      
//                       }
//                  }
      
               // System.out.println("DANS LANCER DES" + listeDes.toString());       
            return listeDes ;   
    }
 
 
} // crochet fin de class
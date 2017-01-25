/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.stri.projetperudo;

import java.util.ArrayList;

/**
 *
 * @author jerome
 */
public class Partie {
    
    /* Arguments */
    private String nomPartie;
    private  int nbJoueur;
    private ArrayList<Joueurs> listeJoueur = new ArrayList<Joueurs>();
    private ArrayList<Manche> listeManche = new ArrayList<Manche>();
    

  

    
    private String  NomDernieJoueur;
    private int desValeur;
    private int nbVdes;
    
    private int Attente;
    
    private int valeur;
    
    
    /*Constructeur*/
    
    public Partie(String nomPartie,int nbJoueur) 
    {
    this.nomPartie=nomPartie;
    this.nbJoueur = nbJoueur;
    
    }
    
    
    
   /*MethodeS*/
    
    /*Ajouter un joueur dans la listejoueur*/
    public String connexion (Joueurs a)
    {
        String nomJ;
        listeJoueur.add(a);  
        nomJ= a.getNomJoueurs();
        return "Le joueurs est ajouté ";
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
    
      void pileMache() {
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
}

      
      
      

	public void lanceDes(int nbDes, Joueurs j){
            // liste 
               int nb = j.getNbDes();
               ArrayList listeDes = new ArrayList();
               for (int i=0;i<=nb;i++)
                    {
                    valeur = (int)(1+ 6*Math.random());  
                    listeDes.add(valeur);
                    }
                j.setListeDes(listeDes);
                
		}
  
        
}
    
    
    
          
       
            

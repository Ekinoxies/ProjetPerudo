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

    
    /*Constructeur*/
    
    public Partie() 
    {
    this.nomPartie="temp";
    this.nbJoueur = 2;     
    }
    
    
    
   /*Methode*/
    public String connexion (Joueurs a)
    {
        String nomJ;
        listeJoueur.add(a);  
        nomJ= a.getNomJoueurs();
        return "Le joueurs nomJ ";
    }
   
    public String avantManche ()
    {
    
       for(int i = 0; i <nbJoueur; i++)
       {
           /*get de truck */
       }
        
        return"";
    }
   
    
    
    
    }      
       
            

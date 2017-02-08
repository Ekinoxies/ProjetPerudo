package Version2;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import java.util.Enumeration;
import java.util.HashSet;

public class Partie{ 
    private String nomP;

    ArrayList<Joueur> partie= new ArrayList<>();
    ArrayList<Des> des= new ArrayList<>();
 
    
 // ajout du joueur a la partie
    public void addjoueur(Joueur joueur){
       partie.add(joueur);
    }
 
 // ajout des dés
    public void addDés(Des dé){
       des.add(dé);
    }

    

    public Partie(String nom){
        super();
        this.nomP=nom;
    }
    
    

    public String getNom() {
        return nomP;
    }

    public void setNom(String nom) {
        this.nomP = nom;
    }


 
    

 // A mettre a chaque class que l'on veut pouvoir partager, pour le RMI "inverse"  
   private static Vector NOTIF = new Vector();
    
    public static Partie getInstancePartie(String attribut1){
    	Partie tmp = new Partie(attribut1);
        if (NOTIF.contains(tmp)) {
            Enumeration enume = NOTIF.elements();
            while (enume.hasMoreElements()) {
            	Partie element = (Partie) enume.nextElement();
                if (element.equals(tmp)) {
                    return element;
                }
            }
        }
        else {
        	NOTIF.add(tmp);
            return tmp;
        }
        return null;
    }
 
}

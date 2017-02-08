package Version2;


import java.rmi.RemoteException;
import java.util.Enumeration;
import java.util.Vector;



// Cette classe sert uniquement de Carte d'identité à nos Joueurs
public class Utilisateur {
    
    private String Joueur;
    
    public Utilisateur(String Utilisateur) {
        this.Joueur=Joueur;
    }
    
 // on va utiliser pour recup le joueur
    public String getJoueur() {
        return Joueur;
    }
    
 // on ajoute le joueur
    public void setJoueur(String Joueur) {
        this.Joueur = Joueur;
    }
 
    
    
    
 // A mettre a chaque class que l'on veut pouvoir partager, pour le RMI "inverse"   
    private static Vector NOTIF = new Vector();
     
    public static Utilisateur getInstanceUtilisateur(String attribut1){
    	Utilisateur tmp = new Utilisateur(attribut1);
        if (NOTIF.contains(tmp)) {
            Enumeration enume = NOTIF.elements();
            while (enume.hasMoreElements()) {
            	Utilisateur element = (Utilisateur) enume.nextElement();
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
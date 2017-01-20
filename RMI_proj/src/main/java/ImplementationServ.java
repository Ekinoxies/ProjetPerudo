/* ICI on va entrer les fonctions des méthodes, elles pourront etre appellées via le client si elles sont dans InterfaceServ*/


/**
 *
 * @author florian b
 */

 import java.rmi.RemoteException;

public class ImplementationServ implements InterfaceServ {
    
    /* Methode Erreur*/
    public Integer Erreur(Integer x) throws RemoteException {
        return x;
    }
    
    /* Methode CreerPartie*/
    public String CreerPartie(String nomPartie,Integer NbJoueur)throws RemoteException {
         return "c'est bon partie créée"; 
     }
     
    /* Méthode SeConnecter */
    public String SeConnecter(String nomJoueur)throws RemoteException {
         return "Connecté, bienvenu : "+nomJoueur;
    }
    
    /* Méthode LanceDes */
    public String LanceDes(Integer Des)throws RemoteException{
        return "Vous avez fait : "+Des;
    }
}   

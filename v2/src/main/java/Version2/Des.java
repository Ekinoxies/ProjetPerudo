package Version2;


import java.util.Enumeration;
import java.util.Vector;
import java.io.Serializable;

public class Des implements Serializable{
   
    private String ValDes;

    public Des (String val){
       this.ValDes=val;
    }
   
    
    
    
// on ajoute   
    public void setValeur(String val){
       this.ValDes=val;
    }

// on envoie
    public String getVal(){
       return ValDes;
    }
   

    
    
 // On lance nos petits des !!! Attention on ne fait que 1 lancé donc si le joeur a 3 des il faudra faire 3 fois !
    public String getValeur() {
        int resultat = (int)(1+ 6*Math.random());  

        if(resultat==1){
        	ValDes="perudo";   
        }
        else{
        	ValDes=Integer.toString(resultat);
        }
        return ValDes;
    }
    
    
    
    
    
    
 // A mettre a chaque class que l'on veut pouvoir partager, pour le RMI "inverse"  
    private static Vector NOTIF = new Vector();
    
    public static Des getInstanceDes(String attribut1){
    	Des tmp = new Des(attribut1);
        if (NOTIF.contains(tmp)) {
            Enumeration enume = NOTIF.elements();
            while (enume.hasMoreElements()) {
            	Des element = (Des) enume.nextElement();
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
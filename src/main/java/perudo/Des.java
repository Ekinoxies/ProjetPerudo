/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perudo;

/**
 *
 * @author jerome
 */
public class Des {

        /*Arguments*/
	public int valeurDe;
        int valeur;
        
        /*Constructeur*/
	public  Des(){
		valeur = (int)(1+ 6*Math.random());
		}
        
        
       /*Getteur DES*/
        public int getDes() {
		return valeurDe;     
        }
        
}

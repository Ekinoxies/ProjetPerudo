/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author florian b
 */
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Client {
    public static void main(String[] argv) {
try {
            Registry registry = LocateRegistry.getRegistry(10000);
            
            /* APPELLE METHODE ERREUR*/
            InterfaceServ stub = (InterfaceServ) registry.lookup("Erreur");
            System.out.println(stub.Erreur(100000000)); // On entre les parametres pour Methode Erreur
            
            /* APPELLE METHODE CreerPartie*/
            InterfaceServ stub2 = (InterfaceServ) registry.lookup("CreerPartie");
            System.out.println(stub2.CreerPartie("DOFUS",1)); // On entre les parametres pour Methode CreerPartie
            
            /* APPELLE METHODE CreerPartie*/
            InterfaceServ stub3 = (InterfaceServ) registry.lookup("SeConnecter");
            System.out.println(stub3.SeConnecter("Xelor")); // On entre les parametres pour Methode SeConnecter
            
            /* APPELLE METHODE LanceDes*/
            InterfaceServ stub4 = (InterfaceServ) registry.lookup("LanceDes");
            System.out.println(stub4.LanceDes(5)); // On entre les parametres pour Methode SeConnecter
            
        } catch (Exception e) {
            e.printStackTrace();
        }








    }
}   


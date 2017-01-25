/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.stri.projetperudo;
/**
 *
 * @author florian b
 */
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class RmiClient {
    public static void main(String[] argv)throws Exception  {

            InterfaceServCli proxy = (InterfaceServCli) Naming.lookup("rmi://localhost:1099/MonServeur");
            
            // Attention les systemeout sont juste des teste pour voir que ca fonctionne bien !!!!!!!!
            /* APPELLE METHODE CreerPartie*/
            System.out.println(proxy.CreerPartie("DOFUS",1)); // On entre les parametres pour Methode CreerPartie
            
            /* APPELLE METHODE se connecter*/
            System.out.println(proxy.SeConnecter("Xelor")); // On entre les parametres pour Methode SeConnecter
            
            /* APPELLE METHODE LanceDes*/
            System.out.println(proxy.LanceDes(5)); // On entre les parametres pour Methode SeConnecter
            
            
         

    }
}   


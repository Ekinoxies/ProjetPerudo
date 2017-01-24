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
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author Alain Defrance
 */
public class RmiServeur {
    public static void main(String[] argv) {
        try {
        	// 10000 est le port sur lequel sera publiÃ© le service. Nous devons le prÃ©ciser Ã  la fois sur le registry et Ã  la fois Ã  la crÃ©ation du stub.
            InterfaceServCli skeleton = (InterfaceServCli) UnicastRemoteObject.exportObject(new ImplementationServ(), 10000); // GÃ©nÃ¨re un stub vers notre service.
            Registry registry = LocateRegistry.createRegistry(10000);
            // publie notre instance sous le nom donnÃ©
            registry.rebind("Erreur", skeleton); 
            registry.rebind("CreerPartie", skeleton);
            registry.rebind("SeConnecter", skeleton);
            registry.rebind("LanceDes", skeleton);
        } catch (Exception e) {
        }
    }
}   


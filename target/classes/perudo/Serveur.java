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
import java.rmi.server.UnicastRemoteObject;

/**
 * @author Alain Defrance
 */
public class Serveur {
    public static void main(String[] argv) {
        try {
        	// 10000 est le port sur lequel sera publié le service. Nous devons le préciser à la fois sur le registry et à la fois à la création du stub.
            InterfaceServ skeleton = (InterfaceServ) UnicastRemoteObject.exportObject(new ImplementationServ(), 10000); // Génère un stub vers notre service.
            Registry registry = LocateRegistry.createRegistry(10000);
            // publie notre instance sous le nom donné
            registry.rebind("Erreur", skeleton); 
            registry.rebind("CreerPartie", skeleton);
            registry.rebind("SeConnecter", skeleton);
            registry.rebind("LanceDes", skeleton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}   


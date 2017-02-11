/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.stri.projetperudo;

import fr.stri.projetperudo.ClientNotification;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author florian b
 */
public class ClientImplementation  extends UnicastRemoteObject implements ClientNotification  {
   
private String id;
public ClientImplementation(String id) throws RemoteException {
	 	 super() ;
	 	 this.id = id;
}



   public void notificationNbDes(int nbDes) throws RemoteException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   public void notificationDes(ArrayList listeDes) throws RemoteException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}


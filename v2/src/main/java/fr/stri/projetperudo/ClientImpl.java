/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.stri.projetperudo;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import fr.stri.projetperudo.Client;

/**
 *
 * @author florian b
 */
public class ClientImpl  extends UnicastRemoteObject implements Client  {
   
private String id;
public ClientImpl(String id) throws RemoteException {
	 	 super() ;
	 	 this.id = id;
}


@Override
   public void notificationNbDes(int nbDes) throws RemoteException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

@Override
   public void notificationDes(ArrayList listeDes) throws RemoteException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
   }

}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.stri.projetperudo;

import fr.stri.projetperudo.InterfaceServCli.ClientNotification;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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




public void notification(double valeur, double mini)
 throws RemoteException {
	 	 System.out.println("Votre compte "+id+" est inferieur au mini : "+
 mini+" solde : "+valeur);
}
}


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




public void notification1(String valeur)throws RemoteException {
	 	 System.out.println("Votre compte "+valeur+" est inferieur au mini : ");
 }

public void notification2(String valeur)throws RemoteException {
	 	 System.out.println("Votre compte "+valeur+" est inferieur au mini : ");
 }
}


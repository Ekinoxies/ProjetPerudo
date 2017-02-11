/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.stri.projetperudo;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author florian b
 */
public interface ClientNotification extends Remote {
	 	 public void notification1(double valeur) throws RemoteException;
                 public void notification2(String valeur) throws RemoteException;
                 
    }

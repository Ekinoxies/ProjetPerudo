/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.stri.projetperudo;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author florian b
 */
public interface Client extends Remote {
	 	 public void notificationDes(ArrayList listeDes) throws RemoteException;
                 public void notificationNbDes(int nbDes) throws RemoteException;
                 
    }

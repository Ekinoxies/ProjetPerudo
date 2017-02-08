package Version2;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

/**
*
* @author Administrator
*/
public interface InterfaceServ extends Remote {
	public ArrayList<String> getJoueur() throws RemoteException;
	public String getinit(String text) throws RemoteException;
	public void CreerJoueur(String j) throws RemoteException;
}
/**
 * 
 */
package com.aim.app.rmi;

import java.rmi.RemoteException;

/**
 * @author aim
 *
 */
public class HelloImpl implements Hello {

	@Override
	public void printMsg() throws RemoteException {
		System.out.println("This is a remote method");
	}
}

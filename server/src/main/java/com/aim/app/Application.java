package com.aim.app;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import com.aim.app.rmi.Hello;
import com.aim.app.rmi.HelloImpl;

public class Application extends HelloImpl {

	public Application() {
	}

	public static void main(String[] args) {

		try {

			/**
			 * Instantiating the implementation class
			 */
			HelloImpl obj = new HelloImpl();

			/**
			 * Exporting the object of implementation class (here we are exporting the
			 * remote object to the stub)
			 */
			Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);

			/**
			 * Binding the remote object in the registry
			 **/
			Registry registry = LocateRegistry.getRegistry();

			registry.bind("Hello", stub);
			System.err.println("Server ready");

		} catch (Exception e) {
			System.err.println("Server Exception: " + e.toString());
			e.printStackTrace();
		}

	}
}

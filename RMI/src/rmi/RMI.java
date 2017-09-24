/*
 */
package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author adam-bien.com
 */
public class RMI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        Hello hello = (Hello) Naming.lookup("rmi://localhost:1099/hello");
        System.out.println("Hello: " + hello.getClass().getName());
        System.out.println(hello.hello("duke"));
    }

}

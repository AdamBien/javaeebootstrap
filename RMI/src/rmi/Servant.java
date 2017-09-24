/*
 */
package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author adam-bien.com
 */
public class Servant {

    public static void main(String[] args) throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("hello", new HelloServant());
    }
}

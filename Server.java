import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
public class Server extends UnicastRemoteObject implements RMI_Interface {
    Server() throws RemoteException {
        super();
    }
    public int sum(int a,int b) throws RemoteException {
        return (a+b);
    }
    public static void main(String[] args) {
        try{
            Server obj= new Server();
            LocateRegistry.createRegistry(1099);
            Registry registry=java.rmi.registry.LocateRegistry.getRegistry();
            registry.rebind("HelloServer",obj);
            System.out.println("Server is Ready");
        }catch(Exception e){
            System.err.println("Server Exception: "+e.toString());
            e.printStackTrace();
        }
    }

}

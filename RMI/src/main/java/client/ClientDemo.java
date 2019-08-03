package client;

import server.HelloService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientDemo {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        HelloService helloService =
                (HelloService)Naming.lookup("rmi://127.0.0.1/Hello");
        System.out.println(helloService.hello("zfd"));

    }
}

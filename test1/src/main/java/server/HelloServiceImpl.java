package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {
    protected  HelloServiceImpl() throws RemoteException{
        super();
    }


    @Override
    public String hello(String name) {
        return "hello" + name ;
    }
}

package rpc;

public class ClientDemo {

    public static void main(String[] args) {

        RpcClientProxy rpcClientProxy =new RpcClientProxy();

        IGPHello hello = rpcClientProxy.clientProxy(IGPHello.class, "localhost", 8000);
        System.out.println(hello.sayHello("mic"));
    }




}

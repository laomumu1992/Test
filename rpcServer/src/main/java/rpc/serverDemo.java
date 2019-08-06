package rpc;

public class serverDemo {
    public static void main(String[] args) {
        IGPHello iGPHello = new GPHelloImpl();
        RpcServer rpcServer = new RpcServer();
        //发布服务 应用和端口号
        rpcServer.publisher(iGPHello,8000);
    }
}

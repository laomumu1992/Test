package rpc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RpcServer {

     private static final ExecutorService executorService = Executors.newCachedThreadPool();

     /**
      * 对外发布服务
      * */
    public void publisher(final Object service/*发布的服务*/, int port/*端口号*/){
        ServerSocket  serverSocket = null;
        try{
         serverSocket = new ServerSocket(port); //启动一个服务监听
            while (true){
                //拿到请求
                Socket socket = serverSocket.accept();
                //通过线程池去提交任务
                executorService.execute(new ProcessorHandler(socket,service ));
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

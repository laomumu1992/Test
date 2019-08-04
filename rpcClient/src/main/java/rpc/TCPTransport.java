package rpc;

import java.io.*;
import java.net.Socket;

public class TCPTransport {

    private String host;

    private int port;



    public TCPTransport(String host, int port) {
        this.host = host;
        this.port = port;
    }

    private Socket newSocket(){
        System.out.println("创建一个新的连接");
        Socket socket;
        try {
            socket = new Socket(host,port);
            return socket;
        } catch (IOException e) {
            throw new RuntimeException("连接建立失败");
        }
    }

    public  Object send(RpcRequest request){
        Socket socket = null;
        try {
            socket = newSocket();

            ObjectOutputStream   outputStream= new ObjectOutputStream
                    (socket.getOutputStream());
            outputStream.writeObject(request);
            outputStream.flush();


            InputStream inputStream1 = socket.getInputStream();

            //TODO 此处抛出异常  java.io.EOFException
            ObjectInputStream inputStream = new ObjectInputStream
                    (inputStream1);

            Object result = inputStream.readObject();

            inputStream.close();
            outputStream.close();


            return  result;


        } catch (EOFException eof){
            throw  new RuntimeException("EOFException：" + eof);
        }
        catch (Exception e) {
            throw  new RuntimeException("发起远程调用异常：" + e);
        } finally {
            try {
                if(socket != null){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

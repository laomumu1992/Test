package server;

import com.alibaba.fastjson.JSON;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Map;
import java.util.Set;

public class Server {
    public static void main(String[] args) {

        try {
            HelloService helloService = new HelloServiceImpl();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://127.0.0.1/Hello",helloService);
            System.out.println("服务启动成功");
        } catch (RemoteException e) {
            new RuntimeException(e);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

   public static String getMapToString(Map<Object,Object> map){

        Set<Object> keySet = map.keySet();

        Object[] keyArray = keySet.toArray();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < keySet.size(); i++) {
                sb.append(keyArray[i]).append(":").append(map.get(keyArray[i]));
            if(i != keyArray.length-1){
                sb.append(";");
            }
        }

        return sb.toString();
    }

    /*public static String getMapToString(Map<String,String> map){

        Set<String> keySet = map.keySet();

        StringBuilder sb = new StringBuilder();

        for (String str:keySet) {
            sb.append(str).append(":").append(map.get(str)+';');
        }
        return sb.toString();
    }
*/



}

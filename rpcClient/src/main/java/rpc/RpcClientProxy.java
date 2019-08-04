package rpc;


import java.lang.reflect.Proxy;

/**
 * 实现一个动态代理
 * */
public class RpcClientProxy {
    public <T> T clientProxy(final Class<T> interfaceCls,
                             final String host, final int port){

        return (T)Proxy.newProxyInstance(interfaceCls.getClassLoader(),
                new Class[]{interfaceCls},new RemoteInvocationHandler(host,port));

    }
}

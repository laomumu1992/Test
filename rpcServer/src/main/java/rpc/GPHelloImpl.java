package rpc;

public class GPHelloImpl implements IGPHello {

    public String sayHello(String msg) {
        return "Hello" + msg;
    }
}
 
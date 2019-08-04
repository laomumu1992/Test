package rpc;

import java.io.Serializable;

/**
 * 提交请求
 * 作为一个远程传输的对象
 * */

public class RpcRequest implements Serializable {

    private static final long serialVersionUID = 5651131960519623549L;
    private String className;

     private String methodName;

     private Object[] parameters;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}

package cn.onehand.acss.server;

public class Code {
    //是否成功
    private boolean flag;
    //返回对象
    private Object data;
    //提示
    private String message;

    public Code(){}
    public Code(boolean flat, Object o) {
        this.flag = flat;
        this.data = o;
    }

    public Code(boolean flat) {
        this.flag = flat;
    }

    public Code(boolean flat, Object o, String mess) {
        this.flag = flat;
        this.data = o;
        this.message = mess;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

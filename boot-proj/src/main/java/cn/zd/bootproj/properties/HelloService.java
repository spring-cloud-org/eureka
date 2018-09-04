package cn.zd.bootproj.properties;

/**
 * @author: Zhao Da
 * @since: 2018/9/4 09:47
 */
public class HelloService {
    private String msg;

    public String sayHello() {
        return "Hello " + msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

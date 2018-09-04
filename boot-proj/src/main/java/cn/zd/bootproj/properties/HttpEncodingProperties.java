package cn.zd.bootproj.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: Zhao Da
 * @since: 2018/9/4 09:44
 */
@ConfigurationProperties(prefix = "spring.http.encoding")
public class HttpEncodingProperties {

    public static final String MSG = "world";
    private String msg = MSG;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

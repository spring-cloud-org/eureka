package cn.zd.thymeleafproj.ws.domain;

/**
 * 服务端向浏览器发送的此类消息
 * @author: Zhao Da
 * @since: 2018/9/4 11:46
 */
public class DarwinResponse {
    private String responseMessage;

    public DarwinResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}

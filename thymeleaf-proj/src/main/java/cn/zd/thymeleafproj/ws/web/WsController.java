package cn.zd.thymeleafproj.ws.web;

import cn.zd.thymeleafproj.ws.domain.DarwinMessage;
import cn.zd.thymeleafproj.ws.domain.DarwinResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * @author: Zhao Da
 * @since: 2018/9/4 11:47
 */
@Controller
public class WsController {
    @MessageMapping("/welcome")// 浏览器向服务端发送请求时，通过@MessageMapping映射/welcome这个地址
    @SendTo("/topic/getResponse")// 当服务端有消息，会对订阅了@SendTo中的路径的浏览器发送消息
    public DarwinResponse say(DarwinMessage message) throws Exception {
        Thread.sleep(3000);
        return new DarwinResponse("welcome, " + message.getName() + "!");
    }

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg) {// principal中包含当前用户的信息
        if ("wyf".equals(principal.getName())) {
            messagingTemplate.convertAndSendToUser("wisely", "/queue/notifications", principal.getName() + "-send: " + msg);
        } else {
            messagingTemplate.convertAndSendToUser("wyf", "/queue/notifications", principal.getName() + "-send: " + msg);
        }
    }
}

package cn.zd.thymeleafproj.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * 开启使用STOMP协议来传输基于代理的消息，这时控制器支持使用@MessageMapping,就像使用@RequestMapping一样
 * @author: Zhao Da
 * @since: 2018/9/4 11:36
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    /**
     * // 注册STOMP协议的节点(endpoint)，并映射指定的URL
     * @param stompEndpointRegistry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        // 注册一个STOMP的endpoint，并指定使用SockJS协议
        stompEndpointRegistry.addEndpoint("/endpointDarwin").withSockJS();
        stompEndpointRegistry.addEndpoint("/endpointWisely").withSockJS();
        stompEndpointRegistry.addEndpoint("endpointChat").withSockJS();
    }

    /**
     * // 配置消息代理
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 广播式应配置一个/topic消息代理,点对点式增加一个/queue消息代理
        registry.enableSimpleBroker("/queue", "/topic");
    }
}

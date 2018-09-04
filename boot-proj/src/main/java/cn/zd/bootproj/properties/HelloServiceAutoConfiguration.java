package cn.zd.bootproj.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Zhao Da
 * @since: 2018/9/4 09:48
 */
@Configuration
@EnableConfigurationProperties(HttpEncodingProperties.class)// 开启属性注入
@ConditionalOnClass(HelloService.class)// 当在类路径的条件下
@ConditionalOnProperty(prefix = "hello", value = "enabled", matchIfMissing = true)//
public class HelloServiceAutoConfiguration {

    @Autowired
    private HttpEncodingProperties httpEncodingProperties;

    @Bean
    @ConditionalOnMissingBean(HelloService.class)
    public HelloService helloService() {
        HelloService helloService = new HelloService();
        helloService.setMsg(httpEncodingProperties.getMsg());
        return helloService;
    }
}

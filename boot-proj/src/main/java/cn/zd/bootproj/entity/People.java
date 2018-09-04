package cn.zd.bootproj.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: Zhao Da
 * @since: 2018/9/4 09:16
 */
@Component
@ConfigurationProperties(prefix = "people")
public class People {
    private Integer age;
    private String sex;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

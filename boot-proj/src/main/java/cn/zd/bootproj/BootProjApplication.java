package cn.zd.bootproj;

import cn.zd.bootproj.entity.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class BootProjApplication {

    @Autowired
    private People people;

    @RequestMapping("/")
    public String index() {
        return "sex is " + people.getSex() + " and age is " + people.getAge();
    }

    public static void main(String[] args) {
        SpringApplication.run(BootProjApplication.class, args);
    }
}

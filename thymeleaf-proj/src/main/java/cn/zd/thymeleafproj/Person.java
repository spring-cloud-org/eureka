package cn.zd.thymeleafproj;

/**
 * @author: Zhao Da
 * @since: 2018/9/4 10:10
 */
public class Person {
    private String name;
    private Integer age;

    public Person() {
        super();
    }

    public Person(String name, Integer age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

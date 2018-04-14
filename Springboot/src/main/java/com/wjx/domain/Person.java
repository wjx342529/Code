package com.wjx.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author WJX
 * @since 2018/4/15 1:19
 */
public class Person implements Serializable {
    private String id;
    private String name;
    private Integer age;
    private Date birthday;

    public String getId() {
        return id;
    }

    private void setId() {
        this.id = UUID.randomUUID().toString();
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date brithday) {
        this.birthday = brithday;
    }

    public Person() {
        setId();
    }

    public Person(String name, Integer age, Date birthday) {
        setId();
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String parseBirthday(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + parseBirthday(this.birthday) +
                '}';
    }
}

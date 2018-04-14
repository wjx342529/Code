package com.wjx.controller;

import com.wjx.domain.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author WJX
 * @since 2018/4/15 1:01
 */
@RestController
@RequestMapping("springboot")
public class SpringBootController {
    private final Integer LIST_INITIALCAPACITY = 16;

    /**
     * 返回string
     * @return
     */
    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }

    /**
     * 返回对象
     */
    @RequestMapping("/showPerson")
    public Person showPerson(){
        Person person = new Person("tom",20,new Date());
        return person;
    }

    /**
     * 返回list
     */
    @RequestMapping("/showList")
    public List<Person> showList(){
        Person person1 = new Person("tom",21,new Date());
        Person person2 = new Person("kity",24,new Date());
        Person person3 = new Person("lucy",16,new Date());
        Person person4 = new Person("jack",18,new Date());
        Person person5 = new Person("nexus",20,new Date());

        List<Person> list = new ArrayList<>(LIST_INITIALCAPACITY);

        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        list.add(person5);

        return list;
    }

    /**
     * 返回map
     */
    @SuppressWarnings("AlibabaCollectionInitShouldAssignCapacity")
    @RequestMapping("showMap")
    public Map<String,Person> showMap(){
        List<Person> list = showList();
        Map<String, Person> map = list.stream().collect(Collectors.toMap(Person::getId, Function.identity()));
        return map;
    }
}

package com.mepan.utils;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
//        // 创建一个示例实体类对象
//        Person person = new Person();
//        person.setName("John Doe");
//        person.setAge(30);
//        person.setEmail("john.doe@example.com");
//        person.setUserIdAf("null");
//        // 将实体类转换为Map
//        Map<String, Object> resultMap = EntityToMapConverter.convertToMap(person);
//
//        // 打印转换后的Map
//        for (Map.Entry<String, Object> entry : resultMap.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }
//
//        String s = "saasd_asd_asa_a";
//        System.out.println("s.substring(0,1) = " + s.substring(0, 1));
        Integer i = 0;
        ArrayList<String> arrayList = new ArrayList<>();

//        new Main().test1(i);
        new Main().test1(arrayList);
        System.out.println(arrayList.toString());

    }
    void test1(ArrayList<String> i){
        i.add("a");
    }
}

class Person {
    private String name;
    private int age;
    private String email;

    private String userIdAf;

    public String getUserIdAf() {
        return userIdAf;
    }

    public void setUserIdAf(String userIdAf) {
        this.userIdAf = userIdAf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
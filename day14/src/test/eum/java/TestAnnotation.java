package test.eum.java;/*
 *@author Zoumugen
 *@create 2018/11/4 0004-下午 22:04
 * JDK提供的常用注解
 * 元注解
 * 如何自定义注解
 */

public class TestAnnotation {
    public static void main(String[] args) {
        Person person=new Student();

    }
}
class Student extends Person{
    @Override
    public void work() {
        System.out.println("xueshengzoulu ");
    }

    @Override
    public void eat() {
        System.out.println("xueshengchifan");
    }
}
class Person {
    String name;
    int age;

    public void work() {
        System.out.println("zoulu");
    }
    public void eat(){
        System.out.println("chifan");
    }
    public Person() {
        super();
    }

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
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
}
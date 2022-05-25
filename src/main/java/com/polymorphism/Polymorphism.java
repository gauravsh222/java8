package com.polymorphism;

class Base {
    String name = "Base";
    public String m1() {return null;}
}
class Child extends Base {
    String name = "Child";
    public String m1()  {return null;}
}

public class Polymorphism {

    //below methods are for checking ambiguity
    public Base m1(Integer param) {return null;}
    public Base m1(String param) {return null;}


    public static void main(String[] args) {
        Base base = new Child();
        System.out.println(base.name);
        Polymorphism polymorphism = new Polymorphism();
//        polymorphism.m1(null);
    }
}

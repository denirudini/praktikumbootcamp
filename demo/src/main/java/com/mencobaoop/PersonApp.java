package com.mencobaoop;

public class PersonApp {
    public static void main(String[] args) {
        var person = new Person();
        person.name = "Deni";
        person.address = "Bandung";

        System.out.println("Name: " + person.name); 
        System.out.println("Address: " + person.address);
        System.out.println("Country: " + person.country);

        person.sayHello("Diana Amelia");

        
        
    }
}

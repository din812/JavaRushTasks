package com.javarush.task.task13.task1327;

import org.w3c.dom.ls.LSOutput;

public class Person implements RepkaItem{
    private String name;
    private String namePadezh;

    public Person(String name, String namePadezh) {
        this.name = name;
        this.namePadezh = namePadezh;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getNamePadezh() {

        return namePadezh;
    }

    public void setNamePadezh(String namePadezh) {

        this.namePadezh = namePadezh;
    }

    public void pull(Person person){
        System.out.println(name + " за " + person.namePadezh);
    }

    /*@Override
    public String toString() {
        return name + " за " + this.namePadezh;
    }*/
}

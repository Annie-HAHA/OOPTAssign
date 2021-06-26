/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentoopt;

/**
 *
 * @author User
 */
public class Person {
    private String name;
    private int age;
    private char gender;

    public Person(String name,int age,char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;      
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Staff Name : " + name + "\nAge : " + age + "\nGender : " + gender;
    }
}

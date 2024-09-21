// File: Villagers/Healer.java
package Villagers;

public class Healer extends Villager {
    public Healer(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    @Override
    public void performDuty() {
        System.out.println(getFirstName() + " is healing the wounded.");
    }

    @Override
    public void print() {
        System.out.println("Healer: " + getFirstName() + " " + getLastName() + ", Age: " + getAge());
    }
}


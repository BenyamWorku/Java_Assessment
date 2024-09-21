// File: Villagers/Scholar.java
package Villagers;

public class Scholar extends Villager {
    public Scholar(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    @Override
    public void performDuty() {
        System.out.println(getFirstName() + " is researching new technologies.");
    }

    @Override
    public void print() {
        System.out.println("Scholar: " + getFirstName() + " " + getLastName() + ", Age: " + getAge());
    }
}

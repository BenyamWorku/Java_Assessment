// File: Villagers/Blacksmith.java
package Villagers;

public class Blacksmith extends Villager {
    public Blacksmith(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
        // Additional initialization if needed
    }

    @Override
    public void performDuty() {
        System.out.println(getFirstName() + " is forging weapons.");
    }

    @Override
    public void print() {
        System.out.println("Blacksmith: " + getFirstName() + " " + getLastName() + ", Age: " + getAge());
    }
}

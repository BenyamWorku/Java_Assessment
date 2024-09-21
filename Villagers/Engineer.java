package Villagers;

public class Engineer extends Villager {

    public Engineer(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    @Override
    public void performDuty() {
        System.out.println(getFirstName() + " is strengthening the buildings.");
    }

    @Override
    public void print() {
        System.out.println("Engineer: " + getFirstName() + " " + getLastName() + ", Age: " + getAge());
    }
}

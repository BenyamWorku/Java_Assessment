package Villagers;
import Buildings.Building;

public abstract class Villager {

    String firstName;
    String lastName;
    int age;
    private Building assignedBuilding;

    public Villager(String firstName, String lastName, int age) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
        this.assignedBuilding=null;
    }

    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName=firstName;
    }

    public void setLastName(String lastName) {
        this.lastName=lastName;
    }

    public void setAge(int age) {
        this.age=age;
    }

    public Building getAssignedBuilding() {
        return assignedBuilding;
    }

    public void setAssignedBuilding(Building building) {
        this.assignedBuilding = building;
    }

    public  void performDuty() {};
    
    // public abstract void print();
    public void print() {
        System.out.println("  Villager: " + this.firstName + " " + this.lastName + ", Age: " + this.age);
        if (assignedBuilding != null) {
            System.out.println("    Assigned to: " + assignedBuilding.getName());
        } else {
            System.out.println("    Not assigned to any building.");
        }
    }
}

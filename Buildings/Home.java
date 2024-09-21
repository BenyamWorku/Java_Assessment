// File: Buildings/Home.java
package Buildings;
import Villagers.*;


public class Home extends Building {
    private int capacity;

    public Home(String name) {
        super(name);
        this.capacity = 4; // Example capacity
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public void print() {
        System.out.println("  Home: " + getName() + " (Capacity: " + capacity + ")");
        if (assignedVillagers.isEmpty()) {
            System.out.println("    No villagers assigned.");
        } else {
            System.out.println("    Assigned Villagers:");
            for (Villager villager : assignedVillagers) {
                System.out.println("      - " + villager.getFirstName() + " " + villager.getLastName());
            }
        }
    }
}

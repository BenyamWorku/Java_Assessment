// File: Buildings/Barracks.java
package Buildings;
import Villagers.*;


public class Barracks extends Building {
    private int soldierCount;

    public Barracks(String name) {
        super(name);
        this.soldierCount = 0; // Initial soldier count
    }

    public int getSoldierCount() {
        return soldierCount;
    }

    public void trainSoldier() {
        soldierCount++;
        System.out.println("  Barracks '" + getName() + "' trained a new soldier. Total Soldiers: " + soldierCount);
    }

    @Override
    public void print() {
        System.out.println("  Barracks: " + getName() + " (Soldiers: " + soldierCount + ")");
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
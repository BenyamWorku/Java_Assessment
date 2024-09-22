// File: Buildings/Barracks.java
package Buildings;
import Villagers.*;
import java.util.List;
import java.util.ArrayList;


public class Barracks extends Building {
    private static final int DEFENSE_BOOST_PER_KNIGHT = 10;

    public Barracks(String name) {
        super(name);
    }
    /**
     * Assigns a Knight to the Barracks.
     * Only Knights can be assigned to the Barracks.
     *
     * @param villager The villager to assign.
     */
    @Override
    public boolean assignVillager(Villager villager) {
        if (!(villager instanceof Knight)) {
            System.out.println("Only Knights can be assigned to the Barracks.");
            return false;
        }

        assignedVillagers.add(villager);
        villager.setAssignedBuilding(this);
        System.out.println(villager.getFirstName() + " has been assigned to " + this.getName() + ".");
    
        return true;
    }

    /**
     * Calculates the total defense boost provided by all Knights in the Barracks.
     *
     * @return Total defense boost.
     */
    public int getTotalDefenseBoost() {
        int numberOfKnights = 0;
        for (Villager villager : assignedVillagers) {
            if (villager instanceof Knight) {
                numberOfKnights++;
            }
        }
        return numberOfKnights * DEFENSE_BOOST_PER_KNIGHT;
    }
    /**
     * Overrides the print method to display Knights and total defense boost.
     */
    @Override
    public void print() {
        System.out.println("  Barracks: " + getName());
        if (assignedVillagers.isEmpty()) {
            System.out.println("    No Knights assigned.");
        } else {
            System.out.println("    Assigned Knights:");
            for (Villager villager : assignedVillagers) {
                System.out.println("      - " + villager.getFirstName() + " " + villager.getLastName());
            }
            System.out.println("    Total Defense Boost: " + getTotalDefenseBoost());
        }
    }
}
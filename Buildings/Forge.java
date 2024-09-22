// File: Buildings/Forge.java
package Buildings;
import Villagers.*;
import java.util.List;
import java.util.ArrayList;

public class Forge extends Building {
    private static final int ATTACK_BOOST_PER_BLACKSMITH = 50;

    public Forge(String name) {
        super(name);
    }

    /**
     * Assigns a Blacksmith to the Forge.
     * Only Blacksmiths can be assigned to the Forge.
     *
     * @param villager The villager to assign.
     */
    @Override
    public boolean assignVillager(Villager villager) {
        if (!(villager instanceof Blacksmith)) {
            System.out.println("Only Blacksmiths can be assigned to the Forge.");
            return false;
        }

        assignedVillagers.add(villager);
        villager.setAssignedBuilding(this);
        System.out.println(villager.getFirstName() + " has been assigned to " + this.getName() + ".");
        
        return true;
    }

    /**
     * Calculates the total attack boost provided by all Blacksmiths in the Forge.
     *
     * @return Total attack boost.
     */
    public int getTotalAttackBoost() {
        int numberOfBlacksmiths = 0;
        for (Villager villager : assignedVillagers) {
            if (villager instanceof Blacksmith) {
                numberOfBlacksmiths++;
            }
        }
        return numberOfBlacksmiths * ATTACK_BOOST_PER_BLACKSMITH;
    }

    /**
     * Overrides the print method to display Blacksmiths and total attack boost.
     */
    @Override
    public void print() {
        System.out.println("  Forge: " + getName());
        if (assignedVillagers.isEmpty()) {
            System.out.println("    No Blacksmiths assigned.");
        } else {
            System.out.println("    Assigned Blacksmiths:");
            for (Villager villager : assignedVillagers) {
                System.out.println("      - " + villager.getFirstName() + " " + villager.getLastName());
            }
            System.out.println("    Total Attack Boost: " + getTotalAttackBoost());
        }
    }
}

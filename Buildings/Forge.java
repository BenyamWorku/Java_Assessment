// File: Buildings/Forge.java
package Buildings;
import Villagers.*;


public class Forge extends Building {
    private int equipmentLevel;

    public Forge(String name) {
        super(name);
        this.equipmentLevel = 1; // Example initial equipment level
    }

    public int getEquipmentLevel() {
        return equipmentLevel;
    }

    public void upgradeEquipment() {
        equipmentLevel++;
        System.out.println("  Forge '" + getName() + "' upgraded to Equipment Level " + equipmentLevel);
    }

    @Override
    public void print() {
        System.out.println("  Forge: " + getName() + " (Equipment Level: " + equipmentLevel + ")");
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

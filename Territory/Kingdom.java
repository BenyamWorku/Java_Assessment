package Territory;

import Buildings.Building;
import Villagers.Villager;

public class Kingdom extends Territory {

    public Kingdom(String name) {
        super(name);
    }

    // @Override
    // public void addBuilding(Building building) {
    //     buildings.add(building);
    // }

    // @Override
    // public void printStructure() {
    //     System.out.println("\n=== Kingdom: " + getName() + " ===");
    //     for (Building building : buildings) {
    //         building.print();
    //     }
    // }
    @Override
    public void addBuilding(Building building) {
        buildings.add(building);
        System.out.println("Building '" + building.getName() + "' added to the Kingdom.");
    }
    
    @Override
    public void printStructure() {
        System.out.println("\n=== Kingdom: " + getName() + " ===");
        System.out.println("Defense Level: " + defenseLevel);
        System.out.println("Technology Level: " + technologyLevel);
        System.out.println("Health Level: " + healthLevel + "%\n");

        System.out.println("Buildings:");
        if (buildings.isEmpty()) {
            System.out.println("  No buildings in this Kingdom.");
        } else {
            for (Building building : buildings) {
                building.print(); // Each Building's print() method
            }
        }

        System.out.println("\nVillagers:");
        if (villagers.isEmpty()) {
            System.out.println("  No villagers in this Kingdom.");
        } else {
            for (Villager villager : villagers) {
                villager.print(); // Each Villager's print() method
            }
        }
        System.out.println("====================================\n");
    }
}

// File: Territory/Dynasty.java
package Territory;

import Villagers.Villager;
import Buildings.Building;
import java.util.ArrayList;

// public class Dynasty extends Territory {

//     public Dynasty(String name) {
//         super(name);
//         buildings = new ArrayList<>();
//     }

//     @Override
//     public void addBuilding(Building building) {
//         buildings.add(building);
//     }

//     @Override
//     public void addVillager(Villager villager) {
//         // Villagers can be added to the dynasty without assignment to a building
//     }

//     @Override
//     public void printStructure() {
//         System.out.println("\n=== Dynasty: " + getName() + " ===");
//         for (Building building : buildings) {
//             building.print();
//         }
//     }
// }

public class Dynasty extends Territory {

    public Dynasty(String name) {
        super(name);
    }

    @Override
    public void addBuilding(Building building) {
        buildings.add(building);
        System.out.println("Building '" + building.getName() + "' added to the Dynasty.");
    }

    @Override
    public void printStructure() {
        System.out.println("\n=== Dynasty: " + getName() + " ===");
        System.out.println("Defense Level: " + defenseLevel);
        System.out.println("Technology Level: " + technologyLevel);
        System.out.println("Health Level: " + healthLevel + "%\n");

        System.out.println("Buildings:");
        if (buildings.isEmpty()) {
            System.out.println("  No buildings in this Dynasty.");
        } else {
            for (Building building : buildings) {
                building.print(); // Each Building's print() method
            }
        }

        System.out.println("\nVillagers:");
        if (villagers.isEmpty()) {
            System.out.println("  No villagers in this Dynasty.");
        } else {
            for (Villager villager : villagers) {
                villager.print(); // Each Villager's print() method
            }
        }
        System.out.println("====================================\n");
    }
}

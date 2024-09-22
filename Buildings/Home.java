// File: Buildings/Home.java
package Buildings;

import Territory.*;
import Villagers.*;
import java.util.List;
import java.util.ArrayList;

public class Home extends Building {
    private int capacity;
    private static final int FOOD_CONSUMPTION_PER_VILLAGER = 10;
    private int foodProduction;

    public Home(String name) {
        super(name);
        this.capacity = 5;
        this.foodProduction = 50; // Initial production covers 5 villagers
    }

    @Override
    public boolean assignVillager(Villager villager) {
        // Check if the home is at full capacity
        if (assignedVillagers.size() >= capacity) {
            System.out.println("Cannot assign villager. Home '" + getName() + "' is at full capacity.");
            return false;
        }
    
        // Check if the profession is limited to one per home
        if (villager instanceof Farmer || villager instanceof Merchant || villager instanceof Engineer
                || villager instanceof Scholar || villager instanceof Healer) {
            for (Villager v : assignedVillagers) {
                if (v.getClass().equals(villager.getClass())) {
                    System.out.println("Cannot assign villager. Home '" + getName() + "' already has a "
                            + villager.getClass().getSimpleName() + ".");
                    return false;  // Ensure that it returns false when the profession already exists
                }
            }
        }
    
        // Assign the villager to the home
        assignedVillagers.add(villager);
        villager.setAssignedBuilding(this);
        System.out.println(villager.getFirstName() + " has been assigned to " + this.getName() + ".");
    
        // Update food production if a Farmer is assigned
        if (villager instanceof Farmer) {
            this.foodProduction = 100; // Farmer increases food production to 100 units
        }
    
        return true; // Return true when assignment is successful
    }
    

    public int calculateNetFood() {
        int totalConsumption = assignedVillagers.size() * FOOD_CONSUMPTION_PER_VILLAGER;
        int netFood = foodProduction - totalConsumption;
        return netFood;
    }

    public void applyFoodEffects(Territory territory) {
        int netFood = calculateNetFood();
        if (netFood > 0) {
            // Increase health level based on surplus food
            territory.increaseHealthLevel(5); // Increase health level by 5%
            System.out.println("Home '" + getName() + "' has a food surplus. Health level increased.");
        } else {
            // No surplus; no effect on health level
            System.out.println("Home '" + getName() + "' has no food surplus.");
        }
    }

    @Override
    public void print() {
        System.out.println("  Home: " + getName() + " (Capacity: " + capacity + ")");
        if (assignedVillagers.isEmpty()) {
            System.out.println("    No villagers assigned.");
        } else {
            System.out.println("    Assigned Villagers:");
            for (Villager villager : assignedVillagers) {
                System.out.println("      - " + villager.getFirstName() + " " + villager.getLastName()
                        + " (" + villager.getClass().getSimpleName() + ")");
            }
        }
    }
}

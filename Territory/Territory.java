package Territory;


import Buildings.Building;
import Villagers.Villager;
import Villagers.Engineer;//enhances defense level
import Villagers.Scholar;//enhances technology level
import Villagers.Healer;//enhances health level
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Territory {
    protected String name;
    protected List<Building> buildings;
    protected List<Villager> villagers;

    protected int defenseLevel;
    protected int technologyLevel;
    protected int healthLevel;

    public Territory(String name) {
        this.name = name;
        this.buildings = new ArrayList<>();
        this.villagers = new ArrayList<>();
        this.defenseLevel = 1;
        this.technologyLevel = 1;
        this.healthLevel = 100;
    }

    public abstract void addBuilding(Building building);

    public abstract void printStructure();

    public void addVillager(Villager villager) {
        villagers.add(villager);
        applyVillagerEnhancement(villager);
    }

    protected void applyVillagerEnhancement(Villager villager) {
        if (villager instanceof Villagers.Engineer) {
            defenseLevel += 1;
            System.out.println("Defense level increased to " + defenseLevel);
        } else if (villager instanceof Villagers.Scholar) {
            technologyLevel += 1;
            System.out.println("Technology level increased to " + technologyLevel);
        } else if (villager instanceof Villagers.Healer) {
            healthLevel = Math.min(healthLevel + 10, 100);
            System.out.println("Health level increased to " + healthLevel + "%");
        }
    }

    public String getName() {
        return name;
    }

    public void attack(Territory enemy) {
        int attackPower = (this.technologyLevel + this.defenseLevel) * 10;
        System.out.println(this.getName() + " is attacking " + enemy.getName() + " with power " + attackPower);
        enemy.takeDamage(attackPower);
        if (enemy.isConquered()) {
            System.out.println(enemy.getName() + " has been conquered by " + this.getName());
        }
    }

    public void takeDamage(int damage) {
        healthLevel -= damage;
        if (healthLevel < 0) {
            healthLevel = 0;
        }
        System.out.println(getName() + " took " + damage + " damage. Health is now " + healthLevel + "%");

        // Chance to lose a building
        if (!buildings.isEmpty()) {
            int chance = new Random().nextInt(100);
            if (chance < 30) { // 30% chance to lose a building
                Building lostBuilding = buildings.remove(0); // Remove the first building
                System.out.println(getName() + " lost the building: " + lostBuilding.getName());
            }
        }
    }

    public boolean isConquered() {
        return healthLevel <= 0;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public List<Villager> getVillagers() {
        return villagers;
    }

    public List<Villager> getUnassignedVillagers() {
        List<Villager> unassigned = new ArrayList<>();
        for (Villager v : villagers) {
            if (v.getAssignedBuilding() == null) {
                unassigned.add(v);
            }
        }
        return unassigned;
    }
}

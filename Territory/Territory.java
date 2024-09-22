package Territory;


import Buildings.Building;
import Villagers.Villager;
// import Villagers.Engineer;//enhances defense level
// import Villagers.Scholar;//enhances technology level
// import Villagers.Healer;//enhances health level
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Territory {
    protected String name;
    protected int defenseLevel;
    protected int technologyLevel;
    protected int healthLevel; // in percentages
    protected int attackPower;
    protected int gold;
    protected List<Building> buildings;
    protected List<Villager> villagers;

 
    public Territory(String name) {
        this.name = name;
        this.defenseLevel = 0;
        this.technologyLevel = 0;
        this.healthLevel = 100;
        this.attackPower = 0;
        this.gold = 0;
        this.buildings = new ArrayList<>();
        this.villagers = new ArrayList<>();
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
        //alternatively:healthLevel = Math.max(healthLevel - damage, 0);
        System.out.println(getName() + " took " + damage + " damage. Health is now " + healthLevel + "%");

        // Chance to lose a building
        if (!buildings.isEmpty()) {
            Random rand = new Random();
            int chance = rand.nextInt(100);
            if (chance < 30) { // 30% chance to lose a building
                int buildingIndex=rand.nextInt(buildings.size());
                Building lostBuilding = buildings.remove(buildingIndex); // Remove a random building
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

    public void increaseDefenseLevel(int amount) {
        defenseLevel += amount;
    }

    public void increaseTechnologyLevel(int amount) {
        technologyLevel += amount;
    }

    public void increaseHealthLevel(int amount) {
        healthLevel = Math.min(healthLevel + amount, 100); // Cap at 100%
    }

    public void increaseAttackPower(int amount) {
        attackPower += amount;
    }

    public void addGold(int amount) {
        gold += amount;
    }

    public int getGold() {
        return gold;
    }
}

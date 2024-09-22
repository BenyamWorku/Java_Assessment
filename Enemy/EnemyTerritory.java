package Enemy;

import Territory.Territory;
import Villagers.Villager;
import Buildings.Building;
import java.util.ArrayList;
import java.util.Random;

public class EnemyTerritory extends Territory {

    public EnemyTerritory(String name) {
        super(name);
        // Initialise enemy-specific attributes
        defenseLevel = new Random().nextInt(3) + 1;
        technologyLevel = new Random().nextInt(3) + 1;
        healthLevel = 100;
        buildings = new ArrayList<>();
        villagers = new ArrayList<>();
        
    }

    @Override
    public void addBuilding(Building building) {
        buildings.add(building);
    }

    @Override
    public void printStructure() {
        // Optionally implement 
    }

    @Override
    public void addVillager(Villager villager) {
        villagers.add(villager);
    }

    public void takeTurn(Territory playerTerritory) {
        System.out.println("\nEnemy's turn:");
        Random rand = new Random();
        int action = rand.nextInt(2); // 0 or 1
        if (action == 0) {
            // Enemy attacks
            this.attack(playerTerritory);
            if (playerTerritory.isConquered()) {
                System.out.println("Your territory has been conquered by the enemy!");
                System.exit(0); // End the game
            }
        } else {
            // Enemy strengthens defenses
            this.defenseLevel += 1;
            System.out.println("Enemy territory has increased its defense level to " + this.defenseLevel);
        }
    }
}


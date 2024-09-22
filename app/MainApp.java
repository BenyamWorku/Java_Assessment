package app;
import Territory.*;
import Villagers.*;
import Buildings.*;
import Enemy.EnemyTerritory; // Import the EnemyTerritory class
import Utils.HelperFunctions;
import java.util.Scanner;
import java.util.Random;
import java.util.List;


public class MainApp {

    private static Territory playerTerritory;
    private static EnemyTerritory enemyTerritory;
    private static Random random = new Random();

    public static void main(String[] args) {
        createPlayerTerritory();
        boolean exit = false;
        while (!exit) {
            HelperFunctions.displayMainMenu();
            int choice = HelperFunctions.getValidatedIntegerInput(1, 7);
            switch (choice) {
                case 1:
                    addBuilding();
                    break;
                case 2:
                    addVillager();
                    break;
                case 3:
                    assignVillagerToBuilding();
                    break;
                case 4:
                    playerTerritory.printStructure();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting program.");
                    break;
                case 6:
                    attackEnemyTerritory();
                    break;
                case 7:
                    restartGame(); // Call the method to restart the game
                    break;    
                default:
                    break;
            }
        }
    }

    private static void createPlayerTerritory() {
        System.out.println("Choose territory type:");
        System.out.println("1: Kingdom");
        System.out.println("2: Dynasty");
        System.out.print("Enter choice: ");
        int choice = HelperFunctions.getValidatedIntegerInput(1, 2);
        String name = HelperFunctions.getNonEmptyStringInput("Enter name of territory: ");
        if (choice == 1) {
            playerTerritory = new Kingdom(name);
        } else if (choice == 2) {
            playerTerritory = new Dynasty(name);
        }
        System.out.println("Territory '" + playerTerritory.getName() + "' created.");
    }

   

    private static void addBuilding() {
        System.out.println("\nChoose building type:");
        System.out.println("1: Home");
        System.out.println("2: Forge");
        System.out.println("3: Barracks");
        System.out.print("Enter choice: ");
        int choice = HelperFunctions.getValidatedIntegerInput(1, 3);
        String name = HelperFunctions.getNonEmptyStringInput("Enter name of the building: ");
        Building building = null;
        switch (choice) {
            case 1:
                building = new Home(name);
                break;
            case 2:
                building = new Forge(name);
                break;
            case 3:
                building = new Barracks(name);
                break;
            default:
                return;
        }
        playerTerritory.addBuilding(building);
        System.out.println("Building '" + building.getName() + "' added to territory.");
    }

    private static void addVillager() {
        System.out.println("\nChoose villager profession:");
        System.out.println("1: Knight");
        System.out.println("2: Blacksmith");
        System.out.println("3: Farmer");
        System.out.println("4: Healer");
        System.out.println("5: Engineer");
        System.out.println("6: Scholar");
        System.out.println("7: Merchant");
        System.out.print("Enter choice: ");
        int choice = HelperFunctions.getValidatedIntegerInput(1, 7);
        String firstName = HelperFunctions.getNonEmptyStringInput("Enter first name: ");
        String lastName = HelperFunctions.getNonEmptyStringInput("Enter last name: ");
        System.out.print("Enter age: ");
        int age = HelperFunctions.getValidatedIntegerInput(0, 120);
        Villager villager = null;
        switch (choice) {
            case 1:
                villager = new Knight(firstName, lastName, age);
                break;
            case 2:
                villager = new Blacksmith(firstName, lastName, age);
                break;
            case 3:
                villager = new Farmer(firstName, lastName, age);
                break;
            case 4:
                villager = new Healer(firstName, lastName, age);
                break;
            case 5:
                villager = new Engineer(firstName, lastName, age);
                break;
            case 6:
                villager = new Scholar(firstName, lastName, age);
                break;
            case 7:
                villager = new Merchant(firstName, lastName, age);
                break;
            default:
                return;
        }
        playerTerritory.addVillager(villager);
        System.out.println("Villager '" + villager.getFirstName() + " " + villager.getLastName() + "' added to territory.");
    }

    private static void assignVillagerToBuilding() {
        if (playerTerritory.getBuildings().isEmpty()) {
            System.out.println("No buildings available. Please add a building first.");
            return;
        }
        if (playerTerritory.getUnassignedVillagers().isEmpty()) {
            System.out.println("No unassigned villagers available. Please add villagers first.");
            return;
        }

        // List unassigned villagers
        System.out.println("\nAvailable Villagers:");
        List<Villager> unassignedVillagers = playerTerritory.getUnassignedVillagers();
        for (int i = 0; i < unassignedVillagers.size(); i++) {
            Villager villager = unassignedVillagers.get(i);
            System.out.println((i + 1) + ": " + villager.getFirstName() + " " + villager.getLastName()
                    + " (" + villager.getClass().getSimpleName() + ")");
        }
        System.out.print("Enter the number of the villager to assign: ");
        int villagerChoice = HelperFunctions.getValidatedIntegerInput(1, unassignedVillagers.size());

        // List buildings
        System.out.println("\nAvailable Buildings:");
        List<Building> buildings = playerTerritory.getBuildings();
        for (int i = 0; i < buildings.size(); i++) {
            Building building = buildings.get(i);
            System.out.println((i + 1) + ": " + building.getName() + " (" + building.getClass().getSimpleName() + ")");
        }
        System.out.print("Enter the number of the building to assign to: ");
        int buildingChoice = HelperFunctions.getValidatedIntegerInput(1, buildings.size());

        // Retrieve the selected villager and building
        Villager selectedVillager = unassignedVillagers.get(villagerChoice - 1);
        Building selectedBuilding = buildings.get(buildingChoice - 1);

        // Assign the villager to the building
        boolean assignmentSuccessful=selectedBuilding.assignVillager(selectedVillager);
        if(assignmentSuccessful) {
             // Apply territory enhancements based on the villager's profession and building
            if (selectedVillager instanceof Knight && selectedBuilding instanceof Barracks) {
                playerTerritory.increaseDefenseLevel(10); // Each Knight adds 10 defense
                System.out.println("Defense level increased by 10.");
            } else if (selectedVillager instanceof Blacksmith && selectedBuilding instanceof Forge) {
                playerTerritory.increaseAttackPower(50); // Each Blacksmith adds 50 attack power
                System.out.println("Attack power increased by 50.");
            } else if (selectedVillager instanceof Engineer && selectedBuilding instanceof Home) {
                playerTerritory.increaseDefenseLevel(5); // Engineer adds 5 defense
                System.out.println("Defense level increased by 5 due to Engineer.");
            } else if (selectedVillager instanceof Scholar && selectedBuilding instanceof Home) {
                playerTerritory.increaseTechnologyLevel(5); // Scholar adds 5 technology
                System.out.println("Technology level increased by 5 due to Scholar.");
            } else if (selectedVillager instanceof Healer && selectedBuilding instanceof Home) {
                playerTerritory.increaseHealthLevel(5); // Healer adds 5% health
                System.out.println("Health level increased by 5% due to Healer.");
            } else if (selectedVillager instanceof Merchant && selectedBuilding instanceof Home) {
                int goldGenerated = random.nextInt(51) + 50; // Generates between 50 and 100 gold
                playerTerritory.addGold(goldGenerated);
                System.out.println("Merchant generated " + goldGenerated + " gold.");
            }


        } else {
            System.out.println("Failed to assign villager to the building.");
        }
       
        // For Homes, apply food effects
        if (selectedBuilding instanceof Home) {
            ((Home) selectedBuilding).applyFoodEffects(playerTerritory);
        }

        System.out.println("Assigned " + selectedVillager.getFirstName() + " to " + selectedBuilding.getName());
    }

    private static void attackEnemyTerritory() {
        if (enemyTerritory == null) {
            initializeEnemyTerritory();
        }
        playerTerritory.attack(enemyTerritory);
        if (enemyTerritory.isConquered()) {
            System.out.println("You have defeated the enemy territory!");
        } else {
            enemyTerritory.takeTurn(playerTerritory);
        }
    }

    private static void initializeEnemyTerritory() {
        enemyTerritory = new EnemyTerritory("Enemy Kingdom");
        System.out.println("An enemy territory has emerged: " + enemyTerritory.getName());
    }

    private static void restartGame(){
        //clears the current game state
        playerTerritory=null; // wipe clean player's territory
        enemyTerritory=null; // wipe clean enemy territory

        System.out.println("\nGame restarted. Please choose your new territory:");
        //Presnenting the initial territory selection menu again
        createPlayerTerritory();
    }   
    
    
}


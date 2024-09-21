package app;
import Territory.*;
import Villagers.*;
import Buildings.*;
import Enemy.EnemyTerritory; // Import the EnemyTerritory class
import Utils.HelperFunctions;
import java.util.Scanner;

public class MainApp {
    private static Scanner scanner = new Scanner(System.in);
    private static Territory playerTerritory;
    private static EnemyTerritory enemyTerritory;

    public static void main(String[] args) {
        createPlayerTerritory();
        boolean exit = false;
        while (!exit) {
            HelperFunctions.displayMainMenu();
            int choice = HelperFunctions.getValidatedIntegerInput(1, 6);
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
        System.out.print("Enter name of territory: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Name cannot be empty. Defaulting to 'Unnamed Territory'.");
            name = "Unnamed Territory";
        }
        if (choice == 1) {
            playerTerritory = new Kingdom(name);
        } else if (choice == 2) {
            playerTerritory = new Dynasty(name);
        }
        System.out.println("Territory '" + playerTerritory.getName() + "' created.");
    }

    // menu method moved to package Utils

    // Methods for adding buildings, villagers, assigning villagers, etc.

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

    // Utility method: getValidatedIntegerInput() moved to package Utils
   

    private static void addBuilding() {
        System.out.println("\nChoose building type:");
        System.out.println("1: Home");
        System.out.println("2: Forge");
        System.out.println("3: Barracks");
        System.out.print("Enter choice: ");
        int choice = HelperFunctions.getValidatedIntegerInput(1, 3);
        System.out.print("Enter name of the building: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Name cannot be empty. Building not added.");
            return;
        }
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
                // This case should not occur due to validation
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
        int choice = HelperFunctions.getValidatedIntegerInput(1, 6);
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine().trim();
        if (firstName.isEmpty()) {
            System.out.println("First name cannot be empty. Villager not added.");
            return;
        }
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine().trim();
        if (lastName.isEmpty()) {
            System.out.println("Last name cannot be empty. Villager not added.");
            return;
        }
        System.out.print("Enter age: ");
        int age = HelperFunctions.getValidatedIntegerInput(0, 120); // Assuming age between 0 and 120
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
                // This case should not occur due to validation
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
        int index = 1;
        java.util.List<Villager> unassignedVillagers = playerTerritory.getUnassignedVillagers();
        for (Villager villager : unassignedVillagers) {
            System.out.println(index + ": " + villager.getFirstName() + " " + villager.getLastName());
            index++;
        }
        System.out.print("Enter the number of the villager to assign: ");
        int villagerChoice = HelperFunctions.getValidatedIntegerInput(1, unassignedVillagers.size());

        // List buildings
        System.out.println("\nAvailable Buildings:");
        int bIndex = 1;
        java.util.List<Building> buildings = playerTerritory.getBuildings();
        for (Building building : buildings) {
            System.out.println(bIndex + ": " + building.getName());
            bIndex++;
        }
        System.out.print("Enter the number of the building to assign to: ");
        int buildingChoice = HelperFunctions.getValidatedIntegerInput(1, buildings.size());

        // Retrieve the selected villager and building
        Villager selectedVillager = unassignedVillagers.get(villagerChoice - 1);
        Building selectedBuilding = buildings.get(buildingChoice - 1);

        // Assign the villager to the building
        selectedBuilding.assignVillager(selectedVillager);
        System.out.println("Assigned " + selectedVillager.getFirstName() + " to " + selectedBuilding.getName());
    }

}


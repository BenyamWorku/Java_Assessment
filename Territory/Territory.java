package Territory;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import Villagers.*;

public class Territory {
    private String name;
    private List<Villager> villagers=new ArrayList<Villager>();

    public Territory(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n Name of territory: ");
        this.name=scanner.nextLine();
        System.out.print("How big is your territory i.e. number of villagers?: ");
        populateTerritory(Integer.parseInt(scanner.nextLine()));

    }

    private void populateTerritory(int iterations) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < iterations; i++) {
            System.out.println("\nSelect villager type:");
            System.out.println("1: Knight");
            System.out.println("2: Farmer");
            System.out.println("3: Merchant");
            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
    
            System.out.print("Enter first name: ");
            String fName = scanner.nextLine();
            System.out.print("Enter last name: ");
            String sName = scanner.nextLine();
            System.out.print("Enter age: ");
            int age = Integer.parseInt(scanner.nextLine());
    
            Villager villager = null;
            switch (choice) {
                case 1:
                    villager = new Knight(fName, sName, age);
                    break;
                case 2:
                    villager = new Farmer(fName, sName, age);
                    break;
                case 3:
                    villager = new Merchant(fName, sName, age);
                    break;
                default:
                    System.out.println("Invalid choice. Defaulting to Knight.");
                    villager = new Knight(fName, sName, age);
                    break;
            }
            this.villagers.add(villager);
        }
    }
    
    public String getName() {
        return name;
    }

    public List<Villager> getvillages() {
        return villagers;
    }

    public void printVillagers() {
        for (Villager v : this.villagers) {
            v.print();  // Polymorphic call
        }
    }
    
}


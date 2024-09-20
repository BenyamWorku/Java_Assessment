package Villagers;

import java.util.Scanner;

public class Farmer extends Villager {
    private String cropType;

    public Farmer(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
        selectCropType();
    }

    private void selectCropType() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter crop type: ");
        this.cropType = scanner.nextLine();
    }

    public String getCropType() {
        return cropType;
    }

    @Override
    public void print() {
        System.out.println("\n******************************");
        System.out.println("Farmer Details:");
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Age: " + getAge());
        System.out.println("Crop Type: " + getCropType());
        System.out.println("******************************");
    }
}


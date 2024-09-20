package Villagers;

import java.util.Scanner;

public class Merchant extends Villager {
    private String tradeGoods;

    public Merchant(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
        selectTradeGoods();
    }

    private void selectTradeGoods() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter trade goods: ");
        this.tradeGoods = scanner.nextLine();
    }

    public String getTradeGoods() {
        return tradeGoods;
    }

    @Override
    public void print() {
        System.out.println("\n******************************");
        System.out.println("Merchant Details:");
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Age: " + getAge());
        System.out.println("Trade Goods: " + getTradeGoods());
        System.out.println("******************************");
    }
}


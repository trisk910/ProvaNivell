package Presentation;

import java.util.Scanner;

public class MenuManager {
    public int showMainMenu() {
        System.out.println("Main Menu:");
        System.out.println("1. Create Product");
        System.out.println("2. List Products by Price");
        System.out.println("3. Remove Products");
        System.out.println("4. Calculate Expiring Warranty Date");
        System.out.println("5. Apply Discount");
        System.out.println("6. List Discounted Products");
        System.out.println("7. Check stock of a product");
        System.out.println("8. Add Stock to a product");
        System.out.println("9. Remove Stock from a product");
        System.out.println("0. Exit");
        return askForInt();
    }

    public int showProductMenu() {
        System.out.println("Create Product:");
        System.out.println("1. Appliance");
        System.out.println("2. Beauty");
        System.out.println("3. Cloth");
        System.out.println("4. Electronic Component");
        return askForInt();
    }

    public int showRemoveProductMenu() {
        System.out.println("Remove Product Type:");
        System.out.println("1. Appliance");
        System.out.println("2. Beauty");
        System.out.println("3. Cloth");
        System.out.println("4. Electronic Component");
        return askForInt();
    }

    private int askForInt() {
        Scanner scn = new Scanner(System.in);
        try {
            System.out.print("> ");
            int option = scn.nextInt();
            return option;
        } catch (Exception e) {
            return 0;
        }
    }
}

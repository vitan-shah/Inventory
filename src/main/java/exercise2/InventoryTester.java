package exercise2;

import java.util.ArrayList;
import java.util.Scanner;

public class InventoryTester {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        try {
            Item item1 = new Item(1, "Widget", 50, 10, 500.99);
            Item item2 = new Item(2, "Gadget", 30, 8, 120.49);
            Item item3 = new Item(3, "Accessory", 20, 5, 200.99);

            inventory.addItem(item1);
            inventory.addItem(item2);
            inventory.addItem(item3);

            boolean exit = false;

            while (!exit) {
                System.out.println("1. Show all items");
                System.out.println("2. Add stock to an item");
                System.out.println("3. Withdraw stock from an item");
                System.out.println("4. Show items under stock");
                System.out.println("5. Show total inventory cost");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Items in Inventory:");
                        ArrayList<Item> items = inventory.getAllItems();
                        for (Item item : items) {
                            System.out.println(item.getItemCode() + " " + item.getItemDescription());
                        }
                        break;
                    case 2:
                        System.out.print("Enter item code to add stock: ");
                        int itemCodeToAddStock = scanner.nextInt();
                        System.out.print("Enter quantity to add: ");
                        int qtyToAdd = scanner.nextInt();
                        inventory.addStock(itemCodeToAddStock, qtyToAdd);
                        System.out.println("Stock added successfully!");
                        break;
                    case 3:
                        System.out.print("Enter item code to withdraw stock: ");
                        int itemCodeToWithdrawStock = scanner.nextInt();
                        System.out.print("Enter quantity to withdraw: ");
                        int qtyToWithdraw = scanner.nextInt();
                        inventory.withdrawStock(itemCodeToWithdrawStock, qtyToWithdraw);
                        System.out.println("Stock withdrawn successfully!");
                        break;
                    case 4:
                        ArrayList<Item> underStockItems = inventory.getItemsUnderStock();
                        if (!underStockItems.isEmpty()) {
                            System.out.println("Under Stock Items:");
                            for (Item item : underStockItems) {
                                System.out.println(item);
                            }
                        } else {
                            System.out.println("No items are currently under stock.");
                        }
                        break;
                    case 5:
                        double totalInventoryCost = inventory.totalInventoryCost();
                        System.out.println("Total Inventory Cost: $" + totalInventoryCost);
                        break;
                    case 6:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }

                System.out.println();
            }

        } catch (ItemAlreadyExists | ItemNotFound | InsufficientStock e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

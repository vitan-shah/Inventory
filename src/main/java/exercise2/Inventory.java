package exercise2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<Integer, Item> items;

    public Inventory() {
        items = new HashMap<>();
    }

    public Item getItem(int itemno) throws ItemNotFound {
        Item item = items.get(itemno);
        if (item == null) {
            throw new ItemNotFound("Item not found with item code: " + itemno);
        }
        return new Item(item.getItemCode(), item.getItemDescription(), item.getStock(), item.getMinQty(), item.getCost());
    }

    public void addItem(Item item1) throws ItemAlreadyExists {
        if (items.containsKey(item1.getItemCode())) {
            throw new ItemAlreadyExists("Item with item code " + item1.getItemCode() + " already exists.");
        }
        items.put(item1.getItemCode(), item1);
    }

    public void updateItem(Item item) throws ItemNotFound {
        if (!items.containsKey(item.getItemCode())) {
            throw new ItemNotFound("Item not found with item code: " + item.getItemCode());
        }
        items.put(item.getItemCode(), item);
    }

    public void addStock(int item_code, int qty) throws ItemNotFound {
        Item item = items.get(item_code);
        if (item == null) {
            throw new ItemNotFound("Item not found with item code: " + item_code);
        }
        item.addStock(qty);
    }

    public void withdrawStock(int item_code, int qty) throws ItemNotFound, InsufficientStock {
        Item item = items.get(item_code);
        if (item == null) {
            throw new ItemNotFound("Item not found with item code: " + item_code);
        }

        item.withdrawStock(qty);
    }

    public void deleteItem(int item_code) throws ItemNotFound {
        if (!items.containsKey(item_code)) {
            throw new ItemNotFound("Item not found with item code: " + item_code);
        }
        items.remove(item_code);
    }

    public ArrayList<Item> getAllItems() {
        return new ArrayList<>(items.values());
    }

    public ArrayList<Item> getItemsUnderStock() {
        ArrayList<Item> underStockItems = new ArrayList<>();
        for (Item item : items.values()) {
            if (item.isUnderStock()) {
                underStockItems.add(item);
            }
        }
        return underStockItems;
    }

    public double totalInventoryCost() {
        double totalCost = 0;
        for (Item item : items.values()) {
            totalCost += item.getCost() * item.getStock();
        }
        return totalCost;
    }

	public void addItem1(exercise2.Item item1) {
		// TODO Auto-generated method stub
		
	}
}

package exercise2;

public class Item {
    private int item_code;
    private String description;
    private int qty_in_stock;
    private int min_qty_in_stock;
    private double cost;

    // Constructors
    public Item(int code, String description, int qty, int min_qty, double cost) {
        this.item_code = code;
        this.description = description;
        this.qty_in_stock = qty;
        this.min_qty_in_stock = min_qty;
        this.cost = cost;
    }

    public Item(int code, String description, double cost) {
        this(code, description, 0, 0, cost);
    }

    // Methods
    public int getItemCode() {
        return item_code;
    }

    public String getItemDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getStock() {
        return qty_in_stock;
    }

    public int getMinQty() {
        return min_qty_in_stock;
    }

    public void addStock(int qty) {
        qty_in_stock += qty;
    }

    public void withdrawStock(int qty) throws InsufficientStock {
        if (qty_in_stock < qty) {
            throw new InsufficientStock("Insufficient stock to withdraw.");
        }
        qty_in_stock -= qty;
    }

    public boolean isUnderStock() {
        return qty_in_stock < min_qty_in_stock;
    }
}


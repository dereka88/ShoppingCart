package ShoppingCart;

//Implementation of the class ItemToPurchase
public class ItemToPurchase {
    // Private fields
    private String itemDescription;
    private String name;
    private double itemPrice;
    private int itemQuantity;

    // default constructor
    public ItemToPurchase() {
        // string itemDescription
        // Initialized in default constructor to "none"
        itemDescription = "none";
        itemQuantity = 0;
        itemPrice = 0;
        name = "";
    }

    /* Parameterized constructor to assign item name,
     item description, item price, and item quantity */
    public ItemToPurchase(String name, String description, double price, int itemQuantity) {
        this.itemDescription = description;
        this.name = name;
        this.itemPrice = price;
        this.itemQuantity = itemQuantity;
    }

    // getDescription() accessor
    public String getDescription() {
        return itemDescription;
    }

    // setDescription() mutator
    public void setDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    // printItemCost() - Outputs the item name
    // followed by the quantity, price, and sub total
    public void printCost() {
        System.out.println(name + " " + itemQuantity + " @ " + itemPrice + " = $" + (itemQuantity * itemPrice));
    }

    // definition of the method printDescription
    public void printDescription() {
        System.out.println(name + " " + itemDescription);
    }

    // printItemDescription() -
    // Outputs the item name and description
    public String getName() {
        return name;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    // getters
    public double getPrice() {
        return itemPrice;
    }

    public void setPrice(double itemPrie) {
        this.itemPrice = itemPrie;
    }

    public int getQuantity() {
        return itemQuantity;
    }
}


package ShoppingCart;

import java.util.ArrayList;

//Implementation of the class ShoppingCart
class ShoppingCart {
    // Private fields
    private String customerName;
    private String currentDate;
    ArrayList<ItemToPurchase> cartItems = new ArrayList<ItemToPurchase>();

    // default constructor
    public ShoppingCart() {
        // String currentDate -
        // Initialized in default constructor to "January 1, 2016"
        currentDate = "January 1, 2016";
        // String customerName -
        // Initialized in default constructor to "none"
        customerName = "none";
    }

    /* Parameterized constructor which takes
     the customer name and date as parameters */
    public ShoppingCart(String name, String date) {
        this.currentDate = date;
        this.customerName = name;
    }

    // getCustomerName() accessor
    public String getCustomerName() {
        return customerName;
    }

    // setters
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    // getDate() accessor
    public String getDate() {
        return currentDate;
    }

    // setters
    public void setDate(String currentDate) {
        this.currentDate = currentDate;
    }

    // Adds an item to cartItems array
    // Has parameter ItemToPurchase
    public void addItem(ItemToPurchase i) {
        cartItems.add(i);
    }// Does not return anything

    // Removes item from cartItems array.
    // Has a string (an item's name) parameter.
    public void removeItem(String name) {
        boolean found = false;
        for (ItemToPurchase i : cartItems) {
            if (i.getName().equalsIgnoreCase(name)) {
                cartItems.remove(i);
                found = true;
                break;
            }
        }
        // If item name cannot be found
        if (!found) {
            // output this message: Item not found in cart.
            System.out.println("Item not found in cart. Nothing removed");
        }
    }

    // Modifies an item's description, price, and/or quantity.
    // Has parameter ItemToPurchase.
    public void modifyItem(ItemToPurchase item) {
        boolean found = false;
        for (ItemToPurchase i : cartItems) {
            if (i.getName().equalsIgnoreCase(item.getName())) {
                if (i.getQuantity() != 0) {
                    i.setQuantity(item.getQuantity());
                }
                found = true;
                break;
            }
        }
        // If not found, modify item in cart.
        if (!found) {
            // If item cannot be found (by name) in cart, output this message:
            System.out.println("Item not found in cart. Nothing modified");
            System.out.println();
            System.out.println(
                    "MENU\na - Add item to cart\n" + "d - Remove item from cart\n" + "c - Change item quantity\n"
                            + "i - Output items' descriptions\n" + "o - Output shopping cart\n" + "q - Quit\n");
        }
    }

    // Definition of the method getNumItemsInCart
    // Returns quantity of all items in cart. Has no parameters
    public int getNumItemsInCart() {
        int sum = 0;
        for (ItemToPurchase i : cartItems) {
            sum = sum + i.getQuantity();
        }
        return sum;
    }

    // Definition if the method getCostOfCart
    // Determines and returns the total cost of items in cart.
    public double getCostOfCart() {
        double sum = 0;
        for (ItemToPurchase i : cartItems) {
            sum = sum + i.getPrice() * i.getQuantity();
        }
        return sum;
    }

    // Definition of the method to print total
    // Outputs total of objects in cart.
    // Definition of the method to print total
    // Outputs total of objects in cart.
    public void printTotal() {
        int sum = 0;
        if (cartItems != null && cartItems.size() > 0) {
            System.out.println(customerName + "'s Shopping Cart - " + currentDate);
            System.out.println("Number of Items: " + getNumItemsInCart());
            System.out.println();
            for (ItemToPurchase i : cartItems) {
                i.printCost();
            }
            System.out.println("\nTotal: $" + getCostOfCart());
        }
        // If cart is empty, output this message: SHOPPING CART IS EMPTY
        else {
            System.out.println("OUTPUT SHOPPING CART\n" + customerName + "'s Shopping Cart - " + currentDate
                    + "\nNumber of items: 0\n" + "\nSHOPPING CART IS EMPTY\nTotal: $0\n");
        }
    }

    // Definition of the method printDescriptions
    // printDescriptions() Outputs each item's description.
    public void printDescriptions() {
        System.out.println(customerName + "'s Shopping Cart - " + currentDate);
        System.out.println();
        System.out.println("Item Descriptions");
        for (ItemToPurchase i : cartItems) {
            i.printDescription();
        }
    }
}



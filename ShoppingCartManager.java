package ShoppingCart;

//import the packages

import java.util.Scanner;

//implementation of the class ShoppingCartManager
public class ShoppingCartManager {
    // main method
    public static void main(String[] args) {
        // Create an object
        Scanner scnr = new Scanner(System.in);
        // Prompt and read the customer name from the user
        System.out.println("Enter Customer's Name:");
        String customerName = scnr.nextLine();
        // Prompt and read the today's date
        System.out.println("Enter Today's Date:");
        String currentDate = scnr.nextLine();
        ShoppingCart s = new ShoppingCart(customerName, currentDate);
        System.out.println();
        // Display the customer name and date
        System.out.println("Customer Name: " + s.getCustomerName());
        System.out.println("Today's Date: " + currentDate);
        System.out.println();
        printMenu(s);

    }

    // Implement the printMenu() method. printMenu()
    // has a ShoppingCart parameter
    public static void printMenu(ShoppingCart s) {
        // If the an invalid character is entered,
        // continue to prompt for a valid choice.
        // Outputs a menu of options to manipulate the shopping cart.
        System.out.println("MENU\na - Add item to cart\n" + "d - Remove item from cart\n" + "c - Change item quantity\n"
                + "i - Output items' descriptions\n" + "o - Output shopping cart\n" + "q - Quit");
        System.out.println();
        while (true) {
            System.out.println("Choose an option:");
            // create an object
            Scanner scan = new Scanner(System.in);
            char ch = scan.next().charAt(0);
            scan.nextLine();
            // Check the choice is a or A, then add item into the cart
            if (ch == 'a' || ch == 'A') {
                // prompt and read the item name
                System.out.println("ADD ITEM TO CART");
                System.out.println("Enter Item Name: ");
                System.out.println("Enter Item Description: ");
                System.out.println("Enter Item Price: ");
                System.out.println("Enter Item Quantity: ");
                String name = scan.nextLine();
                // prompt and read the item Description
                String itemDescription = scan.nextLine();
                // prompt and read the item Price
                int itemPrice = scan.nextInt();
                // prompt and read the item Quantity
                int quantity = scan.nextInt();
                scan.nextLine();
                ItemToPurchase item = new ItemToPurchase(name, itemDescription, itemPrice, quantity);
                s.addItem(item);
                System.out.println();
                printMenu(s);
            }
            // Check the choice d or D then delete item from cart
            else if (ch == 'd' || ch == 'D') {
                System.out.println("REMOVE ITEM FROM CART");
                System.out.print("Enter name of item to remove: ");
                String name = scan.nextLine();
                // call the method removeItem
                s.removeItem(name);
                System.out.println();
                System.out.println("MENU\na - Add item to cart\n" + "d - Remove item from cart\n" + "c - Change item quantity\n"
                        + "i - Output items' descriptions\n" + "o - Output shopping cart\n" + "q - Quit");
                System.out.println();
            }

            // Check the choice is c or C. then change
            // Item Quantity into the list
            else if (ch == 'c' || ch == 'C') {
                System.out.println("CHANGE ITEM QUANTITY");
                System.out.println("Enter the item name: ");
                String name = scan.nextLine();
                System.out.println("Enter the new quantity: ");
                int quantity = scan.nextInt();
                ItemToPurchase item = new ItemToPurchase();
                item.setName(name);
                item.setQuantity(quantity);
                // call the method modifyItem
                s.modifyItem(item);
            }
            // Check the choice is i or I, then output item descriptions
            else if (ch == 'I' || ch == 'i') {
                System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
                // call the method printDescriptions
                s.printDescriptions();
            }

            // Check the choice is o or O, then output items
            else if (ch == 'O' || ch == 'o') {
                // call the method printTotal
                s.printTotal();
                System.out.println();
                System.out.println("MENU\na - Add item to cart\n" + "d - Remove item from cart\n" + "c - Change item quantity\n"
                        + "i - Output items' descriptions\n" + "o - Output shopping cart\n" + "q - Quit");
                System.out.println();
            } else if (ch != 'q' || ch != 'Q' || ch != 'o' || ch != 'O' || ch != 'o' ||
                    ch != 'c' || ch != 'C' || ch != 'd' || ch != 'D' || ch != 'a' || ch != 'A' || ch != 'i'
                    || ch != 'I') {
                System.out.println("Choose an option:");
            }
            // Check the choice is q or Q, then quit from the program
            else if (ch == 'q' || ch == 'Q') {
                break;
            }
        }
    }
}


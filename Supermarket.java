package task5;

import java.util.Scanner;

public class Supermarket {
    public static void main(String[] args) {
        SupermarketFacade facade = new SupermarketFacade();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a command\n==add Product: 1==\n==update Quantity: 2==\n==update Price: 3==\n==remove Product: 4==\n==calculate Total: 5==\n==set Discount: 6==\n==show Product: 7==\n==Enter exit to exit: ==");
            String input = scanner.nextLine();
            String[] inputs = input.split(" ");
            String command = inputs[0];

            try {
                switch (command) {
                    case "1":
                        String name = inputs[1];
                        System.out.println("Adding a product!");
                        double price = Double.parseDouble(inputs[2]);
                        facade.addProductToCatalog(name, price);
                        System.out.println("Product added to catalog successfully!");
                        break;
                    case "2":
                        name = inputs[1];
                        int quantity = Integer.parseInt(inputs[2]);
                        facade.updateProductQuantityInAccount(name, quantity);
                        System.out.println("Product quantity updated successfully!");
                        break;
                    case "3":
                        name = inputs[1];
                        price = Double.parseDouble(inputs[2]);
                        facade.updateProductPriceInCatalog(name, price);
                        System.out.println("Product price updated successfully!");
                        break;
                    case "4":
                        name = inputs[1];
                        facade.removeProductFromAccount(name);
                        System.out.println("Product removed successfully!");
                        break;
                    case "5":
                        System.out.println("Total: " + facade.getTotalBill());
                        break;
                    case "6":
                        double discount = Double.parseDouble(inputs[1]);
                        facade.setDiscount(discount);
                        System.out.println("Discount set successfully!");
                        break;
                    case "7":
                        System.out.println("All products: " + facade.getAllProduct() );
                        break;
                    case "exit":
                        System.exit(0);
                    default:
                        System.out.println("Invalid command!");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

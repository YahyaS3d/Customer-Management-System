OOD EX5 - Customer Manager System for supermarkets 
CREATED BY: Yahya Saad 
==Description==
The program show a system to manage every customer in a supermarket, with a full options of adding/deleting/ modifying a specific product 
==Design Pattern== 
The facade design pattern is a design pattern that provides a simplified interface to a complex system of classes. It acts as an intermediary between the client and the complex system, providing a simplified and unified API for the client to interact with the system. The client interacts with the facade class, which in turn interacts with the underlying classes to perform the required operations.
how does this design pattern reflect in my program: 
This pattern is often used in situations where a system has a large number of classes, or where the classes have complex interactions. By using a facade, you can simplify the interactions between the client and the system and make it easier for the client to use the system 
==Files== 
-Catalog.java
This class represents a catalog of supermarket products, it contains a HashMap of products with their names as keys and their prices as values. The class provides the following functionality:
Adding a product to the catalog: This is done by calling the addProduct(String name, double price) method, which adds a product to the catalog with the provided name and price.
Retrieving the price of a product: This is done by calling the getPrice(String name) method, which takes the name of a product as an input and returns its price.
Updating the price of a product: This is done by calling the updatePrice(String name, double price) method, which takes the name of a product and its new price as inputs and updates the price in the catalog.
-Account.java
This class represents an account in a supermarket, it contains a HashMap of products with their names as keys and their quantities as values. The class provides the following functionality:

Adding a product to the account: This is done by calling the addProduct(String name, int quantity) method, which adds a product to the account with the provided name and quantity.
Updating the quantity of a product: This is done by calling the updateQuantity(String name, int quantity) method, which takes the name of a product and its new quantity as inputs and updates the quantity in the account.
Removing a product from the account: This is done by calling the removeProduct(String name) method, which takes the name of a product as an input and removes it from the account.
Calculating the total bill: This is done by calling the calculateTotal() method, which calculates and returns the total bill of the products in the account.
Calculating the number of different products in the account: This is done by calling the getDifferentProductsCount() method, which returns the number of different products in the account.
Displaying the quantity of a specific item: This is done by calling the getProductQuantityInAccount(String name) method, which takes the name of a product as an input and returns its quantity in the account.

-SupermarketFacade.java
This class is a facade class, which provides a simplified and unified interface to interact with the Catalog and Account classes. It has a reference to both the Catalog and Account classes and provides the following functionality:

Adding a product to the catalog: This is done by calling the addProduct(String name, double price) method, which adds a product to the catalog with the provided name and price.
Retrieving the price of a product: This is done by calling the getPrice(String name) method, which takes the name of a product as an input and returns its price.
Updating the price of a product: This is done by calling the updatePrice(String name, double price) method, which takes the name of a product and its new price as inputs and updates the price in the catalog.
Adding a product to the account: This is done by calling the addProductToAccount(String name, int quantity) method, which adds a product to the account with the provided name and quantity.
Updating the quantity of a product: This is done by calling the updateQuantityInAccount(String name, int quantity) method, which takes the name of a product and its new quantity as inputs and updates the quantity in the account.
Removing a product from the account: This is done by calling the removeProductFromAccount(String name) method, which takes the name of a product as an input and removes it from the account.
Calculating the total bill: This is done by calling the calculateTotal() method, which calculates and returns the total bill of the products in the account.
Setting a global discount: This is done by calling the setDiscount(double discount) method, which takes the discount value as an input and sets it as the global discount.
Getting the number of different products in the account: This is done by calling the getDifferentProductsCount() method, which returns the number of different products in the account.
Getting the quantity of a specific item: This is done by calling the getProductQuantityInAccount(String name) method, which takes the name of a product as an input and returns its quantity in the account.
Getting all product : This is done by calling the getAllProduct() method, which returns the string representation of the products HashMap in the catalog class.

-Supermarket.java
This is the main class of the program, it provides a command-line interface for the user to interact with the SupermarketFacade class. The user can enter different commands such as addProduct, updateQuantity, updatePrice, removeProduct, calculateTotal, setDiscount, showProduct and exit. The program will execute the corresponding action and display the result.

-AccountTest.java
This class contains JUnit test cases for the Account class, it tests the functionality of the class by creating test instances of the class and calling its methods to check for expected results. The class contains the following test cases:

Comparing the amount of the bill containing 3 products to the expected value
Checking that an empty account gives an amount of 0
Adding and removing an item gives an empty account
Adding 2 products to an empty account gives 2 products in the account
Check that the number of different products in the order is correct
Changing the quantity for a certain item twice and checking that the quantity is equal to the last update

Displaying a quantity (0) for an item that does not exist in the account
Checking that the total amount of the bill comes out half after 50% discount
These test cases cover most of the functionality provided by the Account class and ensure that the class works as expected. By running these test cases, developers can quickly identify any bugs or errors in the class and fix them before the program is deployed.

-README.txt 
-testProgram.txt 
An example to run the program 

==Classes flow and design== 
+----------------+      +----------------+
|  Catalog       |<>----| SupermarketFacade |
+----------------+      +----------------+
                  
+----------------+      +----------------+
|  Account        |<>----| SupermarketFacade |
+----------------+      +----------------+

+----------------+
| Supermarket    |
+----------------+
    |
    |  uses
    |
+----------------+
| SupermarketFacade |
+----------------+

+----------------+
| AccountTest     |
+----------------+
    |
    |  tests
    |
+----------------+
|  Account        |
+----------------+
The above diagram shows that the Catalog class, Account class and SupermarketFacade class are associated with each other and the SupermarketFacade class is aggregated with the Catalog class and the Account class. Also, Supermarket class uses SupermarketFacade class and AccountTest class tests Account class.

==Flow chart: how does the program works?==
                                   +-------------+
                                   |  Main Class |
                                   +-------------+
                                            |
                                            |
                                            |
                                   +----------------+
                                   | SupermarketFacade |
                                   +----------------+
                                            |
                                            |
                                            |
                                   +----------------+
                                   |      Catalog    |
                                   +----------------+
                                            |
                                            |
                                            |
                                   +----------------+
                                   |     Account      |
                                   +----------------+

                                  
The program starts with the main class, which displays a menu of options for the user to choose from.
The user inputs a command (a number from 1-7 and exit) to proceed a functions such as addProduct, updateQuantity, updatePrice, removeProduct, calculateTotal, setDiscount, showProduct, getDifferentProductsCount, getProductQuantityInAccount or exit the program.
The main class passes the command and its parameters to the SupermarketFacade class, which acts as a facade to the Catalog and Account classes.
The SupermarketFacade class performs the corresponding action, such as adding a product to the catalog, updating the quantity of a product in the account, or calculating the total bill.
The SupermarketFacade class returns the result of the action to the main class, which displays it to the user.
The program loops back to step 2, allowing the user to input another command.
If the user inputs the exit command, the program ends.

==Run the program==
To run the program, you will need to have the Java Development Kit (JDK) and an IDE (Integrated Development Environment) such as Eclipse or IntelliJ IDEA installed on your machine.

Here are the general steps to run the program:

Open your IDE and create a new Java project.
In the project, create a new package for your classes.
In the package, create the main class, SupermarketFacade class, Catalog class, Account class and AccountTest class, and add the code for each class that you have developed.
Make sure that the main class has a main method that serves as the entry point for the program.
Compile the program by clicking on the "Build" or "Compile" button in your IDE.
Run the program by clicking on the "Run" button in your IDE or by using the command line, this will launch the program and the menu will be displayed in the console.
Once the program is running, you can interact with it by entering the commands that you want to execute.
Once you're done, you can exit the program by entering the "exit" command or by closing the console window.

==Test== 
 use the JUnit test class by running the test cases by clicking on the "Run as JUnit Test"
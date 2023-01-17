package task5;
class SupermarketFacade {
private Catalog catalog;
private Account account;
public SupermarketFacade() {
    catalog = new Catalog();
    account = new Account(catalog);
}

public void addProductToCatalog(String name, double price) throws Exception {
    catalog.addProduct(name, price);
}

public void addProductToAccount(String name, int quantity) throws Exception {
    account.addProduct(name, quantity);
}

public void removeProductFromAccount(String name) throws Exception {
    account.removeProduct(name);
}

public void updateProductQuantityInAccount(String name, int newQuantity) throws Exception {
    account.updateQuantity(name, newQuantity);
}

public void updateProductPriceInCatalog(String name, double newPrice) throws Exception {
    account.updatePrice(name, newPrice);
}

public double getTotalBill() {
    return account.calculateTotal();
}

public int getDifferentProductsCount() {
    return account.countDifferentProducts();
}

public int getProductQuantityInAccount(String name) throws Exception {
    return account.getQuantity(name);
}

public void setDiscount(double discount) throws Exception {
    account.setDiscount(discount);
}

public String getAllProduct() {
    return catalog.products.toString();

}
}
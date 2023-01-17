package task5;

import java.util.HashMap;
import java.util.Map;

class Account {
    private HashMap<String, Integer> items;
    private Catalog catalog;
    private double discount;

    public Account(Catalog catalog) {
        items = new HashMap<String, Integer>();
        this.catalog = catalog;
        discount = 0;
    }
    

    public void addProduct(String name, int quantity) throws Exception {
        double price = catalog.getPrice(name);
        if (items.containsKey(name)) {
            quantity += items.get(name);
        }
        items.put(name, quantity);
    }

    public void updateQuantity(String name, int newQuantity) throws Exception {
        if (!items.containsKey(name)) {
            throw new Exception("Product not found in account");
        }
        items.put(name, newQuantity);
    }

    public void updatePrice(String name, double newPrice) throws Exception {
        if (!(catalog.getPrice(name)==(newPrice))) {
            catalog.addProduct(name, newPrice);
        }
    }

    public void removeProduct(String name) throws Exception {
        if (!items.containsKey(name)) {
            throw new Exception("Product not found in account");
        }
        items.remove(name);
    }

    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            try {
                total += catalog.getPrice(entry.getKey()) * entry.getValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        total = total - (total * discount);
        return total;
    }

    public int countDifferentProducts() {
        return items.size();
    }

    public int getQuantity(String name) throws Exception {
        if (!items.containsKey(name)) {
            throw new Exception("Product not found in account");
        }
        return items.get(name);
    }

    public void setDiscount(double discount) throws Exception {
        if(discount < 0 || discount > 1) {
            throw new Exception("Invalid discount value. It should be between 0 and 1.");
        }
        this.discount = discount;
    }
}

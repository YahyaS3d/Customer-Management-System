package task5;

import java.util.HashMap;

class Catalog {
    HashMap<String, Double> products;

    public Catalog() {
        products = new HashMap<String, Double>();
    }

    public void addProduct(String name, double price) throws Exception {
        if (products.containsKey(name)) {
            throw new Exception("Product already exists in catalog");
        }
        products.put(name, price);
    }

    public double getPrice(String name) throws Exception {
        if (!products.containsKey(name)) {
            throw new Exception("Product does not exist in catalog");
        }
        return products.get(name);
    }
}

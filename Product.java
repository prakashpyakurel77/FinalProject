package Project;

import java.util.*;
import java.util.stream.*;

abstract class Product {
    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public abstract String getCategory();
}

class Electronics extends Product {
    public Electronics(String name, double price) {
        super(name, price);
    }
    public String getCategory() { return "Electronics"; }
}

class Clothing extends Product {
    public Clothing(String name, double price) {
        super(name, price);
    }
    public String getCategory() { return "Clothing"; }
}

class Grocery extends Product {
    public Grocery(String name, double price) {
        super(name, price);
    }
    public String getCategory() { return "Grocery"; }
}

abstract class User {
    protected String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() { return username; }
}

class Customer extends User {
    public Customer(String username) {
        super(username);
    }
}

class Admin extends User {
    public Admin(String username) {
        super(username);
    }
}

// Order class
class Order {
    private Customer customer;
    private List<Product> products;

    public Order(Customer customer) {
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotal() {
        double subtotal = products.stream().mapToDouble(Product::getPrice).sum();
        double tax = 0.08 * subtotal;
        double shipping = 5.0;
        return subtotal + tax + shipping;
    }

    public List<Product> getProducts() { return products; }
}



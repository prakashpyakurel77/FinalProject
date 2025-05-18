package Project;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ECommercePlatform {
    public static void main(String[] args) {
        List<Product> catalog = Arrays.asList(
            new Electronics("Laptop", 2000.0),
            new Clothing("T-Shirt", 40.0),
            new Grocery("Apple", 2.0),
            new Electronics("Smartphone", 1200.0),
            new Grocery("Milk", 4.5)
        );

       
        List<Product> electronics = catalog.stream()
            .filter(p -> p.getCategory().equals("Electronics"))
            .collect(Collectors.toList());

        System.out.println("Electronics:");
        electronics.forEach(p -> System.out.println(p.getName() + " : $" + p.getPrice()));

        
        List<Product> sorted = catalog.stream()
            .sorted(Comparator.comparing(Product::getPrice))
            .collect(Collectors.toList());

        System.out.println("\nSorted by Price:");
        sorted.forEach(p -> System.out.println(p.getName() + " : $" + p.getPrice()));

        
        Customer customer = new Customer("prakassh_pyakurel");
        Order order = new Order(customer);
        order.addProduct(catalog.get(0)); 
        order.addProduct(catalog.get(1)); 

        double total = order.calculateTotal();
        System.out.printf("\nTotal Order Cost for %s: $%.2f\n", customer.getUsername(), total);
    }
}
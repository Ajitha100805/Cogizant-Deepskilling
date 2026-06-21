
import java.util.*;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    Product(int productId, String productName,
            int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String toString() {
        return "ID: " + productId +
               ", Name: " + productName +
               ", Quantity: " + quantity +
               ", Price: " + price;
    }
}

class Inventorymap {
    HashMap<Integer, Product> inventory = new HashMap<>();

    public void addProduct(Product product) {
        inventory.put(product.productId, product);
        System.out.println("Product Added");
    }

    public void updateProduct(int id,
                              int quantity,
                              double price) {

        if (inventory.containsKey(id)) {
            Product p = inventory.get(id);
            p.quantity = quantity;
            p.price = price;
            System.out.println("Product Updated");
        } else {
            System.out.println("Product Not Found");
        }
    }

    public void deleteProduct(int id) {

        if (inventory.remove(id) != null) {
            System.out.println("Product Deleted");
        } else {
            System.out.println("Product Not Found");
        }
    }

    public void displayProducts() {
        for(Product p : inventory.values()) {
            System.out.println(p);
        }
    }
}

public class Inventory {
    public static void main(String[] args) {

        Inventorymap inv = new Inventorymap();

        inv.addProduct(
            new Product(101, "Laptop", 20, 50000));

        inv.addProduct(
            new Product(102, "Mouse", 50, 500));

        System.out.println("\nInitial Inventory:");
        inv.displayProducts();

        inv.updateProduct(101, 25, 52000);

        inv.deleteProduct(102);

        System.out.println("\nFinal Inventory:");
        inv.displayProducts();
    }
}

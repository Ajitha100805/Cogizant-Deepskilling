
class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

public class Ecommerce_platform {
    public static void main(String[] args) {

        Product[] products = new Product[5];

        products[0] = new Product(101, "Laptop", "Electronics");
        products[1] = new Product(102, "Mouse", "Accessories");
        products[2] = new Product(103, "Keyboard", "Accessories");
        products[3] = new Product(104, "Monitor", "Electronics");
        products[4] = new Product(105, "Printer", "Electronics");

        int searchId = 104;

        int linearIndex = -1;

        for(int i = 0; i < products.length; i++) {
            if(products[i].productId == searchId) {
                linearIndex = i;
                break;
            }
        }

        if(linearIndex != -1)
            System.out.println("Linear Search: Product Found at Index " + linearIndex);
        else
            System.out.println("Linear Search: Product Not Found");

        int low = 0;
        int high = products.length - 1;
        int binaryIndex = -1;

        while(low <= high) {

            int mid = (low + high) / 2;

            if(products[mid].productId == searchId) {
                binaryIndex = mid;
                break;
            }

            if(searchId > products[mid].productId)
                low = mid + 1;
            else
                high = mid - 1;
        }

        if(binaryIndex != -1)
            System.out.println("Binary Search: Product Found at Index " + binaryIndex);
        else
            System.out.println("Binary Search: Product Not Found");
    }
}
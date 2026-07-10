import java.util.Arrays;
import java.util.Comparator;

public class SearchDemo {

    public static void main(String[] args) {

        // Sample catalog, deliberately kept unsorted by id since that's how
        // products usually get added to a list in real life
        Product[] products = {
                new Product(105, "Wireless Mouse", "Electronics"),
                new Product(101, "Bluetooth Speaker", "Electronics"),
                new Product(110, "Yoga Mat", "Fitness"),
                new Product(103, "Running Shoes", "Fitness"),
                new Product(108, "Coffee Maker", "Home Appliances"),
                new Product(102, "Desk Lamp", "Home Appliances"),
                new Product(107, "Backpack", "Accessories"),
                new Product(104, "Water Bottle", "Accessories"),
                new Product(109, "Notebook Set", "Stationery"),
                new Product(106, "Pen Drive 64GB", "Electronics")
        };

        int searchId = 108;

        // --- Linear search on the unsorted array ---
        System.out.println("---- Linear Search ----");
        long startLinear = System.nanoTime();
        Product foundLinear = LinearSearch.search(products, searchId);
        long endLinear = System.nanoTime();

        if (foundLinear != null) {
            System.out.println("Found: " + foundLinear);
        } else {
            System.out.println("Product not found.");
        }
        System.out.println("Time taken: " + (endLinear - startLinear) + " ns");

        // --- Binary search needs the array sorted by productId first ---
        Product[] sortedProducts = products.clone();
        Arrays.sort(sortedProducts, Comparator.comparingInt(Product::getProductId));

        System.out.println("\n---- Binary Search ----");
        long startBinary = System.nanoTime();
        Product foundBinary = BinarySearch.search(sortedProducts, searchId);
        long endBinary = System.nanoTime();

        if (foundBinary != null) {
            System.out.println("Found: " + foundBinary);
        } else {
            System.out.println("Product not found.");
        }
        System.out.println("Time taken: " + (endBinary - startBinary) + " ns");
    }
}
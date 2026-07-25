public class LinearSearch {

    // Goes through the array one item at a time until it finds a match.
    // Works fine on an unsorted array, but gets slow as the list grows.
    public static Product search(Product[] products, int targetId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductId() == targetId) {
                return products[i];
            }
        }
        return null;
    }
}
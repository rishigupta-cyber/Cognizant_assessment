public class BinarySearch {

    // Requires the array to already be sorted by productId.
    // Repeatedly cuts the search space in half instead of checking every item.
    public static Product search(Product[] sortedProducts, int targetId) {
        int low = 0;
        int high = sortedProducts.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midId = sortedProducts[mid].getProductId();

            if (midId == targetId) {
                return sortedProducts[mid];
            } else if (midId < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null; // not found
    }
}
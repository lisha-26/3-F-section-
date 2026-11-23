import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
    private List<Integer> prefixProducts;

    public ProductOfNumbers() {
        prefixProducts = new ArrayList<>();
        // Initialize with 1 to act as a neutral base for multiplication
        prefixProducts.add(1);
    }
    
    public void add(int num) {
        if (num == 0) {
            // Reset the list because any future product including this 0 will be 0
            prefixProducts = new ArrayList<>();
            prefixProducts.add(1);
        } else {
            // Multiply the new number by the last cumulative product
            int lastProduct = prefixProducts.get(prefixProducts.size() - 1);
            prefixProducts.add(lastProduct * num);
        }
    }
    
    public int getProduct(int k) {
        int n = prefixProducts.size();
        
        // If k is greater than or equal to the current non-zero streak,
        // a 0 must have occurred within the last k elements
        if (k >= n) {
            return 0;
        }
        
        // Divide the total product by the product right before the last k elements
        return prefixProducts.get(n - 1) / prefixProducts.get(n - 1 - k);
    }
}


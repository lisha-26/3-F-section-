import java.util.Arrays;

class Solution {
    public int totalNumbers(int[] digits) {
        // Step 1: Count the frequency of each digit in the input array
        int[] availableCounts = new int[10];
        for (int digit : digits) {
            availableCounts[digit]++;
        }
        
        int totalUniqueEvenNumbers = 0;
        
        // Step 2: Iterate through all valid 3-digit even numbers
        for (int num = 100; num <= 998; num += 2) {
            int hundreds = num / 100;
            int tens = (num / 10) % 10;
            int units = num % 10;
            
            // Temporarily decrement to simulate using the digits
            availableCounts[hundreds]--;
            availableCounts[tens]--;
            availableCounts[units]--;
            
            // Check if we had enough of each digit available
            if (availableCounts[hundreds] >= 0 && availableCounts[tens] >= 0 && availableCounts[units] >= 0) {
                totalUniqueEvenNumbers++;
            }
            
            // Backtrack/restore the original counts for the next iteration
            availableCounts[hundreds]++;
            availableCounts[tens]++;
            availableCounts[units]++;
        }
        
        return totalUniqueEvenNumbers;
    }
}

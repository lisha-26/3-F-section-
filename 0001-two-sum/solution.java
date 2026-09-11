import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Map to store: Key = number, Value = index
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // Check if the required complement already exists in the map
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            
            // Otherwise, add the current number and index to the map
            map.put(nums[i], i);
        }
        
        // Return empty array if no solution is found (guaranteed not to happen per constraints)
        return new int[] {};
    }
}

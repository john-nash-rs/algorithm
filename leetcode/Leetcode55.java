class Solution {
    
    public static boolean canJump(int[] nums) {
        int maxReach = 0; // Initialize the maximum index that can be reached

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                // If the current index cannot be reached, return false
                return false;
            }

            // Update the maximum index that can be reached
            maxReach = Math.max(maxReach, i + nums[i]);

            if (maxReach >= nums.length - 1) {
                // If the last index can be reached, return true
                return true;
            }
        }

        return true;
    }
}
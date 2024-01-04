class Solution {
    public  boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // If the sum is odd, it's not possible to partition into equal subsets
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        int n = nums.length;

        // dp[i][j] is true if there is a subset of the first i elements with sum equal to j
        boolean[][] dp = new boolean[n + 1][target + 1];

        // Base case: an empty subset can always achieve a sum of 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill the dp array using the 0/1 knapsack approach
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                // If the current element is greater than the target sum, exclude it
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Include or exclude the current element
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        // The final result is stored in the bottom-right cell of the dp array
        return dp[n][target];
    }

}

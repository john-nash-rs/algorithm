class Solution {
    
    public int rob(int[] nums) {
        int n = nums.length;
        
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return nums[0];
        }

        // dp array to store the maximum amount of money robbed up to each house
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // Iterate from the third house to the last house
        for (int i = 2; i < n; i++) {
            // Choose the maximum of robbing the current house or skipping it
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        // The final result is stored in the last element of the dp array
        return dp[n-1];
    }

}

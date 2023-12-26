class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        
        // Create an array to store the minimum cost to reach each step
        int[] dp = new int[n + 1];
        
        // Base cases: cost to reach the first and second steps
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        // Calculate the minimum cost for each step starting from the third step
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        
        // The minimum cost to reach the top floor is the minimum of the last two steps
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}

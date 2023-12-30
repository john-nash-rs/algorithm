class Solution {

    public boolean divisorGame(int n) {
        // dp array to memoize the results
        boolean[] dp = new boolean[n + 1];

        // Base case: Alice loses when n is 1
        dp[1] = false;

        // Filling the dp array for all values from 2 to n
        for (int i = 2; i <= n; i++) {
            // Assume Alice loses initially
            dp[i] = false;

            // Check all possible x values
            for (int x = 1; x < i; x++) {
                // If there exists an x such that n % x == 0 and Alice can force a win after the move
                if (i % x == 0 && !dp[i - x]) {
                    dp[i] = true;
                    break; // No need to check further x values
                }
            }
        }

        // The final result for n represents whether Alice can win or not
        return dp[n];
    }
}

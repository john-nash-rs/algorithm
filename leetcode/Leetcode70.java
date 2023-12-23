class Solution {
    public int climbStairs(int n) {
        int memo[] = new int[n + 1];
        int count = distinctWays(n,0,memo);
        return count;
    }
    
    public int distinctWays(int n,int count, int memo[]){
        if(count > n)
            return 0;
        if(count == n)
            return 1;
        if(memo[count] > 0)
            return memo[count];
        int res =  distinctWays(n, count + 1, memo) + distinctWays(n, count + 2, memo);
        memo[count] = res;
        return res;
    }
}

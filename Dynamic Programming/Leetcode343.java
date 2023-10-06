// Problem Statement - Leetcode 343 - https://leetcode.com/problems/integer-break

// My Solution

class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[59];
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;
        dp[5] = 6;
        dp[6] = 9;
        for(int i=7; i<=n; i++){
            dp[i] = 3 * dp[i-3];
        }
        return dp[n];
    }
}

// Problem Statement - Leetcode 1155 - https://leetcode.com/problems/number-of-dice-rolls-with-target-sum

// My Solution

class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int mod = 1000 * 1000 * 1000 + 7;
        long[][] dp = new long[n+1][target+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=target; j++){
                dp[i][j] = -1;
            }
        }
        rollSum(n, k, target, mod, dp);
        return (int)dp[n][target];
    }

    long rollSum(int n, int k, int target, int mod, long[][] dp){
        if(n==0 && target==0){
            return 1;
        }
        if(n==0 || target < 0){
            return 0;
        }
        if(dp[n][target] != -1){
            return dp[n][target];
        }
        long ans = 0;
        for(int i=1; i<=k; i++){
            ans = (ans + rollSum(n-1, k, target - i, mod, dp))%mod;
    }
        dp[n][target] = ans;
        return ans;
    }
}

// Problem Statement - Leetcode 1220 - https://leetcode.com/problems/count-vowels-permutation

// My Solution

class Solution {
    public int countVowelPermutation(int n) {
        int mod = 1000 * 1000 * 1000 + 7;
        long[][] dp = new long[5][2];
        for(int i=0; i<5; i++){
            dp[i][0] = 1;
        }
        for(int j=2; j<=n; j++){
            dp[0][1] = (((dp[0][1] + dp[1][0]) % mod) + ((dp[2][0] + dp[4][0])%mod))%mod;
            dp[1][1] = (((dp[1][1] + dp[0][0])%mod) + dp[2][0])%mod;
            dp[2][1] = (((dp[2][1] + dp[1][0])%mod) + dp[3][0])%mod;
            dp[3][1] = (dp[3][1] + dp[2][0])%mod;
            dp[4][1] = (((dp[4][1] + dp[2][0])%mod) + dp[3][0])%mod;
            dp[0][0] = dp[0][1];
            dp[1][0] = dp[1][1];
            dp[2][0] = dp[2][1];
            dp[3][0] = dp[3][1];
            dp[4][0] = dp[4][1];
            dp[0][1] = 0;
            dp[1][1] = 0;
            dp[2][1] = 0;
            dp[3][1] = 0;
            dp[4][1] = 0;
        }
        long ans = (((((dp[0][0] + dp[1][0])%mod) + ((dp[2][0] + dp[3][0])%mod))%mod) + dp[4][0])%mod;
        return (int)ans;
    }
}

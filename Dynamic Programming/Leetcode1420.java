// Problem Statement - Leetcode 1420 - https://leetcode.com/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons

// My Solutions

class Solution {
    public int numOfArrays(int n, int m, int k) {
        int mod = 1000 * 1000 * 1000 + 7;
        int[][][] dp = new int[n][m+1][k+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<=m; j++){
                for(int l=0; l<=k; l++){
                    dp[i][j][l] = -1; 
                }
            }
        }
        return createDP(dp, n, m, k, 0, 0, k, mod);
    }

    int createDP(int[][][] dp, int n, int m, int k, int nextElementIndex, int maxSoFar, int remainCost, int mod){
        if(nextElementIndex == n){
            if(remainCost == 0){
                return 1;
            }
            return 0;
        }
        if(remainCost < 0){
            return 0;
        }
        if(dp[nextElementIndex][maxSoFar][remainCost] != -1){
            return dp[nextElementIndex][maxSoFar][remainCost];
        }
        long ans = 0;
        // element to be added is less than or equal to maxSoFar
        for(int i=1; i<= maxSoFar; i++){
            ans = (ans + createDP(dp, n, m, k, nextElementIndex+1, maxSoFar, remainCost, mod))%mod;
        }

        // element to be added is greater than maxSoFar
        for(int i = maxSoFar+1; i<=m; i++){
            ans = (ans + createDP(dp, n, m, k, nextElementIndex+1, i, remainCost-1, mod))%mod;
        }
        return dp[nextElementIndex][maxSoFar][remainCost] = (int) ans;
    }
}

// Problem Statement - Leetcode 1269 - https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps

// My Solution

class Solution {
    public int numWays(int steps, int arrLen) {
        int[][] dp = new int[Math.min(arrLen, steps)][steps+1];      
        dp[0][0] = 1;
        dp[0][1] = 1;
        if(arrLen >=2)
            dp[1][1] = 1;
        int mod = 1000 * 1000 * 1000 + 7;
        int ans = findAns(dp, 0, steps, arrLen, mod);
        return dp[0][steps];
    }

    int findAns(int[][] dp, int currIndex, int steps, int arrLen, int mod){
        if(currIndex < 0 || currIndex >=arrLen || steps <0 || currIndex > steps){
            return 0;
        }
        if(dp[currIndex][steps] !=0){
            return dp[currIndex][steps];
        }
        int backStep = findAns(dp, currIndex-1, steps-1, arrLen, mod);
        int noStep = findAns(dp, currIndex, steps-1, arrLen, mod);
        int frontStep = findAns(dp, currIndex+1, steps-1, arrLen, mod);
        dp[currIndex][steps] = (int)((((long)backStep + noStep)%mod) + frontStep % mod)%mod;
        return dp[currIndex][steps];
    }
}

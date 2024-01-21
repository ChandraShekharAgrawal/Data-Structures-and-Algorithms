// Problem Statement - Leetcode 198 - https://leetcode.com/problems/house-robber/

// My Solution

class Solution {
    public int rob(int[] nums) {
        int houses = nums.length;
        int[] dp = new int[houses];
        for(int i=0; i<houses; i++){
            dp[i] = -1;
        }
        moneyCount(nums, 0, houses, dp);
        return dp[0];        
    }

    int moneyCount(int[]nums, int i, int n, int[] dp){
        if(i>=n){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int takeCurrent = nums[i] + moneyCount(nums, i+2, n, dp);
        int excludeCurrent = moneyCount(nums, i+1, n, dp);
        return dp[i] = Math.max(takeCurrent, excludeCurrent);
    }
}

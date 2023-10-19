// Problem Statement - Leetcode 300 - https://leetcode.com/problems/longest-increasing-subsequence

// My Solution

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            dp[i] = Math.max(dp[i], 1);
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}

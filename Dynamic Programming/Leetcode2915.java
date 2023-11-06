// problem statement - Leetcode 2915 - https://leetcode.com/problems/length-of-the-longest-subsequence-that-sums-to-target/

// My Solution

class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        int[][] dp = new int[n][target+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<=target; j++){
                dp[i][j] = -1;
            }
        }
        int ans = findAns(0, n-1, n, target, nums, dp);
        if(ans <= 0){
            return -1;
        }
        return ans;
    }

    int findAns(int start, int end, int n, int target, List<Integer> nums, int[][]dp){
        if(target == 0){
            return 0;
        }
        if(target < 0 || start > end){
            return Integer.MIN_VALUE;
        }
        if(dp[start][target]!=-1){
            return dp[start][target];
        }
        int included = 1 + findAns(start+1, end, n, target - nums.get(start), nums, dp);
        int excluded = findAns(start+1, end, n, target, nums, dp);
        dp[start][target] = Math.max(included, excluded);
        return dp[start][target];
    }
}

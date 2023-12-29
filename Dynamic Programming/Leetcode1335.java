// Problem Statement - Leetcode 1335 - https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule

// My Solution

class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(d > n){
            return -1;
        }
        int[][] dp = new int[n][d];
        for(int i=0; i<n; i++){
            for(int j=0; j<d; j++){
                dp[i][j] = -1;
            }
        }
        return findDifficulty(jobDifficulty, 0, n, d-1, dp);
    }

    private int findDifficulty(int[] jobDifficulty, int index, int n, int dayRemain, int[][] dp){
        if(dayRemain == 0){
            int val = jobDifficulty[index];
            for(int i = index + 1; i<n; i++){
                val = Math.max(val, jobDifficulty[i]);
            }
            return val;
        }
        if(dp[index][dayRemain] != -1){
            return dp[index][dayRemain];
        }
        int ans = 10001;
        int maxSoFar = jobDifficulty[index];
        for(int i= index; i< n - dayRemain; i++){
            maxSoFar = Math.max(maxSoFar, jobDifficulty[i]);
            ans = Math.min(ans, maxSoFar + findDifficulty(jobDifficulty, i+1, n, dayRemain-1, dp));
        }
        return dp[index][dayRemain] = ans;
    }
}

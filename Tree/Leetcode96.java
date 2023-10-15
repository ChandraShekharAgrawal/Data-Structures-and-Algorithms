// Problem Statement - Leetcode 96 - https://leetcode.com/problems/unique-binary-search-trees/

// My Solution

class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            for(int j=1; j<=i; j++){
                int leftSubTree = dp[j-1];
                int rightSubTree = dp[i-j];
                dp[i] += leftSubTree * rightSubTree;
            }
        }
        return dp[n];
    }
}

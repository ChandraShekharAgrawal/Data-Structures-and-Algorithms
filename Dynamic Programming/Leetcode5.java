// Problem Statement - Leetcode 5 - https://leetcode.com/problems/longest-palindromic-substring

// My Solution

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] ans = {0,0};
        for(int i=0; i<n; i++){
            dp[i][i] = true;
        }
        for(int i=0; i<n-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                ans[0] = i;
                ans[1] = i+1;
            }
        }
        for(int len = 2; len < n; len++){
            for(int i=0; i<n-len; i++){
                int j = i+len;
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true){
                    dp[i][j] = true;
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int index = ans[0]; index <= ans[1]; index++){
            sb.append(s.charAt(index));
        }
        return sb.toString();
    }
}

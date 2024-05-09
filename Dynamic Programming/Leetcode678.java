// Problem Statement - Leetcode 678 - https://leetcode.com/problems/valid-parenthesis-string

// My Solution

class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int[][] dp = new int[n][n+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                dp[i][j] = -1;
            }
        }
        checkParenthesis(s, dp, 0, 0, n);
        if(dp[0][0] == 0){
            return false;
        }
        return true;
    }

    int checkParenthesis(String s, int[][] dp, int index, int openBracket, int n){
        if(index == n){
            if(openBracket == 0)
                return 1;
            return 0;
        }
        if(dp[index][openBracket] != -1){
            return dp[index][openBracket];
        }
        dp[index][openBracket] = 0;
        if(s.charAt(index) == '('){
            dp[index][openBracket] = checkParenthesis(s, dp, index+1, openBracket+1, n);
        }
        else if(s.charAt(index) == ')'){
            if(openBracket > 0){
                dp[index][openBracket] = checkParenthesis(s, dp, index+1, openBracket-1, n);
            }
        }
        else{
            
            dp[index][openBracket] = dp[index][openBracket] | checkParenthesis(s, dp, index+1, openBracket+1, n);
            if(openBracket > 0){
                dp[index][openBracket] = dp[index][openBracket] | checkParenthesis(s, dp, index+1, openBracket-1, n);
            }
            dp[index][openBracket] = dp[index][openBracket] | checkParenthesis(s, dp, index+1, openBracket, n);           
        }
        return dp[index][openBracket];
    }
}

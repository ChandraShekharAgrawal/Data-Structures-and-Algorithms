// Problem Statement - Leetcode 678 - https://leetcode.com/problems/valid-parenthesis-string

// My Solution

class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int openBracket = 0;
        int closeBracket = 0;
        for(int i=0; i<n; i++){
            char front = s.charAt(i);
            char back = s.charAt(n-1-i);
            if(front == '(' || front == '*'){
                openBracket++;
            }
            else if(front == ')'){
                openBracket--;
            }
            if(back == ')' || back == '*'){
                closeBracket++;
            }
            else if(back == '('){
                closeBracket--;
            }
            if(openBracket <0 || closeBracket < 0){
                return false;
            }
        }
        return true;
    }
}

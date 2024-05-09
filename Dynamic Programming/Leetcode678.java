// Problem Statement - Leetcode 678 - https://leetcode.com/problems/valid-parenthesis-string

// My Solution

class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        Stack<Integer> openBracket = new Stack<>();
        Stack<Integer> special = new Stack<>();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                openBracket.push(i);
            }
            else if(ch == '*'){
                special.push(i);
            }
            else{
                if(openBracket.size() == 0 && special.size() == 0){
                    return false;
                }
                else if(openBracket.size() != 0){
                    openBracket.pop();
                }
                else {
                    special.pop();
                }
            }
        }
        while(openBracket.size() != 0 && special.size() != 0){
            if(openBracket.peek() > special.peek()){
                return false;
            }
            openBracket.pop();
            special.pop();
        }
        if(openBracket.size() == 0){
            return true;
        }
        return false;
    }
}

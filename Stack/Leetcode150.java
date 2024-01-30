// Problem Statement - Leetcode 150 - https://leetcode.com/problems/evaluate-reverse-polish-notation

// My Solution

class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            if(tokens[i].charAt(0) == '+'){
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left + right);
            }
            else if(tokens[i].charAt(0) == '-' && tokens[i].length() == 1){
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left - right);
            }
            else if(tokens[i].charAt(0) == '*'){
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left * right);
            }
            else if(tokens[i].charAt(0) == '/'){
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left / right);
            }
            else{
                stack.push(convertToInt(tokens[i]));
            }            
        }
        return stack.peek();
    }

    int convertToInt(String str){
        int ans = 0;
        int n = str.length();
        for(int i=0; i<n; i++){
            if(str.charAt(i) == '-'){
                continue;
            }
            ans = ans * 10 + (str.charAt(i) - '0');
        }
        if(str.charAt(0) == '-'){
            ans = 0-ans;
        }
        return ans;
    }
}

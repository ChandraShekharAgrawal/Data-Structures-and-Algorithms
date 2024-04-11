// Problem Statement - Leetcode 402 - https://leetcode.com/problems/remove-k-digits

// My Solution

class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while(i < n){
            while(k > 0 && stack.size() > 0 && stack.peek() > (num.charAt(i) - '0')){
                stack.pop();
                k--;
            }
            stack.add(num.charAt(i) - '0');
            i++;
        }
        while(k > 0){
            stack.pop();
            k--;
        }
        Stack<Integer> reverse = new Stack<>();
        while(stack.size() != 0){
            reverse.add(stack.pop());
        }

        StringBuilder ans = new StringBuilder();

        boolean firstNum = false;
        while(reverse.size() != 0){
            if(!firstNum){
                if(reverse.peek() == 0){
                    reverse.pop();
                }
                else{
                    firstNum = true;
                    ans.append(reverse.pop());                   
                }
            }
            else{
                ans.append(reverse.pop());
            }
        }
        if(ans.length() == 0){
            ans.append(0);
        }
        return ans.toString();
    }
}

// Problem Statement - Leetcode 739 - https://leetcode.com/problems/daily-temperatures

// My Solution

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] warmTemp = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1; i>=0 ; i--){
            while(stack.size() > 0 && temperatures[stack.peek()] <= temperatures[i]){
                stack.pop();
            }
            if(stack.size() == 0){
                warmTemp[i] = 0;
            }
            else{
                warmTemp[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return warmTemp;
    }
}

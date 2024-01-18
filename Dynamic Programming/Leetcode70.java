// Problem Statement - Leetcode 70 - https://leetcode.com/problems/climbing-stairs

// My Solution

class Solution {
    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int climbTwo = 1;
        int climbOne = 2;
        // int ans = 0;
        for(int i=3; i<=n; i++){
            int temp = climbOne;
            climbOne = climbOne + climbTwo;
            climbTwo = temp;
        }
        return climbOne;
    }
}

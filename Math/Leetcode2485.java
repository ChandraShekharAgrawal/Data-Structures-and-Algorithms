// Problem Statement - Leetcode 2485 - https://leetcode.com/problems/find-the-pivot-integer

// My Solution

class Solution {
    public int pivotInteger(int n) {
        int totalSum = (n * (n+1))/2;
        int currSum = 0;
        for(int i=1; i<=n; i++){
            currSum += i;
            if(currSum == (totalSum - currSum + i)){
                return i;
            }
        }
        return -1;
    }
}

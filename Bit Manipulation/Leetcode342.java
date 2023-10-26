// Problem Statement - Leetcode 342 - https://leetcode.com/problems/power-of-four

// My Solution

class Solution {
    public boolean isPowerOfFour(int n) {
        int count1 = 0;
        int count0 = 0;
        while(n > 0){
            if((n&1) > 0){
                count1++;
            }
            else{
                count0++;
            }
            n = n>>1;
        }
        if(count1 != 1){
            return false;
        }
        if((count0 & 1) > 0){
            return false;
        }
        return true;
    }
}

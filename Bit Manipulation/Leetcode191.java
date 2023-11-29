// Problem Statement - Leetcode 191 - https://leetcode.com/problems/number-of-1-bits

// My Solution

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for(int i=0; i<=31; i++){
            if((n&(1<<i))!=0){
                count++;
            }
        }
        return count;
    }
}

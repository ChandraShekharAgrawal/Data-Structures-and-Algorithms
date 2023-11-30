// Problem Statement - Leetcode 1611 - https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero

// My Solution

class Solution {
    public int minimumOneBitOperations(int n) {
        if(n==0){
            return 0;
        }
        // find msb
        int msb = 32;
        for(int i=31; i>=0; i--){
            if((n & (1<<i)) > 0){
                msb = i;
                break;
            }
        }
        return ((1<<(msb+1)) - 1) - minimumOneBitOperations(n ^ (1<<msb));
    }
}

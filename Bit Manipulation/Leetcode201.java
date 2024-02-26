// Problem Statement - Leetcode 201 - https://leetcode.com/problems/bitwise-and-of-numbers-range

// My Solution

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        if(left == 0)
            return 0;
        // find common prefix in bits
        int countShift = 0;
        while(left != right){
            left = left >> 1;
            right = right >> 1;
            countShift++;
        }
        return left << countShift;
    }
}

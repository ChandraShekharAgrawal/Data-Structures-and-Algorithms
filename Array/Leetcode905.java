// Problem Statement - Leetcode 905 - https://leetcode.com/problems/sort-array-by-parity/description

// my solution

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int numsLen = nums.length;
        int[] sortedArray = new int[numsLen];
        int start = 0;
        int end = numsLen-1;
        for(int i=0; i<numsLen; i++){
            if((nums[i] & 1) != 0){
                sortedArray[end] = nums[i];
                end--;
            }
            else{
                sortedArray[start] = nums[i];
                start++;
            }
        }
        return sortedArray;
    }
}

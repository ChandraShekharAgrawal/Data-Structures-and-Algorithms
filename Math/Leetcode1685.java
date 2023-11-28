// Problem Statement - Leetcode 1685 - https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array

// My Solution

class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for(int i=1; i<n; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        int[] absDiffArray = new int[n];
        absDiffArray[0] = prefixSum[n-1] - (n*nums[0]);
        for(int i=1; i<n; i++){
            absDiffArray[i] = prefixSum[n-1] - prefixSum[i-1] - ((n-i)*nums[i]) + (i*nums[i]) - prefixSum[i-1];
        }
        return absDiffArray;
    }
}

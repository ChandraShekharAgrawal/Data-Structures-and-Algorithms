// Problem Statement - Leetcode 3105 - https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray

// My Solution

class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        boolean increasing = true;
        int ans = 1;
        int temp = 1;
        for(int i=1; i<n; i++){
            if(nums[i] > nums[i-1]){
                if(increasing){
                    temp++;
                } else {
                    ans = Math.max(ans, temp);
                    temp = 2;
                    increasing = true;
                }
            } else if(nums[i] < nums[i-1]){
                if(!increasing){
                    temp++;
                } else {
                    ans = Math.max(ans, temp);
                    temp = 2;
                    increasing = false;
                }
            } else {
                ans = Math.max(ans, temp);
                temp = 1;
                increasing = true;
            }
        }
        return Math.max(ans, temp);
    }
}

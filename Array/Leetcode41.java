// Porblem Statement - Leetcode 41 - https://leetcode.com/problems/first-missing-positive/

// My solution

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(nums[i] <= 0 || nums[i] > n){
                nums[i] = n+1;
            }
        }
        for(int i=0; i<n; i++){
            int value = Math.abs(nums[i]);
            if(value <= n && nums[value - 1] > 0){
                nums[value - 1] = 0 - nums[value - 1];
            }
            
        }
        for(int i=0; i<n; i++){
            if(nums[i] > 0){
                return i+1;
            }
        }
        return n+1;
    }
}

// Problem Statement - Leetcode 55 - https://leetcode.com/problems/jump-game/

// My Solution

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxIndex = nums[0];
        for(int i=1; i<n-1; i++){
            if(maxIndex >= n-1){
                return true;
            }
            if(i <= maxIndex){
                maxIndex = Math.max(maxIndex, i + nums[i]);
            }
        }
        if(maxIndex >= n-1){
            return true;
        }
        return false;
    }
}

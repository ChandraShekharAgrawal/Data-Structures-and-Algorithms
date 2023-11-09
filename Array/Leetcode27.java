// Problem Statement - Leetcode 27 - https://leetcode.com/problems/remove-element

// My Solution

class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int count = 0;
        int index = 0;
        for(int i=0; i<n; i++){
            if(nums[i] != val){
                count++;
                nums[index] = nums[i];
                index++;
            }
        }
        return count;
    }
}

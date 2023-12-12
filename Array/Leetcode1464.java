// Problem Statement - Leetcode 1464 - https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array

// My Solution

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int firstMax = 0;
        int secondMax = 0;
        if(nums[0] < nums[1]){
            firstMax = nums[1];
            secondMax = nums[0];
        }
        else{
            firstMax = nums[0];
            secondMax = nums[1];
        }
        for(int i=2; i<n; i++){
            if(nums[i] > secondMax && nums[i] < firstMax){
                secondMax = nums[i];
            }
            else if(nums[i] >= firstMax){
                secondMax = firstMax;
                firstMax = nums[i];
            }
        }
        return (firstMax -1) * (secondMax-1);
    }
}

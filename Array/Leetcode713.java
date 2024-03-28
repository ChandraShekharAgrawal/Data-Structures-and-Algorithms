// Problem Statement - Leetcode 713 - https://leetcode.com/problems/subarray-product-less-than-k

// My Solution

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int subArray = 0;
        for(int i=0; i<n; i++){
            if(nums[i] < k){
                subArray++;
            }
            long currentProduct = nums[i];
            boolean last = true;
            for(int j= i+1; j<n; j++){
                if(currentProduct * nums[j]  < k){
                    currentProduct *= nums[j];
                }
                else{
                    subArray += (j - i -1);
                    last = false;
                    break;
                }
            }
            if(last){
                subArray += (n - i - 1);
            }
        }
        return subArray;
    }
}

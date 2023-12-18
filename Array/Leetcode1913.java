// Problem Statement - Leetcode 1913 - https://leetcode.com/problems/maximum-product-difference-between-two-pairs

// My Solution

class Solution {
    public int maxProductDifference(int[] nums) {
        int n = nums.length;
        int largest = 0;
        int secondLargest = 0;
        int smallest = 10001;
        int secondSmallest = 10001;
        for(int i=0; i<n; i++){
            if(nums[i] > largest){
                secondLargest = largest;
                largest = nums[i];
            }
            else if(nums[i] > secondLargest){
                secondLargest = nums[i];
            }
            if(nums[i] < smallest){
                secondSmallest = smallest;
                smallest = nums[i];
            }
            else if(nums[i] < secondSmallest){
                secondSmallest = nums[i];
            }
        }
        return (largest * secondLargest) - (smallest * secondSmallest);
    }
}

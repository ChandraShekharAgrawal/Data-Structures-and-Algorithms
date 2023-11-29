// Problem Statement - Leetcode 1877 - https://leetcode.com/problems/minimize-maximum-pair-sum-in-array

// My Solution

class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        int i=0;
        int j=n-1;
        while(i<j){
            ans = Math.max(ans, nums[i]+ nums[j]);
            i++;
            j--;
        }
        return ans;
    }
}

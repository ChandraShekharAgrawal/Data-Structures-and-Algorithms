// Problem Statement - Leetcode 713 - https://leetcode.com/problems/subarray-product-less-than-k/

// My solution - Java

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;
        if(k==0)
            return 0;
        int product = 1;
        int start = -1;
        int end = -1;
        for(int i=0; i<n; i++){
            end = i;
            product *= nums[i];
            while(product >=k && start < i){
                start++;
                product /= nums[start];
            }
            if(product < k){
                ans+= (end - start);
            }
        }
        return ans;
    }
}

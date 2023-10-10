// Problem Statement - Leetcode 1458 - https://leetcode.com/problems/max-dot-product-of-two-subsequences

// My solution

class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[][] dp = new int[n1+1][n2+1];
        int ans = createDp(n1, n2, dp, nums1, nums2, n1, n2);
        int nums1Max = -1001;
        int nums1Min = 1001;
        int nums2Max = -1001;
        int nums2Min = 1001;
        boolean nums1Positive = true;
        boolean nums1Negative = true;
        boolean nums2Positive = true;
        boolean nums2Negative = true;
        for(int i=0; i<n1; i++){
            if(nums1[i] < 0){
                nums1Positive = false;
            }
            else if(nums1[i] > 0){
                nums1Negative = false;
            }
            nums1Max = Math.max(nums1Max, nums1[i]);
            nums1Min = Math.min(nums1Min, nums1[i]);
        }
        for(int j=0; j<n2; j++){
            if(nums2[j] < 0){
                nums2Positive = false;
            }
            else if(nums2[j] > 0){
                nums2Negative = false;
            }
            nums2Max = Math.max(nums2Max, nums2[j]);
            nums2Min = Math.min(nums2Min, nums2[j]);
        }
        if(nums1Positive == true && nums2Negative == true){
            return nums1Min * nums2Max;
        }
        if(nums1Negative == true && nums2Positive == true){
            return nums1Max * nums2Min;
        }
        return dp[n1][n2];
    }

    int createDp(int end1, int end2, int[][] dp, int[] nums1, int[] nums2, int n1, int n2){
        if(end1 <=0 || end2 <=0){
            return 0;
        }
        if(dp[end1][end2] != 0){
            return dp[end1][end2];
        }
        dp[end1][end2] = Math.max(nums1[end1-1] * nums2[end2-1] + createDp(end1-1, end2-1, dp, nums1, nums2, n1, n2), Math.max(createDp(end1-1, end2, dp, nums1, nums2, n1, n2), createDp(end1, end2-1, dp, nums1, nums2, n1, n2)));
        return dp[end1][end2];
    }
}

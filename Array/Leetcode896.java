// problem statement - Leetcode 896 - https://leetcode.com/problems/monotonic-array

// my solution

class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean ans = true;
        int n = nums.length;
        if(n < 3){
            return ans;
        }
        int countPos = 0;
        int countNeg = 0;
        for(int i=1; i<n; i++){
            int currDiff = nums[i] - nums[i-1];
            if(currDiff > 0){
                countPos++;
            }
            else if(currDiff < 0){
                countNeg++;
            }
        }
        if(countPos !=0 && countNeg != 0){
            return false;
        }
        return ans;
    }
}

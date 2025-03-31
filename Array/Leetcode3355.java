// Problem Statement - Leetcode 3355 - https://leetcode.com/problems/zero-array-transformation-i/

// My Solution

class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int queriesLength = queries.length;
        int[] decreamentArray = new int[n];
        for(int i=0; i< queries.length; i++){
            decreamentArray[queries[i][1]]--;
            if(queries[i][0] != 0){
                decreamentArray[queries[i][0]-1]++;
            }
        }
        int currSum = 0;
        for(int i=n-1; i>=0; i--){
            if(nums[i]!= 0 && (nums[i] + decreamentArray[i] + currSum) > 0){
                return false;
            }
            currSum += decreamentArray[i];
        }
        return true;
    }
}

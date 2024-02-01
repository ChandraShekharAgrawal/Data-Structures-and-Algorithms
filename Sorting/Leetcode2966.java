// Problem Statement  -Leetcode 2966 - https://leetcode.com/problems/divide-array-into-arrays-with-max-difference

// My Solution

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int[][] ansArr = new int[n/3][3];
        Arrays.sort(nums);
        int row = 0;
        for(int i=0; i<n; i=i+3){
            int prev = nums[i];
            int col = 0;
            if(nums[i+2] - nums[i] > k){
                return new int[0][0];
            }
            for(int j=i; j< i+3; j++){
                ansArr[row][col] = nums[j];
                col++;
            }
            row++;
        }
        return ansArr;
    }
}

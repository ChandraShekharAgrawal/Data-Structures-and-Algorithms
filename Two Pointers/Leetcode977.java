// Problem Statement - Leetcode 977 - https://leetcode.com/problems/squares-of-a-sorted-array/

// My Solution

class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] squareArray = new int[n];
        int index = -1;
        for(int i=0; i<n; i++){
            if(nums[i] >= 0){
                index = i;
                break;
            }
        }
        int negIndex = index-1;
        int ansIndex = 0;
        while(negIndex >=0 && index < n){
            if(Math.abs(nums[negIndex]) < nums[index]){
                squareArray[ansIndex] = nums[negIndex] * nums[negIndex];
                negIndex--;
            }
            else if(Math.abs(nums[negIndex]) >= nums[index]){
                squareArray[ansIndex] = nums[index] * nums[index];
                index++;
            }
            ansIndex++;
        }
        while(negIndex >= 0){
            squareArray[ansIndex] = nums[negIndex] * nums[negIndex];
            negIndex--;
            ansIndex++;
        }
        while(index >= 0 && index < n){
            squareArray[ansIndex] = nums[index] * nums[index];
            index++;
            ansIndex++;
        }
        if(index < 0){
            index = n-1;
            while(index >= 0){
                squareArray[n-index-1] = nums[index] * nums[index];
                index--;
            }
        }
        return squareArray;
    }
}

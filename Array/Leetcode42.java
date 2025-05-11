// Problem Statement - Leetcode 42 - https://leetcode.com/problems/trapping-rain-water/

// My Solution

class Solution {

    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        createMaxLeft(left, height, n);
        createMaxRight(right, height, n);
        int water = 0;
        for(int i=0; i<n; i++){
            int leftValue = left[i];
            int rightValue = right[i];
            if(leftValue < 0 | rightValue< 0){
                continue;
            } else {
                water += Math.min(left[i], right[i]) - height[i];
            }
        }
        return water;
    }

    private void createMaxRight(int[] arr, int[] height, int n){
        int prevValue = -1;
        for(int i=n-1; i>=0; i--){
            if(height[i] > prevValue){
                arr[i] = -1;
                prevValue = height[i];
            } else {
                arr[i] = prevValue;
            }
        }
    }

    private void createMaxLeft(int[] arr, int[] height, int n){
        int prevValue = -1;
        for(int i=0; i<n; i++){
            if(height[i] > prevValue){
                arr[i] = -1;
                prevValue = height[i];
            } else {
                arr[i] = prevValue;
            }
        }
    }
}

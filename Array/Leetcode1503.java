// Problem Statement - Leetcode 1503 - https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank

// My Solution

class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int leftMax = -1;
        for(int i=0; i< left.length; i++){
            leftMax = Math.max(leftMax, left[i]);
        }
        int rightMin = n+1;
        for(int i=0; i<right.length; i++){
            rightMin = Math.min(rightMin, right[i]);
        }
        return Math.max(leftMax, n - rightMin);
    }
}

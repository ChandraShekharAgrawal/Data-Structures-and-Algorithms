// Problem Statement - Leetcode 1846 - https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging

// My Solution

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        int ans = 1;
        Arrays.sort(arr);
        int prev = 1;
        for(int i=1; i<n; i++){
            if(arr[i] - prev <= 1){
                ans = arr[i];
                prev = arr[i];
            }
            else{
                ans++;
                prev++;
            }
        }
        return ans;
    }
}

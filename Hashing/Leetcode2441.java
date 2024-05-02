// Problem Statement - Leetcode 2441 - https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative

// My Solution

class Solution {
    public int findMaxK(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i: nums){
            set.add(i);
        }
        int ans = -1001;
        for(int i: nums){
            if(set.contains(0-i)){
                ans = Math.max(ans, Math.abs(i));
            }
        }
        if(ans == -1001){
            return -1;
        }
        return ans;
    }
}

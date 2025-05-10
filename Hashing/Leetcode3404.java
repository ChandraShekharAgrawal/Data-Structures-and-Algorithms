// Problem Statement - Leetcode 3404 - https://leetcode.com/problems/count-special-subsequences/

// My Solution

class Solution {
    public long numberOfSubsequences(int[] nums) {
        int n = nums.length;
        long ans = 0L;
        Map<Double, Integer> ratioMap = new HashMap<>();
        for(int r = 4; r < n-2; r++){
            int q = r-2;
            for(int p=0; p<q-1; p++){
                double currentRatio = (double) nums[p]/nums[q];
                if(ratioMap.containsKey(currentRatio)){
                    ratioMap.put(currentRatio, ratioMap.get(currentRatio) + 1);
                } else {
                    ratioMap.put(currentRatio, 1);
                }
            }
            for(int s=r+2; s<n; s++){
                double currentRatio = (double) nums[s]/nums[r];
                if(ratioMap.containsKey(currentRatio)){
                    ans += ratioMap.get(currentRatio);
                }
            }
        }
        return ans;
    }
}

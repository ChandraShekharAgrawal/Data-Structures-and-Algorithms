// Problem Statement - Leetcode 3371 - https://leetcode.com/problems/identify-the-largest-outlier-in-an-array/

// My Solution

class Solution {
    public int getLargestOutlier(int[] nums) {
        int n = nums.length;
        int sum = 0;
        Map<Integer, Integer> numberMap = new HashMap<>();
        for(int i=0; i<n; i++){
            sum += nums[i];
            if(numberMap.containsKey(nums[i])){
                numberMap.put(nums[i], numberMap.get(nums[i])+1 );
            } else {
                numberMap.put(nums[i], 1);
            }
        }
        int ans = -1001;
        for(int i=0; i< n; i++){
            int potentialOutlier = sum - 2 * nums[i];
            if(numberMap.containsKey(potentialOutlier)){
                if(potentialOutlier == nums[i]){
                    if(numberMap.get(potentialOutlier) > 1){
                        ans = Math.max(ans, nums[i]);
                    }
                } else {
                    if(numberMap.get(potentialOutlier) > 0){
                        ans = Math.max(ans, potentialOutlier);
                    }
                }
            }
        }
        return ans;
    }
}

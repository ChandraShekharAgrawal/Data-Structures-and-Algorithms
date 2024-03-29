// Problem Statement - Leetcode 2962 - https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times

// my Solution

class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int start = 0;
        int firstOccur = -1;
        long ans = 0;
        int currFreq = 0;
        int i = 0;
        int maxElement = nums[0];
        for(int j=1; j<n; j++){
            maxElement = Math.max(maxElement, nums[j]);
        }
        boolean flag = false;
        while(i<n){
            if(nums[i] == maxElement){
                currFreq++;
                if(!flag){
                    firstOccur = i;
                    flag = true;
                }
                if(currFreq == k){
                    ans += ((long)(firstOccur - start + 1) * (n-i));
                    while(nums[start] != maxElement){
                        start++;
                    }
                    firstOccur++;
                    start++;
                    while(firstOccur < n && nums[firstOccur] != maxElement){
                        firstOccur++;
                    }                    
                    currFreq--;
                }
            }
            i++;
        }
        return ans;
    }
}

// Problem Statement - Leetcode 1838 - https://leetcode.com/problems/frequency-of-the-most-frequent-element

// My Solution

class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0;
        int freq = 1;
        long sum = nums[0];
        for(int i=1; i<n; i++){
            int currTarget = nums[i];
            sum += nums[i];
            while(((i - left + 1) * (long)nums[i]) - sum > k){
                sum -= nums[left];
                left++;
            }
            freq = Math.max(freq, (i - left + 1));
        }
        return freq;
    }
}

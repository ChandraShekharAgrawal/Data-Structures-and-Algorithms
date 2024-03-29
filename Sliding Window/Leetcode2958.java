// Problem Statement - Leetcode 2958 - https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/

// My Solution

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int index = 0;
        int start = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(index < n){
            if(map.containsKey(nums[index]) == false){
                map.put(nums[index], 1);
            }
            else{
                if(map.get(nums[index]) == k){
                    ans = Math.max(ans, index - start);
                    while(nums[start] != nums[index]){
                        map.put(nums[start], map.get(nums[start]) - 1);
                        start++;
                    }
                    start++;
                }
                else{
                    map.put(nums[index], map.get(nums[index]) + 1);
                }
            }
            index++;
        }
        return Math.max(ans, n - start);
    }
}

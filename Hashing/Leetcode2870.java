// Problem Statement - Leetcode 2870 - https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty

// My Solution

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for(int i=0; i<n; i++){
            if(countMap.containsKey(nums[i]) == false){
                countMap.put(nums[i], 1);
            }
            else{
                countMap.put(nums[i], countMap.get(nums[i]) + 1);
            }
        }
        int ans = 0;
        for(Integer value : countMap.keySet()){
            int count = countMap.get(value);
            if(count == 1){
                return -1;
            }
            ans += (count/3);
            if(count%3 != 0){
                ans++;
            }
        }
        return ans;
    }
}

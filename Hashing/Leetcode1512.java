// Problem Statement - Leetcode 1512 - https://leetcode.com/problems/number-of-good-pairs

// My Solution

class Solution {
    public int numIdenticalPairs(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<n; i++){
            if(mp.containsKey(nums[i]) == false){
                mp.put(nums[i], 1);
            }
            else{
                mp.put(nums[i], mp.get(nums[i]) + 1);
            }
        }
        int ans = 0;
        for(Integer i : mp.keySet()){
            int countNum = mp.get(i);
            ans += ((countNum * (countNum-1))/2);
        }
        return ans;
    }
}

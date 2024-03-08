// Problem Statement - Leetcode 3005 - https://leetcode.com/problems/count-elements-with-maximum-frequency

// My Solution

class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            if(map.containsKey(nums[i]) == false){
                map.put(nums[i], 1);
            }
            else{
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        int maxFrequency = 0;
        int countTotal = 0;
        for(Integer i: map.keySet()){
            int currFrequency = map.get(i);
            if(currFrequency > maxFrequency){
                maxFrequency = currFrequency;
                countTotal = currFrequency;
            }
            else if(currFrequency == maxFrequency){
                countTotal += currFrequency;
            }
        }
        return countTotal;
    }
}

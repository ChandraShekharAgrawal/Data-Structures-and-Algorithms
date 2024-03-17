// Problem Statement - Leetcode 525 - https://leetcode.com/problems/contiguous-array/

// My Solution

class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        map.put(0, -1);
        for(int i=0; i<n; i++){
            if((nums[i] & 1) > 0){
                count++;
            }
            else{
                count--;
            }
            if(count == 0){
                ans = Math.max(ans, i+1);
            }
            else{
                if(map.containsKey(count) == false){
                    map.put(count, i);
                }
                else{
                    ans = Math.max(ans, i - map.get(count));
                }
            }
        }
        return ans;
    }
}

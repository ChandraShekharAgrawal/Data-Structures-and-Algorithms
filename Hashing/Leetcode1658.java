// problem statement - leetcode 1658 - https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero

// my solution
class Solution {
    public int minOperations(int[] nums, int x) {
        int length = nums.length;
        int sum = nums[0];
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(sum, 0);
        int totalSum = 0;
        if(length == 1){
            totalSum = nums[0];
        }
        for(int i=1; i<length; i++){
            sum = sum + nums[i];
            mp.put(sum, i);
            if(i== length-1){
                totalSum = sum;
            }
        }
        int ans = -1;
        sum = 0;
        for(int i=0; i<length; i++){
            sum += nums[i];
            if(sum == totalSum - x){
                ans = Math.max(ans, i+1);
            }
            if(mp.containsKey(sum - totalSum + x) == true){
                ans = Math.max(ans, i - mp.get(sum - totalSum + x));
            }
        }
        if(ans == -1){
            return ans;
        }
        return length - ans;
    }
}

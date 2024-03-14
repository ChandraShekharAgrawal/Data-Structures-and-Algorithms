// Problem Statement - Leetcode 930 - https://leetcode.com/problems/binary-subarrays-with-sum

// My Solution

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int index = 0;
        int ans = 0;
        int len = 0;
        if(goal == 0){
            while(index < n){
                while(index < n && nums[index] != 1){
                    index++;
                    len++;
                }                
                if(index < n && nums[index] == 1){
                    ans += ((len* (len+1))/2);
                    len = 0;
                    index++;
                }
            }
            ans += ((len * (len+1))/2);
            return ans;
        }
        int prevEnd = -1;
        int currStart = -1;
        int currEnd = -1;
        int nextStart = 0;
        index = 0;
        int currSum = 0;
        ans = 0;
        boolean foundFirstOne = false;
        while(index < n){
            if(nums[index] == 1){
                currSum++;
                if(foundFirstOne == false){
                    currStart = index;
                    currEnd = index;
                    foundFirstOne = true;
                }
            }
            if(currSum == goal){
                currEnd = index;
                index++;
                while(index < n && nums[index] == 0){
                    index++;
                }
                nextStart = index;
                ans += ((currStart - prevEnd) * (nextStart - currEnd));
                currSum--;
                prevEnd = currStart;
                currStart++;
                while(currStart < n && nums[currStart] != 1){
                    currStart++;
                }
            }
            else{
                index++;
            }            
        }
        return ans;
    }
}

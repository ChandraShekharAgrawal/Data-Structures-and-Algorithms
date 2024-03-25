// Problem Statement - Leetcode 287 -  https://leetcode.com/problems/find-the-duplicate-number/

// My Solution. It is not intuitive at all. Can't come up with this in an interview.

class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;

        // we are trying to find a cycle using floyd's algo - hare and tortoise algo
        int slow = nums[0];
        int fast = nums[0];
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast){
                break;
            }
        }
        
        fast = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}

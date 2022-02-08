// https://leetcode.com/problems/missing-number/

// My Solution(Java)


class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sumreq = (n*(n+1))/2;
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum+= nums[i];
        }
        int ans = sumreq - sum;
        return ans;        
    }
}

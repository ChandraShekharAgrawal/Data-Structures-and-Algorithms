// Problem Statement - Leetcode 456 - https://leetcode.com/problems/132-pattern/description

// my solution

class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] minLeft = new int[n];
        minLeft[0] = nums[0];
        for(int i=1; i<n; i++){
            minLeft[i] = Math.min(minLeft[i-1], nums[i-1]);
        }
        Stack<Integer> searchK = new Stack<>();
        for(int i=n-1; i>=0; i--){
            if(nums[i] > minLeft[i]){
                while(searchK.size() > 0 && minLeft[i] >= searchK.peek()){
                    searchK.pop();
                }
                if(searchK.size() > 0 && searchK.peek() < nums[i]){
                    return true;
                }
                searchK.push(nums[i]);
            }
        }
        return false;
    }
}

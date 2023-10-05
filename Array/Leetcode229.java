// Problem Statement - Leetcode 229 - https://leetcode.com/problems/majority-element-ii

// My solution - Moore's Voting algorithm modified version

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int element1 = Integer.MIN_VALUE;
        int count1 = 0;
        int element2 = Integer.MIN_VALUE;
        int count2 = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == element1){
                count1++;
            }
            else if(nums[i] == element2){
                count2++;
            }
            else if(count1 == 0){
                element1 = nums[i];
                count1++;
            }
            else if(count2 == 0){
                element2 = nums[i];
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == element1){
                count1++;
            }
            else if(nums[i] == element2){
                count2++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        if(count1 > (n/3)){
            ans.add(element1);
        }
        if(count2 > (n/3)){
            ans.add(element2);
        }
        return ans;
    }
}

// Problem Statement - Leetcode 442 - https://leetcode.com/problems/find-all-duplicates-in-an-array

// My Solution

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> duplicateList = new ArrayList<>();
        for(int i=0; i<n; i++){
            int indexToModify = (Math.abs(nums[i])) - 1;
            if(nums[indexToModify] < 0){
                duplicateList.add(indexToModify + 1);
            }
            else{
                nums[indexToModify] = 0 - nums[indexToModify];
            }
        }
        return duplicateList;
    }
}

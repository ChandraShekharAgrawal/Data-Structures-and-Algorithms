// Problem Statement - Leetcode 1630 - https://leetcode.com/problems/arithmetic-subarrays

// My Solution

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = nums.length;
        int m = l.length;
        List<Boolean> ans = new ArrayList<>();
        for(int i=0; i<m; i++){
            int[] rangeArr = new int[r[i] - l[i] + 1];
            int k = rangeArr.length;
            int start = l[i];
            for(int j =0; j<k; j++){
                rangeArr[j] = nums[start];
                start++;
            }
            Arrays.sort(rangeArr);
            int diff = rangeArr[1] - rangeArr[0];
            boolean value = true;
            for(int j=2; j<k; j++){
                if(rangeArr[j] - rangeArr[j-1] != diff){
                    value = false;
                    break;
                }
            }
            ans.add(value);
        }
        return ans;
    }
}

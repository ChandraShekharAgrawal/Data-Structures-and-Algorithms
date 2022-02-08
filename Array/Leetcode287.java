// https://leetcode.com/problems/find-the-duplicate-number/

// My Solution (Java) using cyclic sort

class Solution {
    public int findDuplicate(int[] nums) {
        CyclicSort(nums);
        int ans =0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!= i+1){
                ans = nums[i];
                break;
            }
        }
        return ans;
    }
    
    void CyclicSort(int[] arr){
        int i = 0;
        while(i < arr.length){
            int correctindex = arr[i]-1;
            
            if(arr[i]!= arr[correctindex]){
                swap(arr, i, correctindex);
            }
            else{
                i++;
            }
        }
    }
    
    void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

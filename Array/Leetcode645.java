// https://leetcode.com/problems/set-mismatch/

// My Solution (Java) using cyclic sort

class Solution {
    public int[] findErrorNums(int[] nums) {
        CyclicSort(nums);
        int[] ans = new int[2];
        for(int i=0; i< nums.length; i++){
            if(nums[i]!= i+1){
                ans[0] = nums[i];
                ans[1] = i+1;
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
                swap(arr,i,correctindex);
            }
            else{
                i++;
            }
        }
    }
    
    void swap (int[] arr, int a ,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

// https://leetcode.com/problems/find-all-duplicates-in-an-array/

// My Solution (Java) using cyclic sort

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        CyclicSort(nums);
        List <Integer> ans = new ArrayList<Integer>();
        for(int i=0; i< nums.length; i++){
            if(nums[i]!= i+1){
                ans.add(nums[i]);
            }
        }
        return ans;
    }
    
    public void CyclicSort(int[] arr){
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

    public void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

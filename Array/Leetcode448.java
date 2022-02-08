// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

// My Solution (Java) using cyclic sort

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        CyclicSort(nums);
        List<Integer> ans = new ArrayList<Integer>();
        
        for(int i=0; i<nums.length; i++){
            if(nums[i]!= i+1){
                ans.add(i+1);
            }
        }
        return ans;
    }
    
    void CyclicSort(int[] arr){
        // index = value-1; if not swap
        int i=0;
        while(i<arr.length){
            int correctindex = arr[i]-1;
            //int currentindex = i;
            if(arr[i] != arr[correctindex]){
                swap(arr, i, correctindex);
            }
            else{
                i++;
            }
        }
    }
    
    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}



    

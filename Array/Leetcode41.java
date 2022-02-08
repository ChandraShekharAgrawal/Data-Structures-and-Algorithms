// https://leetcode.com/problems/first-missing-positive/

// My solution (Java) using cyclic sort

class Solution {
    public int firstMissingPositive(int[] arr) {      
        CyclicSort(arr);
        //System.out.println(Arrays.toString(arr));
        int ans =0;
        boolean flag = true;
        for(int i=0; i<arr.length; i++){
            if(arr[i]!= i+1){
                ans = i+1;
                flag = false;
                break;
            }
        }
        //System.out.println(ans);
        //edge case if arr contain all continuous positives after sorting like {1,2,3} ans = 4
        
        if (flag)
            return arr[arr.length-1]+1;
        return ans;
    }
    
    public void CyclicSort(int[] arr){
        int i = 0;
        while(i < arr.length){
            int correctindex = arr[i]-1;

            if(arr[i]>0 && correctindex< arr.length &&  arr[i]!= arr[correctindex]){
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

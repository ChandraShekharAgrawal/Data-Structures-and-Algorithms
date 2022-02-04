// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

// My Solution (Java)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        int[] ans = {-1,-1};
        if(length == 0){
            return ans; 
        }
        
        int start = findstart(nums, target);
        int end = findend(nums, target);
        
        ans[0] = start;
        ans[1] = end;
        return ans;
    }
    
    int findstart(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        int ans = -1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(arr[mid]<target){
                start = mid+1;
            }
            else if(arr[mid]>target){
                end = mid -1;
            }
            else{
                ans = mid;
                end = mid-1;
            }
        }
        return ans;
    }
    
    int findend(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        int ans = -1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(arr[mid]<target){
                start = mid+1;
            }
            else if(arr[mid]>target){
                end = mid -1;
            }
            else{
                ans = mid;
                start = mid+1;
            }
        }
        return ans;        
    }
}

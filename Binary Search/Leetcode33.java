// https://leetcode.com/problems/search-in-rotated-sorted-array/

// My Solution (Java)

class Solution {
    public int search(int[] nums, int target) {
        // largest index
        int index = -1;
        int largestindex = findLargest(nums);
        // apply binary search in two parts
        index = binarysearch(nums, 0, largestindex, target);
        
        if(index <0){
            index = binarysearch(nums, largestindex+1, nums.length-1, target);
        }
        return index;
    }
    
    //index of largest element
    int findLargest(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(mid < end && arr[mid]> arr[mid+1]){
                return mid;
            }
            if(mid>start && arr[mid] < arr[mid-1]){
                return mid-1;
            }
            if(arr[mid] < arr[start]){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return -1;
    }
    
    // binary search
    int binarysearch(int[] arr, int start, int end, int target){
        while (start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid] < target){
                start = mid + 1;
            }
            else if(arr[mid] > target){
                end = mid - 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}

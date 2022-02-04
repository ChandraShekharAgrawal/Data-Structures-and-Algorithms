// https://leetcode.com/problems/peak-index-in-a-mountain-array/

// My Solution (Java)

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length -1;
        int ans = -1;
        while(start <=end){
            int mid = start + (end - start)/2;
            if(arr[mid]> arr[mid-1] && arr[mid] < arr[mid+1]){
                start = mid;                
            }
            else if(arr[mid]< arr[mid-1] && arr[mid] > arr[mid+1]){
                end = mid;
            }
            else{
                ans = mid;
                start = mid+1;
                end = mid-1;
            }
        }
        return ans;
    }
}

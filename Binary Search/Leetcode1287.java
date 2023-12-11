// Problem Statement - Leetcode 1287 - https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/

// My Solution

class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        if(n<4){
            return arr[0];
        }
        int quarter = n/4;
        int[] ansCandidates = {arr[n/4], arr[n/2], arr[3*n/4]};
        for(int i=0; i<3; i++){
            int firstIndex = findStart(arr, n, ansCandidates[i]);
            int lastIndex = findEnd(arr, n, ansCandidates[i]);
            if((lastIndex - firstIndex + 1) >  quarter){
                return ansCandidates[i];
            }
        }
        return 0;        
    }

    int findStart(int[] arr, int n, int num){
        int start = 0;
        int end = n-1;
        int ans = n;
        while(start <= end){
            int mid = (start + end)/2;
            if(arr[mid] == num){
                ans = mid;
                end = mid-1;
            }
            else if(arr[mid] > num){
                end = mid -1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
    }

    int findEnd(int[] arr, int n, int num){
        int start = 0;
        int end = n-1;
        int ans = n;
        while(start <= end){
            int mid = (start + end)/2;
            if(arr[mid] == num){
                ans = mid;
                start = mid+1;
            }
            else if(arr[mid] > num){
                end = mid -1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
    }
}

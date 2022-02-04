// https://leetcode.com/problems/find-smallest-letter-greater-than-target/

// My Solution (Java)

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int index = findgreaterelement(letters,target);
        if(index<0){
            return letters[0];
        }
        else{
            return letters[index];
        }
    }
    
    int findgreaterelement(char[] arr, char target){
        int start = 0;
        int end = arr.length-1;
        int ans = -1;
        while(start<=end){
            //int mid = (start + end)/2;
            int mid = start + (end-start)/2;
            if(arr[mid]<=target){
                start = mid+1;
            }
            // else if(arr[mid]==target){
            //     return mid;
            // }
            else {
                ans = mid;
                end = mid-1;
            }
        }
        return ans;
    }
}

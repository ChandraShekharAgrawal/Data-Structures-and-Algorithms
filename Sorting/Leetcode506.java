// Problem Statement - Leetcode 506 - https://leetcode.com/problems/relative-ranks

// My Solution

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int[] sortedScore = new int[n];
        String[] ans = new String[n];
        for(int i=0; i<n; i++){
            sortedScore[i] = score[i];
        }
        Arrays.sort(sortedScore);
        for(int i=0; i<n; i++){
            int index = findIndex(score[i], sortedScore, n);
            if(index == n-1){
                ans[i] = "Gold Medal";
            }
            else if(index == n-2){
                ans[i] = "Silver Medal";
            }
            else if(index == n-3){
                ans[i] = "Bronze Medal";
            }
            else{
                ans[i] = "" + (n-index);
            }
            
        }
        return ans;
    }

    private int findIndex(int val, int[] arr, int n){
        int start = 0;
        int end = n-1;
        while(start <= end){
            int mid = (start + end)/2;
            if(arr[mid] == val){
                return mid;
            }
            else if(arr[mid] < val){
                start = mid + 1;
            }
            else{
                end = mid -1 ;
            }
        }
        return -1;
    }
}

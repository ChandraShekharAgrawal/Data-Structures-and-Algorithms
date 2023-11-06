// Problem Statement - Leetcode 1535 - https://leetcode.com/problems/find-the-winner-of-an-array-game

// My Solution

class Solution {
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        int prevWinner = arr[0];
        int win = 0;
        int largestNum = arr[0];
        for(int i=1; i<n; i++){
            largestNum = Math.max(largestNum, arr[i]);
            if(arr[i] < prevWinner){
                win++;
                if(win == k){
                    return prevWinner;
                }
            }
            else{
                win = 1;
                prevWinner = arr[i];
                if(win == k){
                    return prevWinner;
                }
            }
        }
        return largestNum;
    }
}

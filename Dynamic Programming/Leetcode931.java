// Problem Statement - Leetcode 931 - https://leetcode.com/problems/minimum-falling-path-sum

// My Solution

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] previousRow = new int[n];
        for(int i=0; i<n; i++){
            previousRow[i] = matrix[0][i];
        }
        int[] currRow = new int[n];
        for(int i=1; i<n; i++){
            for(int j=0; j<n; j++){
                if(j==0){
                    currRow[j] = matrix[i][j] + Math.min(previousRow[j], previousRow[j+1]);
                }
                else if(j==n-1){
                    currRow[j] = matrix[i][j] + Math.min(previousRow[j], previousRow[j-1]);
                }
                else{
                    currRow[j] = matrix[i][j] + Math.min(previousRow[j], Math.min(previousRow[j-1], previousRow[j+1]));
                }
            }
            for(int j=0; j<n; j++){
                previousRow[j] = currRow[j];
                currRow[j] = 0;
            }
        }
        int minSum = previousRow[0];
        for(int i=1; i<n; i++){
            minSum = Math.min(minSum, previousRow[i]);
        }
        return minSum;
    }
}

// Problem Statement - Leetcode 867 - https://leetcode.com/problems/transpose-matrix

// My Solution

class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] ans = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i!=j){
                    ans[i][j] = matrix[j][i];
                }
                else{
                    ans[i][i] = matrix[i][i];
                }
            }
        }
        return ans;
    }
}

// Problem Statement - Leetcode 2482 - https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column

// My Solution

class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];
        int[] onesRow = new int[m];
        int[] onesCol = new int[n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    onesRow[i]++;
                    onesCol[j]++;
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                ans[i][j] = 2 * onesRow[i] - m + 2 * onesCol[j] - n;
            }
        }
        return ans;
    }
}

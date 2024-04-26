// Problem Statement - Leetcode 1289 - https://leetcode.com/problems/minimum-falling-path-sum-ii

// My Solution - T.C. = O(n^3) and S.C. = O(n) is easy but T.C. = O(n^2) and S.C. = O(1) is tricky.

class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int minElement = 20001;
        int minIndex = -1;
        int nextMinElement = 20001;
        int nextMinIndex = -1;

        for(int i=0; i<n; i++){
            if(grid[0][i] < minElement){
                nextMinElement = minElement;
                nextMinIndex = minIndex;
                minElement = grid[0][i];
                minIndex = i;
            }
            else if(grid[0][i] < nextMinElement){
                nextMinElement = grid[0][i];
                nextMinIndex = i;
            }
        }

        for(int i=1; i<n; i++){
            int tempMinElement = 20001;
            int tempMinIndex = -1;
            int nextTempMinElement = 20001;
            int nextTempMinIndex = -1;

            for(int j=0; j<n; j++){
                if(j == minIndex){
                    if(grid[i][j] + nextMinElement < tempMinElement){
                        nextTempMinElement = tempMinElement;
                        nextTempMinIndex = tempMinIndex;
                        tempMinElement = grid[i][j] + nextMinElement;
                        tempMinIndex = j;
                    }
                    else if(grid[i][j] + nextMinElement < nextTempMinElement){
                        nextTempMinElement = grid[i][j] + nextMinElement;
                        nextTempMinIndex = j;
                    }
                }
                else{
                    if(grid[i][j] + minElement < tempMinElement){
                        nextTempMinElement = tempMinElement;
                        nextTempMinIndex = tempMinIndex;
                        tempMinElement = grid[i][j] + minElement;
                        tempMinIndex = j;
                    }
                    else if(grid[i][j] + minElement < nextTempMinElement){
                        nextTempMinElement = grid[i][j] + minElement;
                        nextTempMinIndex = j;
                    }
                }
            }
            minElement = tempMinElement;
            minIndex = tempMinIndex;
            nextMinElement = nextTempMinElement;
            nextMinIndex = nextTempMinIndex;
        }

        return minElement;
    }
}

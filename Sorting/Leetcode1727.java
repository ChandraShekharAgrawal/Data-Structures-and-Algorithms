// Problem Statement - Leetcode 1727 - https://leetcode.com/problems/largest-submatrix-with-rearrangements

// My Solution

class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int largestSubmatrix = 0;
        int[] arr = new int[m];
        int[] height = new int[m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] == 1){
                    arr[j] += 1;
                }
                else{
                    arr[j] = 0;
                }
                height[j] = arr[j];
            }
            Arrays.sort(height);
            for(int j=0; j<m; j++){
                largestSubmatrix = Math.max(largestSubmatrix, height[j] * (m-j));
            }
        }
        return largestSubmatrix;
    }
}

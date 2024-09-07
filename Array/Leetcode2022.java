// Problem Statement - Leetcode 2022 - https://leetcode.com/problems/convert-1d-array-into-2d-array

// My Solution

class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int totalElements = original.length;
        int[][] emptyArray = {};
        if((m*n) != totalElements){
            return emptyArray;
        }
        int rowCount = 0;
        int colCount = 0;
        int[][] ansArray = new int[m][n];
        for(int i=0; i< totalElements; i++){
            ansArray[rowCount][colCount] = original[i];
            colCount++;
            if(colCount == n){
                colCount = 0;
                rowCount++;
            }
        }
        return ansArray;
    }
}

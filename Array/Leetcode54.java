// Problem Statement - Leetcode 54 - https://leetcode.com/problems/spiral-matrix/

// My Solution - java

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<Integer> spiralMatrix = new ArrayList<>();
        int totalElements = rows * cols;
        int direction = 0;
        int processX = cols;
        int processY = rows-1;
        int i = 0;
        int j = 0;
        while(true){
            if(direction == 0){
                if(spiralMatrix.size() == totalElements){
                    break;
                }
                for(int k=0; k<processX; k++){
                    spiralMatrix.add(matrix[i][j]);
                    j++;
                }
                j--;
                i++;
                processX--;
                direction = 1;
            }
            if(direction == 1){
                if(spiralMatrix.size() == totalElements){
                    break;
                }
                for(int k = 0; k< processY; k++){
                    spiralMatrix.add(matrix[i][j]);
                    i++;
                }
                i--;
                j--;
                processY--;
                direction = 2;
            }
            if(direction == 2){
                if(spiralMatrix.size() == totalElements){
                    break;
                }
                for(int k = 0; k < processX; k++){
                    spiralMatrix.add(matrix[i][j]);
                    j--;
                }
                i--;
                j++;
                processX--;
                direction = 3;
            }
            if(direction == 3){
                if(spiralMatrix.size() == totalElements){
                    break;
                }
                for(int k=0; k < processY; k++){
                    spiralMatrix.add(matrix[i][j]);
                    i--;
                }
                i++;
                j++;
                processY--;
                direction = 0;
            }
            if(spiralMatrix.size() == totalElements){
                break;
            }
        }
        return spiralMatrix;
    }
}

// problem statement - Leetcode 799 - https://leetcode.com/problems/champagne-tower

// my solution

class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] tower = new double[101][101];
        tower[0][0] = poured;
        for(int i=0; i<100; i++){
            for(int j=0; j<=i; j++){
                double flowingDown = (tower[i][j] - 1)/2;
                if(flowingDown > 0){
                    tower[i+1][j] += flowingDown;
                    tower[i+1][j+1] += flowingDown;
                }
            }
        }
        return Math.min(1,tower[query_row][query_glass]);
    }
}

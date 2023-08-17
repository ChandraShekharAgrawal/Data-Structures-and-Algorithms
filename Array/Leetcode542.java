// problem statement - leetcode 542 https://leetcode.com/problems/01-matrix/description/

class Solution {
    class Cell{
        int r;
        int c;
        Cell(int x, int y){
            r = x;
            c = y;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] ans = new int[row][col];
        Queue<Cell> q = new LinkedList<>();
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(mat[i][j] !=0){
                    ans[i][j] = Integer.MAX_VALUE;
                }
                else{
                    q.add(new Cell(i,j));
                }
            }
        }
        while(q.size() != 0){
            Cell curr = q.remove();
            int currRow = curr.r;
            int currCol = curr.c;
            int[] rowDir = {0, 0, 1, -1};
            int[] colDir = {1, -1, 0, 0};
            for(int i=0; i<4; i++){
                int checkRow = currRow + rowDir[i];
                int checkCol = currCol + colDir[i];
                if(checkRow < row && checkRow >=0 && checkCol < col && checkCol >=0){
                    if(ans[checkRow][checkCol] == Integer.MAX_VALUE){
                        ans[checkRow][checkCol] = ans[currRow][currCol] + 1;
                        q.add(new Cell(checkRow, checkCol));
                    }
                }
            }
        }
        return ans;
    }
}

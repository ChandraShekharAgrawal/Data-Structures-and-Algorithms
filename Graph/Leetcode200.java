// Problem Statement - Leetcode 200 - https://leetcode.com/problems/number-of-islands/

// My Solution

class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] visited = new int[rows][cols];
        int islandCount = 0;
        for(int i=0; i< rows; i++){
            for(int j=0; j< cols; j++){
                if(grid[i][j] == '1' && visited[i][j] == 0){
                    islandCount++;
                    performBfsFromNode(createQueueNode(i,j), rows, cols, visited, grid);
                }
            }
        }
        return islandCount;
    }

    private void performBfsFromNode(List<Integer> startNode, int rows, int cols, int[][] visited, char[][] grid){
        Queue<List<Integer>> bfsList = new LinkedList<>();
        bfsList.add(startNode);
        visited[startNode.get(0)][startNode.get(1)] = 1;
        while(bfsList.size() != 0){
            List<Integer> currNode = bfsList.remove();
            int currRow = currNode.get(0);
            int currCol = currNode.get(1);
            // check in left
            if(currCol-1 >= 0 && visited[currRow][currCol-1] == 0 && grid[currRow][currCol-1] == '1'){
                bfsList.add(createQueueNode(currRow, currCol-1));
                visited[currRow][currCol-1] = 1;
            }
            // check in right
            if(currCol+1 < cols && visited[currRow][currCol+1] == 0 && grid[currRow][currCol+1] == '1'){
                bfsList.add(createQueueNode(currRow, currCol+1));
                visited[currRow][currCol+1] = 1;
            }
            // check in up
            if(currRow-1 >= 0 && visited[currRow-1][currCol] == 0 && grid[currRow-1][currCol] == '1'){
                bfsList.add(createQueueNode(currRow-1, currCol));
                visited[currRow-1][currCol] = 1;
            }
            // check in down
            if(currRow+1 < rows && visited[currRow+1][currCol] == 0 && grid[currRow+1][currCol] == '1'){
                bfsList.add(createQueueNode(currRow+1, currCol));
                visited[currRow+1][currCol] = 1;
            }

        }
    }

    private List<Integer> createQueueNode(int row, int col){
        List<Integer> tempList = new ArrayList<>();
        tempList.add(row);
        tempList.add(col);
        return tempList;
    }
}

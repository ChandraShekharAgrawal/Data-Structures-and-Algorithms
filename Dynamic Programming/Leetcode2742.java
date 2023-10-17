// Problem Statement - Leetcode 2742 - https://leetcode.com/problems/painting-the-walls

// My Solution

class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int wall = cost.length;
        int[][] dp = new int[wall][wall+1];
        int ans = findWall(dp, wall, 0, wall, cost, time);
        return dp[0][wall];
    }

    int findWall(int[][] dp, int wall, int currIndex, int remainingWall, int[] cost, int[] time){
        if(remainingWall <= 0){
            return 0;
        }
        if(currIndex>=wall){
            return 1000 * 1000 * 1000;
        }
        if(dp[currIndex][remainingWall] != 0){
            return dp[currIndex][remainingWall];
        }
        int dontPaintPaid = findWall(dp, wall, currIndex+1, remainingWall, cost, time);
        int paintPaid = cost[currIndex] + findWall(dp, wall, currIndex+1, remainingWall - 1 - time[currIndex], cost, time);
        dp[currIndex][remainingWall] = Math.min(dontPaintPaid, paintPaid);
        return dp[currIndex][remainingWall];
    }
}

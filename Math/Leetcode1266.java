// Problem Statement - Leetcode 1266 - https://leetcode.com/problems/minimum-time-visiting-all-points

// My Solution

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        int prevX = points[0][0];
        int prevY = points[0][1];
        for(int i=1; i<points.length; i++){
            ans += Math.max(Math.abs(points[i][0] - prevX), Math.abs(points[i][1] - prevY));
            prevX = points[i][0];
            prevY = points[i][1];
        }
        return ans;
    }
}

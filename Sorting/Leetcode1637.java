// Problem Statement - Leetcode 1637 - https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/

// My Solution

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (o1, o2)->{
            return o1[0] - o2[0];
        });
        int ans = 0;

        for(int i=1; i<n; i++){
            int diff = points[i][0] - points[i-1][0];
            if(diff > ans){
                ans = diff;
            }
        }
        return ans;
    }
}

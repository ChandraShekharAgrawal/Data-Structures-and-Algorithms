// Problem Statement - Leetcode 3111 - https://leetcode.com/problems/minimum-rectangles-to-cover-points/

// My Solution

class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, (o1, o2) -> {
            if(o1[0] <= o2[0]){
                return -1;
            }
            return 1;
        });
        int minRectangle = 0;
        int index = 0;
        int pointLength = points.length;
        while(index < pointLength){
            int tempIndex = index + 1;
            while(tempIndex < pointLength && points[tempIndex][0] - points[index][0] <= w){
                tempIndex++;
            }
            minRectangle++;
            index = tempIndex;
        }
        return minRectangle;
    }
}

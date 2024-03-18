// Problem Statement - Leetcode 452 - https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

// My Solution

class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (o1, o2)->{
            if(o1[0] < o2[0]){
                return -1;
            }
            else if(o1[0] > o2[0]){
                return 1;
            }
            else{
                return o1[1] - o2[1];
            }
        });
        int arrows = 1;
        int endX = points[0][1];
        int i = 1;
        while(i<n){
            if(points[i][0] > endX){
                arrows++;                
                if(i<n)
                    endX = points[i][1];
                i++;
            }
            else if(points[i][0] == endX){
                i++;
                while(i<n && points[i][0] == endX){
                    i++;
                }
                // arrows++;
                if(i<n){
                    arrows++;
                    endX = points[i][1];
                    i++;
                }
            }
            else{
                if(points[i][1] < endX){
                    //arrows++;
                    endX = points[i][1];
                }
                i++;
            }
        }
        return arrows;
    }
}

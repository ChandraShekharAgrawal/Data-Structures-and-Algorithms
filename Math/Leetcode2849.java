// Problem Statement - Leetcode 2849 - https://leetcode.com/problems/determine-if-a-cell-is-reachable-at-a-given-time

// My Solution

class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int diffX = Math.abs(fx - sx);
        int diffY = Math.abs(fy - sy);
        int minTime = Math.max(diffX, diffY);
        if(minTime == 0 && t==1){
            return false;
        }
        if(minTime > t){
            return false;
        }
        return true;
    }
}

// Problem Statement - Leetcode 1496 - https://leetcode.com/problems/path-crossing/

// My Solution

class Solution {
    public boolean isPathCrossing(String path) {
        int n = path.length();
        HashSet<String> points = new HashSet<>();
        int x = 0;
        int y = 0;
        points.add(x + " " + y);
        for(int i=0; i<n; i++){
            char curr = path.charAt(i);
            if(curr == 'N'){
                y++;
            }
            else if(curr == 'E'){
                x++;
            }
            else if(curr == 'W'){
                x--;
            }
            else{
                y--;
            }
            String currPath = x + " " + y;
            if(points.contains(currPath) == true){
                return true;
            }
            points.add(currPath);
        }
        return false;
    }
}

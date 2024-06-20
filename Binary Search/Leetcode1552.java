// Problem Statement - Leetcode 1552 - https://leetcode.com/problems/magnetic-force-between-two-balls

// My Solution

class Solution {
    public int maxDistance(int[] position, int m) {
        int baskets = position.length;
        Arrays.sort(position);
        int minPos = position[0];
        int maxPos = position[baskets-1];
        
        int ans = 1;
        int low = 1;
        int high = maxPos - minPos;
        while(low <= high){
            int mid = (low + high)/2;
            // check if mid can be answer
            boolean check = findBall(position, m, mid);
            if(!check){
                high = mid-1;
            }
            else{
                ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean findBall(int[] position, int m, int separation){
        int count = 1;
        //int index = 0;
        int prevPosition = position[0];
        for(int i=1; i<position.length; i++){
            if(position[i] < prevPosition + separation){
                continue;
            }
            else{
                count++;
                prevPosition = position[i];
            }           
            
        }
        if(count < m){
            return false;
        }
        return true;
    }
}

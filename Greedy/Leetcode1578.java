// Problem Statement - Leetcode 1578 - https://leetcode.com/problems/minimum-time-to-make-rope-colorful

// My Solution

class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int ans = 0;
        char prev = colors.charAt(0);
        int prevTime = neededTime[0];
        int sameLength = 1;
        int sameSum = neededTime[0];
        for(int i=1; i<n; i++){
            char curr = colors.charAt(i);
            if(curr == prev){
                prevTime = Math.max(prevTime, neededTime[i]);
                sameLength++;
                sameSum += neededTime[i];
            }
            else{
                if(sameLength > 1){
                    ans += (sameSum - prevTime);
                }                    
                prevTime = neededTime[i];
                sameLength = 1;
                sameSum = neededTime[i];
            }
            prev = curr;
        }
        if(sameLength > 1){
            ans += (sameSum - prevTime);
        }            
        return ans;
    }
}

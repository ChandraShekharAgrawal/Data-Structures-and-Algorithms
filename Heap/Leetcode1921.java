// Problem Statement - Leetcode 1921 - https://leetcode.com/problems/eliminate-maximum-number-of-monsters

// My Solution

class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        PriorityQueue<Double> time = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            double tempTime = ((double)dist[i])/speed[i];
            time.add(tempTime);
        }
        double prevTime = time.remove();
        prevTime = 0;
        int ans = 1;
        while(time.size()!=0){
            double currTime = time.remove();
            if(currTime - prevTime > 1){
                ans++;
                prevTime++;
            }
            else{
                break;
            }
        }
        return ans;
    }
}

// Problem Statement - Leetcode 2391 - https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage

// My Solution

class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;
        int ans = 0;
        int gt = -1;
        int pt = -1;
        int mt = -1;
        for(int i=0; i<n; i++){
            ans += garbage[i].length();
            for(int j=0; j<garbage[i].length(); j++){
                if(garbage[i].charAt(j) == 'G'){
                    gt = i;
                }
                else if(garbage[i].charAt(j) == 'M'){
                    mt = i;
                }
                else{
                    pt = i;
                }
            }            
        }
        int[] prefixTravel = new int[travel.length];
        prefixTravel[0] = travel[0];
        for(int i=1; i<travel.length; i++){
            prefixTravel[i] = prefixTravel[i-1] + travel[i];
        }
        if(gt > 0){
            ans += prefixTravel[gt-1];
        }
        if(pt > 0){
            ans += prefixTravel[pt-1];
        }
        if(mt > 0){
            ans += prefixTravel[mt-1];
        }
        return ans;
    }
}

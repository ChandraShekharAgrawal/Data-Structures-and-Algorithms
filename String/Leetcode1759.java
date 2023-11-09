// Problem Statement - Leetcode 1759 - https://leetcode.com/problems/count-number-of-homogenous-substrings

// My Solution

class Solution {
    public int countHomogenous(String s) {
        int mod = 1000 * 1000 * 1000 + 7;
        long ans = 0;
        long count = 1;
        char prev = s.charAt(0);
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == prev){
                count++;
            }
            else{
                ans = (ans + ((((count) * (count + 1))/2)%mod))%mod;
                count = 1;
                prev = s.charAt(i);
            }
        }
        ans = (ans + ((((count) * (count + 1))/2)%mod))%mod;
        return (int)ans; 
    }
}

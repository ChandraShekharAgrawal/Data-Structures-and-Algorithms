// Problem Statement - Leetcode 1422 - https://leetcode.com/problems/maximum-score-after-splitting-a-string

// My Solution

class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int[] zeroes = new int[n];
        if(s.charAt(0) == '0'){
            zeroes[0] = 1;
        }
        for(int i=1; i<n; i++){
            zeroes[i] = zeroes[i-1];
            if(s.charAt(i) == '0'){
                zeroes[i] = 1 + zeroes[i-1];
            }
        }
        int ans = 0;
        for(int i=0; i<n-1; i++){
            ans = Math.max(ans, 2*zeroes[i] - zeroes[n-1] + n - i - 1);
        }
        return ans;
    }
}

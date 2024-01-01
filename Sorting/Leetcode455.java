// Problem Statement - Leetcode 455 - https://leetcode.com/problems/assign-cookies/

// My Solution

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int greedLength = g.length;
        int cookies = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0;
        int i = 0;
        int j = 0;
        while(i < greedLength && j < cookies){
            if(s[j] >= g[i]){
                ans++;
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        return ans;
    }
}

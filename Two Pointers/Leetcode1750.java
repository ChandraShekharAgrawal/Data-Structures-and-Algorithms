// Problem Statement - Leetcode 1750 - https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends

// My Solution

class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int i = 0;
        int j = n-1;
        while(i<j && i<n && j>=0){
            char curr = s.charAt(i);
            if(s.charAt(i) != s.charAt(j)){
                break;
            }
            while(i<n && s.charAt(i) == curr && s.charAt(i) == s.charAt(j)){
                i++;
            }
            while(j>=0 && s.charAt(j) == curr){
                j--;
            }
        }
        if(i>j){
            return 0;
        }
        return (j-i + 1);
    }
}

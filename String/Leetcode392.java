// Problem Statement - Leetcode 392 - https://leetcode.com/problems/is-subsequence

// My solution 

class Solution {
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if(sLen == 0){
            return true;
        }
        if(tLen < sLen){
            return false;
        }
        int sIndex = 0;
        for(int i=0; i<tLen; i++){
            if(t.charAt(i) == s.charAt(sIndex)){
                sIndex++;
            }
            if(sIndex == sLen){
                return true;
            }
        }
        return false;
    }
}

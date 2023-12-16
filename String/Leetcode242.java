// Problem Statement - Leetcode 242 - https://leetcode.com/problems/valid-anagram

// My Solution

class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n!=m){
            return false;
        }
        int[] sCount = new int[26];
        int[] tCount = new int[26];
        for(int i=0; i<n; i++){
            sCount[s.charAt(i) - 'a']++;
            tCount[t.charAt(i) - 'a']++;
        }
        for(int i=0; i<26; i++){
            if(sCount[i] != tCount[i]){
                return false;
            }
        }
        return true;
    }
}

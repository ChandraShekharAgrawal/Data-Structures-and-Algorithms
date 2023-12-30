// Problem Statement - Leetcode 1897 - https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal

// My Solution

class Solution {
    public boolean makeEqual(String[] words) {
        int n = words.length;
        if(n==1){
            return true;
        }
        int[] count = new int[26];
        for(int i=0; i<n; i++){
            for(int j=0; j<words[i].length(); j++){
                count[words[i].charAt(j) - 'a']++;
            }
        }
        for(int i=0; i<26; i++){
            if(count[i] != 0 && ((count[i]%n) != 0)){
                return false;
            }
        }
        return true;
    }
}

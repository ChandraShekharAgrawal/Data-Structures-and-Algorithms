// problems statement - leetcode 389 - https://leetcode.com/problems/find-the-difference

// my solution

class Solution {
    public char findTheDifference(String s, String t) {
        int[] alphabet = new int[26];
        for(int i=0; i<s.length(); i++){
            alphabet[s.charAt(i) - 'a']++;
        }
        for(int i=0; i<t.length(); i++){
            alphabet[t.charAt(i) - 'a']--;
            if(alphabet[t.charAt(i) - 'a'] < 0){
                return t.charAt(i);
            }
        }
        return 'a';
    }
}

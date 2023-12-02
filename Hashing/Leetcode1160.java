// Problem Statement - Leetcode 1160 - https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/

// My Solution

class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charCount = new int[26];
        for(int i=0; i<chars.length(); i++){
            charCount[chars.charAt(i) - 'a']++;
        }
        int ans = 0 ;
        for(int i=0; i<words.length; i++){
            int[] currCount = new int[26];
            for(int j=0; j<words[i].length(); j++){
                currCount[words[i].charAt(j) - 'a']++;
            }
            boolean flag = true;
            for(int j=0; j<26; j++){
                if(currCount[j] > charCount[j]){
                    flag = false;
                    break;
                }
            }
            if(flag == true){
                ans += words[i].length();
            }
        }
        return ans;
    }
}

// Problem Statement - Leetcode 3120 - https://leetcode.com/problems/count-the-number-of-special-characters-i

//My Solution

class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        int[] smallCase = new int[26];
        int[] largeCase = new int[26];
        for(int i=0; i<n; i++){
            char ch = word.charAt(i);
            if(ch>='a' && ch<='z'){
                smallCase[ch-'a'] = 1;
            }
            else if(ch >= 'A' && ch <= 'Z'){
                largeCase[ch-'A'] = 1;
            }
        }
        int count = 0;
        for(int i=0; i<26; i++){
            if(largeCase[i] == 1 && smallCase[i] == 1){
                count++;
            }
        }
        return count;
    }
}

// Problem Statement - Leetcode 3121 - https://leetcode.com/problems/count-the-number-of-special-characters-ii/

// My Solution

class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        int[] smallLastOccurence = new int[26];
        int[] largeFirstOccurence = new int[26];
        for(int i=0; i<26; i++){
            smallLastOccurence[i] = -1;
            largeFirstOccurence[i] = -1;
        }
        
        for(int i=0; i<n; i++){
            char ch = word.charAt(i);
            if(ch>= 'a' && ch<='z'){
                smallLastOccurence[ch-'a'] = i;
            }
            else if(ch>='A' && ch<='Z'){
                if(largeFirstOccurence[ch-'A'] == -1){
                    largeFirstOccurence[ch-'A'] = i;
                }
            }
        }
        int count = 0;
        for(int i=0; i<26; i++){
            if(smallLastOccurence[i] >=0 && largeFirstOccurence[i] >= 0){
                if(smallLastOccurence[i] < largeFirstOccurence[i]){
                    count++;
                }
            }
        }
        return count;
    }
}

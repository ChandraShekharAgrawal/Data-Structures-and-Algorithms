// Problem statement - Leetcode 316 - https://leetcode.com/problems/remove-duplicate-letters

// my solution

class Solution {
    public String removeDuplicateLetters(String s) {
        int strLength = s.length();
        int[] alphabetCount = new int[26];
        for(int i=0; i<strLength; i++){
            alphabetCount[s.charAt(i) - 'a']++;
        }
        int[] included = new int[26];
        Stack<Character> track = new Stack<>();
        for(int i=0; i<strLength; i++){
            char curr = s.charAt(i);
            if(included[curr-'a'] == 0){
                while(track.size()>0 && track.peek() > curr){
                    if(alphabetCount[track.peek() - 'a'] > 0){
                        included[track.peek() - 'a'] = 0;
                        track.pop();
                    }
                    else{
                        break;
                    }
                }
                track.push(curr);
                included[curr-'a'] = 1;                
            }
            alphabetCount[curr-'a']--;
        }
        StringBuilder sb = new StringBuilder();
        while(track.size() > 0){
            sb.append(track.pop());
        }
        StringBuilder sbReverse = new StringBuilder();
        for(int i=sb.length()-1; i>=0; i--){
            sbReverse.append(sb.charAt(i));
        }
        return sbReverse.toString();
    }
}

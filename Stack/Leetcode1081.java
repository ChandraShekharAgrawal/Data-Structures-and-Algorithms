// problem statement - Leetcoe 1081 - https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/

// my solution

class Solution {
    public String smallestSubsequence(String s) {
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

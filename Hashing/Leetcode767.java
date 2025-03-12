// Problem Statement - Leetcode 767 - https://leetcode.com/problems/reorganize-string/

// My Solution - java

class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] charFreq = new int[26];
        int maxFreqIndex = -1;
        int maxFreq = 0;
        for(int i=0; i<n; i++){
            int curr = s.charAt(i) - 'a';
            charFreq[curr]++;
            if(charFreq[curr] > maxFreq){
                maxFreq = charFreq[curr];
                maxFreqIndex = curr;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append((char)('a' + maxFreqIndex));
        charFreq[maxFreqIndex]--;
        int len = 1;
        int prevIndex = maxFreqIndex;
        while(len < n){
            int maxTempFreq = 0;
            int maxTempFreqIndex = -1;
            for(int i=0; i<26; i++){
                if(i!= prevIndex && charFreq[i] > maxTempFreq){
                    maxTempFreq = charFreq[i];
                    maxTempFreqIndex = i;
                }
            }
            if(maxTempFreqIndex != -1){
                sb.append((char)('a' + maxTempFreqIndex));
                len++;
                charFreq[maxTempFreqIndex]--;
                prevIndex = maxTempFreqIndex;

            } else {
                break;
            }
        }
        if(sb.length() != n){
            return "";
        }
        return sb.toString();
    }
}

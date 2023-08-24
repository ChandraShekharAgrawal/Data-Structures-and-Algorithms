// problem statement - Leetcode 767 https://leetcode.com/problems/reorganize-string/description/

// my solution

class Solution {
    public String reorganizeString(String s) {
        int length = s.length();
        int[] count = new int[26];
        for(int i=0; i< length; i++){
            count[s.charAt(i) - 'a']++;
        }
        int max = 0;
        char ch = ' ';
        for(int i=0; i<26; i++){
            if(count[i] > max){
                max = count[i];
                ch = (char)('a' + i);
            }
        }
        if(max > (length+1)/2){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<length; i++){
            sb.append(' ');
        }
        int indexInsert = 0;
        while(count[ch-'a']>0){
            sb.setCharAt(indexInsert, ch);
            indexInsert += 2;
            count[ch-'a']--;
        }
        for(int i=0; i<26; i++){
            while(count[i]>0){
                if(indexInsert >= length){
                    indexInsert = 1;
                }
                sb.setCharAt(indexInsert, (char)(i+'a'));
                count[i]--;
                indexInsert += 2;
            }
        }
        return sb.toString();
    }
}

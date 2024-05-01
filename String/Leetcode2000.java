// Problem Statement - Leetcode 2000 - https://leetcode.com/problems/reverse-prefix-of-word

// My Solution

class Solution {
    public String reversePrefix(String word, char ch) {
        int firstOccur = -1;
        int n = word.length();
        StringBuilder sb = new StringBuilder();
        sb.append(word);
        for(int i=0; i<n; i++){
            if(word.charAt(i) == ch){
                firstOccur = i;
                break;
            }
        }
        if(firstOccur >= 0){
            int first = 0;
            int last = firstOccur;
            while(first < last){
                char temp = sb.charAt(first);
                sb.setCharAt(first, word.charAt(last));
                sb.setCharAt(last, temp);
                first++;
                last--;
            }
        }
        return sb.toString();
    }
}

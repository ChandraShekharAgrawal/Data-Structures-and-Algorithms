// problem statement - Leetcode 557 - https://leetcode.com/problems/reverse-words-in-a-string-iii

// my solution

class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        int len = s.length();
        int i=0;
        StringBuilder temp = new StringBuilder();
        while(i < len){
            if(s.charAt(i) == ' '){
                ans.append(temp.reverse());
                ans.append(' ');
                temp = new StringBuilder();
            }
            else
                temp.append(s.charAt(i));
            i++;
        }
        ans.append(temp.reverse());
        return ans.toString();
    }
}

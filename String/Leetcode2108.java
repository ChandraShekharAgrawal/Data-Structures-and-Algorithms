// Problem Statement - Leetcode 2108 - https://leetcode.com/problems/find-first-palindromic-string-in-the-array

// My Solution

class Solution {
    public String firstPalindrome(String[] words) {
        int n = words.length;
        for(int i=0; i<n; i++){
            int start = 0;
            int end = words[i].length()-1;
            boolean flag = true;
            while(start < end){
                if(words[i].charAt(start) != words[i].charAt(end)){
                    flag = false;
                    break;
                }
                start++;
                end--;
            }
            if(flag){
                return words[i];
            }
        }
        return "";
    }
}

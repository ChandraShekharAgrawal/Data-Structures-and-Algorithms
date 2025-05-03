// Problem Statement - Leetcode 680- https://leetcode.com/problems/valid-palindrome-ii/

// My Solution

class Solution {
    public boolean validPalindrome(String s) {
        int len = s.length();
        int start = 0;
        int end = len -1;
        while(start < end){
            while(start < len && end >=0 && s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }
            if(start >= end){
                return true;
            }
            boolean checkLeft = findPalindrome(s, start, end-1);
            boolean checkRight = findPalindrome(s, start+1, end);
            return checkLeft || checkRight;
        }
        return true;
    }

    private boolean findPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
}

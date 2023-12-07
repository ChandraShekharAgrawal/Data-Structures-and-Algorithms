// Problem Statement - Leetcode 1603 - https://leetcode.com/problems/largest-odd-number-in-string

// My Solution

class Solution {
    public String largestOddNumber(String num) {
        int n = num.length();
        //int start = -1;
        int end = -1;
        for(int i=0; i<n; i++){
            if(((num.charAt(i) - '0')& 1) > 0){
                end = i;
            }
        }
        StringBuilder odd = new StringBuilder();
        if(end < 0){
            return "";
        }
        for(int i=0; i<=end; i++){
            odd.append(num.charAt(i));
        }
        return odd.toString();
    }

}

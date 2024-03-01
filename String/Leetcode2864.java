// Problem Statement - Leetcode 2864 - https://leetcode.com/problems/maximum-odd-binary-number

// My Solution

class Solution {
    public String maximumOddBinaryNumber(String s) {
        int n = s.length();
        int count1 = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '1'){
                count1++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<count1-1; i++){
            sb.append('1');
        }
        for(int i=0; i<n-count1; i++){
            sb.append('0');
        }
        sb.append('1');
        return sb.toString();
    }
}

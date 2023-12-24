// Problem Statement - Leetcode 1758 - https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string

// My Solution

class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int operations = 0;
        int req = 1^(s.charAt(0)-'0');
        for(int i=1; i<n; i++){
            if(s.charAt(i) - '0' != req){
                operations++;
            }
            req = 1^req;
        }
        req = s.charAt(0) - '0';
        int operationsChange = 1;
        for(int i=1; i<n; i++){
            if(s.charAt(i) - '0' != req){
                operationsChange++;
            }
            req = 1 ^ req;
        }
        return Math.min(operations, operationsChange);
    }
}

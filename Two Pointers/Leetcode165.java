// Problem Statement - Leetcode 165 - https://leetcode.com/problems/compare-version-numbers

// My Solution

class Solution {
    public int compareVersion(String version1, String version2) {
        int n1 = version1.length();
        int n2 = version2.length();
        int idx1 = 0;
        int idx2 = 0;
        while(idx1 < n1 || idx2 < n2){
            int num1 = 0;
            int num2 = 0;
            // crete first num
            while(idx1 < n1 && version1.charAt(idx1) != '.'){
                num1 = (num1 * 10) + (version1.charAt(idx1) - '0');
                idx1++;
            }
            while(idx2 < n2 && version2.charAt(idx2) != '.'){
                num2 = (num2 * 10) + (version2.charAt(idx2) - '0');
                idx2++;
            }
            if(num1 < num2){
                return -1;
            }
            else if(num1 > num2){
                return 1;
            }
            idx1++;
            idx2++;
        }
        return 0;
    }
}

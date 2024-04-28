// Problem Statement - Leetcode 2370 - https://leetcode.com/problems/longest-ideal-subsequence

// My Solution

class Solution {
    public int longestIdealString(String s, int k) {
        int n = s.length();
        int[] lengthArr = new int[26];
        lengthArr[s.charAt(0) - 'a'] = 1;
        int maxLength = 1;
        for(int i=1; i<n; i++){
            char curr = s.charAt(i);
            int j = curr-'a';
            int temp = k;
            int tempMax = 0;
            while(j>=0 && temp >= 0){
                tempMax = Math.max(tempMax, lengthArr[j]);
                j--;
                temp--;
            }
            j = curr-'a';
            j++;
            temp = k;
            while(j<=25 && temp > 0){
                tempMax = Math.max(tempMax, lengthArr[j]);
                j++;
                temp--;
            }
            lengthArr[curr-'a'] = 1 + tempMax;
            if(maxLength < 1 + tempMax){
                maxLength = 1 + tempMax;
            }
        }
        return maxLength;
    }
}

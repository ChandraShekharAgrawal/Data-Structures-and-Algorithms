// Problem Statement - Leetcode 1624 - https://leetcode.com/problems/largest-substring-between-two-equal-characters

// My Solution

class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int n = s.length();
        int[] firstOccur = new int[26];
        int[] lastOccur = new int[26];
        for(int i=0; i<n; i++){
            if(firstOccur[s.charAt(i) - 'a'] == 0){
                firstOccur[s.charAt(i) - 'a'] = i+1;
                lastOccur[s.charAt(i) - 'a'] = -1;
            }
            else{
                lastOccur[s.charAt(i) - 'a'] = i+1;
            }
        }
        int ans = 0;
        int totalSingle = 0;
        for(int i=0; i<26; i++){
            if(lastOccur[i] == -1){
                totalSingle++;
            }
            ans = Math.max(ans, lastOccur[i] - firstOccur[i] - 1);
        }
        if(totalSingle == n){
            return -1;
        }
        return ans;
    }
}

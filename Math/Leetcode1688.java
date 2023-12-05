// Problem Statement - Leetcode 1688 - https://leetcode.com/problems/count-of-matches-in-tournament/

// My Solution

class Solution {
    public int numberOfMatches(int n) {
        int count = 0;
        while(n > 1){
            if((n&1) > 0){
                count++;
            }
            count += (n/2);
            n = n/2;
        }
        return count;
    }
}

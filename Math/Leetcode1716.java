// Problem Statement - Leetcode 1716 - https://leetcode.com/problems/calculate-money-in-leetcode-bank

// My Solution

class Solution {
    public int totalMoney(int n) {
        int weeks = n/7;
        int remDays = n%7;
        int ans = (28 * weeks);
        if(weeks > 0){
            ans += ((((weeks-1) * (weeks))/2)*7);
        }
        if(remDays == 0){
            return  ans;
        }
        ans += ( weeks * remDays) +  ((remDays * (remDays+1))/2);
        return ans;
    }
}

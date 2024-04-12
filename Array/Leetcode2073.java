// Problem Statement - Leetcode 2073 - https://leetcode.com/problems/time-needed-to-buy-tickets

// My Solution

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int buyTicket = tickets[k];
        int ans = buyTicket;
        for(int i=0; i<n; i++){
            if(i<k){
                ans = ans + Math.min(tickets[i], buyTicket);
            }
            else if(i > k){
                ans = ans + Math.min(tickets[i], buyTicket - 1);
            }
        }
        return ans;
    }
}

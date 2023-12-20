// Problem Statement - Leetcode 2706 - https://leetcode.com/problems/buy-two-chocolates

// My Solution

class Solution {
    public int buyChoco(int[] prices, int money) {
        int n = prices.length;
        int smallest = 101;
        int secondSmallest = 101;
        for(int i=0; i<n; i++){
            if(prices[i] <= smallest){
                secondSmallest = smallest;
                smallest = prices[i];
            }
            else if(prices[i] > smallest && prices[i] < secondSmallest){
                secondSmallest = prices[i];
            }
        }
        if(smallest + secondSmallest > money){
            return money;
        }
        return (money - (smallest + secondSmallest));
    }
}

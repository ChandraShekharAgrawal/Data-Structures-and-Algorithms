// Problem Statement - Leetcode 1561 - https://leetcode.com/problems/maximum-number-of-coins-you-can-get

// My Solution

class Solution {
    public int maxCoins(int[] piles) {
        int n = piles.length;
        int coins = n/3;
        Arrays.sort(piles);
        int myMaxCoin = 0;
        int j = n-2;
        while(coins-- > 0){
            myMaxCoin += piles[j];
            j = j-2;
        }
        return myMaxCoin;
    }
}

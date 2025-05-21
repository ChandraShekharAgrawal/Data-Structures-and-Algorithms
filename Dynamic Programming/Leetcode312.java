// Problem Statement - Leetcode 312 - https://leetcode.com/problems/burst-balloons/

// My Solution

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] coins = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                coins[i][j] = -1;
            }
        }
        findMaxCoins(nums, n, 0, n-1, coins);
        return coins[0][n-1];
    }

    private int findMaxCoins(int[] nums, int n, int start, int end, int[][] coins){
        if(start < 0 || end < 0 || start >=n || end >=n){
            return 0;
        }
        if(start > end){
            return coins[start][end] = 0;
        }
        if(start == end){
            int tempCoins = nums[start];
            if(start -1 >= 0){
                tempCoins *= nums[start-1];
            }
            if(start + 1 <= n-1){
                tempCoins *= nums[start+1];
            }
            return coins[start][end] = tempCoins;
        }
        if(coins[start][end] == -1){
            int tempCoins = Integer.MIN_VALUE;
            for(int i=start; i<=end; i++){
                int leftCoins = findMaxCoins(nums, n, start, i-1, coins);
                int currCoins = nums[i];
                if(start-1 >= 0){
                    currCoins *= nums[start-1];
                }
                if(end+1 <=  n-1){
                    currCoins *= nums[end + 1];
                }
                int rightCoins = findMaxCoins(nums, n, i+1, end, coins);
                tempCoins = Math.max(tempCoins, currCoins + leftCoins + rightCoins);
            }
            coins[start][end] = tempCoins;
        }
        return coins[start][end];
    }
}

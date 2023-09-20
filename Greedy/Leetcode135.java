// problem statement - Leetcode 135 - https://leetcode.com/problems/candy/description/

// my solution

class Solution {
    public int candy(int[] ratings) {
        int totalRatings = ratings.length;
        int[] candies = new int[totalRatings];
        for(int i=0; i<totalRatings; i++){
            candies[i] = 1;
        }
        for(int i=1; i<totalRatings; i++){
            if(ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1] + 1;
            }
        }
        for(int i=totalRatings-2; i>=0; i--){
            if(ratings[i] > ratings[i+1] && candies[i] <= candies[i+1]){
                candies[i] = candies[i+1] + 1;
            }
        }
        int minCandy = 0;
        for(int i=0; i<totalRatings; i++){
            minCandy += candies[i];
        }
        return minCandy;
    }
}

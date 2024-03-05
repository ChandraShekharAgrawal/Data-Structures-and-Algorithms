// Problem Statement - Leetcode 948 - https://leetcode.com/problems/bag-of-tokens/

// My Solution

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length;
        Arrays.sort(tokens);
        int start = 0;
        int end = n-1;
        int score = 0;
        while(start < n && end >=0 && start <= end){
            if(power < tokens[start]){
                break;
            }
            while(start < n && power >=tokens[start] && start <= end){
                power = power - tokens[start];
                start++;
                score++;
            }
            if(start < n && end >=0 && score >= 1 && start < end){
                power += tokens[end];
                end--;
                score--;
            }
            if(start == end){
                break;
            }
        }
        if(start == end && power >= tokens[start]){
            score++;
        }
        if(score < 0){
            return 0;
        }
        return score;
    }
}

// Problem Statement - Leetcode 458 - https://leetcode.com/problems/poor-pigs

// My Solution

class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int rounds = minutesToTest/minutesToDie;
        rounds++;
        int pigs = 0;
        while(true){
            if(Math.pow(rounds, pigs) >= buckets){
                break;
            }
            else{
                pigs++;
            }
        }
        return pigs;
    }
}

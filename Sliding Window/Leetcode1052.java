// Problem Statement - Leetcode 1052 - https://leetcode.com/problems/grumpy-bookstore-owner

// My Solution

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int currentSatisfied = 0;
        int maxSatisfied = 0;
        for(int i=0; i<n; i++){
            if(grumpy[i] == 0)
                currentSatisfied += customers[i];
        }        
        for(int i=0; i<minutes; i++){
            if(grumpy[i] == 1)
                currentSatisfied += customers[i];
        }
        maxSatisfied = currentSatisfied;
        for(int i=minutes; i<n; i++){
            if(grumpy[i-minutes] == 1){
                currentSatisfied -= customers[i-minutes];
            }
            if(grumpy[i] == 1){
                currentSatisfied += customers[i];
            }
            maxSatisfied = Math.max(currentSatisfied, maxSatisfied);
        }
        return maxSatisfied;
    }
}

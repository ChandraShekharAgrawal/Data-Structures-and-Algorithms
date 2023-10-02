// Problem Statement - Leetcode 2038 - https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color

// My Solution

class Solution {
    public boolean winnerOfGame(String colors) {
        int len = colors.length();
        int countA = 0;
        int countB = 0;
        char prev = colors.charAt(0);
        int tempCount = 1;
        for(int i=1; i< len; i++){
            if(colors.charAt(i) == prev){
                tempCount++;                
            }
            else{
                if(tempCount >=3){
                    if(prev == 'A'){
                        countA += tempCount-2;
                    }
                    else{
                        countB += tempCount - 2;
                    }
                }
                tempCount = 1;
            }
            prev = colors.charAt(i);
        }
        if(tempCount >=3){
                    if(prev == 'A'){
                        countA += tempCount-2;
                    }
                    else{
                        countB += tempCount - 2;
                    }
                }
        if(countA > countB){
            return true;
        }
        return false;
    }
}

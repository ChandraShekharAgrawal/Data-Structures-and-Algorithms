// Problem Statement - Leetcode 2125 - https://leetcode.com/problems/number-of-laser-beams-in-a-bank

// My Solution

class Solution {
    public int numberOfBeams(String[] bank) {
        int m = bank.length;
        int n = bank[0].length();
        int firstOneCount = 0;
        for(int i=0; i<n; i++){
            if(bank[0].charAt(i) == '1'){
                firstOneCount++;
            }
        }
        int secondOneCount = 0;
        int ans = 0;
        for(int i=1; i<m; i++){
            for(int j=0; j<n; j++){
                if(bank[i].charAt(j) == '1'){
                    secondOneCount++;
                }
            }
            if(secondOneCount > 0){
                ans += (firstOneCount * secondOneCount);
                firstOneCount = secondOneCount;
                secondOneCount = 0;
            }
        }
        return ans;
    }
}

// Problem Statement - Leetcode 629 - https://leetcode.com/problems/k-inverse-pairs-array/

// My Solution

class Solution {
    public int kInversePairs(int n, int k) {
        int mod = 1000 * 1000 * 1000 + 7;
        long[] prev = new long[1001];
        prev[0] = 1;
        long[] curr = new long[1001];
        for(int i=2; i<=n; i++){
            int totalCol = (i * (i-1))/2;
            int halfCol = totalCol/2;
            curr[0] = 1;
            int a = 0;
            for(int j=1; (j<=halfCol) && (j<=1000); j++){
                curr[j] = (curr[j-1] + prev[j])%mod;
                if(j>=i){
                    curr[j] = (mod + curr[j] - prev[a])%mod;
                    a++;
                }
            }
            a = 0;
            if((totalCol&1)==0){
                a = 2;
            }
            else{
                a = 1;
            }
            for(int j = halfCol + 1; (j<= totalCol) && (j<=1000); j++){
                curr[j] = curr[j-a]%mod;
                a = a + 2;
            }
            for(int j=0; (j<= totalCol)&& (j<=1000); j++){
                prev[j] = curr[j];
                curr[j] = 0;
            }
        }
        // if(prev[k] < 0){
        //     prev[k] += mod;
        // }
        return (int)prev[k];
    }
}

// Problem Statement - Leetcode 935 - https://leetcode.com/problems/knight-dialer/description

// My Solution

class Solution {
    public int knightDialer(int n) {
        int mod = 1000 * 1000 * 1000 + 7;
        long[] prev = new long[10];
        long[] curr = new long[10];
        for(int i=0; i<=9; i++){
            prev[i] = 2;
        }
        prev[4] = 3;
        prev[6] = 3;
        prev[5] = 0;
        if(n==1){
            return 10;
        }
        if(n==2){
            return 20;
        }
        while(n-2>0)
            {for(int i=0; i<=9; i++){
                if(i==0){
                    curr[4] = (curr[4] + prev[i])%mod;
                    curr[6] = (curr[6] + prev[i])%mod;
                }
                else if(i==1){
                    curr[6] = (curr[6] + prev[i])%mod;
                    curr[8] = (curr[8] + prev[i])%mod;
                }
                else if(i==2){
                    curr[7] = (curr[7] + prev[i])%mod;
                    curr[9] = (curr[9] + prev[i])%mod;
                }
                else if(i==3){
                    curr[4] = (curr[4] + prev[i])%mod;
                    curr[8] = (curr[8] + prev[i])%mod;
                }
                else if(i==4){
                    curr[0] = (curr[0] + prev[i])%mod;
                    curr[3] = (curr[3] + prev[i])%mod;
                    curr[9] = (curr[9] + prev[i])%mod;
                }
                else if(i==6){
                    curr[0] = (curr[0] + prev[i])%mod;
                    curr[1] = (curr[1] + prev[i])%mod;
                    curr[7] = (curr[7] + prev[i])%mod;
                }
                else if(i==7){
                    curr[2] = (curr[2] + prev[i])%mod;
                    curr[6] = (curr[6] + prev[i])%mod;
                }
                else if(i==8){
                    curr[1] = (curr[1] + prev[i])%mod;
                    curr[3] = (curr[3] + prev[i])%mod;
                }
                else if(i==9){
                    curr[2] = (curr[2] + prev[i])%mod;
                    curr[4] = (curr[4] + prev[i])%mod;
                }
            }
            for(int i=0; i<=9; i++){
                prev[i] = curr[i];
                curr[i] = 0;
            }
            n--;
        }
        long ans = 0;
        for(int i=0; i<=9; i++){
            ans = (ans + prev[i])%mod;
        }
        return (int)ans;
    }
}

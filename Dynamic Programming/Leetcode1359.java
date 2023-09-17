// problem statement - Leetcode 1359 -> https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options

// my solution -> for any n, 2n items are there in total (Pn, Dn,). Now apply comabinatorics

class Solution {
    public int countOrders(int n) {
        int mod = 1000 * 1000 * 1000 + 7;
        long validSequence = 1;
        for(int i=1; i<=n; i++){
            long num = 2*i;
            long currentValid = (num * (num-1))/2;
            validSequence = (validSequence * (currentValid))%mod;
        }
        return (int) validSequence;
    }
}

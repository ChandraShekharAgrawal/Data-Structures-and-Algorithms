// problem statement : leetcode 338 https://leetcode.com/problems/counting-bits/description/

// my solution

class Solution {
    public int[] countBits(int n) {
        int[] count = new int[n+1];
        if(n==0)
            return count;
        count[1] = 1;
        int i = 1;
        while((i<<1) <= n ){
            if((i<<1) <=n)
                count[(i<<1)] = count[i];
            if((i<<1) + 1 <=n)
                count[(i<<1) + 1] = count[i] + 1;
            i++;
        }
        return count;
    }
}

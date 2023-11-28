// Problem Statement - Leetcode 2147 - https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor

// My Solution

class Solution {
    public int numberOfWays(String corridor) {
        int n = corridor.length();
        int mod = 1000 * 1000 * 1000 + 7;
        int seats = 0;
        //ArrayList<Integer> arr = new ArrayList<>();
        int currSeats = 0;
        long ans = 1;
        int l = -1;
        int r = -1;
        for(int i=0; i<n; i++){
            if(corridor.charAt(i) == 'S'){
                seats++;
                currSeats++;            
                if(seats >2 && currSeats == 1){
                    r = i;
                    ans = (ans * ((r - l)%mod))%mod;
                }
                if(currSeats == 2){
                    //arr.add(i);
                    l = i;
                    currSeats = 0;
                }
            }
        }
        if(seats %2 != 0 || seats == 0){
            return 0;
        }
        return (int)ans;
    }
}

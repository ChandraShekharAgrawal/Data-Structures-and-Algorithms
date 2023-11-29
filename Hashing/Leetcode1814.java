// Problem Statement - Leetcode 1814 - https://leetcode.com/problems/count-nice-pairs-in-an-array

// My Solution

class Solution {
    public int countNicePairs(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> diffReverse = new HashMap<>();
        for(int i=0; i<n; i++){
            int reverseNum = findReverse(nums[i]);
            int currDiff = nums[i] - reverseNum;
            if(diffReverse.containsKey(currDiff) == false){
                diffReverse.put(currDiff, 1);
            }
            else{
                diffReverse.put(currDiff, diffReverse.get(currDiff) + 1);
            }
        }
        long ans = 0;
        int mod = 1000 * 1000 * 1000 + 7;
        for(Integer diff : diffReverse.keySet()){
            int value = diffReverse.get(diff);
            if(value > 1)
                ans = (ans + (((value * ((long)(value-1)))/2)%mod))%mod;
        }
        return (int)ans;
    }

    int findReverse(int num){
        // int count = 0;
        // int temp = num;
        // while(temp > 0){
        //     count++;
        //     temp = temp/10;
        // }
        int ans = 0;
        int temp = num;
        while(temp > 0){
            ans = ans * 10 + temp%10;
            // ans += ((temp%10) * Math.pow(10,count-1));
            // count--;
            temp = temp/10;
        }
        return ans;
    }
}

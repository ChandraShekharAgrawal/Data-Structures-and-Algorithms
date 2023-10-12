// Problem Statement - Leetcode 2009 - https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous

// My solution

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        // HashSet<Integer> set = new HashSet<>();
        // for(int i=0; i<n; i++){
        //     set.add(nums[i]);
        // }
        ArrayList<Integer> uniqueNums = new ArrayList<>();
        int uniqueIndex = 0;
        for(int i=0; i<n; i++){
            if(i==0){
                uniqueNums.add(nums[i]);
                uniqueIndex++;
            }
            else{
                if(nums[i] != uniqueNums.get(uniqueIndex-1)){
                    uniqueNums.add(nums[i]);
                    uniqueIndex++;
                }
            }
        }
        int ans = n;
        for(int i=0; i<uniqueIndex; i++){
            int rightLimit = uniqueNums.get(i) + n-1;
            int countLessRight = findCount(uniqueNums, uniqueIndex, n, i, rightLimit);
            ans = Math.min(ans, n - (countLessRight - i));
        }
        return ans;
    }

    int findCount(ArrayList<Integer> uniqueNums, int n, int m, int i, int rightLimit){
        int start = 0;
        int end = n-1;
        int ans = -1;
        while(start <= end){
            int mid = (start + end)/2;
            if(uniqueNums.get(mid) > rightLimit){
                end = mid -1;
            }
            else{
                ans = mid;
                start = mid+1;
            }
        }
        if(ans < 0){
            return 0;
        }
        return ans+1;
    }
}

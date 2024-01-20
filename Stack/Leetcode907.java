// Problem Statement - Leetcode 907 - https://leetcode.com/problems/sum-of-subarray-minimums

// My Solution

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = 1000 * 1000 * 1000 + 7;
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        leftMin[0] = -1;
        rightMin[n-1] = -1;
        Stack<Integer> leftCheck = new Stack<>();
        Stack<Integer> rightCheck = new Stack<>();
        leftCheck.add(0);
        rightCheck.add(n-1);
        for(int i=1; i<n; i++){
            while(leftCheck.size() > 0 && arr[leftCheck.peek()] >= arr[i]){
                leftCheck.pop();
            }
            if(leftCheck.size() == 0){
                leftMin[i] = -1;
            }
            else{
                leftMin[i] = leftCheck.peek();
            }
            leftCheck.add(i);
            while(rightCheck.size() > 0 && arr[rightCheck.peek()] > arr[n-i-1]){
                rightCheck.pop();
            }
            if(rightCheck.size() == 0){
                rightMin[n-i-1] = -1;
            }
            else{
                rightMin[n-i-1] = rightCheck.peek();
            }
            rightCheck.add(n-i-1);
        }        
        // now calculate ans
        long ans = 0;
        for(int i=0; i<n; i++){
            int leftLength = leftMin[i] == -1 ? (i+1) : (i-leftMin[i]);
            int rightLength = rightMin[i] == -1 ? (n-1-i) : (rightMin[i] - i -1);
            int totalLength = leftLength + rightLength + ((leftLength-1) * rightLength);
            ans = (ans + (((long)(arr[i])) * (totalLength))%mod)%mod;
        }
        return (int)ans;
    }
}

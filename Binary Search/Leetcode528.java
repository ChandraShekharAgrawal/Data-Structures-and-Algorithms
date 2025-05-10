// Problem Statement - Leetcode 528 - https://leetcode.com/problems/random-pick-with-weight/

// My Solution

class Solution {

    private int[] prefixSum;
    private Random random;

    public Solution(int[] w) {
        prefixSum = createPrefixArr(w);
        random = new Random();
    }

    private int[] createPrefixArr(int[] arr){
        int[] prefixArr = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            if(i == 0)
                prefixArr[i] = arr[i];
            else
                prefixArr[i] = prefixArr[i-1] + arr[i];
        }
        return prefixArr;
    }
    
    public int pickIndex() {
        int pickIndexToFind = random.nextInt(prefixSum[prefixSum.length - 1]) + 1;
        return findIndex(pickIndexToFind, prefixSum);
    }

    private int findIndex(int value, int[] arr){
        int ansIndex = arr.length-1;
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = (start + end)/2;
            if(arr[mid] < value){
                start = mid + 1;
            } else {
                ansIndex = mid;
                end = mid -1;
            }
        }
        return ansIndex;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */

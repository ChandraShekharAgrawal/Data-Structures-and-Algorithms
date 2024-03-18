// Problem Statement - Leetcode 57 - https://leetcode.com/problems/insert-interval/

// My Solution

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if(n==0){
            int[][] arrayAns = new int[1][2];
            arrayAns[0][0] = newInterval[0];
            arrayAns[0][1] = newInterval[1];
            return arrayAns;
        }
        int greaterOrEqual = findIndexGreaterOrEqual(intervals, newInterval[0]);
        int smallerOrEqual = findIndexSmallerOrEqual(intervals, newInterval[1]);
        System.out.println(greaterOrEqual + " "+ smallerOrEqual);
        int ansSize = greaterOrEqual + 1 + n - smallerOrEqual + 1;
        int[][] mergedAns = new int[ansSize][2];
        int mergedIndex = 0;
        if(newInterval[1] < intervals[0][0]){
            mergedAns[mergedIndex][0] = newInterval[0];
            mergedAns[mergedIndex][1] = newInterval[1];
            mergedIndex++;
        }
        for(int i=mergedIndex; i<= greaterOrEqual; i++){
            mergedAns[mergedIndex][0] = intervals[i][0];
            mergedAns[mergedIndex][1] = intervals[i][1];
            mergedIndex++;
        }
        //int mergedIndex = greaterOrEqual+1;
        if(greaterOrEqual + 1 < n && smallerOrEqual-1 >= 0){
            mergedAns[mergedIndex][0] = Math.min(intervals[greaterOrEqual+1][0], newInterval[0]);
            mergedAns[mergedIndex][1] = Math.max(intervals[smallerOrEqual-1][1], newInterval[1]);
            mergedIndex++;
        }      
        for(int i=smallerOrEqual; i<n; i++){
            mergedAns[mergedIndex][0] = intervals[i][0];
            mergedAns[mergedIndex][1] = intervals[i][1];
            mergedIndex++;
        }
        if(newInterval[0] > intervals[n-1][1]){
            mergedAns[mergedIndex][0] = newInterval[0];
            mergedAns[mergedIndex][1] = newInterval[1];
        }
        return mergedAns;
    }

    int findIndexGreaterOrEqual(int[][] intervals, int num){
        int n = intervals.length;
        int start = 0;
        int end = n-1;
        int ans = -1;
        while(start <= end){
            int mid = (start + end)/2;
            if(intervals[mid][1] >= num){
                end = mid - 1;
            }
            else{
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
    }

    int findIndexSmallerOrEqual(int[][] intervals, int num){
        int n = intervals.length;
        int start = 0;
        int end = n-1;
        int ans = n;
        while(start <= end){
            int mid = (start + end)/2;
            if(intervals[mid][0] <= num){
                start = mid + 1;
            }
            else{
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }
}

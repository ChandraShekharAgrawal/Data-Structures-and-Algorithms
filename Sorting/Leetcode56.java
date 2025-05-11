// Problem Statement - Leetcode 56 - https://leetcode.com/problems/merge-intervals/

// My Solution

class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (o1, o2) -> {
            if(o1[0] < o2[0]){
                return -1;
            } else if(o1[0] == o2[0]){
                return 0;
            }
            return 1;
        });
        List<List<Integer>> mergedList = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(intervals[0][0]);
        temp.add(intervals[0][1]);
        int i = 1;
        while(i<n){
            if(temp.get(1) >= intervals[i][0]){                
                int end = Math.max(temp.get(1) , intervals[i][1]);
                temp.remove(temp.get(1));
                temp.add(end);                
            } else {
                mergedList.add(temp);
                temp = new ArrayList<>();               
                temp.add(intervals[i][0]);
                temp.add(intervals[i][1]);                              
            }
            i++;             
        }
        if(temp.size() > 0){
            mergedList.add(temp);
        }
        // convert list to array
        int[][] mergedArr = new int[mergedList.size()][2];
        for(i=0; i<mergedList.size(); i++){
            mergedArr[i][0] = mergedList.get(i).get(0);
            mergedArr[i][1] = mergedList.get(i).get(1);
        }
        return mergedArr;
    }
}

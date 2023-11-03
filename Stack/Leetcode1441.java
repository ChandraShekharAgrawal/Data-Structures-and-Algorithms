// Problem Statement - Leetcode 1441 - https://leetcode.com/problems/build-an-array-with-stack-operations

// My Solution

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int stream = 1;
        int index = 0;
        for(int i=0; i<target[target.length-1]; i++){
            int currVal = target[index];
            if(stream == currVal){
                ans.add("Push");
                stream++;
                index++;
            }
            else{
                ans.add("Push");
                ans.add("Pop");
                stream++;
            }
        }
        return ans;
    }
}

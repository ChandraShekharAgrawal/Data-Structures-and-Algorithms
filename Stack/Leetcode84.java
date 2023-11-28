// Problem Statement - Leetcode 84 - https://leetcode.com/problems/largest-rectangle-in-histogram

// My Solution

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftArr = smallerLeft(heights, n);
        int[] rightArr = smallerRight(heights, n);
        int largestArea = 0;
        for(int i=0; i<n; i++){
            int l = leftArr[i] < 0 ? (i+1) : (i - leftArr[i]);
            int r = rightArr[i] < 0 ? (n-i) : (rightArr[i] - i);
            int width = l + r - 1;
            largestArea = Math.max(largestArea, width * heights[i]);
        }
        return largestArea;
    }

    int[] smallerLeft(int[] heights, int n){
        int[] ans = new int[n];
        ans[0] = -1;
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for(int i=1; i<n; i++){
            while(s.size()>0 && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            if(s.size() ==0){
                ans[i] = -1;
            }
            else{
                ans[i] = s.peek();
            }
            s.push(i);
        }
        return ans;
    }

    int[] smallerRight(int[] heights, int n){
        int[] ans = new int[n];
        ans[n-1] = -1;
        Stack<Integer> s = new Stack<>();
        s.push(n-1);
        for(int i=n-2; i>=0; i--){
            while(s.size()>0 && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            if(s.size() ==0){
                ans[i] = -1;
            }
            else{
                ans[i] = s.peek();
            }
            s.push(i);
        }
        return ans;
    }
}

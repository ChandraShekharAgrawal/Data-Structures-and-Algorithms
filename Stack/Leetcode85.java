// Problem Statement - Leetcode 85 - https://leetcode.com/problems/maximal-rectangle

// My Solution

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] height = new int[m];
        int largestArea = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] == '0'){
                    height[j] = 0;
                }
                else{
                    height[j] += 1;
                }
            }
            int[] leftArr = smallerLeft(height, m);
            int[] rightArr = smallerRight(height, m);
            for(int j=0; j<m; j++){
                int l = leftArr[j] < 0 ? (j+1) : (j - leftArr[j]);
                int r = rightArr[j] < 0 ? (m-j) : (rightArr[j] - j);
                int width = l + r - 1;
                largestArea = Math.max(largestArea, width * height[j]);
            }
        }
        return largestArea;
    }

    int[] smallerLeft(int[] height, int n){
        int[] ans = new int[n];
        ans[0] = -1;
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for(int i=1; i<n; i++){
            while(s.size() > 0 && height[s.peek()] >= height[i]){
                s.pop();
            }
            if(s.size() == 0){
                ans[i] = -1;
            }
            else{
                ans[i] = s.peek();
            }
            s.push(i);
        }
        return ans;
    }

    int[] smallerRight(int[] height, int n){
        int[] ans = new int[n];
        ans[n-1] = -1;
        Stack<Integer> s = new Stack<>();
        s.push(n-1);
        for(int i=n-2; i>=0; i--){
            while(s.size() > 0 && height[s.peek()] >= height[i]){
                s.pop();
            }
            if(s.size() == 0){
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

// Problem Statement - Leetcode 661 - https://leetcode.com/problems/image-smoother

// My Solution

class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] smooth = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int sum = 0;
                int count = 0;
                for(int k=i-1; k<=i+1 && k<m; k++){
                    if(k>=0){
                        for(int l=j-1; l<=j+1 && l<n; l++){
                            if(l>=0){
                                sum += img[k][l];
                                count++;
                            }
                        }
                    }
                }
                smooth[i][j] = sum/count;
            }
        }
        return smooth;
    }
}

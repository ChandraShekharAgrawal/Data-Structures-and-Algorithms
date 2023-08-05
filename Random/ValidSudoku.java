// following program checks if a 9*9 sudoku is valid or not
// you can add your values of sudoku instead of already placed values in arr
// I like solving sudokus. So, I've created this program to check if I'm solving correctly or not

import java.util.*;
class ValidSudoku{
    public static void main (String[] args){
        int[][] arr = {{1,4, 7,3,5,2,9,8,6},
                        {2,6,8,4,9,1,7,3,5},
                        {5,9,3,8,7,6,4,1,2},
                        {3,8,2,1,6,9,5,4,7},
                        {7,1,4,5,2,3,6,9,8},
                        {6,5,9,7,8,4,3,2,1},
                        {9,2,1,6,3,5,8,7,4},
                        {8,3,5,2,4,7,1,6,9},
                        {4,7,6,9,1,8,2,5,3}};
        int n = arr.length;
        int checkRow = findRow(arr,n);
        int checkCol = findCol(arr, n);
        int checkBox = findBox(arr, n);
        //System.out.println(checkRow + " "+ checkCol + " "+ checkBox);
        if((checkRow==1) && (checkCol==1) && (checkBox==1)){
            System.out.println("Valid");
        }
        else
            System.out.println("Not Valid");
    }

    static int findRow(int[][] arr, int n){
        int ans = 1;
        int[] vis = new int[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                vis[arr[i][j]-1]++;
            }
            for(int j=0; j<n; j++){
                if(vis[j]!=1){
                    ans = 0;
                    break;
                }
                else{
                    vis[j] = 0;
                }
            }
        }
        return ans;
    }

    static int findCol(int[][] arr, int n){
        int ans = 1;
        int[] vis = new int[n];
        for(int j=0; j<n; j++){
            for(int i=0; i<n; i++){
                vis[arr[i][j]-1]++;
            }
            for(int i=0; i<n; i++) {
                if (vis[i] != 1) {
                    ans = 0;
                    System.out.println(j);
                    break;
                } else {
                    vis[i] = 0;
                }
            }
        }
        return ans;
    }

    static int findBox(int[][] arr, int n){
        int ans = 1;
        int[] vis = new int[n];
        for(int i=0; i<n; i=i+3){
            for(int j=0; j<n; j=j+3){
                for(int k=i; k<i+3; k++){
                    for(int l=j; l<j+3; l++){
                        vis[arr[k][l]-1]++;
                    }
                }
                for(int k=0; k<n; k++){
                    if(vis[k]!=1){
                        ans = 0;
                        break;
                    }
                    else{
                        vis[k] = 0;
                    }
                }
            }
        }
        return ans;
    }
}

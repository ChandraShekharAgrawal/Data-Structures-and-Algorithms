// Problem Statement - Leetcode 779 - https://leetcode.com/problems/k-th-symbol-in-grammar

// My Solution

class Solution {
    public int kthGrammar(int n, int k) {
        if(n==1){
            return 0;
        }
        k = k-1;
        boolean flag = true;
        while(k>1){
            int rem = k%2;
            k = k/2;
            if(rem !=0){
                flag = !flag;
            }
        }
        if(k==0 && flag == true){
            return 0;
        }
        else if(k==0 && flag == false){
            return 1;
        }
        else if(k==1 && flag == true){
            return 1;
        }
        return 0;
    }
}

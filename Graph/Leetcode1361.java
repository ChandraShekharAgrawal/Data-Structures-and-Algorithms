// Problem Statement - Leetcode 1361 - https://leetcode.com/problems/validate-binary-tree-nodes

// My Solution

class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        //boolean ans = true;
        if(n==1){
            return true;
        }
        int[] leftChildMap = new int[n];
        int[] rightChildMap = new int[n];
        for(int i=0; i<n; i++){
            if(leftChild[i] != -1){
                leftChildMap[leftChild[i]] = 1;
                if(leftChild[leftChild[i]] == i){
                    return false;
                }
            }
            if(rightChild[i] != -1){
                rightChildMap[rightChild[i]] = 1;
                if(rightChild[rightChild[i]] == i){
                    return false;
                }
            }
        }
        int rootCount = 0;
        for(int i=0; i<n; i++){
            if(leftChild[i] == -1 && rightChild[i] == -1){
                if(leftChildMap[i] ==0 && rightChildMap[i] ==0){
                    return false;
                }
            }
            if(leftChildMap[i] == 1){
                if(rightChildMap[i] == 1)
                    return false;
            }
            if(leftChildMap[i] == 0 && rightChildMap[i] == 0){
                rootCount++;
            }
        }
        if(rootCount !=1){
            return false;
        }
        boolean selfLeft = findSelfLoop(n, leftChild);
        boolean selfRight = findSelfLoop(n, rightChild);
        if(selfLeft== false || selfRight == false)
            return false;
        return true;
    }

    boolean findSelfLoop(int n, int[] arr){
        // return false if this arr has self loop else true
        int[] parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = -1;
        }
        for(int i=0; i<n; i++){
            if(arr[i]!=-1){
                if(parent[arr[i]] == -1){
                    if(parent[i] != -1){
                        parent[arr[i]] = parent[i];
                    }
                    else{
                        parent[arr[i]] = i;
                    }
                }
                else{
                    parent[arr[i]] = parent[i];
                }
            }
        }
        for(int i=0; i<n; i++){
            if(parent[i] != -1 && parent[parent[i]] == i){
                return false;
            }
        }
        return true;
    }
}

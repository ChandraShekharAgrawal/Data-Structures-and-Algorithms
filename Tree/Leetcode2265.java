// Problem Statement - Leetcode 2265 - https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree

// My Solution

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count = 0;
    class SumNode{
        int nodeCount;
        int sum;
        SumNode(int x, int y){
            nodeCount = x;
            sum = y;
        }
    }
    public int averageOfSubtree(TreeNode root) {
        if(root == null){
            return 0;
        }
        SumNode sumRoot = calcAverage(root);
        return count;
    }

    SumNode calcAverage(TreeNode root){
        if(root == null){
            return new SumNode(0,0);
        }
        SumNode left = calcAverage(root.left);
        SumNode right = calcAverage(root.right);
        int currSum = root.val + left.sum + right.sum;
        int totalNodes = 1 + left.nodeCount + right.nodeCount;
        if(currSum/totalNodes == root.val){
            count++;
        }
        return new SumNode(totalNodes, currSum);
    }
}

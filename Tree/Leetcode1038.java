// Problem Statement - Leetcode 1038 - https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree

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
    private int sumSoFar;
    public TreeNode bstToGst(TreeNode root) {
        sumSoFar = 0;
        findGst(root);
        return root; 
    }

    private void findGst(TreeNode root){
        if(root == null){
            return;
        }
        findGst(root.right);
        sumSoFar += root.val;
        root.val = sumSoFar;
        findGst(root.left);
        return;
    }
}
